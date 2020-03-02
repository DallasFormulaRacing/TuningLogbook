/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;
import javax.swing.JFrame;
/**
 *
 * @author Nolan
 */
public class SetupWindow extends JFrame{
    LogData logData;
    public SetupWindow(LogData logData){
        this.logData = logData;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setAlwaysOnTop(false);
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
}
