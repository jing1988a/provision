package eight_hundred_plus;
//In the following, every capital letter represents some hexadecimal digit from 0 to f.
//
//        The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".
//
//        Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
//
//        Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"
//
//        Example 1:
//        Input: color = "#09f166"
//        Output: "#11ee66"
//        Explanation:
//        The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
//        This is the highest among any shorthand color.
//        Note:
//
//        color is a string of length 7.
//        color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
//        Any answer which has the same (highest) similarity as the best answer will be accepted.
//        All inputs and outputs should use lowercase letters, and the output is 7 characters.
public class SimilarRGBColor800 {
    public String similarRGB(String color) {
        int r=Integer.valueOf(color.substring(1 , 3) , 16);
        int g=Integer.valueOf(color.substring(3 , 5) , 16);
        int b=Integer.valueOf(color.substring(5 , 7) , 16);
        String x="";
        String y="";
        String z="";
        double delta=Double.MAX_VALUE;
        for(int i=0 ; i<16 ; i++){
            for(int j=0 ; j<16 ; j++){
                for(int k=0 ; k<16 ; k++){
                    double curD=Math.pow(i*17-r , 2)+Math.pow(j*17-g, 2)+Math.pow(k*17-b, 2);
                    if(curD<delta){
                        delta=curD;
                        x=Integer.toString(i,16);
                        y=Integer.toString(j,16);
                        z=Integer.toString(k,16);
                    }
                }
            }
        }
        return "#"+x+x+y+y+z+z;
    }
    static  public  void  main(String[] str){
        SimilarRGBColor800 test=new SimilarRGBColor800();
//        Input:
//        "#09f166"
//        Output:
//        "#66ee66"
//        Expected:
//        "#11ee66"
        test.similarRGB("#09f166");
    }
}
