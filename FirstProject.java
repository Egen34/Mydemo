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
        String[] res={"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX"};
        if (isNumeric(str))
            return res[Integer.parseInt(str)-1];
        for (int i = 0; i < res.length; i++)
            if (str.equals(res[i]))
                return ""+(i+1);
        return "";
    }
    public static String calc(String input){
        String[] st=input.split(" ");
        if (st.length>3)
            return "throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
        if (st.length==1)
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
        System.out.println(calc("1 + 2"));
        System.out.println(calc("VI / III"));
        System.out.println(calc("I - II"));
        System.out.println(calc("I + 1"));
        System.out.println(calc("1"));
        System.out.println(calc("1 + 2 + 3"));
    }
}
