package hard;

import java.util.ArrayList;
import java.util.List;
//        ;Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//
//        You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
//
//        Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//        For the last line of text, it should be left justified and no extra space is inserted between words.
//
//        Note:
//
//        A word is defined as a character sequence consisting of non-space characters only.
//        Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
//        The input array words contains at least one word.
//        Example 1:
//
//        Input:
//        words = ["This", "is", "an", "example", "of", "text", "justification."]
//        maxWidth = 16
//        Output:
//        [
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//        Example 2:
//
//        Input:
//        words = ["What","must","be","acknowledgment","shall","be"]
//        maxWidth = 16
//        Output:
//        [
//        "What   must   be",
//        "acknowledgment  ",
//        "shall be        "
//        ]
//        Explanation: Note that the last line is "shall be    " instead of "shall     be",
//        because the last line must be left-justified instead of fully-justified.
//        Note that the second line is also left-justified becase it contains only one word.
//        Example 3:
//
//        Input:
//        words = ["Science","is","what","we","understand","well","enough","to","explain",
//        "to","a","computer.","Art","is","everything","else","we","do"]
//        maxWidth = 20
//        Output:
//        [
//        "Science  is  what we",
//        "understand      well",
//        "enough to explain to",
//        "a  computer.  Art is",
//        "everything  else  we",
//        "do                  "
//        ]

//what if there is a length of word bigger than maxWidth????
public class TextJustification68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        int curLength=0;
        int i=0;
        int l=words.length;
        List<String> line=new ArrayList<>();
        while(i<l){
            String word=words[i];
            int wordL=word.length();
            if(wordL>maxWidth){return new ArrayList<String>();}

            if(line.isEmpty()){
                line.add(word);
                curLength+=wordL;
            }else{
                if(curLength+1+wordL<=maxWidth){
                    line.add(word);
                    curLength+=1+wordL;
                }else{
                    ans.add(formatLine(line , maxWidth));
                    line.clear();
                    line.add(word);
                    curLength=wordL;


                }
            }
            i++;
        }

        String lastLine=String.join(" "  ,line);
        ans.add(String.format("%-"+maxWidth+"s" , lastLine)); // 学到了没？？？

        return ans;


    }
    private String formatLine(List<String> line , int maxWidth){
        int l=line.size();
        if(l==1){
//            int extraSpace=maxWidth-line.get(0).length();
            return String.format("%-"+maxWidth+"s" , line.get(0));

        }else{
            int totalWord=line.size();
            int totalChar=0;
            for(String s:line){
                totalChar+=s.length();
            }
            int totalSpaceNeed=maxWidth-totalChar;
            int space=totalSpaceNeed/(totalWord-1);
            int extraSpace=totalSpaceNeed%(totalWord-1);
            StringBuilder res=new StringBuilder();
            res.append(line.get(0));
            int i=1;
            while(i<l){
                if(extraSpace!=0){
                    res.append(" ");
                    extraSpace--;
                }
                for(int j=0 ; j<space;j++){
                    res.append(" ");
                }
                res.append(line.get(i));
                i++;
            }
            return res.toString();
        }
    }

    static public void main(String[] args){
        TextJustification68 test= new TextJustification68();
        String[] line={"This", "is", "an", "example", "of", "text", "justification."};
        int witdth=16;
        List<String> ans=test.fullJustify(line , witdth);
        System.out.println(ans);
    }

}
