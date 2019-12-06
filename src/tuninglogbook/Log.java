package tuninglogbook;
import java.util.*;
/**
 *
 * @author mauri
 */
public class Log {
    private String name;
    private String time;
    private String event;
    private String notes;
    //private Setup set;
    
    public Log(){ //constructor
        name = "";
        time = "";
        event = "";
        notes = "";
    }
    
    public Log(String n, String t, String e, String nts){ //overloadedconstructor
        name = n;
        time = t;
        event = e;
        notes = nts;
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
    
    public String toString(){
        return "Name: " + name + "\n"
             + "Time: " + time + "\n"
             + "Event: " + event + "\n"
             + "Notes: " + notes + "\n";
    }
        
}
