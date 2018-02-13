package testcardgame;
import cardgame.CardStack;
import cardgame.CardStackHistory;
import java.util.ArrayList;
public class TestCardStackHistory {
    public static void main(String[] args) {
        CardStackHistory csh=new CardStackHistory();
        System.out.println("Result of Test Suite no. 14");
        System.out.println("Result of Test Case no. 1");
        System.out.println(csh.searchDice("2d6"));
        System.out.println("Result of Test Case no.2");
        ArrayList<CardStack> acs=new ArrayList<>();
        CardStack cs=new CardStack(); 
        cs.setDiceno(2);
        cs.setFaceno(6);
        cs.setCardstodeal(3); 
        acs.add(cs);
        csh.setCardst(acs); 
        System.out.println(csh.searchDice("2d6-3")); 
    }
}
