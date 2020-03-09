/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author Harish
 */
public class FileCorrelationTest {
    
    public FileCorrelationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findFilesAtTimes method, of class FileCorrelation.
     */
    @Test
    public void testFindFilesAtTimes() {
        System.out.println("findFilesAtTimes");
        LogData rowElemList = null;
        FileCorrelation instance = new FileCorrelation();
        String expResult = "Done";
        String result = instance.findFilesAtTimes(rowElemList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of associateRow method, of class FileCorrelation.
     */
    @Test
    public void testAssociateRow() {
        System.out.println("associateRow");
        Log rowElem = new Log("log1", "2019-04-14T14-21-51-884303", "morning test", "car was ");
        FileCorrelation instance = new FileCorrelation();
        int expResult = 0;
        int result = instance.associateRow(rowElem);
        System.out.println(instance.fileLogPairs.get(0));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateTimeParser method, of class FileCorrelation.
     */
    @Test
    public void testDateTimeParser() {
        System.out.println("dateTimeParser");
        String time = "2019-04-14T14-21-51-884303";
        LocalDateTime expResult = null;
        LocalDateTime result = FileCorrelation.dateTimeParser(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
