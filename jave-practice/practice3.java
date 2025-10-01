class Car {
    private String color;
    private String name;
    private int capacity;
    private int horsepower;

    public Car(int capacity, int horsepower) {
        this.capacity = capacity;
        this.horsepower = horsepower;
    }

    public void setColor(String color) { this.color = color; }
    public void setName(String name) { this.name = name; }

    public String getName() { return name; }
    public String getColor() { return color; }
    public int getCapacity() { return capacity; }
    public int getHorsepower() { return horsepower; }
}

class ModelType extends Car {
    public ModelType(int capacity, int horsepower) {
        super(capacity, horsepower);
    }

    public void modelDetails() {
        if(getCapacity() > 400) {
            System.out.println("Cannot be an electric");
        } else {
            System.out.println("is hybrid");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Car bmw = new Car(4, 450);
        bmw.setColor("Black");
        bmw.setName("M10");

        System.out.println("------------Showing car details---------------");
        System.out.printf("Car Name : %s, Car Color : %s\n", bmw.getName(), bmw.getColor());
        System.out.printf("Seating capacity : %d, horsepower produced : %d\n", bmw.getCapacity(), bmw.getHorsepower());

        ModelType show = new ModelType(bmw.getCapacity(), bmw.getHorsepower());
        show.modelDetails();
    }
}
