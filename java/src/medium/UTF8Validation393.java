package medium;


//A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
//
//        For 1-byte character, the first bit is a 0, followed by its unicode code.
//        For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
//        This is how the UTF-8 encoding would work:
//
//        Char. number range  |        UTF-8 octet sequence
//        (hexadecimal)    |              (binary)
//        --------------------+---------------------------------------------
//        0000 0000-0000 007F | 0xxxxxxx
//        0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//        0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//        0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
//        Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
//
//        Note:
//        The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.
//
//        Example 1:
//
//        data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
//
//        Return true.
//        It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
//        Example 2:
//
//        data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
//
//        Return false.
//        The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
//        The next byte is a continuation byte which starts with 10 and that's correct.
//        But the second continuation byte does not start with 10, so it is invalid.


//If your string contains numbers only, you can make it an integer and then do padding:
//
//        String.format("%010d", Integer.parseInt(mystring));
//
//
//https://stackoverflow.com/questions/388461/how-can-i-pad-a-string-in-java
//        down vote
//        Padding to 10 characters:
//
//        String.format("%10s", "foo").replace(' ', '*');
//        String.format("%-10s", "bar").replace(' ', '*');
//        String.format("%10s", "longer than 10 chars").replace(' ', '*');



//1 format to binary string
//2 remve digit more than 8 & add extra 0 for digit less than 8
//3 check format
//
//Input:
//        [250,145,145,145,145]
//        Output:
//        true
//        Expected:
//        false
//        Stdout:
//        [11111010, 10010001, 10010001, 10010001, 10010001]
//

//Arrays.toString(); 和 直接 .toString() 是不一样的 ， 学到了没有？？

import java.util.Arrays;

public class UTF8Validation393 {
    public boolean validUtf8(int[] data) {
        String[] formatedData=myFormat(data);
        int l=formatedData.length;
        //System.out.println(Arrays.toString(formatedData));
        int nBit=0;
        for(int i=0 ; i<l ; i++){
            String top2=formatedData[i].substring(0,2);
            if(nBit==0){
                if(top2.equals("00")){continue;}
                if(top2.equals("10")){return false;}
                if(top2.charAt(0)=='1'){
                    int j=1;
                    while(formatedData[i].charAt(j)!='0' ){
                        nBit++;
                        j++;
                        if(j==5){
                            return false;
                        }

                    }
                }
            }else{
                if(!top2.equals("10")){
                    return false;
                }
                nBit--;
            }
        }
        return nBit==0;
    }
    private String[] myFormat(int[] data){
        int l=data.length;
        String[] ans=new String[l];
        for(int i=0 ; i<l ; i++){
            String bStr=Integer.toBinaryString(data[i]);
            if(bStr.length()<8){
                ans[i]=String.format("%10s" , bStr).replace(' ' , '0');
            }else{
                ans[i]=bStr.substring(  bStr.length()-8 );
            }
        }
        return ans;
    }

}
