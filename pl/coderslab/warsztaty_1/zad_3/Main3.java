package pl.coderslab.warsztaty_1.zad_3;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        String userAnswer;

        int minValue = 1;
        int maxValue = 1000;
        int numOfTrial = 0;
        boolean isWinner = false;
        int guessNum = giveNumber(minValue,maxValue);

        System.out.println("Let's imagine a number from range 0 to 1000.");
        System.out.println("As your computer, I will try to guess it maximally in 10 trial.");
        System.out.println("Let's start!");

        while (numOfTrial < 10){

            numOfTrial ++;
            System.out.println("I guess: " + guessNum);
            userAnswer = takeUserAnswer();
            if(userAnswer.equals("you win")){
                System.out.println("I am so happy. I win!" );
                break;
            } else if (userAnswer.equals("too big")){
                maxValue = guessNum;
                guessNum = giveNumber(minValue,maxValue);
            } else if (userAnswer.equals("too small")) {
                minValue = guessNum;
                guessNum = giveNumber(minValue,maxValue);
            }
            if(numOfTrial == 10){
                System.out.println("You cheat me!");
            }
        }

    }

    public static int giveNumber(int min, int max){

        return (int)(((max - min) / 2 ) + min);
    }

    public static String takeUserAnswer(){

        String userAnswer;
        String tempStr;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your answer? You have three options:");
        System.out.println("\t - too big\n\t - too small\n\t - you win");
        userAnswer = scanner.nextLine();
        while (!((userAnswer.equals("too big")) || (userAnswer.equals("too small")) || (userAnswer.equals("you win")))){
            System.out.println("Do not cheat! Give a proper answer!");
            userAnswer = scanner.nextLine();
        }
        return userAnswer;
    }

}
