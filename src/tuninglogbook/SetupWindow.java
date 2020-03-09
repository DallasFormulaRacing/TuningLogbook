/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuninglogbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
/**
 *
 * @author Nolan
 */
public class SetupWindow extends JFrame{
    LogData logData;
    JPanel setupPanel;
    JFrame helpFrame;
    private String[] vehicleVariables = {
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
    
    private ArrayList<Slider> sliders;
    
    private class Slider {
        public JSlider slider;
        public int index;
        public JLabel label;
        public Slider(JSlider slider, int index, JLabel label){
            this.slider = slider;
            this.index = index;
            this.label = label;
            
            
            
            slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                    label.setText(vehicleVariables[index] + ": " + ((JSlider)e.getSource()).getValue());
                }
            });
        }
    }
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
        sliders = new ArrayList<Slider>();
        
        GridLayout layout = new GridLayout(0,6);
        this.setLayout(layout);
        
        for(int i = 0; i < 34; i++){
            JLabel tempLabel = new JLabel(vehicleVariables[i] + ": 0");
            tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JSlider temp = new JSlider(JSlider.HORIZONTAL, -10,10,0);
            temp.setMinorTickSpacing(1);  
            temp.setMajorTickSpacing(5);  
            temp.setPaintTicks(true);  
            temp.setPaintLabels(true);  
            //temp.addChangeListener(new ChangeListener() {
             //   public void stateChanged(ChangeEvent e) {
              //      
               //     labels.get(i).setText(vehicleVariables[i] + ((JSlider)e.getSource()).getValue());
            //    }
            //}); 
            sliders.add(new Slider(temp, i, tempLabel));
        }
        
        for(int i = 0; i < 34; i++){
            this.add(sliders.get(i).label);
            this.add(sliders.get(i).slider);
        }
        
        // This label acts as a buffer so tha the close and submit buttons are on the bottom right. 
        this.add(new JLabel(" "));
        
        JButton helpButton = new JButton("Help");
        
        helpButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                openHelpFrame();
            } 
        });
        
        JButton closeButton = new JButton("Close");
        
        closeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               closeWindow();
            }    
        });
        
        JButton submitButton = new JButton("Submit");
        
        submitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               submitSetup();
            }    
        });
        
        this.add(helpButton);
        this.add(closeButton);
        this.add(submitButton);
        
    }
    
    public void openHelpFrame(){
        helpFrame = new JFrame("Help");
        helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpFrame.setSize(300,600);
        helpFrame.setAlwaysOnTop(true);
        helpFrame.setAlwaysOnTop(false);
        helpFrame.setLocationRelativeTo(null);
        
        String[] vehicleVariables_help = {
            "FRHSC - front right high speed compresssion",
            "FRHSR - front right high speed rebound",
            "FRLSC - front right low speed compression",
            "FRLSR - front right low speed rebound",
            "FLHSC - front left high speed compression",
            "FLHSR - front left high speed rebound",
            "FLLSC - front left low speed compression",
            "FLLSR - front left low speed rebound",
            "RRHSC - rear right high speed compression",
            "RRHSR - rear right high speed rebound",
            "RRLSC - rear right low speed compression",
            "RRLSR - rear right low speed rebound",
            "RLHSC - rear left high speed compression",
            "RLHSR - rear left high speed rebound",
            "RLLSC - rear left low speed compression",
            "RLLSR - rear left low speed rebound",
            "FARB - front anti roll bar",
            "RARB - rear anti roll bar",
            "FRS - front right spring",
            "FLS - front left spring",
            "RRS - rear right spring",
            "RLS - rear left spring",
            "RHF - right height front",
            "RHR - right height rear",
            "CF - camber front",
            "CR - camber rear",
            "TF - toe front",
            "TR - toe rear",
            "AA - ackermann angle",
            "TPFR - tire pressure front right",
            "TPFL - tire pressure front left",
            "TPRR - tire pressure rear right",
            "TPRL - tire pressure rear left",
            "BB - brake bias"
        };
        
        GridLayout layout = new GridLayout(0,1);
        helpFrame.setLayout(layout);
        
        ArrayList<JLabel> helpLabels = new ArrayList<JLabel>();
        
        for(int i = 0; i < 34; i++){
            helpLabels.add(new JLabel("   "+vehicleVariables_help[i]));
            helpFrame.add(helpLabels.get(i));
        }
        
        helpFrame.setVisible(true);        
    }
    
    public void closeWindow(){
        this.setVisible(false);
        helpFrame.dispose();
        this.dispose();
    }
    
    public void submitSetup(){
        //TODO: Figure out code for submitting the setup
        System.out.println("Submitted the setup");
        
        closeWindow();
    }
}
