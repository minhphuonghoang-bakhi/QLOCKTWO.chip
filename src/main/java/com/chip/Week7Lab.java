package com.chip;

import java.util.*;
// Write a function that highlights chosen words (e.g., "IT" → [IT]).
public class Week7Lab {
    static String[] grid = {      //list of strings with length of 10
            "ITLISASAMPM",            //main() is static (belongs to the class)
            "ACQUARTERDC",            //grid would be non-static (belongs to an instance/object)
            "TWENTYFIVEX",            //Static methods cannot access instance variables directly (chapter 9)
            "HALFSTENFTO",
            "PASTERUNINE",
            "ONESIXTHREE",
            "FOURFIVETWO",
            "EIGHTELEVEN",
            "SEVENTWELVE",
            "TENSEO'CLOCK"
    };
    public static String MinutesNearestToFive(int minutes) {
        int minuteNearestFive = (int) (Math.round(minutes / 5.0) * 5); //math.round returns a long value

        if (minuteNearestFive == 60) {
            minuteNearestFive = 0;
        }

        switch (minuteNearestFive) { //cast into int because we just need small numbers
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
                return "Invalid value";
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
            default: return "Invalid value";
        }
    }
    public static void highlightWord(String word) {   //void: return no values
                                                      //do not need String (data type of return value) before method name
        word = word.toUpperCase(); // make uppercase to match grid
        for (int i = 0; i < grid.length; i++) {
            String row = grid[i];
            int index = row.indexOf(word);
            if (index != -1) {
                String beforeWord =  row.substring(0, index);
                String afterWord = row.substring(index + word.length());
                grid[i] = beforeWord + "[" + word.toUpperCase() + "]" + afterWord;
                break; //stop after highlighting the first occurrence
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the current time in form HH:MM: ");
        String currentTime = input.nextLine(); //HH:MM (index: 01234)

        //int hour = (int)(currentTime.substring(0, 2)); cannot cast with (int) but with Integer.parseInt()
        //int minute = (int)(currentTime.substring(3, 5));
        int hour = Integer.parseInt(currentTime.substring(0, 2));
        int minute = Integer.parseInt(currentTime.substring(3, 5));
        //convert minute to word
        String minuteWord = MinutesNearestToFive(minute);

        //10:47 is ten to eleven so 10 should be updated to 11
        if (minuteWord.contains("To")) {
            hour++;
            if (hour > 12) hour = 1;
        }
        //convert hour to word
        String hourWord = PrintHour(hour);

        //split the minute words into each word so that the highlightWord method can function
        String[] minuteParts = minuteWord.split(" ");
        //highlight the minute parts
        for (String word : minuteParts) {
            highlightWord(word);
        }
        //highlight the hours
        highlightWord(hourWord);

        highlightWord("IT");
        highlightWord("IS");

        for (String s : grid) {
            System.out.println(s); //print out the grid
        }
    }
}
