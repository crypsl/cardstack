
package cardgame;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
public class Dialogbox{
    private JDialog jd;
    private JPanel panel_help,panel_history;
    private JScrollPane pane,pane1;
    private JTextArea txthelp,txthistory;   
   public Dialogbox(){
        
    }
   public Dialogbox(String str,ArrayList<CardStack> cardst){
        jd=new JDialog();
        jd.setSize(300,400);
        jd.setDefaultCloseOperation(jd.DISPOSE_ON_CLOSE);
        txthelp=new JTextArea(20,25);
        txthelp.setText(
        "-> Please enter dice notation in the form of <number of dice> d <number of face> - <cards to deal>.\n"+
        "-> Then Click on Create Cards. \n"+
        "-> Then you can choose options from the given buttons to seek the formed cards and its frequency.\n"+
        "-> You can also use peek opeartions available where you can see the cards you selected, removed cards "
        + "as well as cards which will be displayed in future.\n"+
        "-> You can also reshuffle cards in stack at any time you want just by clicking on shuffle button.\n"+
        "-> Thank you !!!");
        txthistory=new JTextArea(15,15);
        txthelp.setEditable(false);
        txthistory.setEditable(false);
        txthistory.setText(""); 
        for (CardStack cst : cardst) {
            txthistory.setText(txthistory.getText() + cst.getDiceNotation() + "\n");
        }
        pane=new JScrollPane();
        pane1=new JScrollPane();
        pane.getViewport().add(txthelp);
        pane1.getViewport().add(txthistory);
        panel_help=new JPanel();
        panel_help.add(pane);
        panel_history=new JPanel();
        panel_history.add(pane1);
        if (str.equals("help")) {
             jd.setTitle("Information");
             jd.add(panel_help);
        }else if (str.equals("history")) {
            jd.setTitle("History");
             jd.add(panel_history);
        }
        jd.setVisible(true); 
    }
}
