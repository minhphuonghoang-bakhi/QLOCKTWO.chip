package com.chip;

public class Week3Lab {
    public static String printing12HoursIntoWord(int number) {
        switch (number) {
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
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            System.out.println(i + " now is " + printing12HoursIntoWord(i) + " " + "o'clock.");
        }
    }
}
