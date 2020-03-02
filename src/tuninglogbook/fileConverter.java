package tuninglogbook;
import java.io.*;
import java.util.List;
import com.arib.categoricalhashtable.CategoricalHashTable;



public class fileConverter {
	
	CategoricalHashMap dataMap = new CategoricalHashMap();
	
	String fileNotes;
	
	public void convertFile(String filepath, String filename, String fileNotes) {
		CategoricalHashTable<CategorizedValueMarker> staticMarkers = new CategoricalHashTable<>();
		TXTParser.parse(dataMap, staticMarkers, filepath, 0);
		saveFile(filename, fileNotes);
	}
	
	
	private String getStringOfData() {
        StringBuilder toReturn = new StringBuilder();
        
        //for each tag of data
        for(String tag : dataMap.tags) {
            //output the tag
            toReturn.append(tag);
            toReturn.append("\n");
            //get the list of data for the current tag
            List<LogObject> data = dataMap.getList(tag);
            //for each data element
            for(LogObject lo : data) {
                //output the data
                toReturn.append(lo.toString());
                toReturn.append("\n");
            }
            
            //output END to signify end of data for this tag.
            toReturn.append("END\n");
        }
        
        //return calculated value
        return toReturn.toString();
        
    }
	
       
	

	private void saveFile(String filename, String fileNotes) {
        //add normal data
        StringBuilder sb = new StringBuilder(getStringOfData());
        //append vehicle dynamic data
        sb.append("VEHICLEDYNAMICDATA");
        sb.append("\n");
        //append lap data
        sb.append("LAPDATA");
        sb.append("\n");
        if(!fileNotes.isEmpty()) {
            sb.append("FILENOTES\n");
            sb.append(fileNotes);
        }
        
        String chosenFileName = "";
        try(FileWriter fw = new FileWriter(chosenFileName + ".dfr")) {
            //write the data
            fw.write(sb.toString());
            //close the file writer
            fw.close();
        //exception handling
        } catch (IOException e) {

        }
        //if a filename was not provided
	}
        
	
}