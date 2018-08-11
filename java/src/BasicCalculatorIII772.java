//
//Implement a basic calculator to evaluate a simple expression string.
//
//        The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
//
//        The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.
//
//        You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].
//
//        Some examples:
//
//        "1 + 1" = 2
//        " 6-4 / 2 " = 4
//        "2*(5+5*2)/3+(6/2+8)" = 21
//        "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
//
//
//        Note: Do not use the eval built-in library function.
//


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BasicCalculatorIII772 {

    public int calculate(String s) {
        int l=s.length();
        if(l==0){return 0;}
        List<String> sList=myFormat(s);
        return realCaculate(sList);



    }

    private List<String> myFormat(String s){
        List<String> sList=new ArrayList();
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==' '){
                continue;
            }else if(c=='(' || c==')' || c=='+' || c=='-' || c=='*'  || c=='/'){
                if(sb.length()>0){
                    sList.add(sb.toString());
                    sb.delete(0 , sb.length());
                }
                sList.add(Character.toString(c));
            }else {
                sb.append(c);
            }
        }
        if(sb.length()>0) {
            sList.add(sb.toString());
        }
        return sList;
    }

    private int realCaculate(List<String> sList){
        int l=sList.size();
        Deque<Integer> numS=new LinkedList();
        Deque<String> opS=new LinkedList();


        int i=0;
        while(i<l){
            String c=sList.get(i);
            if(c.equals("+") || c.equals("-")){
                opS.addLast(c);
            }else if(c.equals("*") || c.equals("/")){
                int leftVal=numS.removeLast();
                String right=sList.get(i+1);
                if(right.equals("(")){
                    int j=i+1;
                    int count=1;
                    while(count!=0){
                        j++;
                        if(sList.get(j).equals(")")){
                            count--;
                        }else if(sList.get(j).equals("(")){
                            count++;
                        }
                    }
                    int rightVal=realCaculate(sList.subList(i+2 , j));
                    if(c.equals("*")){
                        numS.addLast(leftVal*rightVal);
                    }else{
                        numS.addLast(leftVal/rightVal);
                    }
                    i=j;
                }else{
                    int rightVal=Integer.parseInt(right);
                    if(c.equals("*")){
                        numS.addLast(leftVal*rightVal);
                    }else{
                        numS.addLast(leftVal/rightVal);
                    }
                    i++;
                }

            }else if(c.equals("(")){
                int j=i;
                int count=1;
                while(count!=0){
                    j++;
                    if(sList.get(j).equals(")")){
                        count--;
                    }else if(sList.get(j).equals("(")){
                        count++;
                    }
                }
                numS.addLast(realCaculate(sList.subList(i+1 , j)));
                i=j;
            }else{
                numS.addLast(Integer.parseInt(c));
            }
            i++;
        }
        while(!opS.isEmpty()){
            int a=numS.pollFirst();
            int b=numS.pollFirst();
            String op=opS.pollFirst();
            if(op.equals("+")){
                numS.addFirst(a+b);
            }else{
                numS.addFirst(a-b);
            }
        }
        return numS.pollFirst();
    }




    static public void main(String[] args){
        BasicCalculatorIII772 test=new BasicCalculatorIII772();
        System.out.println(test.calculate("(2+6* 3+5- (3*14/7+2)*5)+3"));
    }
}
