package testcardgame;
import cardgame.Card;
import cardgame.Dice;
public class TestDice {
    public static void main(String[] args) {
        System.out.println("Result of Test Suite no. 3");
        System.out.println("Result of Test Case no. 1");
        try {
            Dice d = new Dice(2,5);
            for (Card c:d.getList()) {
                System.out.println(c.getCardNumber());   
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }        
        System.out.println("Result of Test Case no. 2");
        try {
            Dice d = new Dice(0,0);
            for (Card c:d.getList()) {
                System.out.println(c.getCardNumber());   
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }        
        System.out.println("Result of Test Case no. 3");
        try {
            Dice d = new Dice(-2,-5);
            for (Card c:d.getList()) {
                System.out.println(c.getCardNumber());   
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
