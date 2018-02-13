package testcardgame;
import cardgame.Card;
public class TestCard {
    public static void main(String[] args) {
        System.out.println("Result of Test Suite no. 1");
        System.out.println("Result of Test Case no. 1");
        try {
            Card c=new Card(5,20);
            System.out.println("Card Number"+c.getCardNumber()+" Card Frequency"+c.getCardFrequency());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test Case no. 2");
        try {
            Card c=new Card(0,0);
            System.out.println("Card Number"+c.getCardNumber()+" Card Frequency"+c.getCardFrequency());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test Case no. 3");
        try {
            Card c=new Card(-1,-1);
            System.out.println("Card Number"+c.getCardNumber()+" Card Frequency"+c.getCardFrequency());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test Case no. 4");
        try {
            Card c=new Card(2147483647,2147483647);
            System.out.println("Card Number"+c.getCardNumber()+" Card Frequency"+c.getCardFrequency());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test Suite no.2");
        System.out.println("Regresion Testing for Test Suite no.1 case 4");
        try {
            Card c=new Card(2147483647,2147483647);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
