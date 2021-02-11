
package casino;


import java.util.Scanner;
import java.util.Random;

public class Higherorlower {

    static String card;
    static int prevcard;
    static int score = 0;
    static int newcard;
    static int right;
    static int wrong;

    public static int main() {
        Scanner input = new Scanner(System.in);
        System.out.println("Your first card is the " + randomcard());
        prevcard = newcard;
        System.out.println("Answers other than 'H' and 'L' still count but no points will be gained.");
        System.out.println("Aces are low. You have 10 attempts, Good Luck");
        System.out.println("Right answers award you one but, but be careful wrong answers will reduce you one point instead.");
        System.out.println("If the answer is the same higher and lower are right");
        for (int i = 0; i < 10; i++) {
            System.out.println("Do you think the next guess is higher or lower? H/L");
            String guess = input.nextLine();
            guesscheck(guess);
            System.out.println("The next card is " + card);
        }
        System.out.print("You got " + right + " correct and " + wrong + " incorrect so ");
        System.out.println("your total score is " + score + " points, well done.");

        return score;
    }

    public static String randomcard() {
        Random rand = new Random();
        newcard = ((rand.nextInt(51) + 1) / 4) + 1;

        if (newcard == 11) {
            card = "Jack";
        } else {
            if (newcard == 12) {
                card = "Queen";
            } else {
                if (newcard == 13) {
                    card = "King";
                } else {
                    if (newcard == 1) {
                        card = "Ace";
                    } else {
                        card = Integer.toString(newcard);

                    }
                }
            }
        }
//        prevcard = newcard;
        return (card);
    }

    public static void guesscheck(String check) {
        randomcard();

        int newcar = newcard;
        if (check.equalsIgnoreCase("H")) {

            if (prevcard <= newcar) {
                System.out.println("Correct");
                score++;
                right++;

            } else {
                if (prevcard > newcar) {
                    System.out.println("Incorrect");
                    score--;
                    wrong++;
                }

            }
        }
        if (check.equalsIgnoreCase("L")) {
            if (prevcard >= newcar) {
                System.out.println("Correct");
                score++;
                right++;
            } else {
                if (prevcard < newcar) {
                    System.out.println("Incorrect");
                    score--;
                    wrong++;
                }

            }
        }
        prevcard = newcard;
        
    }

}
