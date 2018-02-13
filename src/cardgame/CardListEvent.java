package cardgame;
import java.util.ArrayList;
public class CardListEvent {    
    private ArrayList<Card> cardlist=new ArrayList<>();
    public ArrayList<Card> getCardlist() {
        return cardlist;
    }
    public void setCardlist(ArrayList<Card> cardlist) {
        this.cardlist = cardlist;
    }
}
