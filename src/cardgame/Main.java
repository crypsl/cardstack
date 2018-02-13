package cardgame;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class Main extends JFrame implements ActionListener{    
    private JTextField txt_uname,txt_notation;
    private JPanel panel1,panel2,panel3,panel4,panel5,panel6,panel_cardbtn,panel_peekbtn,
            panel_topicard,panel_topicpeek,inputpanel;
    private JButton btn_create,btn_getCard,btn_shuffle,btn_DealtCard,btn_RemovedCard,
            btn_FutureCard,btnshowhistory,btnclearhistory,btnhelp;
    private CardListner cardlistener;
    private CardStack cardstack;
    private int diceno,faceno,cardstodeal;
    private DisplayCards dispcards;
    private DisplayRemovedCards displremcards;
    private ArrayList<CardStack> cards;
    private CardStackHistory cardstackhistory;
    private ValidateNotation vn;
    private boolean isok;
    private int []value;  
    private Dialogbox dbox;
   public Main(){
        cards=new ArrayList<>();
        dispcards=new DisplayCards();
        displremcards=new DisplayRemovedCards();
        cardstackhistory=new CardStackHistory();
        vn=new ValidateNotation();
        setTitle("Rolling Dice"); 
        initializeComponents();
    }
    private void initializeComponents(){
        setSize(580,550);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon("img/dice.png").getImage()); 
        setBackground(new Color(153,153,204)); 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                int option= JOptionPane.showConfirmDialog(null,"Goodbye "+txt_uname.getText()
                        +"\n"+" All stacks you created will lost!","Confirm Close",
                        JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
                if (option==JOptionPane.OK_OPTION) {
                    System.exit(0); 
                }else{
                    System.out.println("do nothing");
                }
            }
        });        
        panel1=new JPanel();    panel1.setBorder(BorderFactory.createBevelBorder(2)); 
        panel2=new JPanel(new GridLayout(3, 1));    panel2.setBorder(BorderFactory.createEtchedBorder());
        panel3=new JPanel();    panel3.setBorder(BorderFactory.createEtchedBorder());
        panel4=new JPanel();    panel4.setBorder(BorderFactory.createEtchedBorder());
        panel5=new JPanel();    panel5.setBorder(BorderFactory.createEtchedBorder());              
        panel1.setPreferredSize(new Dimension(600,50));
        panel2.setPreferredSize(new Dimension(150,500));
        panel3.setPreferredSize(new Dimension(450,500)); 
        panel4.setPreferredSize(new Dimension(200,500)); 
        panel5.setPreferredSize(new Dimension(600,50));         
        btn_getCard=new JButton("Show Card");      btn_DealtCard=new JButton("Dealt Card");
        btn_shuffle=new JButton("Shuffle");        btn_RemovedCard=new JButton("Removed Card");
        btn_FutureCard=new JButton("Future Cards"); btn_create=new JButton("Create Cards"); 
        btnshowhistory=new JButton("Show History"); btnclearhistory=new JButton("Clear History");
        btnhelp=new JButton("Help");
        btn_getCard.addActionListener(this);    btn_shuffle.addActionListener(this);
        btn_DealtCard.addActionListener(this);  btn_RemovedCard.addActionListener(this);
        btn_FutureCard.addActionListener(this); btn_create.addActionListener(this);   
        btnshowhistory.addActionListener(this); btnclearhistory.addActionListener(this); 
        btnhelp.addActionListener(this); 
        txt_uname=new JTextField(10);
        txt_uname.setToolTipText("Please enter your name.");
        txt_notation=new JTextField(10);
        txt_notation.setToolTipText("Please enter dice notation in the form of <number of cards> d <number of face> - <cards to remove>"); 
        inputpanel=new JPanel();        
        inputpanel.add(new JLabel("Enter your name"));
        inputpanel.add(txt_uname);
        inputpanel.add(new JLabel("Enter dice notation"));
        inputpanel.add(txt_notation);
        inputpanel.add(btn_create);
        panel_cardbtn=new JPanel(new GridLayout(3, 1, 10, 1)); 
        panel_cardbtn.setBorder(BorderFactory.createTitledBorder("Card"));
        panel_peekbtn=new JPanel(new GridLayout(3, 1, 10, 1)); 
        panel_peekbtn.setBorder(BorderFactory.createTitledBorder("Peek")); 
        panel_cardbtn.add(btn_getCard);
        panel_cardbtn.add(btn_shuffle);        
        panel1.add(inputpanel);
        panel6=new JPanel(new GridLayout(3, 1, 10, 1));      
        panel_peekbtn.add(btn_DealtCard);
        panel_peekbtn.add(btn_RemovedCard);
        panel_peekbtn.add(btn_FutureCard);
        panel6.add(btnshowhistory); panel6.setBorder(BorderFactory.createTitledBorder("History"));
        panel6.add(btnclearhistory);
        panel2.add(panel_cardbtn);
        panel2.add(panel_peekbtn);
        panel2.add(panel6);
        panel3.add(dispcards); 
        panel4.add(new JLabel(new ImageIcon("img/dice-1.png"))); 
        panel5.add(btnhelp);
        btn_getCard.setEnabled(false);
        btn_DealtCard.setEnabled(false);
        btn_FutureCard.setEnabled(false);
        btn_shuffle.setEnabled(false);
        btn_RemovedCard.setEnabled(false);
        btnshowhistory.setEnabled(false);
        btnclearhistory.setEnabled(false);
        Container c=getContentPane();        
        c.add(panel1,BorderLayout.PAGE_START);
        c.add(panel2,BorderLayout.LINE_START);
        c.add(panel3,BorderLayout.CENTER);
        c.add(panel4,BorderLayout.LINE_END);
        c.add(panel5,BorderLayout.PAGE_END);        
    }       
    public void addCardListener(CardListner cardlistener){
        this.cardlistener=cardlistener;
    }    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn=(JButton)e.getSource();
        String notation=this.txt_notation.getText().toLowerCase();
        if (btn==btn_create) {  
            dispcards.getLbl_card().setText("CARD NUMBER");
            dispcards.getLbl_freq().setText("FREQUENCY"); 
            if (isok) { 
                cardstackhistory.addCardStackHistory(cardstack); 
                isok=false;
            }            
            if (cardstackhistory.searchDice(notation)) {
                cardstack=cardstackhistory.getCs();
                JOptionPane.showMessageDialog(null, "Old Card Stack found! Use old one!");
                isok=true;
            }else{
            cardstack=new CardStack();
            isok=true;
                if (notation.contains("d") && notation.contains("-")) {
                    try {
                   this.value=vn.checkAndSplit(notation);
                    diceno=value[0];
                    faceno=value[1];
                    cardstodeal=value[2];
                      } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Please use correct form of dice notation!");
                    return;
                     }
                }else if (notation.contains("d") ) {
                    try {
                    this.value=vn.checkAndSplitd(notation);
                    diceno=value[0];
                    faceno=value[1];
                    cardstodeal=0;
                      } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Please use correct form of dice notation!");
                    return;
                     }    
                }else{
                    JOptionPane.showMessageDialog(null,"Please use correct form of dice notation!","Message",
                            JOptionPane.PLAIN_MESSAGE);
                    return;
                }                
            this.addCardListener(cardstack);
            DiceNotationEvent dn=new DiceNotationEvent();
            dn.setDiceno(diceno);
            dn.setFaceno(faceno);
            dn.setCardstodeal(cardstodeal);
            cardlistener.actionDiceNotation(dn); 
            btn_getCard.setEnabled(true);
            btn_DealtCard.setEnabled(true);
            btn_FutureCard.setEnabled(true);
            btn_shuffle.setEnabled(true);
            btn_RemovedCard.setEnabled(true);
            btnshowhistory.setEnabled(true);
            btnclearhistory.setEnabled(true);
            }
        }else if (btn==btn_getCard) {            
            if (cardstack.getCardlist().isEmpty()) {
                 JOptionPane.showMessageDialog(null,"Card Stack is empty! Reshuffle Cards!","Message",
                         JOptionPane.INFORMATION_MESSAGE);
                 cardstack.shuffleCards(cardstack.getCardlist(),cardstack.getDealtcardstack());
                 return;
            }
            dispcards.showCard(cardstack.getCardlist()); 
            cardstack.addDealtCard(cardstack.getCardlist().get(0));  
        }else if (btn==btn_shuffle) {
            cardstack.shuffleCards(cardstack.getCardlist(),cardstack.getDealtcardstack());
        }else if (btn==btn_DealtCard) {
            DisplayDealtCards dispdealcards=new DisplayDealtCards();
            this.addCardListener(dispdealcards);
            CardListEvent ce=new CardListEvent();
            ce.setCardlist(cardstack.getDealtcardstack());
            cardlistener.actionCardList(ce); 
            dispdealcards.setVisible(true); 
        }else if (btn==btn_RemovedCard) {
            this.addCardListener(displremcards);
            CardListEvent ce=new CardListEvent();
            ce.setCardlist(cardstack.getRemovedcardstack());
            cardlistener.actionCardList(ce);
            displremcards.setVisible(true); 
        }else if (btn==btn_FutureCard) {
             DisplayFutureCards dispfutucards=new DisplayFutureCards();
             this.addCardListener(dispfutucards);
             CardListEvent ce=new CardListEvent();
             ce.setCardlist(cardstack.getCardlist());
             cardlistener.actionCardList(ce);
             dispfutucards.setVisible(true); 
        }else if (btn==btnshowhistory) {
            dbox=new Dialogbox("history", cardstackhistory.getCardst());
        }else if (btn==btnhelp) {
            dbox=new Dialogbox("help",cardstackhistory.getCardst());
        }else if (btn==btnclearhistory) {
            int opt=JOptionPane.showConfirmDialog(null,"Are you sure you want to clear all History?","Message",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (opt==JOptionPane.YES_OPTION) {
                if (cardstackhistory.getCardst().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"No previous history found!!!","Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                cardstackhistory.getCardst().clear();
                cardstack.getCardlist().clear();
            }else{
                System.out.println("Do nothing");
            }
        }
    }    
    public static void main(String[] args) {
        try{
          for (UIManager.LookAndFeelInfo lookandfeel:UIManager.getInstalledLookAndFeels()) {
             if ("Nimbus".equals(lookandfeel.getName())) {
                UIManager.setLookAndFeel(lookandfeel.getClassName());
                    break;
              }
            }
         }catch(ClassNotFoundException | InstantiationException | IllegalAccessException
                 | UnsupportedLookAndFeelException e){          
        }
        new Main().setVisible(true); 
    }    
}
