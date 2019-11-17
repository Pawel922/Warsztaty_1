package pl.coderslab.warsztaty_1.zad_1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Random random = new Random();
        int randomNum = random.nextInt(100) + 1;
        int numOfTrial = 0;
        int maxNumOfTrial = 10;

        System.out.println("I have chosen a number from range 1 to 100.\nTry to guess it in less than 10 trials! Good luck!");

        while(numOfTrial <= maxNumOfTrial){

            numOfTrial ++;

            if(numOfTrial == maxNumOfTrial){
                System.out.println("It is your last chance");
            } else if (numOfTrial > maxNumOfTrial){
                System.out.println("It was your last chance! You lose! Try again.");
                break;
            }

            int number = getNumber();

            if (number < randomNum) {
                System.out.println("Your number is too small.");
            } else if (number > randomNum) {
                System.out.println("You number is too big.");
            } else {
                System.out.println("You win! It was your " + ordinalNumber(numOfTrial) + " trial.");
                break;
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

    public static String ordinalNumber(int num){

        String result;
        switch (num){
            case 1:
                result = "1st";
                break;
            case 2:
                result = "2nd";
                break;
            case 3:
                result = "3rd";
                break;
            default:
                result = String.format("%dth",num);
        }
        return result;
    }
}
