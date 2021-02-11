package casino;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Roulette {

    static int chips;
    static int game;
    static int wins;
    static int end = 0;
    static int out;
    
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    static ArrayList<Integer> guesseschips = new ArrayList<Integer>();
    static ArrayList<Integer> guesseslocat = new ArrayList<Integer>();

    public static int main() {

        System.out.println("How many chips are you puting in?");
        chips = input.nextInt();

        play();
        spin();
        return out;
    }

    public static void play() {

        boolean done = false;

        while (done == false) {

            System.out.println("Where would you like to put chips? 1-36");

            int locat = input.nextInt();

            System.out.println("How many chips would you like to put down?");

            int numchip = input.nextInt();

            if (numchip > chips) {
                System.out.println("You dont have that many chips");
                System.out.println("You have " + chips + " ships left.");
                end = end--;
            } else {
                if (numchip <= chips) {
                    chips = chips - numchip;

                    guesseschips.add(numchip);
                    guesseslocat.add(locat);
                }
            }

            System.out.println("would you like to put more chips down, yes or no? (maximum of 3 places)");
            String again = input.next();
            if (again.equalsIgnoreCase("no")) {
                done = true;
            } else {
                end = end + 1;
            }

            if (end == 3) {
                done = true;
            }

        }

    }

    public static void spin() {
        //http://www.casinocity.com/rule/roulette.htm

        int spin = rand.nextInt(35) + 1;

        if (guesseslocat.size() == 1) {
            System.out.println("Straight bets");
            game = 1;
            wins = 35;
        } else {
            if (guesseslocat.size() == 2) {
                System.out.println("Straight bets");
                game = 2;
                wins = 17;
            } else {
                if (guesseslocat.size() == 3) {
                    System.out.println("Straight bets");
                    game = 3;
                    wins = 11;
                }
            }

        }
        System.out.println("The spin outcome is " + spin + ".");
        if (guesseslocat.contains(spin)) {
            System.out.println("You win");
            int winninglocat = guesseslocat.indexOf(spin);
            out = wins * guesseschips.get(winninglocat);
            System.out.println("You won " + out + " more chips");
            chips = chips + out;
        } else {
            System.out.println("You lose");
        }

    }
}
