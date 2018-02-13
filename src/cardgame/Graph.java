package cardgame;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.JPanel;
public class Graph extends JPanel{
        private int cheight;
        private ArrayList<Card> card;
       public Graph(ArrayList<Card> card){
            this.card = card;
            cheight=400;
            setPreferredSize(new Dimension(this.card.size()*40+40,200));
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            Graphics2D g2d=(Graphics2D)g;
            int x=40,y=30;
            for (Card d:card) {
                double height=cheight*d.getCardFrequency()/100;
                double width=35;
                double newY=cheight-height+y;
                g2d.fill3DRect(x, (int)newY, (int)width, (int)height, true); 
                g2d.drawString(d.getCardNumber()+"", x, 442);
                x+=40;
            }
            g2d.drawLine(35,10,35,cheight+30);
            g2d.drawLine(35,cheight+30,x,cheight+30);
            g2d.drawString("Cards", 150, 460);
            int nx = 430;
            for (int i = 0; i <= 10; i++) {             
                g2d.drawString(i*10+"", 20, nx);
                nx-=40;
            }
            AffineTransform at=new AffineTransform();
            at.rotate(Math.toRadians(-90));
            Font f=new Font("Arial",Font.BOLD,15).deriveFont(at); 
            g2d.setFont(f);
            g2d.drawString("Percentage",18,200);
            
        } 
    }
