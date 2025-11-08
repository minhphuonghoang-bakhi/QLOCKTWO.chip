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
}
