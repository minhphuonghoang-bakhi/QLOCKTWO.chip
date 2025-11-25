package com.chip;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Week10Lab {
    static String[] gridTemplate = {
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

    static String[] grid = new String[gridTemplate.length];

    public static void resetGrid() {        //reset grid each time and also filled in the grid
        for (int i = 0; i < gridTemplate.length; i++) {
            grid[i] = gridTemplate[i];
        }
    }

    public static String MinutesNearestToFive(int minutes) {
        int minuteNearestFive = (int) (Math.round(minutes / 5.0) * 5);
        if (minuteNearestFive == 60) minuteNearestFive = 0;

        switch (minuteNearestFive) {
            case 0: return "O'clock";
            case 5: return "Five Past";
            case 10: return "Ten Past";
            case 15: return "Quarter Past";
            case 20: return "Twenty Past";
            case 25: return "Twenty Five Past";
            case 30: return "Half Past";
            case 35: return "Twenty Five To";
            case 40: return "Twenty To";
            case 45: return "Quarter To";
            case 50: return "Ten To";
            case 55: return "Five To";
            default: return "Invalid";
        }
    }

    public static String PrintHour(int hour) {
        switch (hour) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            default: return "Invalid";
        }
    }

    public static void highlightWord(String word) {
        word = word.toUpperCase();
        for (int i = 0; i < grid.length; i++) {
            String row = grid[i];  //go through each string in string array
            int index = row.indexOf(word);  //index of the first char of word in the row
            if (index != -1) {
                String beforeWord = row.substring(0, index);
                String afterWord = row.substring(index + word.length());
                grid[i] = beforeWord + "[" + word + "]" + afterWord;  //put in klammern
                break;  //forgotten lol break so that it doesnt print out FIVE two times in grid
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
        int durationMinutes = 10; // total run time
        int sleepSeconds = 60;    // refresh every minute
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (int elapsed = 0; elapsed < durationMinutes; elapsed++) {  //elapse + 1 until 10
            resetGrid();

            LocalTime now = LocalTime.now();
            int hour = now.getHour();
            int minute = now.getMinute();

            String minuteWord = MinutesNearestToFive(minute);
            int leftoverMinutes = minute % 5;

            // Adjust hour if minute word contains "To"
            // Make sure the clock in 12 hours format
            if (minuteWord.contains("To")) {
                hour++;
                if (hour > 12) hour = 1; //12:47: Ten To One (13Oclock => One)
            }
            else if (hour > 12) { //for another hours not containing To: 14:30 = HALF PAST TWO (14 - 12 = 2)
                hour -= 12;
            }

            String hourWord = PrintHour(hour);

            // Highlight words
            highlightWord("IT");
            highlightWord("IS");
            for (String part : minuteWord.split(" ")) highlightWord(part);
            highlightWord(hourWord);

            // Display
            System.out.println("Current time: " + timeFormatter.format(now));
            displayGridWithDots(leftoverMinutes);

            // Wait for next update
            try {
                Thread.sleep(sleepSeconds * 1000);
            } catch (InterruptedException e) {
                System.out.println("Clock interrupted!");
                break;
            }
        }

        System.out.println("10 minutes elapsed!");
    }
}
