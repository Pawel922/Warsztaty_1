package pl.coderslab.warsztaty_1.zad_5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Scanner;


public class Main5 {

    public static void main(String[] args) {

        String[] rejectedWords = {"gdyż", "ponieważ", "oraz", "albo", "jest", "jakie", "które", "jego"};

        String msn = createPortalAddress("msn");
        String interia = createPortalAddress("interia");
        String onet = createPortalAddress("onet");

        savePopularWords(msn,3);
        savePopularWords(interia,3);
        savePopularWords(onet,3);

        saveFilteredWords("popular_words.txt",rejectedWords);

    }

    public static String createPortalAddress(String name){

        return String.format("http://www.%s.pl", name);

    }

    public static void savePopularWords(String portalName, int threshold){

        Elements headings = getHeadings(portalName);
        try{

            FileWriter fileWriter = new FileWriter("popular_words.txt",true);
            for(Element elem : headings){
                String selectedWords = selectWords(elem,3);
                fileWriter.append(selectedWords + "\n");
            }
            fileWriter.close();

        } catch (FileNotFoundException e){
            System.out.println("Cannot find a file");
        } catch (IOException e){
            System.out.println("Something goes wrong");
        }
    }

    public static Elements getHeadings(String portalName){

        Elements links = new Elements();
        Connection connect = Jsoup.connect(portalName);
        try {
            Document document = connect.get();
            links = document.select("span.title");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

    public static String selectWords(Element elem, int threshold){

        StringBuilder resultStr = new StringBuilder();
        String tempStr = elem.text();
        String[] tempArray = tempStr.split(" ");
        for(String word : tempArray) {
            if (word.length() > threshold) {
                resultStr.append(word + " ");
            }
        }
        return resultStr.toString();
    }

    public static void saveFilteredWords(String sourceName, String[] deletedWords){
        File file = new File("popular_words.txt");
        try {

            Scanner scanner = new Scanner(file);
            FileWriter fileWriter = new FileWriter("filtered_popular_words.txt");
            String tempStr;
            while(scanner.hasNextLine()){
                tempStr = scanner.nextLine();
                for(String word : deletedWords){
                    tempStr = tempStr.replaceAll(word,"");
                }
                fileWriter.append(tempStr + "\n");
            }
            fileWriter.close();

        } catch (FileNotFoundException e){
            System.out.println("File does not exist");
        } catch (IOException e){
            System.out.println("Something goes wrong");
        }

    }

}
