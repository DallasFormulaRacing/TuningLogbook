package tuninglogbook;

/**
 * Holds the data in a single row
 * @author Nolan Davenport
 */
public class RowElement {
    String name;
    String time;
    String event;
    String notes;
    Setup setup;

    /**
     * Constructs a row element using parameters
     */
    public RowElement(String name, String time, String event, String notes, Setup setup) {
        this.name = name;
        this.time = time;
        this.event = event;
        this.notes = notes;
        this.setup = setup;
    }
    
    //getters
    public String getName(){return name;}
    public String getTime(){return time;}
    public String getEvent(){return event;}
    public String getNotes(){return notes;}
    public Setup getSetup(){return setup;}
    //setters
    public void setName(String name){this.name = name;}
    public void setTime(String time){this.time = time;}
    public void setEvent(String event){this.event = event;}
    public void setNotes(String notes){this.notes = notes;}
    public void setSetup(Setup setup){this.setup = setup;}
    
}
