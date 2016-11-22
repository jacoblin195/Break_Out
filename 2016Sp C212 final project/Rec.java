import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;
public class Rec extends Shape {
  Rectangle leftr;
  Rectangle rightr;
  public Rec() {
    super(360,600);
    width = 80;
    height = 5;
    leftr = new Rectangle(new Point(0,600),new Dimension(360,500));
    rightr = new Rectangle(new Point(440,600),new Dimension(800,500));
    this.ctr = new Point(this.getX()+width/2,this.getY()+height/2);
    this.direction = Math.random()*2*Math.PI;
  }
  public void draw(Graphics g){
    g.setColor(this.getFillColor());
    g.fillRect(this.getX(),this.getY(),width,height);
    g.setColor(this.getBorderColor());
    g.drawRect(this.getX(),this.getY(),width,height);
  }
  public void moveLoc(int dx, int dy) {
    int x = this.getX() + dx;
    int y = this.getY() + dy;
    this.Location.move(x,y);
    this.ctr.move((int)this.ctr.getX()+dx,(int)this.ctr.getY()+dy);
    this.leftr = new Rectangle(new Point(0,600),new Dimension(x-4,500));
    this.rightr = new Rectangle(new Point(x+4,600),new Dimension(800,500));
  }
}
  