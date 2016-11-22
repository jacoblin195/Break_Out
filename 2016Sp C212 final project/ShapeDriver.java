////////////////////////////////////////////////////////////////////////////////////
//
//  C212 Spring 16
//  Yicheng Lin (Jacob)
//  Homework 6 Template
//  Due: Friday 3/11 11:59 pm
//  @Author  Earl Dean
//
///////////////////////////////////////////////////////////////////////////////////
 
// These are the imports I used 
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.lang.Math;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.Timer;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class ShapeDriver extends JPanel implements KeyListener,ActionListener{
  
  public final int FRAME_WIDTH = 600;
  public final int FRAME_HEIGHT = 700;
  private Timer timer;
  private Random random = new Random();
  private Rec paddle = new Rec();
  private Circle s = new Circle(4);
  private int scorenum = 0;
  private boolean end = false;
  private JButton starter;
  private boolean beginn = false;
  private ArrayList<block> blocklist = new ArrayList<block>();
  private framebox f = new framebox();
  private int maxscore;
  
  public ShapeDriver() {
    super();
    for(int i = 0;i<=7;++i){
      for(int j = 1;j<=8;++j){
        blocklist.add(new block(i*70+20,j*20,i,j));
      }
    }
    maxscore = blocklist.size();
    paddle.setFillColor(Color.orange);
    s.setFillColor(Color.blue);
    starter = new JButton("Start");
    
    starter.addActionListener(new ButtonListener());
    addKeyListener(this);
    setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
    setFocusable(true);
    setBackground(Color.white);
    add(starter);
    
    timer = new Timer(1000/60, this);
  }
  
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      
      timer.start();
      beginn = true;
      remove(starter);
      repaint();
    }
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if(beginn){
      s.draw(g);
      f.draw(g);
      for(block k:blocklist){
        k.draw(g);
      }
      paddle.draw(g);
      g.setColor(Color.black);
      g.setFont(new Font("TimesRoman", Font.PLAIN, 18)); 
      g.drawString("Score:  " + scorenum,30,16);
    }
    if(end){
      JFrame frame = new JFrame("End");
      if(scorenum == maxscore){
        JOptionPane.showMessageDialog(frame,"Congratulations! You Win!","End",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
      } else {
        JOptionPane.showMessageDialog(frame,"You lose! Your score: " + scorenum + "!","End",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
      }
    }
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    
    if (e.getKeyCode() == KeyEvent.VK_RIGHT && (paddle.ctr.x+40)<580) {
      paddle.moveLoc(Math.min(20,560 - paddle.ctr.x),0);
    } else if (e.getKeyCode() == KeyEvent.VK_LEFT && (paddle.ctr.x-40)>20){
      paddle.moveLoc(-Math.min(20,paddle.ctr.x-40),0);
    } else {
    }
    repaint();
  }
  
  @Override
  public void keyReleased(KeyEvent e) { }
  
  @Override
  public void keyTyped(KeyEvent e) { }
  
  @Override
    public void actionPerformed(ActionEvent e) {
    if(s.ctr.getY()>720){
      timer.stop();
      end = true;
      this.repaint();
    } else if(scorenum == maxscore){
      timer.stop();
      end = true;
      this.repaint();
    } else {        
      s.direction = s.direction % (2*Math.PI);
      if(s.ctr.getX()-(s.width/2)<=20){
        s.moveLoc((int)(22-(s.ctr.getX()-s.width/2)),0);
        s.direction = Math.PI - s.direction;
      } else if (s.ctr.getX()+(s.width/2)>=580){
        s.moveLoc((int)(577-(s.ctr.getX()+(s.width/2))),0);
        s.direction = Math.PI - s.direction;
      } else if (s.ctr.getY()-(s.height/2)<=20){
        s.moveLoc(0,(int)(22-(s.ctr.getY()-(s.height/2))));
        s.direction = 0 - s.direction;
      } else if ((!(s.rect.intersects(paddle.leftr)||s.rect.intersects(paddle.rightr))) && s.ctr.getY()>592 && s.ctr.getY()<604
                     && s.ctr.getX()>=paddle.Location.getX() && s.ctr.getX()<=(paddle.Location.getX()+80)) {
        s.direction = ((80-(s.ctr.getX()-paddle.Location.getX()))/80)*0.5*Math.PI+0.25*Math.PI;
      }
      for (Iterator<block> iterator = blocklist.iterator(); iterator.hasNext();) {
        block st = iterator.next();
        if (s.rect.intersects(st.up)) {
          s.direction = 0 - s.direction;
          iterator.remove();
          break;
        } 
      }
      for (Iterator<block> iterator = blocklist.iterator(); iterator.hasNext();) {
        block st = iterator.next();
          if (s.rect.intersects(st.down)) {
            s.direction = 0 - s.direction;
            iterator.remove();
            break;
          }
      }
      for (Iterator<block> iterator = blocklist.iterator(); iterator.hasNext();) {
        block st = iterator.next();
          if (s.rect.intersects(st.left)) {
            s.direction = Math.PI - s.direction;
            iterator.remove();
            break;
          } 
      }
      for (Iterator<block> iterator = blocklist.iterator(); iterator.hasNext();) {
        block st = iterator.next();
        if (s.rect.intersects(st.right)) {
            s.direction = Math.PI - s.direction;
            iterator.remove();
            break;
        }
      }
      s.moveLoc((int)(Math.cos(s.direction)*s.speed),-(int)(Math.sin(s.direction)*s.speed));
      scorenum = maxscore-blocklist.size();
      this.repaint();
    }
  }

    
  public static void main(String[] args) { }   
  
}