import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;
public class block extends Shape {
  public Rectangle up;
  public Rectangle down;
  public Rectangle right;
  public Rectangle left;
  public block(int x,int y,int i,int j){
    super(x,y);
    if( (i==0|| i==7) || (j==1|| j== 8) ){
       this.setFillColor(Color.red);
    } else if ( i ==1 || i ==6 || j == 2 || j == 7){
      this.setFillColor(Color.green);
    } else if (i == 2 || i ==5 || j == 3 || j == 6){
      this.setFillColor(Color.orange);
    } else {
      this.setFillColor(Color.blue);
    }
    this.setBorderColor(Color.black);
    this.up = new Rectangle(new Point(x,y),new Dimension(70,1));
    this.down = new Rectangle(new Point(x,y+20),new Dimension(70,1));
    this.left = new Rectangle(new Point(x,y+1),new Dimension(1,18));
    this.right = new Rectangle(new Point(x+70,y+1),new Dimension(1,18));
    
    this.width = 70;
    this.height = 20;
  }
  public void draw(Graphics g){
    g.setColor(this.getFillColor());
    g.fillRect(this.getX(),this.getY(),width,height);
    g.setColor(this.getBorderColor());
    g.drawRect(this.getX(),this.getY(),width,height);
  }
  public void moveLoc(int dx, int dy) {
  }
}