/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Nolan
 */
public class SetupWindow extends JFrame{
    LogData logData;
    JPanel setupPanel;
    public SetupWindow(LogData logData){
        this.logData = logData;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setAlwaysOnTop(true);
        this.setAlwaysOnTop(false);
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        //TODO: Make the scroll wheel and panel and then add them to the frame
        GridLayout layout = new GridLayout(1,0,0,2);
        setupPanel.setLayout(layout);
        JButton temp1 = new JButton("temp1");
        JButton temp2 = new JButton("temp2");
        JButton temp3 = new JButton("temp3");
        JButton temp4 = new JButton("temp4");
        JButton temp5 = new JButton("temp5");

        setupPanel.add(temp1);
        setupPanel.add(temp2);
        setupPanel.add(temp3);
        setupPanel.add(temp4);
        setupPanel.add(temp5);
        this.add(setupPanel);
        
    }
}
