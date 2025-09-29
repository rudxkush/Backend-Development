def run_concurrent_tasks(): 
    # creating the list of tasks we would put into threading (func + args + kwargs)
    tasks = [
        {"func": task_one, "args": (), "kwargs": {}},
        {"func": task_two, "args": (), "kwargs": {}},
        {"func": task_three, "args": (), "kwargs": {}}
    ]

    results = []
    with ThreadPoolExecutor(max_workers=3) as executor:  
        # max_workers : count of threads alive at once
        future_to_task = {
            # submit gives us a future (like a ticket we can cash later for result)
            executor.submit(task["func"], *task["args"], **task["kwargs"]): task["func"].__name__  
            for task in tasks  # loop over the things that we would thread concurrently
        }

        for future in as_completed(future_to_task):  
            # loop over the output of every thread that got executed (order = who finishes first)
            task_name = future_to_task[future]
            try:
                result = future.result()  # grab the actual return value of the function
                logging.info(f"{task_name} completed with result: {result}")
                results.append((task_name, result))
            except Exception as e:
                # if the function crashed, log the error but don’t break everything
                logging.error(f"{task_name} failed with error: {e}")
                results.append((task_name, None))

    return results
