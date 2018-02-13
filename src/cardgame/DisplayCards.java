package cardgame;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class DisplayCards extends JPanel{    
    private JLabel lbl_card,lbl_freq;    
    public DisplayCards(){        
        setLayout(new GridLayout(2,1,5,50));
        add(lbl_card=new JLabel("CARD NUMBER"));
        add(lbl_freq=new JLabel("FREQUENCY"));
    }    
    public void showCard(ArrayList<Card> card){
        lbl_card.setText(card.get(0).getCardNumber()+"");
        lbl_freq.setText(card.get(0).getCardFrequency()+"");
    }
    public JLabel getLbl_card() {
        return lbl_card;
    }
    public JLabel getLbl_freq() {
        return lbl_freq;
    }
}
 