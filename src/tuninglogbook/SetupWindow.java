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
        GridLayout layout = new GridLayout(0,2);
        this.setLayout(layout);
        JLabel label1 = new JLabel("temp1");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        JSlider temp1 = new JSlider(JSlider.HORIZONTAL, -10,10,0);
        JLabel label2 = new JLabel("temp2");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        JSlider temp2 = new JSlider(JSlider.HORIZONTAL, -10,10,0);
        JSlider temp3 = new JSlider(JSlider.HORIZONTAL, -10,10,0);
        JSlider temp4 = new JSlider(JSlider.HORIZONTAL, -10,10,0);
        JSlider temp5 = new JSlider(JSlider.HORIZONTAL, -10,10,0);

        this.add(label1);
        this.add(temp1);
        this.add(label2);
        this.add(temp2);
        this.add(temp3);
        this.add(temp4);
        this.add(temp5);
        
    }
}
