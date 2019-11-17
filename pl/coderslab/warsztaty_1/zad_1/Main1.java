package pl.coderslab.warsztaty_1.zad_1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Random random = new Random();
        int randomNum = random.nextInt(100) + 1;
        int numOfTrial = 0;

        System.out.println("Try to find a number which I have chosen. Good luck!");

        boolean win = false;

        while(!win) {


            int number = getNumber();
            numOfTrial ++;

            if (number < randomNum) {
                System.out.println("Your number is too small.");
            } else if (number > randomNum) {
                System.out.println("You number is too big.");
            } else {
                System.out.println("You win! It was your " + numOfTrial + " trial.");
                win = true;
            }
        }
    }

    public static int getNumber(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a number:");
        while(!scanner.hasNextInt()){
            System.out.println("Invalid value. You have to give a number.");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
