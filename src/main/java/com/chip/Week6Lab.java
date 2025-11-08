package com.chip;

// Write a function that highlights chosen words (e.g., "IT" → [IT]).
public class Week6Lab {
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
    public static void highlightWord(String word) {   //void: return no values
        for (int i = 0; i < grid.length; i++) {       //do not need String (data type of return value) before method name
            String row = grid[i];
            int index = row.indexOf(word);
            if (index != -1) {
                String beforeWord =  row.substring(0, index);
                String afterWord = row.substring(index + word.length());
                grid[i] = beforeWord + "[" + word.toUpperCase() + "]" + afterWord;
            }
        }
    }
    public static void main(String[] args) {
        highlightWord("IT");
        highlightWord("IS");
        highlightWord("SEVEN");
        highlightWord("O'CLOCK");

        for (String s : grid) {
            System.out.println(s); //print out the grid
        }
    }
}
