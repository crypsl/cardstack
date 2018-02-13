package cardgame;
import java.util.ArrayList;
import java.util.Collections;
public class CardStack implements CardListner{    
    private ArrayList<Card> cardlist;
    private ArrayList<Card> removedcardstack;
    private ArrayList<Card> dealtcardstack;
    private int diceno,faceno,cardstodeal;
    private Dice dice;
  public CardStack() {
        removedcardstack=new ArrayList<>();
        dealtcardstack=new ArrayList<>();
    }
    public ArrayList<Card> getCardlist() {
        return cardlist;
    }
    public ArrayList<Card> getRemovedcardstack() {
        return removedcardstack;
    }
    public ArrayList<Card> getDealtcardstack() {
        return dealtcardstack;
    }  
    public void setDiceno(int diceno) {
        this.diceno = diceno;
    }
    public void setFaceno(int faceno) {
        this.faceno = faceno;
    }
    public void setCardstodeal(int cardstodeal) {
        this.cardstodeal = cardstodeal;
    }
    
    public void setCardlist(ArrayList<Card> cardlist) {
        this.cardlist = cardlist;
    }
    public void setRemovedcardstack(ArrayList<Card> removedcardstack) {
        this.removedcardstack = removedcardstack;
    }
    public void setDealtcardstack(ArrayList<Card> dealtcardstack) {
        this.dealtcardstack = dealtcardstack;
    }   
    public void removeCards(int cardstodeal,int size) throws Exception{
        if (cardstodeal<0) {
             throw new Exception("Negative number of cards can not be removed!");
        }
        if (cardstodeal>size-1) {
             throw new Exception("Can not remove more cards than in Stack!");
        }
        for (int i = 0; i < cardstodeal; i++) {
            removedcardstack.add(cardlist.get(i));
            cardlist.remove(i);
        }
    }    
    public void addDealtCard(Card c){
        dealtcardstack.add(c);
        cardlist.remove(c);
    }    
    public void shuffleCards(ArrayList<Card> cardlist, ArrayList<Card> dealtcardstack){
        if (cardlist.isEmpty()) {
            cardlist.addAll(dealtcardstack);
            dealtcardstack.clear();
            Collections.shuffle(cardlist);
        }else{
            Collections.shuffle(cardlist); 
        }
    }
    @Override
    public void actionDiceNotation(DiceNotationEvent dn) {
        this.diceno=dn.getDiceno();
        this.faceno=dn.getFaceno();
        this.cardstodeal=dn.getCardstodeal();       
        try {
            dice=new Dice(diceno,faceno);
        } catch (Exception ex) {
            ex.getMessage();
        }
        this.cardlist=dice.getList();
        shuffleCards(cardlist,dealtcardstack);
        try { 
            removeCards(cardstodeal,cardlist.size());
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    @Override
    public void actionCardList(CardListEvent ce) {}   
    public String getDiceNotation(){
        if (cardstodeal == 0 ) {
            return diceno+"d"+faceno;
        }
        return diceno+"d"+faceno+"-"+cardstodeal;
    }
}
