/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;
import java.util.ArrayList;
/**
 * Holds all of the rows
 * @author Nolan Davenport
 */
public class LogData {
    ArrayList<RowElement> rows;
    
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
    public void saveLogData(){
        //TODO: Figure out file system
    }
}
