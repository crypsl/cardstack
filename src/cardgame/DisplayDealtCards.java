package cardgame;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class DisplayDealtCards extends JFrame implements CardListner{    
    private JTextArea txtarea;
    private JScrollPane pane1, pane;
    private Graph g;
    public DisplayDealtCards(){
        setSize(500,580);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pane=new JScrollPane();
        pane.getViewport().add(txtarea=new JTextArea());
        txtarea.setEditable(false); 
        pane.setBorder(BorderFactory.createTitledBorder("Dealt Cards")); 
        getContentPane().add(pane,BorderLayout.PAGE_START);        
    }
    @Override
    public void actionDiceNotation(DiceNotationEvent dn){}
    @Override
    public void actionCardList(CardListEvent ce) {
        String str="";
        for (Card c:ce.getCardlist()) {
            str+=c.getCardNumber()+", ";
        }
        txtarea.setText(str); 
        g = new Graph(ce.getCardlist());
        pane1=new JScrollPane();     
        pane1.getViewport().add(g);
        getContentPane().add(pane1, BorderLayout.CENTER);
    }
    public JTextArea getTxtarea() {
        return txtarea;
    }
}
