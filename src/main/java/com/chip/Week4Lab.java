package com.chip;

import java.util.*;

public class Week4Lab {
    public static String MinutesNearestToFive(long minutes) {
        long minuteNearestFive = Math.round(minutes / 5.0) * 5; //math.round returns a long value

        if (minuteNearestFive == 60) {
            minuteNearestFive = 0;
        }

        switch ((int) minuteNearestFive) { //cast into int because we just need small numbers
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of minutes from 0 to 59: ");
        int minute = input.nextInt();
        System.out.print("It is: " + MinutesNearestToFive(minute));
    }
}
