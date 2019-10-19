/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
/**
 * Holds all of the rows
 * @author Nolan Davenport
 */
public class LogData {
    ArrayList<RowElement> rows;
    String fileDirectory;
    
    /**
     * Instantiates a LogData object using an ArrayList of previously instantiated rows
     * @param rows rows to be added
     */
    public LogData(ArrayList<RowElement> rows){
        this.rows = rows;
    }
    
    public LogData(){
        rows = new ArrayList<RowElement>();
    }
    
    /**
     * Adds a new RowElement to the rows ArrayList
     * @param row row to be added
     */
    public void addRow(RowElement row){
        rows.add(row);
    }
    
    /**
     * Deletes the RowElement at the specified index
     * @param index index of desired RowElement
     */
    public void deleteRow(int index){
        rows.remove(index);
    }
    
    /**
     * Returns the RowElement at the specified index
     * @param index index of desired RowElement
     * @return RowElement at the index
     */
    public RowElement getRow(int index){
        return rows.get(index);
    }
    
    /**
     * Saves each row element into a file
     */
    public void saveLogData(String filename) throws Exception{
        //TODO: Figure out file system
        
        File fout = new File(fileDirectory + File.separator + filename + ".logbook");
        fout.mkdirs();
        fout.createNewFile();
        
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        
        for (RowElement row : rows) {
            String tags = "";
            bw.write(row.getName() + "⨁" + row.getTime() + "⨁" + row.getEvent() + "⨁" + row.getNotes() + "⨁");
            for(float value : row.getSetup().setupData){
                bw.write(value + " ");
            }
            bw.newLine();
        }
        bw.close();  
    }
    
    public void setFileDirectory(){ //TODO: Learn the correct file directory for this to be saved
        if(Util.getOS() == "WINDOWS"){
            fileDirectory = "C:" + File.separator + "Program Files" + File.separator + "DataAnalyzer" + File.separator +"Log Book";
        }else if(Util.getOS() == "MAC"){
            fileDirectory = "Applications" + File.separator + "DataAnalyzer" + File.separator +"Log Book";
        }else if(Util.getOS() == "LINUX"){
            fileDirectory = File.separator + "run" + File.separator + "DataAnalyzer" + File.separator +"Log Book";
        }
    }
}
