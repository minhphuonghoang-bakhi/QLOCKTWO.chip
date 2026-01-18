package com.chip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Week11LabTest {

    @BeforeEach
    public void setup() {
        // Reset language to English before each test
        Week11Lab.currentLanguage = Week11Lab.Language.ENGLISH;
    }

    @Test
    public void testMinutesNearestToFiveEnglish() {
        Week11Lab.currentLanguage = Week11Lab.Language.ENGLISH;
        assertEquals("O'clock", Week11Lab.MinutesNearestToFive(0));
        assertEquals("Five Past", Week11Lab.MinutesNearestToFive(6));
        assertEquals("Quarter Past", Week11Lab.MinutesNearestToFive(16));
        assertEquals("Twenty To", Week11Lab.MinutesNearestToFive(38));
        assertEquals("Five To", Week11Lab.MinutesNearestToFive(57));
    }

    @Test
    public void testMinutesNearestToFiveGerman() {
        Week11Lab.currentLanguage = Week11Lab.Language.GERMAN;
        assertEquals("UHR", Week11Lab.MinutesNearestToFive(0));
        assertEquals("FÜNF NACH", Week11Lab.MinutesNearestToFive(6));
        assertEquals("VIERTEL NACH", Week11Lab.MinutesNearestToFive(16));
        assertEquals("ZWANZIG VOR", Week11Lab.MinutesNearestToFive(38));
        assertEquals("FÜNF VOR", Week11Lab.MinutesNearestToFive(57));
    }

    @Test
    public void testPrintHourEnglish() {
        Week11Lab.currentLanguage = Week11Lab.Language.ENGLISH;
        assertEquals("One", Week11Lab.PrintHour(1));
        assertEquals("Twelve", Week11Lab.PrintHour(12));
        assertEquals("Invalid", Week11Lab.PrintHour(13));  // out of range
    }

    @Test
    public void testPrintHourGerman() {
        Week11Lab.currentLanguage = Week11Lab.Language.GERMAN;
        assertEquals("EINS", Week11Lab.PrintHour(1));
        assertEquals("ZWÖLF", Week11Lab.PrintHour(12));
        assertEquals("UNGÜLTIG", Week11Lab.PrintHour(13));
    }

    @Test
    public void testLanguageSwitch() {
        Week11Lab.currentLanguage = Week11Lab.Language.ENGLISH;
        assertEquals("Five Past", Week11Lab.MinutesNearestToFive(6));
        Week11Lab.currentLanguage = Week11Lab.Language.GERMAN;
        assertEquals("FÜNF NACH", Week11Lab.MinutesNearestToFive(6));
    }
    // Test for case 22:10 - expected: Ten past Ten in 12h Format
    @Test
    void test_22_10() {
        int hour = 22;
        int minute = 10;

        String minuteWord = Week11Lab.MinutesNearestToFive(minute);
        int leftoverMinutes = minute % 5;

        hour = hour % 12;
        if (hour == 0) hour = 12;

        if (minuteWord.contains("To")) {
            hour++;
            if (hour > 12) hour = 1;
        }

        String hourWord = Week11Lab.PrintHour(hour);

        assertEquals("Ten Past", minuteWord);
        assertEquals(0, leftoverMinutes);
        assertEquals("Ten", hourWord);
    }

    // Test for case 17:07 - expected: Five past Five in 12h Format
    @Test
    void test_17_07() {
        int hour = 17;
        int minute = 7;

        String minuteWord = Week11Lab.MinutesNearestToFive(minute);
        int leftoverMinutes = minute % 5;

        hour = hour % 12;
        if (hour == 0) hour = 12;

        if (minuteWord.contains("To")) {
            hour++;
            if (hour > 12) hour = 1;
        }

        String hourWord = Week11Lab.PrintHour(hour);

        assertEquals("Five Past", minuteWord);
        assertEquals(2, leftoverMinutes);
        assertEquals("Five", hourWord);
    }
// case 21:18 expected Twenty past Nine (test for the switching to the 12H format)
    @Test
    void test_21_18() {
        int hour = 21;
        int minute = 18;

        String minuteWord = Week11Lab.MinutesNearestToFive(minute);
        int leftoverMinutes = minute % 5;

        hour = hour % 12;
        if (hour == 0) hour = 12;

        if (minuteWord.contains("To")) {
            hour++;
            if (hour > 12) hour = 1;
        }

        String hourWord = Week11Lab.PrintHour(hour);

        assertEquals("Twenty Past", minuteWord);
        assertEquals(3, leftoverMinutes);
        assertEquals("Nine", hourWord);
    }
}
