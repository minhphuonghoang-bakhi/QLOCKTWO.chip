package com.chip;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Week9Lab {
    public static void main(String[] args) {
        DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        int durationSeconds = 60;
        int sleepingSeconds = 10;
        int elapsed = 0;


        while (elapsed < durationSeconds) {
            // Get and print current time
            LocalTime now = LocalTime.now();
            //get the minute of current time
            int minutes = now.getMinute();
            //calculate for example: 47 = 45 (7*5) + 2 = ((47/5)*5) + 47%5
            int roundedMinutes = (minutes / 5) * 5;
            int leftoverMinutes = minutes % 5; //0-4 minutes

            //print current time without rounded and with minutes rounded
            System.out.println("Current time: " + currentTime.format(now));
            System.out.println("Rounded to 5 mins: " + String.format("%02d:%02d", now.getHour(), roundedMinutes));

            // Display minute dots
            System.out.print("Minute dots: ");
            for (int i = 0; i < leftoverMinutes; i++) {
                System.out.print("● ");
            }
            for (int i = leftoverMinutes; i < 4; i++) { //when it is no leftover minutes
                System.out.print("○ ");
            }

            try {
                Thread.sleep(sleepingSeconds * 1000);
            } catch (InterruptedException e) {
                System.out.println("Clock interrupted!");
                break;
            }

            elapsed += sleepingSeconds;

        }

        System.out.println("1 minute elapsed!!");
    }
}
