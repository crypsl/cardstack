package cardgame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class DisplayFutureCards extends JFrame implements CardListner{    
    private ArrayList<Card> card;
    private JScrollPane pane,pane1;
    private Graph g;
    private JTextArea txtarea;
    public DisplayFutureCards(){
        setSize(500,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        txtarea=new JTextArea();
        txtarea.setEditable(false);
        pane1=new JScrollPane();
        pane1.getViewport().add(txtarea);        
        pane1.setBorder(BorderFactory.createTitledBorder("Future Cards"));
        getContentPane().add(pane1,BorderLayout.PAGE_START);
    }    
    @Override
    public void actionDiceNotation(DiceNotationEvent dn){}
    @Override
    public void actionCardList(CardListEvent ce) {
        this.card=ce.getCardlist();
        txtarea.setText(""); 
        for (Card c:ce.getCardlist()) {
            txtarea.setText(txtarea.getText()+c.getCardNumber()+", ");
        }
        g = new Graph(ce.getCardlist());
        pane=new JScrollPane();     
        pane.getViewport().add(g);
        getContentPane().add(pane,BorderLayout.CENTER);
    }
    public JTextArea getTxtarea() {
        return txtarea;
    }
}
