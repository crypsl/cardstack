package cardgame;
import java.util.ArrayList;
import java.util.Collections;
public class Dice {    
    private ArrayList<Card> list=new ArrayList<>();    
    public Dice(int diceno,int faceno) throws Exception {
        ArrayList<Integer> temp=new ArrayList<>();
        if (diceno==0 || faceno==0) {
            throw new Exception("Dice number OR Face number can not be zero!");
        }
        if (diceno<0 || faceno<0) {
            throw new Exception("Dice number OR Face number can not be less than zero!");
        }
        for (int i = 0; i < 10000; i++) {
            temp.add(getRandomValue(diceno, diceno*faceno));
        }
        for (int i = diceno; i <= diceno*faceno; i++) {
            try {
                list.add(new Card(i,Collections.frequency(temp, i)));
            } catch (Exception ex) {
               ex.getMessage();
            }
        }
    }
    public ArrayList<Card> getList() {
        return list;
    }    
    private int getRandomValue(int min, int max){
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
