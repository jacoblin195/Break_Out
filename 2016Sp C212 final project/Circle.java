import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;
public class Circle extends Shape{
  public int radius;
  public int speed;
  
  
  public Circle(int r){
    super(300,300);
    speed =4;
    radius = r;
    this.width =2*r;
    this.height = 2*r;
    this.rect = new Rectangle(this.Location,new Dimension(width,height));
    ctr = new Point(this.getX()+radius,this.getY()+radius);
    this.direction =Math.random()*Math.PI*.5+Math.PI*0.25;
    
  } 
  public void draw(Graphics g){
    g.setColor(this.getFillColor());
    g.fillOval(this.getX(),this.getY(),2*radius,2*radius);
    g.setColor(this.getBorderColor());
    g.drawOval(this.getX(),this.getY(),2*radius,2*radius);
  }
  // moves location by dx and dy
  public void moveLoc(int dx, int dy) {
    int x = this.getX() + dx;
    int y = this.getY() + dy;
    this.rect.setLocation(x,y);
    this.Location.move(x,y);
    this.ctr.move((int)this.ctr.getX()+dx,(int)this.ctr.getY()+dy);
  }
}
