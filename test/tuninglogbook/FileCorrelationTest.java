/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author haris
 */
public class FileCorrelationTest {
    
    public FileCorrelationTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of findFilesAtTimes method, of class FileCorrelation.
     */
    @Ignore
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
        Log rowElem = new Log("log1", "2019-04-14T14-21-51-884303", "", "");
        FileCorrelation instance = new FileCorrelation();
        int expResult = 0;
        int result = instance.associateRow(rowElem);
        System.out.println(instance.fileLogPairs.get(0));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBuffer method, of class FileCorrelation.
     */
    @Ignore
    @Test
    public void testFindBuffer() {
        System.out.println("findBuffer");
        ArrayList<File> fileList = null;
        int expResult = 0;
        int result = FileCorrelation.findBuffer(fileList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dateTimeParser method, of class FileCorrelation.
     */
    @Ignore
    @Test
    public void testDateTimeParser() {
        System.out.println("dateTimeParser");
        String time = "";
        LocalDateTime expResult = null;
        LocalDateTime result = FileCorrelation.dateTimeParser(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
