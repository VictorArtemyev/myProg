package myProg.hippodrome;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName()
    {
        return name;
    }

    public double getDistance()
    {
        return distance;
    }

    public void move() {
        distance += speed * Math.random();
    }

    public void print() {

        for (int i = 0; i < (int) getDistance(); i++)
        {
            System.out.print(".");
        }

        System.out.print(getName());
        System.out.println();
    }
}
