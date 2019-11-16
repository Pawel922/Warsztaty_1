package pl.coderslab.warsztaty_1.zad_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        int[] numFromUser = getAnswer();
        int[] numFromLottery = simulateLottery();
        System.out.print("Numbers which you choose are follow: " + Arrays.toString(numFromUser) + "\n");
        System.out.print("Numbers which win today are follow : " + Arrays.toString(simulateLottery()) + "\n");

        checkWin(numFromUser,numFromLottery);

    }

    public static int[] getAnswer(){

        int number;
        int index = 0;
        int[] chosenNumbers = new int[6];

        System.out.println("Give 6 different numbers from range 1 to 49:");

        do {
            number = getNumber();
            if(checkValue(number,1,49)){
                if(checkNonRepeated(number,chosenNumbers)){
                    chosenNumbers[index] = number;
                    index ++;
                }
            }
        } while (index < 6);

        Arrays.sort(chosenNumbers);
        return chosenNumbers;

    } //end of method


    public static int getNumber(){

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Invalid value. Give a number:");
            scanner.nextLine();
        }
        return scanner.nextInt();

    } //end of method

    public static boolean checkValue(int num, int minValue, int maxValue){

        boolean isValueCorrect = true;
        if(!((num >= minValue) && (num <= maxValue))){
            System.out.println("Your number is out of range. Give another one:");
            isValueCorrect = false;
        }
        return isValueCorrect;

    } //end of method

    public static boolean checkNonRepeated(int num, int[] numArrays){

        boolean isNumberNonRepeated = true;
        for(int item : numArrays){
            if(num == item){
                System.out.println("You have already given this number. Give another one:");
                isNumberNonRepeated = false;
                break;
            }
        }
        return isNumberNonRepeated;

    } //end of method

    public static int[] simulateLottery(){

        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(arr));

        int[] result = new int[6];
        for(int i = 0; i < result.length; i++){
            result[i] = arr[i];
        }

        return result;

    } //end of method

    public static void checkWin(int[] userNum, int[] lotteryNum){

        int counter = 0;

        for(int i = 0; i < userNum.length; i++){
            for(int j = 0; j < lotteryNum.length; j++){
                if(userNum[i] == lotteryNum[j]){
                    counter ++;
                }
            }
        }

        switch (counter){
            case 3:
                System.out.println("You have guessed three numbers. Great!");
                break;
            case 4:
                System.out.println("You have guessed four numbers. Congratulations!");
                break;
            case 5:
                System.out.println("You have guessed five numbers. Lucky you!");
                break;
            case 6:
                System.out.println("You have guessed six numbers. You are a millionaire!");
                break;
            default:
                System.out.println("You have not won anything. Try again. Good luck!");

        }
    } //end of method

} //end of class
