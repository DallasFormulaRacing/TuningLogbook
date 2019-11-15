/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Hareesh Parchuri
 */
public class FileCorrelation {

    public static String findFileAtTime(RowElement inputRowElem)  {
        // Pass a Row Element with the time attribute
        // Parses the ISO formatted datetime
        // Example: "2019-04-14T12-01-15-507944"
        // Also works with colons instead of hyphens
        // Returns the filename as a string, or "Filenotfound"

        // TODO:
        // Associate a whole list of records to files
        // Return a filename and the corresponding row element
        
        
        //String inputTimeString = "2019-04-14T12-01-15-507944";
        LocalDateTime time = dateTimeParser(inputRowElem.getTime());

        File directory = new File("TestingDay4-17/");
        //System.out.println(directory.isDirectory());
        File[] fileList = directory.listFiles();

        int buffer = findBuffer(fileList);

        //System.out.println(buffer);

        /*System.out.println(ChronoUnit.SECONDS.between(
                dateTimeParser(fileList[2].getName()),
                dateTimeParser(fileList[1].getName())));*/
        
        for (File file : fileList) {
            String currentFilename = file.getName();

            LocalDateTime thisTime = dateTimeParser(currentFilename);

            if (Math.abs(ChronoUnit.SECONDS.between(time, thisTime)) < buffer) {
                return currentFilename;
            }
        }
        return "Filenotfound";
    }

    static int findBuffer(File[] fileList) {

        long smallestGap = ChronoUnit.SECONDS.between(
                dateTimeParser(fileList[0].getName()),
                dateTimeParser(fileList[1].getName()));

        for (int i = 1, j = 2; j < fileList.length; i++, j++) {
            long thisGap = ChronoUnit.SECONDS.between(
                    dateTimeParser(fileList[i].getName()),
                    dateTimeParser(fileList[j].getName()));

            if (thisGap < smallestGap) {
                smallestGap = thisGap;
            }
        }

        return (int) (smallestGap / 2);
    }

    static LocalDateTime dateTimeParser(String time) {

        Scanner dateTimeSplitter = new Scanner(time);
        dateTimeSplitter.useDelimiter(Pattern.compile("T|-|\\.|:"));

        int year = dateTimeSplitter.nextInt();
        int month = dateTimeSplitter.nextInt();
        int day = dateTimeSplitter.nextInt();

        int hours = dateTimeSplitter.nextInt();
        int minutes = dateTimeSplitter.nextInt();
        int seconds = dateTimeSplitter.nextInt();

        int nanoseconds;
        LocalDateTime dateTime;

        if (dateTimeSplitter.hasNextInt()) {
            nanoseconds = dateTimeSplitter.nextInt() * 1000;
            dateTime = LocalDateTime.of(year, month, day, hours, minutes, seconds, nanoseconds);
        } else {
            dateTime = LocalDateTime.of(year, month, day, hours, minutes, seconds);
        }

        return dateTime;
    }
}
