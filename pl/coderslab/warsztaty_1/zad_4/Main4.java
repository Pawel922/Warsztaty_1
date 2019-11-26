package pl.coderslab.warsztaty_1.zad_4;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {

        String userAnswer = getAnswer();
        int score = rollDice(userAnswer);
        System.out.println("Your score: " + score);

    }

    public static int rollDice(String dice){

        int dIndex = dice.indexOf("D");
        String xStr = dice.substring(0,dIndex);
        int x;
        if(xStr.equals("")){
            x = 1;
        } else {
            x = Integer.parseInt(xStr);
        }

        int y,z;
        int signIndex;

        if(dice.contains("+")){
            signIndex = dice.indexOf("+");
            String yStr = dice.substring(dIndex + 1,signIndex);
            String zStr = dice.substring(signIndex + 1,dice.length());
            y = Integer.parseInt(yStr);
            z = Integer.parseInt(zStr);
        } else if (dice.contains("-")) {
            signIndex = dice.indexOf("-");
            String yStr = dice.substring(dIndex + 1,signIndex);
            String zStr = dice.substring(signIndex,dice.length());
            y = Integer.parseInt(yStr);
            z = Integer.parseInt(zStr);
        } else {
            String yStr = dice.substring(dIndex + 1, dice.length());
            y = Integer.parseInt(yStr);
            z = 0;
        }

        int totalScore = 0;

        for(int i = 0; i < x; i++){
            int singleScore = (int)(1 + Math.random() * y);
            totalScore += singleScore;
        }
        return (totalScore + z);
    }

    public static String getAnswer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give an answer according to the formula:");
        System.out.println("xDy+z \nwhere");
        System.out.println("\t x  - number of rolling of dice");
        System.out.println("\t Dy - type of dice (for example: D3, D10, D12, D100)");
        System.out.println("\t z  - number added or subtracted to/from total score");
        String answer = scanner.nextLine();
        return answer;
    }
}
