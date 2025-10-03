import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { // Produce items
                queue.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(100); // Simulate time taken to produce an item
            }
            queue.put(-1); // End signal for consumer
        } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

class Consumer implements Runnable {
   private final BlockingQueue<Integer> queue;

   public Consumer(BlockingQueue<Integer> queue) { this.queue = queue; }

   @Override
   public void run() {  
       try {  
           while(true){  
               int item = queue.take();  
               if(item == -1){ break; }  
               System.out.println("Consumed: " + item);  
               Thread.sleep(150); // Simulate time taken to consume an item  
           }  
       } catch(InterruptedException e){ Thread.currentThread().interrupt(); }  
   }  
}

public class ProducerConsumerExample {  
   public static void main(String[] args){  
       BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);  
       Thread producerThread = new Thread(new Producer(queue));  
       Thread consumerThread = new Thread(new Consumer(queue));  

       producerThread.start();  
       consumerThread.start();  

       try{  
           producerThread.join();  
           consumerThread.join();  
       } catch(InterruptedException e){ Thread.currentThread().interrupt(); }  
   }  
}
