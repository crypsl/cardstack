package testcardgame;
import cardgame.CardStack;
import cardgame.Dialogbox;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JDialog;
//////////////////Test Suite no. 15 --- Test Case no.2////////////////////
public class TestDialogbox extends JDialog{
    private Dialogbox dbox;
    private ArrayList<CardStack> cardst;
    public TestDialogbox(){
        setSize(400,400);
        cardst=new ArrayList<>();
        CardStack cs1=new CardStack();
        cs1.setDiceno(5);
        cs1.setFaceno(5);
        cs1.setCardstodeal(3);
        CardStack [] cst={cs1};
        cardst.addAll(Arrays.asList(cst));
        dbox=new Dialogbox("help",cardst); 
    }
    public static void main(String[] args) {
        new TestDialogbox().setVisible(true); 
    }
}
