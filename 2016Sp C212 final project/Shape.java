import java.awt.Color;  
import java.lang.Math;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Dimension;
abstract class Shape {

    private Color fillColor;
    private Color borderColor;
    public Point Location;
    public Rectangle rect;
    public double direction;
    public Point ctr;
    public int width;
    public int height;
    

    // set fillColor to white and border color to black 
    public Shape(int x, int y) {
      this.borderColor = Color.black;
      Location = new Point(x,y);
      this.fillColor = Color.black;
    }

    public void setFillColor(Color c) {
      fillColor = c;
    }

    public Color getFillColor() {
      return fillColor;
    }

    public void setBorderColor(Color c) {
      borderColor = c;
    }

    public Color getBorderColor() {
      return borderColor;
    }

    public Point getLocation() {
      return Location;
    }

    // Note:  subclasses of Shape do not inherent private members
    // so we need methods the subclasses can use to get the x and y values 
    // from the private Point instance field
    public int getX() {
      int x = (int) this.getLocation().getX();
      return x;
    }

    public int getY() {
      int y = (int) this.getLocation().getY();
      return y;
    }
    
    public Rectangle getRect(){
      return rect;
    }
    
    abstract void draw(Graphics g); 
    abstract void moveLoc(int dx, int dy);
    
}
