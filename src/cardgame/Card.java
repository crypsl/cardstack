package cardgame;
import java.text.DecimalFormat;
public class Card {    
    private int cardNumber;
    private int cardFrequency;
    private DecimalFormat decimalformat=new DecimalFormat("0.0");
    public Card(int cardNumber, int cardFrequency) throws Exception{
        if (cardNumber==0 || cardFrequency==0) {
            throw new Exception("Card Number OR its Frequency can not zero.");
        }        
        if (cardNumber<0 || cardFrequency<0) {
            throw new Exception("Card Number OR its Frequency can not be less than zero.");        
        }
        if (cardFrequency>10000) {
             throw new Exception("Dice rolled for 10000 times only! Invalid Data!!");
        }
        this.cardNumber = cardNumber;
        this.cardFrequency = cardFrequency;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public double getCardFrequency() {
        String temp=decimalformat.format(cardFrequency/100); 
        return Double.parseDouble(temp);
    }
    public void setCardFrequency(int cardFrequency) {
        this.cardFrequency = cardFrequency;
    }  }
