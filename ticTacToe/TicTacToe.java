package myProg.ticTacToe;

import java.util.Scanner;

public class TicTacToe {

    private static final int DEFAULT_FIELD_SIZE = 3;

    private static final char X = 'X';

    private static final char O = 'O';

    private final int fieldSize;

    public final char[][] field;

    private boolean gameAvailable = true;

    public TicTacToe(int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new char[fieldSize][fieldSize];
    }

    public void fillField () {
        int spot = 1;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] =(char)spot++;
            }
        }
    }

    public void showField() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {

                if (Character.isLetter(field[i] [j])) {
                    System.out.print("[ " + field[i][j] + " ]");
                } else {
                    System.out.print("[ " + (int) field[i][j] + " ]");
                }
            }
            System.out.println();
        }
    }

    public void move(int spot, char symbol) {
        switch (spot) {
            case 1 : field[0][0] = symbol;
                break;
            case 2 : field[0][1] = symbol;
                break;
            case 3 : field[0][2] = symbol;
                break;
            case 4 : field[1][0] = symbol;
                break;
            case 5 : field[1][1] = symbol;
                break;
            case 6 : field[1][2] = symbol;
                break;
            case 7 : field[2][0] = symbol;
                break;
            case 8 : field[2][1] = symbol;
                break;
            case 9 : field[2][2] = symbol;
                break;
        }
    }

    public boolean checkFreeCell(int spot) {
        boolean freeCell = false;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (field[i][j] == (char) spot) {
                    freeCell = true;
                    break;
                }
            }
        }
        return freeCell;
    }

    public char checkWinner(char symbol) {

        char winner = ' ';

        //horizontal
        if (field[0][0] == symbol && field[0][1] == symbol && field[0][2] == symbol ||
                field[1][0] == symbol && field[1][1] == symbol && field[1][2] == symbol ||
                field[2][0] == symbol && field[2][1] == symbol && field[2][2] == symbol) {
            winner = symbol;
            gameAvailable = false;
            //vertical
        } else if (field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol ||
                field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol ||
                field[0][2] == symbol && field[1][2] == symbol && field[2][2] == symbol) {
            winner = symbol;
            gameAvailable = false;
            //left diagonal
        } else if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
            winner = symbol;
            gameAvailable = false;
            //right diagonal
        } else if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) {
            winner = symbol;
            gameAvailable = false;
            //check draw
        } else {
            int count = 1;
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    if (Character.isLetter(field[i][j])) {
                        count++;
                    }
                }
            }
            if (count == 9) {
                winner = 'd';
                gameAvailable = false;
            }
        }
        return winner;
    }

    public void play() {

        int spot;

        Scanner in = new Scanner(System.in);
        System.out.println("Game Start!");
        fillField();
        showField();

        do {

            //move X
            if(gameAvailable) {

                System.out.println("Player 'X', enter your move ( 1 - 9 ):");
                spot = in.nextInt();
                while (true) {
                    if ((spot > 0 && spot < 10) && checkFreeCell(spot)) {
                        move(spot, X);
                        System.out.println("Nice move!");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Please, enter correct move!");
                        spot = in.nextInt();
                    }
                }
                showField();
                if (checkWinner(X) == X) {
                    System.out.println("Player 'X' wins the game!");
                } else if (checkWinner(X) == 'd') {
                    System.out.println("It's a Draw!");
                }
            }

            //move O
            if (gameAvailable) {
                System.out.println("Player 'O', enter your move ( 1 - 9 ):");
                spot = in.nextInt();
                while (true) {
                    if ((spot > 0 && spot < 10) && checkFreeCell(spot)) {
                        move(spot, O);
                        System.out.println("Nice move!");
                        System.out.println();
                        break;
                    } else {
                        System.out.println("Please, enter correct move!");
                        spot = in.nextInt();
                    }
                }
                showField();
                if (checkWinner(O) == O) {
                    System.out.println("Player 'O' wins the game!");
                } else if (checkWinner(O) == 'd') {
                    System.out.println("It's a Draw!");
                }
            }

            if (!gameAvailable) {
                System.out.println("Would you like to play again (Enter 'y')?");
                Scanner sc = new Scanner(System.in);
                String str = sc.nextLine();
                if (str.equals("y")) {
                    gameAvailable = true;
                    fillField();
                    showField();
                }
            }

        } while (gameAvailable);
    }

    public static void main(String[] args) {
        new TicTacToe(DEFAULT_FIELD_SIZE).play();
    }

}
