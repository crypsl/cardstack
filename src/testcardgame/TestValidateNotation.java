package testcardgame;
import cardgame.ValidateNotation;
public class TestValidateNotation {
    public static void main(String[] args) {
        ValidateNotation vn=new ValidateNotation();
        System.out.println("Result of Test Suite no. 4");
        System.out.println("Result of Test Case no.1");
        try {
            int[] value;
            value=vn.checkAndSplit("2dd");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Use correct form of dice notation!");
        }        
        System.out.println("Result of Test Case no.2");
        try {
            vn.checkAndSplit("1f45");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test Case no.3");
        try {
            int[] value;
            value=vn.checkAndSplit("3d6-7");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test case no. 4");
        try {
            int[] value;
            value=vn.checkAndSplit("5d0");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Use correct form of notation!");
        }
        System.out.println("Result of Test case no. 4");
        try {
            int[] value;
            value=vn.checkAndSplit("3d8");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Use correct form of notation!");
        }
        System.out.println("Result of Test case no. 5");
        try {
            int[] value;
            value=vn.checkAndSplit("4d7-76");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("Result of Test case no. 6");
        try {
            int[] value;
            value=vn.checkAndSplit("0d0-2");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Result of Test Suite no. 5");
        System.out.println("Result of Test case no.1");
        try {
            int[] value;
            value=vn.checkAndSplitd("3d8");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Use correct form of notation!");
        }
        System.out.println("Result of Test case no.2");
        try {
            int[] value;
            value=vn.checkAndSplitd("3dd");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Use correct form of notation!");
        }
        System.out.println("Result of Test case no.2");
        try {
            int[] value;
            value=vn.checkAndSplitd("2d-0");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Use correct form of notation!");
        }
        System.out.println("Result of Test case no.3");
        try {
            int[] value;
            value=vn.checkAndSplitd("1d9-7");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Use correct form of notation!");
        }
        System.out.println("Result of Test case no. 4");
        try {
            int[] value;
            value=vn.checkAndSplit("0d0");
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        } catch (Exception ex) {
            System.out.println("Invalid number of dice and face number!");
        }
    }
}
