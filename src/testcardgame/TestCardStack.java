package testcardgame;
import cardgame.Card;
import cardgame.CardStack;
import java.util.ArrayList;
import java.util.Arrays;
public class TestCardStack {
    public static void main(String[] args) {
        CardStack cs=new CardStack();
        System.out.println("Result of Test Suite no. 6");
        System.out.println("Result of Test Case no. 1");
        ArrayList<Card> ca=new ArrayList<>();
        try { 
            Card c1=new Card(10,250);
            Card c3=new Card(15,200);
            Card c4=new Card(21,260);
            Card c5=new Card(23,264);
            Card []c={c1,c3,c4,c5}; 
            ca.addAll(Arrays.asList(c)); 
            cs.setCardlist(ca);
            cs.removeCards(2,3);
            for (int i = 0; i < cs.getRemovedcardstack().size(); i++) {
             System.out.println(cs.getRemovedcardstack().get(i).getCardNumber());
            }            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }        
        System.out.println("Result of Test Case no. 2");
        ArrayList<Card> car=new ArrayList<>();
        try { 
            Card c1=new Card(10,250);
            Card c3=new Card(15,200);
            Card c4=new Card(21,260);
            Card []c={c1,c3,c4}; 
            car.addAll(Arrays.asList(c)); 
            cs.setCardlist(car); 
            cs.removeCards(-2,-3);
            for (int i = 0; i < cs.getRemovedcardstack().size(); i++) {
             System.out.println(cs.getRemovedcardstack().get(i).getCardNumber());
            } 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }        
        System.out.println("Result of Test Case no. 3");
        ArrayList<Card> cd=new ArrayList<>();
        try { 
            Card c1=new Card(10,250);
            Card c3=new Card(15,200);
            Card c4=new Card(21,260);
            Card []c={c1,c3,c4}; 
            car.addAll(Arrays.asList(c)); 
            cs.setCardlist(cd); 
            cs.removeCards(10,1);
            for (int i = 0; i < cs.getRemovedcardstack().size(); i++) {
                System.out.println(cs.getRemovedcardstack().get(i).getCardNumber());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Result of Test Suit no. 7");
        System.out.println("Result of Test Case no.1");
        ArrayList<Card> cra=new ArrayList<>();
        try {
           Card c1 = new Card(2,500);
           Card c2=new Card(16,560);
           Card c3=new Card(18,780);
           Card []ccc={c1,c2,c3};
           cra.addAll(Arrays.asList(ccc));
           cs.setCardlist(cra); 
           cs.addDealtCard(c2);
            System.out.println("Cards in cardstack after dealt");
            for (int i = 0; i < cs.getCardlist().size(); i++) {
                System.out.println(cs.getCardlist().get(i).getCardNumber());
            }
            System.out.println("Cards in dealtcardstack after dealt");
            for (int i = 0; i < cs.getDealtcardstack().size(); i++) {
                System.out.println(cs.getDealtcardstack().get(i).getCardNumber());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        
        System.out.println("Result of Test suite no.8");
        ArrayList<Card> data=new ArrayList<>();
        ArrayList<Card> deal=new ArrayList<>();
        try {
            Card c1=new Card(10,250);
            Card c3=new Card(15,200);
            Card c4=new Card(21,260);
            Card []c2={c1,c4};
            Card []c={c3}; 
            data.addAll(Arrays.asList(c2));
            deal.addAll(Arrays.asList(c));
            System.out.println("Result of Test Case no. 1");
            cs.shuffleCards(data,deal);
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i).getCardNumber());
            }
            for (int i = 0; i < deal.size(); i++) {
                System.out.println(deal.get(i).getCardNumber());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test Case no. 2");
        ArrayList<Card> card=new ArrayList<>();
        ArrayList<Card> dealt=new ArrayList<>();
        try {
            Card c1=new Card(10,250);
            Card c3=new Card(15,200);
            Card c4=new Card(21,260);
            Card []c={c1,c3,c4}; 
            dealt.addAll(Arrays.asList(c));
            System.out.println("Result of Test Case no. 1");
            cs.shuffleCards(card,dealt);
            for (int i = 0; i < card.size(); i++) {
                System.out.println(card.get(i).getCardNumber());
            }
            for (int i = 0; i < dealt.size(); i++) {
                System.out.println(dealt.get(i).getCardNumber());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
