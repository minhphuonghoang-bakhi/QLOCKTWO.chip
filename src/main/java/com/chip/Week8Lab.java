package com.chip;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Week8Lab {
    public static void main(String[] args) {
        DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        int durationSeconds = 60;  // total run time (1 minute = 60 seconds)
        int sleepingSeconds = 10;  // update every 10 seconds (10 seconds pause = do not print out anything)
        int elapsed = 0; //counter to track if it reaches 60 seconds then stop

        //idea structure:
        //while (elapsed < 60) {        // repeat for one minute
        //  print current time          // step 1
        //  Thread.sleep(10000);        // step 2 (pause for 10 seconds)
        //  elapsed += 10;}             // step 3 (track progress)


        while (elapsed < durationSeconds) {
            // Get and print current time
            LocalTime now = LocalTime.now();
            System.out.println("Current time: " + currentTime.format(now));

            //Java exceptions(try - catch): The catch statement allows you to
            // define a block of code to be executed, if an error occurs in the try block.
            try {
                Thread.sleep(sleepingSeconds * 1000); //thread.sleep(ms): make the default main thread pause for 10s
            } catch (InterruptedException e) {
                System.out.println("Clock interrupted!"); //if sth interrupted the try block, print out
                break;
            }

            elapsed += sleepingSeconds;
            //ex: 0-10-20-30-40-50 (just run 6 times in a circle bc 1 minute = 60 seconds)
            //print the current time each 10 seconds in a minute = print just 6 times
        }

        System.out.println("1 minute elapsed!!");
    }
}
