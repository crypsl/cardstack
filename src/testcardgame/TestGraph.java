package testcardgame;
import cardgame.Card;
import cardgame.Graph;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
public class TestGraph extends JFrame{
    Graph g;
    ArrayList<Card> card;
    public TestGraph(){
        setTitle("Test Suite no. 11"); 
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        card=new ArrayList();
        try{
            Card c1=new Card(15,250);
            Card c2=new Card(16,450);
            Card c3=new Card(43,250);
            Card c4=new Card(87,450);
            Card [] arr={c1,c2,c3,c4};
            card.addAll(Arrays.asList(arr));
        } catch (Exception ex) {
           ex.getMessage();
        }
        g=new Graph(card);
        getContentPane().add(g);
    }
    public static void main(String[] args) {
        new TestGraph().setVisible(true); 
    }
}
