package casino;

import java.util.Scanner;

public class Casino {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("How many chips do you have?");

        int userchips = input.nextInt();
        boolean end = false;
        while(end == false){
        
        System.out.println("What do you wqant to play?");
        System.out.println("1. Blackjack");
        System.out.println("2. Higher or lower");
        System.out.println("3. Roulette");

        int userChoice = input.nextInt();

        switch (userChoice) {
            case 1:
                
                System.out.println("How many chips are you putting in?");
                int blackchips = input.nextInt();
                int win = Blackjack.main();
                
                if (win == 1) {
                    userchips = userchips + (blackchips * 2);

                } else {
                    if (win == 2) {
                        userchips = userchips - blackchips;
                    }
                }
                break;
                
            case 2:
                System.out.println("How many chips are you putting in?");
                int holchips = input.nextInt();
                int score = Higherorlower.main();
                if (score >= 5) {
                    userchips = userchips + (holchips * 2);

                } else {
                    if (score < 5) {
                        userchips = userchips - holchips;
                    }
                }
                break;
                
            case 3:
                int chips = Roulette.main();
                userchips = userchips + chips;
                break;

        }
            System.out.println("");
            System.out.println("");
            System.out.println("do you want to end? Y/N");
            String choice = input.next();
            
            if (choice.equalsIgnoreCase("y")) {
                end = true;
            }

    }
        
        System.out.println("Hope you endoyed the games.");
        System.out.println("You ended with " + userchips + " chips.");
        
}}
