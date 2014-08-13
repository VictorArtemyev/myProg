package myProg.hippodrome;

import java.util.ArrayList;

public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100 ; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse: getHorses())
        {
            horse.move();
        }
    }

    public void print() {

        for (Horse horse : getHorses())
        {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {

        double distance = 0;
        Horse winner = null;

        for (Horse horse : horses)
        {
            double tmp = horse.getDistance();

            if (tmp > distance) {
                distance = tmp;
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


    public static void main(String[] args)
    {
        game = new Hippodrome();

        game.getHorses().add(new Horse("Joey", 3, 0));
        game.getHorses().add(new Horse("Monica", 3, 0));
        game.getHorses().add(new Horse("Ross", 3, 0));

        game.run();

        game.printWinner();

    }
}
