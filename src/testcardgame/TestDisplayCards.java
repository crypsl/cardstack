package testcardgame;
import cardgame.Card;
import cardgame.DisplayCards;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
public class TestDisplayCards extends JFrame{
    DisplayCards disp;
    ArrayList<Card> data=new ArrayList<>();
    public TestDisplayCards(){
        setTitle("Test Suite no.9"); 
        setSize(200,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            Card c2=new Card(2,250);
            Card []c1={c2};
            data.addAll(Arrays.asList(c1));
        } catch (Exception ex) {
            ex.getMessage();
        }
            disp=new DisplayCards();
            getContentPane().add(disp);
            disp.showCard(data);
    }
    public static void main(String[] args) {
        new TestDisplayCards().setVisible(true); 
    }
}
