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
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Hareesh Parchuri
 */
public class FileCorrelation {
    ArrayList<FileLogPair> fileLogPairs;
    ArrayList<File> fileList;
    ArrayList<Log> notFound;
    int buffer;
    File directory;
    
    // Constructor sets directory of files to be correlated
    public FileCorrelation(){
        directory =  new File("TestingDay4-17/");
        
        init();
    }
    
    public FileCorrelation(String d){
        directory = new File(d);
        
        init();
    }
    
    private void init() {
        fileList = (ArrayList) Arrays.asList(directory.listFiles());

        buffer = findBuffer(fileList);

        fileLogPairs = new ArrayList<>();
        
        notFound = new ArrayList<>();
    }

    public String findFilesAtTimes(LogData rowElemList) {
        // Pass a Row Element with the time attribute
        // Parses the ISO formatted datetime
        // Example: "2019-04-14T12-01-15-507944"
        // Also works with colons instead of hyphens
        // Returns the filename as a string, or "Filenotfound"
        // TODO:
        // Associate a whole list of records to files
        // Return a filename and the corresponding row element

        rowElemList.rows.forEach((row) -> {
            int returnCode = associateRow(row);
            if(returnCode == -1){
                notFound.add(row);
            }
        });
        
        
        //Log inputRowElem = rowElemList.getRow(0);
        
        //String inputTimeString = "2019-04-14T12-01-15-507944";
        //LocalDateTime time = dateTimeParser(inputRowElem.getTime());

        //File directory = new File("TestingDay4-17/");
        //System.out.println(directory.isDirectory());
        //File[] fileList = directory.listFiles();

        if(!notFound.isEmpty()){
            return "Not all rows associated";
        }
        else{
            return "Done";
        }

        //return "Filenotfound";
    }
    
    int associateRow(Log rowElem){
        
        LocalDateTime time = dateTimeParser(rowElem.getTime());
        
        for (File file : fileList) {
            String currentFilename = file.getName();

            LocalDateTime thisTime = dateTimeParser(currentFilename);

            if (Math.abs(ChronoUnit.SECONDS.between(time, thisTime)) < buffer) {
                fileLogPairs.add(new FileLogPair(file, rowElem));
                //fileList.remove(file);
                return 0;
            }
        }
        return -1;
    }

    static int findBuffer(ArrayList<File> fileList) {

        long smallestGap = ChronoUnit.SECONDS.between(
                dateTimeParser(fileList.get(0).getName()),
                dateTimeParser(fileList.get(1).getName()));

        for (int i = 1, j = 2; j < fileList.size(); i++, j++) {
            long thisGap = ChronoUnit.SECONDS.between(
                    dateTimeParser(fileList.get(i).getName()),
                    dateTimeParser(fileList.get(j).getName()));

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
    

    
    private class FileLogPair {
        private final File file;
        private final Log log;
        
        FileLogPair(File f, Log l){
            file = f;
            log = l;
        }
        
        public File getFile(){
            return file;
        }
        
        public Log getLog(){
            return log;
        }
        
        @Override
        public String toString(){
            return file.getName() + " " + log.getName();
        }
        
    }
}
