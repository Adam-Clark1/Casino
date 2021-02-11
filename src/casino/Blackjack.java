
package casino;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    static Scanner input = new Scanner(System.in);
    static ArrayList arraylist = new ArrayList<>();
    static Random rand = new Random();
    static int win;
    
    static ArrayList<Integer> cards = new ArrayList<>();
    static ArrayList<Integer> playercards = new ArrayList<>();
    static ArrayList<Integer> playercards1 = new ArrayList<>();

    static int playerscore;
    static int playerscore1 = 0;

    public static int main() {

        System.out.println("Welcome to Blackjack");
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 11; j++) {
                cards.add(j);
            }
        }
//        System.out.println(cards);
        game();
        for (int i = 0; i < playercards.size(); i++) {
            playercards1.add(playercards.get(i));
        }
        for (int i = 0; i < playercards1.size(); i++) {
            playerscore1 = playerscore1 + playercards1.get(i);
        }
        System.out.println("Player 2's turn");
        game();
        finalscores();

        return win;
    }

    public static void game() {

        int card = rand.nextInt(cards.size());
        System.out.println("Your first card is a " + cards.get(card));
        playerscore = cards.get(card);
        playercards.add(playerscore);
        cards.remove(card);
        while (true || playerscore > 21) {

            System.out.println("Would you like to: S. Stick or T. Twist Please input the repective letter.");
            String choice = input.next();
            System.out.println("");

            if (choice.equalsIgnoreCase("T")) {
                twist();
            } else if (choice.equalsIgnoreCase("S")) {
                System.out.println("Ok, you stick.");
                break;
            } else if (playerscore > 21) {
                System.out.println("BUST");
            }
        }
        System.out.println(playercards);
        System.out.println("");
        System.out.println(playerscore);
    }

    public static void twist() {

        int card = rand.nextInt(cards.size());
        System.out.println("Your next card is a " + cards.get(card));
        playercards.add(playerscore);
        playerscore = playerscore + cards.get(card);

        cards.remove(card);

    }

    public static void finalscores() {

        if (playerscore > playerscore1) {
            System.out.println("Player 2 wins with a score of: " + playerscore);
            win = 1;
        } else if (playerscore < playerscore1) {
            System.out.println("Player 1 wins with a score of: " + playerscore1);
            win = 2;
        }

    }

    
}
