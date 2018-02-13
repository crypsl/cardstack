package testcardgame;
import cardgame.DisplayFutureCards;
import java.util.ArrayList;
import java.util.Arrays;
public class TestDisplayFutureCards extends DisplayFutureCards{
    ArrayList<Integer> arr;
    public TestDisplayFutureCards(){
        setTitle("Test Suite no. 13");
        arr=new ArrayList<>();
        Integer [] it={59,48,78,96};
         arr.addAll(Arrays.asList(it));
         for (int i = 0; i < arr.size(); i++) {
             getTxtarea().setText(getTxtarea().getText()+arr.get(i)+", ");
        }
    }
    public static void main(String[] args) {
        new TestDisplayFutureCards().setVisible(true); 
    }
}
