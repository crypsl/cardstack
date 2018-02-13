package testcardgame;
import cardgame.DisplayRemovedCards;
import java.util.ArrayList;
import java.util.Arrays;
public class TestDisplayRemovedCards extends DisplayRemovedCards{
    ArrayList<Integer> i;
    public TestDisplayRemovedCards(){
        setTitle("Test Suite no. 10");
        i=new ArrayList<>();
        Integer[] data={12,13,14,15,16};
        i.addAll(Arrays.asList(data)); 
        for (int j = 0; j < i.size(); j++) {
             getTxtarea().setText(getTxtarea().getText()+i.get(j)+"\n"); 
        }
    }
    public static void main(String[] args) {
        new TestDisplayRemovedCards().setVisible(true); 
    }
}
