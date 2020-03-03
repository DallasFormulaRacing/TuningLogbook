/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
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
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Vehicle Setup");
        this.setVisible(true);
        
        
        //TODO: Make the scroll wheel and panel and then add them to the frame
        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        ArrayList<JSlider> sliders = new ArrayList<JSlider>();
        
        GridLayout layout = new GridLayout(0,6);
        this.setLayout(layout);
        
        String[] vehicleVariables = {
            "FRHSC",
            "FRHSR",
            "FRLSC",
            "FRLSR",
            "FLHSC",
            "FLHSR",
            "FLLSC",
            "FLLSR",
            "RRHSC",
            "RRHSR",
            "RRLSC",
            "RRLSR",
            "RLHSC",
            "RLHSR",
            "RLLSC",
            "RLLSR",
            "FARB",
            "RARB",
            "FRS",
            "FLS",
            "RRS",
            "RLS",
            "RHF",
            "RHR",
            "CF",
            "CR",
            "TF",
            "TR",
            "AA",
            "TPFR",
            "TPFL",
            "TPRR",
            "TPRL",
            "BB"
        };
        
        for(int i = 0; i < 34; i++){
            JLabel tempLabel = new JLabel(vehicleVariables[i]);
            tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
            labels.add(tempLabel);
            JSlider temp = new JSlider(JSlider.HORIZONTAL, -10,10,0);
            temp.setMinorTickSpacing(2);  
            temp.setMajorTickSpacing(10);  
            temp.setPaintTicks(true);  
            temp.setPaintLabels(true);  
            sliders.add(temp);
        }
        
        for(int i = 0; i < 34; i++){
            this.add(labels.get(i));
            this.add(sliders.get(i));
        }
        
        // This label acts as a buffer so tha the close and submit buttons are on the bottom right. 
        this.add(new JLabel(" "));
        
        JButton helpButton = new JButton("Help");
        
        helpButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                //TODO: Make a help menu
            } 
        });
        
        JButton closeButton = new JButton("Close");
        
        closeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                this.setVisible(false);
                dispose();
            }    
        });
        JButton submitButton = new JButton("Submit");
        
        this.add(helpButton);
        this.add(closeButton);
        this.add(submitButton);
        
    }
}
