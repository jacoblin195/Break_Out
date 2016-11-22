import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Dimension;

public class framebox extends Shape {
  public framebox() {
    super(20,20);
  }
  public void draw(Graphics g){
    g.setColor(Color.black);
    g.drawRect(20,20,560,2000);
  }
  public void moveLoc(int dx, int dy) {
  }
}