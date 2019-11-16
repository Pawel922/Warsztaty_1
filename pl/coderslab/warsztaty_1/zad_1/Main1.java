package pl.coderslab.warsztaty_1.zad_1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Random random = new Random();
        int wylosowanaLiczba = random.nextInt(100) + 1;
        int ilosc_prob = 0;

        System.out.println("Wylosowałem liczbę, zgadnij jaką?");

        boolean win = false;

        while(!win) {


            int liczba = wczytajliczbe();
            ilosc_prob ++;

            if (liczba < wylosowanaLiczba) {
                System.out.println("Podana liczba jest za mała");
            } else if (liczba > wylosowanaLiczba) {
                System.out.println("Podana liczba jest za duża");
            } else {
                System.out.println("Zgadłeś w " + ilosc_prob + " probie.");
                win = true;
            }
        }
    }

    public static int wczytajliczbe(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę:");
        while(!scanner.hasNextInt()){
            System.out.println("Musisz podac liczbe");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
