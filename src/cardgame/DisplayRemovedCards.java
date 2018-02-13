package cardgame;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class DisplayRemovedCards extends JFrame implements CardListner{ 
    private JTextArea txtarea;
    private JScrollPane pane;   
   public DisplayRemovedCards(){
        setSize(200,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pane=new JScrollPane();
        pane.getViewport().add(txtarea=new JTextArea(50,50));
        txtarea.setEditable(false); 
        getContentPane().add(new JLabel("Removed Cards"),BorderLayout.PAGE_START);
        getContentPane().add(pane,BorderLayout.CENTER);
    }   
    @Override
    public void actionDiceNotation(DiceNotationEvent dn){}
    @Override
    public void actionCardList(CardListEvent ce) {
        String str="";
        for (Card c:ce.getCardlist()) {
            str+=c.getCardNumber()+"\n";
        }
        txtarea.setText(str);
    }
    public JTextArea getTxtarea() {
        return txtarea;
    }
}
