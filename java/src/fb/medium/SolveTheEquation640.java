package fb.medium;


//Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
//
//        If there is no solution for the equation, return "No solution".
//
//        If there are infinite solutions for the equation, return "Infinite solutions".
//
//        If there is exactly one solution for the equation, we ensure that the value of x is an integer.
//
//        Example 1:
//        Input: "x+5-3+x=6+x-2"
//        Output: "x=2"
//        Example 2:
//        Input: "x=x"
//        Output: "Infinite solutions"
//        Example 3:
//        Input: "2x=x"
//        Output: "x=0"
//        Example 4:
//        Input: "2x+3x-6x=x+2"
//        Output: "x=-1"
//        Example 5:
//        Input: "x=x+2"
//        Output: "No solution"

public class SolveTheEquation640 {
    public String solveEquation(String equation) {
        int equalIdx=equation.indexOf("=");
        if(equalIdx==-1){return "No solution";}
        String leftE=equation.substring(0 , equalIdx);
        String rightE=equation.substring(equalIdx+1);
        int[] countsLeft=myCount(leftE);
        int[] countsRight=myCount(rightE);
        if(countsLeft[0]==countsRight[0]){
            if(countsLeft[1]==countsRight[1]){
                return "Infinite solutions";
            }else{
                return "No solution";
            }
        }
        return "x="+String.valueOf((countsRight[1]-countsLeft[1])/(countsLeft[0]-countsRight[0]));
    }

    private int[] myCount(String str){
        int value=0;
        int xCount=0;
        int vCount=0;
        int flag=1;
        for(int i=0 ; i<str.length() ; i++){
            char c=str.charAt(i);
            if(c=='x'){   //special case  0x=0   这个很僵
                if(value==0 && ((i>0 && str.charAt(i-1)!='0' ) || i==0 )){
                    xCount+=flag;
                }else {
                    xCount += value * flag;
                }
                value = 0;
                flag = 1;
            }else if(c=='+'){
                vCount+=value*flag;
                value=0;
                flag=1;
            }else if(c=='-'){
                vCount+=value*flag;
                value=0;
                flag=-1;
            }else if(Character.isDigit(c)){
                value=value*10+Character.getNumericValue(c);
            }
        }
        if(value!=0){
            vCount+=value*flag;
        }

        return new int[] {xCount  , vCount};
    }
    static public void main(String[] args){
        String equation="x+5-3+x=6+x-2";
        SolveTheEquation640 test=new SolveTheEquation640();
        test.solveEquation(equation);

    }



}
