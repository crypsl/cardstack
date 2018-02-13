package cardgame;
import java.util.ArrayList;
public class CardStackHistory{    
    private ArrayList<CardStack> cardst;
    private CardStack cs;
    public CardStackHistory() {
        cardst=new ArrayList<>();
    }    
    public boolean searchDice(String notation){
        for(CardStack c : cardst){
            if(c.getDiceNotation().equals(notation)){
                cs = c;
                return true;
            }
        }  
        return false;  
    }
    public void addCardStackHistory(CardStack cardst) {
        this.cardst.add(cardst);
    }     
    public ArrayList<CardStack> getCardst() {
        return cardst;
    }
    public void setCardst(ArrayList<CardStack> cardst) {
        this.cardst = cardst;
    }
    public CardStack getCs() {
        return cs;
    }  
}
