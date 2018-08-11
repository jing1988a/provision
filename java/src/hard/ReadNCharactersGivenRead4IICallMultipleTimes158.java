package hard;//
//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//        The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
//        By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//        Note:
//        The read function may be called multiple times.
//
//        Example 1:
//
//        Given buf = "abc"
//        read("abc", 1) // returns "a"
//        read("abc", 2); // returns "bc"
//        read("abc", 1); // returns ""
//        Example 2:
//
//        Given buf = "abc"
//        read("abc", 4) // returns "abc"
//        read("abc", 1); // returns ""


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReadNCharactersGivenRead4IICallMultipleTimes158 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    Deque<Character> myBuffer=new LinkedList<>();
    public int read(char[] buf, int n) {
        int cur=0;
        while(cur!=n){
            while(!myBuffer.isEmpty()){
                buf[cur]=myBuffer.removeFirst();
                cur++;
                if(cur==n){
                    return cur;
                }
            }
            char[] temp=new char[4];
            int l=read4(temp);
            if(l==0){return cur;}
            int i=0;
            while(i<l){
                buf[cur]=temp[i];
                i++;
                cur++;
                if(cur==n){
                    break;
                }
            }
            while(i<l){
                myBuffer.addLast(temp[i]);
                i++;
            }

        }
        return cur;
    }



    private int read4(char[] buf){
        return -1;
    }
}
