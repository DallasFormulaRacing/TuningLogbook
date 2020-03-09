package tuninglogbook;
import java.util.*;
/**
 * This class holds the information for a row
 * @author mauri
 */
public class Log {
    private String name;
    private String time;
    private String event;
    private String notes;
    private Setup set;
    
    public Log(){ //constructor
        name = "";
        time = "";
        event = "";
        notes = "";
        set = new Setup();
    }
    
    public Log(String n, String t, String e, String nts, Setup s){ //overloadedconstructor
        name = n;
        time = t;
        event = e;
        notes = nts;
        set = s;
    }
    
    //mutators
    public void setName(String n){
        name = n;
    }
    
    public void setTime(String t){
        time = t;
    }
    
    public void setEvent(String e){
        event = e;
    }
    
    public void setNotes(String nts){
        notes = nts;
    }
    
    public void setSetup(Setup s){
        set = s;
    }
    
    //accessors
    public String getName(){
        return name;
    }
    
    public String getTime(){
        return time;
    }
    
    public String getEvent(){
       return event;
    }
    
    public String getNotes(){
        return notes;
    }
    
    public Setup getSetup(){
        return set;
    }
    
    public String toString(){
        return "Name: " + name + "\n"
             + "Time: " + time + "\n"
             + "Event: " + event + "\n"
             + "Notes: " + notes + "\n"
                + "Setup: done \n";
    }            
}
