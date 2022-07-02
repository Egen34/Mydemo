import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static String calulate(String[] str){
        String res="";
        int a=Integer.parseInt(str[0]);
        int b=Integer.parseInt(str[2]);
        switch (str[1]) {
            case "*" -> res += a * b;
            case "/" -> res += a / b;
            case "+" -> res += a + b;
            case "-" -> res += a - b;
        }
        return res;
    }
    public static String changer(String str){
        String res = "";
        if (isNumeric(str)){
            String[][] o={
                    {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                    {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                    {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}
            };
            for (int i =str.length()-1; i>=0; i--) {
                res+=o[i][Integer.parseInt(str.split("")[str.length()-i-1])];
            }
        }else{
            for (int i = 1; i <999 ; i++) {
                res = changer(Integer.toString(i));
                if (str.equals(res))
                    return Integer.toString(i);
            }
        }
        return res;
    }
    public static String calc(String input){
        String[] st=input.split(" ");
        if (st.length>3)
            return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        if (st.length<3)
            return "throws Exception //т.к. строка не является математической операцией";
        if (isNumeric(st[0])==isNumeric(st[2])) {
            if (isNumeric(st[0])) {
                return calulate(st);
            } else {
                st[0] = changer(st[0]);
                st[2] = changer(st[2]);
                String k = calulate(st);
                if (Integer.parseInt(k) < 1)
                    return "throws Exception //т.к. в римской системе нет отрицательных чисел";
                return changer(k);
            }
        }else{
            return "throws Exception //т.к. используются одновременно разные системы счисления";}

    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        System.out.println(calc(s.nextLine()));
    }
}
