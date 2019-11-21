package pl.coderslab.warsztaty_1.zad_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
                if(isScoresFileExist()){
                    saveScores(numOfTrial);
                } else {
                    createScoresFile();
                    saveScores(numOfTrial);
                }
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

    public static void saveScores(int score){

        String[] lastScores = readScores();

        String date = getDate();
        String intToStr = String.valueOf(score);
        String currentScore = date + "\t" + intToStr;

        try{
            PrintWriter printWriter = new PrintWriter("scores.txt");
            for(String results : lastScores){
                printWriter.println(results);
            }
            printWriter.println(currentScore);
            printWriter.close();
        } catch (FileNotFoundException e){
            System.out.println("File does not exist");
        }
    }

    public static String getDate(){

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = dateFormat.format(currentDate);
        return dateString;
    }

    public static String[] readScores(){

        File file = new File("scores.txt");
        String[] resultArray = {};

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                resultArray = Arrays.copyOf(resultArray,resultArray.length + 1);
                resultArray[resultArray.length - 1] = scanner.nextLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("File does not exist");
        }
        return resultArray;
    }

    public static void createScoresFile(){

        File file = new File("scores.txt");
        try{
            boolean isCreated = file.createNewFile();
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println("dd-MM-yyyy" + "\t" + "Trials number");
            printWriter.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File does not exist");
        }
        catch (IOException e){
            System.out.println("Creating file fail");
        }
    }


    public static boolean isScoresFileExist(){

        File file = new File("scores.txt");
        return file.exists();

    }

}
