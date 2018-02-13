package testcardgame;
import cardgame.DisplayDealtCards;
import java.util.ArrayList;
import java.util.Arrays;
public class TestDisplayDealtCards extends DisplayDealtCards{
    ArrayList<Integer> data;
    public TestDisplayDealtCards(){
        setTitle("Test Suite no. 12");
         data=new ArrayList<>();
         Integer [] it={15,19,48,45};
         data.addAll(Arrays.asList(it));
         for (int i = 0; i < data.size(); i++) {
             getTxtarea().setText(getTxtarea().getText()+data.get(i)+", ");
        }
    }
    public static void main(String[] args) {
      new TestDisplayDealtCards().setVisible(true); 
    }
}
