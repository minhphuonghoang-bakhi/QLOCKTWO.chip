package com.chip;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Week11Lab {
    enum Language {ENGLISH, GERMAN}

    static Language currentLanguage = Language.ENGLISH;

    public static String[] gridTemplateEnglish = {
            "ITLISASAMPM",
            "ACQUARTERDC",
            "TWENTYFIVEX",
            "HALFSTENFTO",
            "PASTERUNINE",
            "ONESIXTHREE",
            "FOURFIVETWO",
            "EIGHTELEVEN",
            "SEVENTWELVE",
            "TENSEO'CLOCK"
    };

    public static String[] gridTemplateGerman = {
            "ESKISTLFÜNF",
            "ZEHNZWANZIG",
            "DREIVIERTEL",
            "TGNACHVORJM",
            "HALBQZWÖLFP",
            "ZWEINSIEBEN",
            "KDREIRHFÜNF",
            "ELFNEUNVIER",
            "WACHTZEHNRS",
            "BSECHSFMUHR"
    };

    static String[] grid = new String[10];

    public static void resetGrid() {
        if (currentLanguage == Language.GERMAN) {
            for (int i = 0; i < gridTemplateGerman.length; i++) {
                grid[i] = gridTemplateGerman[i];
            }
        } else {
            for (int i = 0; i < gridTemplateEnglish.length; i++) {
                grid[i] = gridTemplateEnglish[i];
            }
        }
    }

    public static String MinutesNearestToFive(int minutes) {
        int minuteNearestFive = (int) (Math.round(minutes / 5.0) * 5);
        if (minuteNearestFive == 60) minuteNearestFive = 0;

        if (currentLanguage == Language.ENGLISH) {
            switch (minuteNearestFive) {
                case 0:
                    return "O'clock";
                case 5:
                    return "Five Past";
                case 10:
                    return "Ten Past";
                case 15:
                    return "Quarter Past";
                case 20:
                    return "Twenty Past";
                case 25:
                    return "Twenty Five Past";
                case 30:
                    return "Half Past";
                case 35:
                    return "Twenty Five To";
                case 40:
                    return "Twenty To";
                case 45:
                    return "Quarter To";
                case 50:
                    return "Ten To";
                case 55:
                    return "Five To";
                default:
                    return "Invalid";
            }
        } else if (currentLanguage == Language.GERMAN) {
            switch (minuteNearestFive) {
                case 0:
                    return "UHR";
                case 5:
                    return "FÜNF NACH";
                case 10:
                    return "ZEHN NACH";
                case 15:
                    return "VIERTEL NACH";
                case 20:
                    return "ZWANZIG NACH";
                case 25:
                    return "FÜNF VOR HALB";
                case 30:
                    return "HALB";
                case 35:
                    return "FÜNF NACH HALB";
                case 40:
                    return "ZWANZIG VOR";
                case 45:
                    return "VIERTEL VOR";
                case 50:
                    return "ZEHN VOR";
                case 55:
                    return "FÜNF VOR";
                default:
                    return "UNGÜLTIG";
            }
        }
        return "Invalid";
    }

    public static String PrintHour(int hour) {
        if (currentLanguage == Language.ENGLISH) {
            switch (hour) {
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                case 4:
                    return "Four";
                case 5:
                    return "Five";
                case 6:
                    return "Six";
                case 7:
                    return "Seven";
                case 8:
                    return "Eight";
                case 9:
                    return "Nine";
                case 10:
                    return "Ten";
                case 11:
                    return "Eleven";
                case 12:
                    return "Twelve";
                default:
                    return "Invalid";
            }
        } else {
            switch (hour) {
                case 1:
                    return "EINS";
                case 2:
                    return "ZWEI";
                case 3:
                    return "DREI";
                case 4:
                    return "VIER";
                case 5:
                    return "FÜNF";
                case 6:
                    return "SECHS";
                case 7:
                    return "SIEBEN";
                case 8:
                    return "ACHT";
                case 9:
                    return "NEUN";
                case 10:
                    return "ZEHN";
                case 11:
                    return "ELF";
                case 12:
                    return "ZWÖLF";
                default:
                    return "UNGÜLTIG";
            }
        }
    }
    public static final String color = "\u001B[34m";

    public static final String reset = "\u001B[0m";



    public static void highlightWord(String word) {
        word = word.toUpperCase();
        for (int i = 0; i < grid.length; i++) {
            String row = grid[i];
            int index = row.indexOf(word);
            if (index != -1) {
                String beforeWord = row.substring(0, index);
                String afterWord = row.substring(index + word.length());
                grid[i] = beforeWord + "[" + color + word + reset + "]" + afterWord;
                break;
            }
        }
    }

    public static void displayGridWithDots(int leftoverMinutes) {
        for (String row : grid) {
            System.out.println(row);
        }
        // Display minute dots
        System.out.print("Minute dots: ");
        for (int i = 0; i < leftoverMinutes; i++) {
            System.out.print("● ");
        }
        for (int i = leftoverMinutes; i < 4; i++) {
            System.out.print("○ ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //  Language selection
        System.out.println("press 1 or 2 to choose language: 1 = English, 2 = German");
        int choice = input.nextInt();
        currentLanguage = (choice == 2) ? Language.GERMAN : Language.ENGLISH;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        while (true) {  // Run continuously
            resetGrid();  //reset for each loop and also fill the empty grid before hightlightWord

            LocalTime now = LocalTime.now();
            int hour = now.getHour();
            int minute = now.getMinute();

            String minuteWord = MinutesNearestToFive(minute);
            int leftoverMinutes = minute % 5;

            // Adjust hour if minute word contains "To" / "VOR"
            if (minuteWord.contains("To") || minuteWord.contains("VOR")) {
                hour++;
                if (hour > 12) hour = 1;
            } else if (hour > 12) {
                hour -= 12;
            }

            if (hour == 0) hour = 12;

            String hourWord = PrintHour(hour);

            // Highlight words
            highlightWord(currentLanguage == Language.GERMAN ? "ES" : "IT");
            highlightWord(currentLanguage == Language.GERMAN ? "IST" : "IS");

            for (String part : minuteWord.split(" ")) highlightWord(part);  //highlight each word in "TEN PAST"
            highlightWord(hourWord);

            // Display
            System.out.println("Current time: " + now.format(timeFormatter));
            displayGridWithDots(leftoverMinutes);

            // Wait until next minute
            try {
                Thread.sleep(60 * 1000);  // update every minute
            } catch (InterruptedException e) {
                System.out.println("Clock interrupted!");
                break;
            }
        }
    }
}