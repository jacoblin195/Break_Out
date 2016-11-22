////////////////////////////////////////////////////////////////////////////////////
//
//  C212 Spring 16
//  Yicheng Lin (Jacob)
//  Homework 6 Template
//  Due: Friday 3/11 11:59 pm
//  @Author  Earl Dean
//
///////////////////////////////////////////////////////////////////////////////////

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

/*
 * Main application for random rhape renerator app
 */
public class ShapeWindow extends JFrame {
  
  JPanel shapeDriver = new ShapeDriver();
  
  public ShapeWindow() {
    super();
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().add(shapeDriver);
    this.pack();
    this.setVisible(true);
        // TO-DO: set up the frame
  }
  
  public static void main(String[] args) {
    // run main application 
    JFrame shapeWindow = new ShapeWindow();
  }
}
