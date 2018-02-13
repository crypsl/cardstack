package cardgame;
public class ValidateNotation{    
    public ValidateNotation(){}    
    public int[] checkAndSplit(String notation) throws Exception{
        int dn=0,fn=0,ctd=0;
        try{
            String temp1[]=notation.split("d");
            dn=Integer.parseInt(temp1[0]);
            String temp2[]=temp1[1].split("-");
            fn=Integer.parseInt(temp2[0]);
            ctd=Integer.parseInt(temp2[1]);
            if (dn<=0 || fn<=0) {
                 throw new Exception("Invalid Input to create Card Stack!");
            }
            if (ctd>=(dn*fn-dn)+1) {
                 throw new Exception("Invalid number of cards to deal!! Please check and try again!!");
            }
            int[] value={dn,fn,ctd};
            return value;
        }catch(NumberFormatException ex){    
            throw new Exception("Please use correct form of dice Notation!");
        }
    }    
    public int[] checkAndSplitd(String notation) throws Exception{
        int dn=0,fn=0,ctd=0;
        try{
            String temp[]=notation.split("d");
            dn=Integer.parseInt(temp[0]);
            fn=Integer.parseInt(temp[1]);
            if (dn<=0 || fn<=0) {
                 throw new Exception("Invalid Input to create Card Stack!");
            }
            int[] value={dn,fn,ctd};
            return value;
        }catch(NumberFormatException ex){
            throw new Exception("Please use correct form of dice Notation!");
        }
    }
}

