import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Drawing2D extends JApplet {
   public static void main(String s[]) {
      JFrame frame = new JFrame();
      frame.setTitle("Shtepia");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JApplet applet = new Drawing2D();
      applet.init();
      frame.getContentPane().add(applet);
      frame.pack();
      frame.setSize(800,200);
      frame.setVisible(true);
   }
 
   public void init() {
      JPanel panel = new PathPanel();
      getContentPane().add(panel);
    
   }
}


class PathPanel extends JPanel
{
   public PathPanel()
   {
      setPreferredSize(new Dimension(800, 300));
      setBackground(new Color(255,255,102));
   }
   
   /** paint  paints the view
     * @param g - the graphics pen */
   public void paint(Graphics g)
   {
   
      Graphics2D g2d = (Graphics2D) g;
      

      drawRect(0,0,800,400,g2d,new Color(251,228,101));
      drawRect(0,220,800,170,g2d,new Color(219,226,16)); 
      drawRect(0,330,800,70,g2d,new Color(124,114,59)); 
     
      paintCloud(g2d,0,0);
      paintCloud(g2d,300,20);
      paintCloud(g2d,200,-20);
      paintCloud(g2d,250,-30);
      paintCloud(g2d,400,-50);
      paintCloud(g2d,450,-50);
      paintCloud(g2d,500,-50);
      paintCloud(g2d,600,-50);
      paintCloud(g2d,550,-20);
      paintCloud(g2d,530,-10);
      paintCloud(g2d,600,-60);
      paintCurve(g2d,new Color(178,157,100));
      paintCurve2(g2d);
   
      for (int i=0; i<800; i=i+50)
      { 
         paintTree2(g2d,i+5);
      }
      for (int i=0; i<800; i=i+50)
      { 
         paintTree1(g2d,i);
      }
     
      paintGrass3(g2d,-70);
      for (int i=-30; i<720; i=i+80)
      
      {paintGrass3(g2d,i-20);
         paintGrass1(g2d,i+30);
         paintGrass(g2d,i);
         paintGrass3(g2d,i+420);
         paintGrass1(g2d,i+545);
         paintGrass2(g2d,i+510);
         paintGrass1(g2d,i-5);
         paintGrass2(g2d,i+34);
      } 
      
   
      for (int i=-20; i<790; i=i+50)
      { 
         paintStone(g2d,i,300);
         paintStone1(g2d,i,305);
         paintStone2(g2d,i,305);
         paintStone4(g2d,i,302);
      }
      drawRect(800,0,800,400,g2d,Color.white);
  //     Font myFont = new Font ("Courier New", 1, 17);
//       g.setFont (myFont);
      
//g.drawString ("Hello World", 10, 10);   
}
  
  /** paintCloud  paints the clouds
     * @param g - the graphics pen 
     * @param x - x position of cloud
     * @param y - y position of cloud*/
   public void paintCloud(Graphics g, int x,int y)
   {
      Graphics2D g2 = (Graphics2D)g;
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      path.moveTo(0+x,90+y);
      path.curveTo(10+x,92+y,30+x,95+y,50+x,90+y);
      path.curveTo(70+x,92+y,90+x,95+y,110+x,90+y);
      path.curveTo(120+x,92+y,130+x,95+y,140+x,90+y);
      path.curveTo(145+x,90+y,150+x,92+y,155+x,89+y);
      path.quadTo(160+x,88+y,140+x,84+y);
      path.quadTo(130+x,80+y,125+x,82+y);
      path.quadTo(115+x,70+y,97+x,79+y);
      path.quadTo(95+x,68+y,90+x,72+y);
      path.quadTo(88+x,66+y,82+x,70+y);
      path.quadTo(80+x,64+y,72+x,68+y);
      path.quadTo(52+x,60+y,42+x,70+y);
      path.quadTo(55+x,80+y,38+x,75+y);
      path.quadTo(15+x,60+y,0+x,90+y);
      path.closePath();
      Color r= new Color(255,255,153);
      GradientPaint gp = new GradientPaint(0,80, Color.white, 100, 10, new Color(255,255,153),true);
      g2.setPaint(gp);
      g2.fill(path);
      g2.setPaint(gp);
      g2.draw(path);
      repaint();    
   }
   
  /** paintCurve  paints a kind of curve
     * @param g - the graphics pen
     * @param r - color of the curve pained */
   public void paintCurve(Graphics g,Color r)
   {
      Graphics2D g2 = (Graphics2D)g;   
      g2.setPaint(r);     
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      path.moveTo(0,380);
      path.curveTo(200,370,250,360,500,385);
      path.quadTo(550,385,580,383);
      path.moveTo(450,380);
      g2.fill(path);
      path.curveTo(600,370,700,360,800,385);
      path.lineTo(800,400);
      path.lineTo(0,400);
      path.lineTo(0,380);
      path.curveTo(200,370,250,360,500,385);
      path.closePath();
      g2.fill(path);       
      g2.setStroke(new BasicStroke(3f));
      g2.setPaint(new Color(162,131,85));
      g2.draw(path);   
   }
   
  /** paintCurve2  paints a kind of curve
     * @param g - the graphics pen
     * @param r - color of the curve pained */
   public void paintCurve2(Graphics g)
   {
      Graphics2D g2 = (Graphics2D)g;     
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      path.moveTo(0,260);
      path.curveTo(200,250,500,243,800,240);
      path.lineTo(800,330);
      path.lineTo(0,330);
      path.closePath();
      GradientPaint gp = new GradientPaint(5,73,new Color(75,111,22), 3,8,new Color(219,226,16),true);
      g2.setPaint(gp);
      g2.fill(path);  
   }

   
  
   /** drawRect  paints a rectangle
     * @param g2d - the graphics pen 
     * @param x - x position of rectangle
     * @param y - y position of rectangle
     * @param r - the color used to fill rectangle*/      
   public static void drawRect(int x, int y, int w, int h,Graphics2D g2d, Color r)
   { 
      g2d.setPaint(r);
      Rectangle rect = new Rectangle(x,y,w,h);
      g2d.fill(rect);
   }

   /** paintTree1  paints the first tree
     * @param g - the graphics pen 
     * @param x - x position of tree for which the tree moves*/
   public void paintTree1(Graphics g,int x)
   {
      Graphics2D g2 = (Graphics2D)g;             
      g2.setPaint(new Color(60,166,92)); 
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      path.moveTo(0+x,210);
      path.lineTo(10+x,170);
      path.lineTo(20+x,210);
      path.lineTo(17+x,210);
      path.lineTo(22+x,230);
      path.lineTo(-2+x,230);
      path.lineTo(3+x,210);
      path.closePath();
      g2.setPaint(new Color(60,166,92));
      g2.fill(path);
      g2.draw(path);
      drawRect(8+x,230,3,10,g2,Color.black);
      g2.setStroke(new BasicStroke(0.01f));   
      g2.setPaint(new Color(251,228,101));
      int count=0;
      int x1=10;
      int y1=10;
      for (int  i=0; i<10; i++)
      {  g2.drawLine(x1+x,172+count,y1+x,172+count);
         count=count+4;
         x1--;
         y1++;    }
         
      x1=x1+3;
      y1=y1-3;
      for (int  i=0; i<5; i++){
      
         g2.drawLine(x1+x,172+count,y1+x,172+count);
         count=count+4;
         x1--;
         y1++;
      }                 
   }
   
   /** paintTree2 paints the second tree
     * @param g - the graphics pen 
     * @param x - x position of tree for which the tree moves*/
   public void paintTree2(Graphics g,int x)
   {
      Graphics2D g2 = (Graphics2D)g;             
      g2.setPaint(new Color(86,171,49)); 
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      path.moveTo(17+x,200);
      path.lineTo(30+x,175);
      path.lineTo(42+x,200);
      path.lineTo(38+x,204);
      path.lineTo(46+x,225);
      path.lineTo(14+x,225);
      path.lineTo(22+x,204);
      path.closePath();
      g2.fill(path);
      g2.draw(path);
      drawRect(28+x,225,5,10,g2,Color.black);      
      int count=0;
      int x1=0;
      int y1=-2;
      for (int i=0; i<=8; i++)
      {
         for (int j=0; j<=11; j++)
         {
            x1=x1+4;
            y1=y1+4;
            drawRect(x1+x+10,174+count,2,2,g2,new Color(251,228,101));
            drawRect(y1+x+10,180+count-3,2,2,g2,new Color(251,228,101));
         }
         x1=0;
         y1=-2;
         count=count+6;
         }  
   }


   
   /** paintGrass  paints the image of grass
     * @param g - the graphics pen 
     * @param x - x position of tree for which the grass moves*/
   public void paintGrass(Graphics g, int x)
   {   
      Graphics2D g2 = (Graphics2D)g;
      g2.setPaint(new GradientPaint(5, 70, new Color(219,226,16), 2, 2,new Color(118,144,49), true));
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      path.moveTo(100+x,330);
      path.curveTo(102+x,320,104+x,300,113+x,290);
      path.quadTo(116+x,288,117+x,290);
      path.curveTo(116+x,292,106+x,300,103+x,330);
      path.moveTo(103+x,330);
      path.curveTo(102+x,320,107+x,310,115+x,305);
      path.quadTo(116+x,304,117+x,305);
      path.curveTo(116+x,312,104+x,310,103+x,330);
      path.closePath();      
      g2.draw(path);
      g2.fill(path);
   }
     /** paintGrass1  paints a kind of grass
     * @param g - the graphics pen 
     * @param x - x position of tree for which the grass moves*/   
   public void paintGrass1(Graphics g, int x)
   { 
      Graphics2D g2 = (Graphics2D)g;       
      g2.setPaint(new Color(158,199,45));
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      path.moveTo(100+x,330);
      path.curveTo(98+x,320,93+x,300,90+x,280);
      path.curveTo(91+x,290,95+x,300,100+x,330);
      path.curveTo(100+x,330,83+x,300,75+x,290);
      path.curveTo(76+x,295,85+x,300,100+x,330);
      path.moveTo(142+x,330);     
      path.curveTo(142+x,320,147+x,310,150+x,300);    
      path.curveTo(149+x,301,145+x,310,140+x,330);     
      path.curveTo(140+x,330,157+x,310,164+x,295);   
      path.curveTo(163+x,301,155+x,310,140+x,330);   
      path.closePath();      
      g2.draw(path);
      g2.fill(path);
   }
   
     /** paintGrass2  paints a kind of grass
     * @param g - the graphics pen 
     * @param x - x position of tree for which the grass moves*/
   public void paintGrass2(Graphics g, int x)
   {
      Graphics2D g2 = (Graphics2D)g;             
      g2.setPaint(new GradientPaint(5, 70, new Color(219,226,16), 2,2,new Color(141,203,47), true));   
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);      
      path.moveTo(100+x,330);
      path.curveTo(98+x,320,100+x,290,110+x,280);    
      path.curveTo(109+x,285,97+x,290,100+x,330);     
      path.curveTo(94+x,330,100+x,320,110+x,300);    
      path.curveTo(109+x,295,97+x,320,100+x,330);    
      path.closePath();
      g2.setStroke(new BasicStroke(1.7f));
      g2.draw(path);      
      g2.draw(path);
      g2.fill(path);
   }
   

     /** paintGrass3  paints a kind of grass
     * @param g - the graphics pen 
     * @param x - x position of tree for which the grass moves*/
   public void paintGrass3(Graphics g, int x)
   {   
      Graphics2D g2 = (Graphics2D)g;
      g2.setPaint(new Color(158,199,45));
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);      
      path.moveTo(100+x,338);
      path.lineTo(80+x,315);
      path.lineTo(100+x,333);
      path.lineTo(90+x,311);
      path.lineTo(100+x,333);
      path.lineTo(100+x,308);
      path.lineTo(102+x,333);
      path.lineTo(110+x,311);
      path.lineTo(102+x,333);
      path.lineTo(120+x,315);
      path.lineTo(100+x,338);
      path.closePath();      
      g2.setStroke(new BasicStroke(0.5f));
      g2.draw(path);
      g2.fill(path);
   }
   
      /** paintStone  paints a kind of stone
     * @param g - the graphics pen 
     * @param x - x position of stone for which the stone moves
     * @param y - y position of stone for which the stone moves*/
   public void paintStone(Graphics g, int x, int y)
   {
       
      Graphics2D g2 = (Graphics2D)g;             
      g2.setPaint(new Color(126,132,118)); 
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      GradientPaint gp = new GradientPaint(3,0,new Color(104,104,100), 6, 70,new Color(159,159,150),true);
      path.moveTo(17+x,33+y);
      path.curveTo(23+x,23+y,30+x,23+y,35+x,24+y);
      path.curveTo(40+x,25+y,44+x,25+y,47+x,23+y);
      path.curveTo(50+x,21+y,55+x,22+y,59+x,23+y);
      path.curveTo(60+x,25+y,64+x,27+y,65+x,33+y);
      path.curveTo(65+x,35+y,35+x,36+y,17+x,33+y);      
      g2.fill(path);   
      path.moveTo(50+x,38+y);
      path.quadTo(60+x,30+y,70+x,38+y);          
      g2.draw(path);     
   }
   
   
      /** paintStone1  paints a kind of stone
     * @param g - the graphics pen 
     * @param x - x position of stone for which the stone moves
     * @param y - y position of stone for which the stone moves*/
   public void paintStone1(Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D)g;             
      g2.setPaint(new Color(159,159,150)); 
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      GradientPaint gp = new GradientPaint(0,0,new Color(90,92,85), 50, 50,new Color(167,175,155),true);   
      path.moveTo(17+x,33+y);
      path.curveTo(20+x,20+y,25+x,26+y,30+x,27+y);
      path.curveTo(34+x,27+y,35+x,27+y,36+x,27+y);
      path.curveTo(38+x,25+y,41+x,19+y,39+x,20+y);
      path.curveTo(50+x,22+y,55+x,23+y,65+x,25+y);
      path.curveTo(65+x,38+y,35+x,36+y,17+x,33+y);
      g2.setPaint(new Color(90,92,85));
      g2.fill(path);     
      path.closePath();
      g2.draw(path);     
   }
   
      /** paintStone2  paints a kind of stone
     * @param g - the graphics pen 
     * @param x - x position of stone for which the stone moves
     * @param y - y position of stone for which the stone moves*/
   public void paintStone2(Graphics g, int x, int y)
   {
       
      Graphics2D g2 = (Graphics2D)g;             
      g2.setPaint(new Color(192,213,213)); 
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      GradientPaint gp = new GradientPaint(5,7,new Color(90,92,85), 50, 5,new Color(167,175,155),true);   
      path.moveTo(20+x,27+y);
      path.curveTo(20+x,23+y,25+x,25+y,30+x,27+y);
      path.curveTo(34+x,27+y,35+x,27+y,36+x,27+y);
      path.curveTo(38+x,25+y,41+x,19+y,39+x,20+y);
      path.curveTo(50+x,22+y,55+x,23+y,65+x,25+y);     
      path.curveTo(65+x,24+y,55+x,22+y,50+x,20+y);
      path.curveTo(39+x,19+y,41+x,20+y,36+x,24+y);
      path.curveTo(33+x,25+y,30+x,25+y,34+x,25+y);
      path.curveTo(30+x,25+y,25+x,26+y,20+x,27+y);
      g2.setPaint( new Color(171,181,158));
      g2.setStroke(new BasicStroke(0.5f));
      g2.fill(path);          
      path.closePath();
      g2.draw(path);     
   }
   
   
      /** paintStone4  paints a kind of stone
     * @param g - the graphics pen 
     * @param x - x position of stone for which the stone moves
     * @param y - y position of stone for which the stone moves*/
public void paintStone4(Graphics g, int x, int y)
   {      
      Graphics2D g2 = (Graphics2D)g;       
      GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
      GradientPaint gp = new GradientPaint(0,0,new Color(90,92,85), 50, 50,new Color(167,175,155),true);
      g2.setPaint(new Color(126,132,118));
      path.moveTo(50+x,38+y);
      path.quadTo(60+x,30+y,70+x,38+y);
      path.quadTo(60+x,40+y,50+x,38+y);
      g2.fill(path);
      g2.draw(path);     
   }   
}



