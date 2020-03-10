package tuninglogbook;

import java.io.*;
import java.util.List;
import com.arib.categoricalhashtable.CategoricalHashTable;

/**
 * This class uses already existing code to quickly convert files from one format to the next
 * Starting format: CSVs/TXTs
 * Ending format: DFRs
 * Path: (CSVs/TXTs) -> CategoricalHashMap() -> DFRs
 * TODO: rememeber that class names in java always have capital words: FileConverter
 */
public class fileConverter {

    //The dataMap that the raw input file will be read into
    CategoricalHashMap dataMap = new CategoricalHashMap();

    //file notes that will be passed in
    String fileNotes;

    /**
     * Essentially the main method of this class.
     * Calls the TXT parser on the input file which populates data map TXT -> dataMap
     * Then calls the save method which goes from dataMap -> DFR file
     * TODO: Perhaps this should be static so that you don't need to create a
     * fileConverter class to call it
     * @param filepath path of the input file
     * @param filename filename to save to
     * @param fileNotes the notes for this file
     */
    public void convertFile(String filepath, String filename, String fileNotes) {
        CategoricalHashTable<CategorizedValueMarker> staticMarkers = new CategoricalHashTable<>();
        TXTParser.parse(dataMap, staticMarkers, filepath, 0);
        saveFile(filename, fileNotes);
    }

    /**
     * Converts the data in the dataMap to a string object.
     * The string can easily be written to the file
     * @return String of the data in the dataMap
     */
    private String getStringOfData() {
        //A string builder is used because appending to a normal String obj takes a long time.
        StringBuilder toReturn = new StringBuilder();

        //for each tag of data
        for (String tag : dataMap.tags) {
            //output the tag
            toReturn.append(tag);
            toReturn.append("\n");
            //get the list of data for the current tag
            List<LogObject> data = dataMap.getList(tag);
            //for each data element
            for (LogObject lo : data) {
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

    /**
     * Saves the file. Takes the data in the dataMap and outputs it into a file
     * @param filename The name of the file that we are saving to
     * @param fileNotes The notes for this file
     */
    private void saveFile(String filename, String fileNotes) {
        //add normal data
        StringBuilder sb = new StringBuilder(getStringOfData());
        //append vehicle dynamic data
        sb.append("VEHICLEDYNAMICDATA");
        sb.append("\n");
        //append lap data
        sb.append("LAPDATA");
        sb.append("\n");
        if (!fileNotes.isEmpty()) {
            sb.append("FILENOTES\n");
            sb.append(fileNotes);
        }

        try ( FileWriter fw = new FileWriter(filename + ".dfr")) {
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
