package com.chip;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Week2Lab {
    public static void main(String[] args) {
        LocalTime CurrentTime = LocalTime.now(); // method to get current time

        DateTimeFormatter formatHHMM = DateTimeFormatter.ofPattern("HH:mm"); // method to convert into HH:MM format
        String CurrentTimeHHMM = CurrentTime.format(formatHHMM);

        DateTimeFormatter formatHHMMSS = DateTimeFormatter.ofPattern("HH:mm:ss"); // method to convert into HH:MM:SS format
        String CurrentTimeHHMMSS = CurrentTime.format(formatHHMMSS);

        System.out.println("Current Time in HH:MM is : " + CurrentTimeHHMM);
        System.out.println("Current Time in HH:MM:SS is : " + CurrentTimeHHMMSS);
    }
}
