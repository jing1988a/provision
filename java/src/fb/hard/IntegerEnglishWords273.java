package fb.hard;//class Solution(object):
//        def numberToWords(self, num):
//        """
//        :type num: int
//        :rtype: str
//        """
//
//        lv1 = "Zero One Two Three Four Five Six Seven Eight Nine Ten \
//        Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen".split()
//        lv2 = "Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety".split()
//        lv3 = "Hundred"
//        lv4 = "Thousand Million Billion".split()
//
//        w=''
//        level=-1
//        ans=[]
//        while num:
//        cur_lv=num%1000
//        num=num/1000
//
//        if cur_lv>99:
//        w+=lv1[cur_lv/100]+' '+lv3+' '
//        cur_lv=cur_lv%100
//
//        if cur_lv>19:
//        w+=lv2[(cur_lv/10)-2]+' '
//        cur_lv=cur_lv%10
//
//        if cur_lv>0:
//        w+=lv1[cur_lv]+' '
//
//
//        if level>-1 and len(w)>1:
//        w+=lv4[level]+' '
//
//
//
//
//        ans.append(w)
//        level+=1
//        w=''
//
//
//        return ''.join(ans[::-1]).strip() or 'Zero'



//
//Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
//
//        Example 1:
//
//        Input: 123
//        Output: "One Hundred Twenty Three"
//        Example 2:
//
//        Input: 12345
//        Output: "Twelve Thousand Three Hundred Forty Five"
//        Example 3:
//
//        Input: 1234567
//        Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//        Example 4:
//
//        Input: 1234567891
//        Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousan
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerEnglishWords273 {
    public String numberToWords(int num) {
        String[] lv1 = "Zero One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen".split(" ");
        String[] lv2 = "Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety".split(" ");
        String lv3 = "Hundred";
        String[] lv4 = "Thousand Million Billion Trillion".split(" ");

        int curLvl=-1;
        List<String> ans=new ArrayList();
        while(num!=0){
            int curNum=num%1000;
            num/=1000;
            List<String> temp=new ArrayList();
            if(curNum>99){
                int lv3Count=curNum/100;
                temp.add(lv1[lv3Count]);
                temp.add(lv3);
                curNum%=100;
            }
            if(curNum>19){
                int lv2Idx=curNum/10;
                temp.add(lv2[lv2Idx-2]); //这里要减2
                curNum%=10;
            }
            if(curNum!=0) {
                temp.add(lv1[curNum]);
            }
            if (curLvl>-1 && temp.size()>0){
                temp.add(lv4[curLvl]);
            }
            curLvl++;
            if(temp.size()>0) {
                ans.add(String.join(" ", temp));
            }
        }
        Collections.reverse(ans);
        String realans=String.join(" " , ans).trim();
        if(realans.length()==0){
            return "Zero";
        }
        return realans;
    }


    static public void main(String[] args){
        int n=1234567891;
        IntegerEnglishWords273 test=new IntegerEnglishWords273();
        test.numberToWords(n);

    }

}
