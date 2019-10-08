//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.List;

public class StringUtils {


    /*
     * Split the input string 'str' w.r.t the character 'marker' in an array of String
     * for example split("test-test", '-') => {"test", "test"}
     * Must return null if there is no occurrence of 'marker' in 'str'
     */
    public static String [] split(String str, char marker){
        if(!str.contains(String.valueOf(marker))){
            return null;
        }
        char[] charArr = str.toCharArray();
        java.util.ArrayList<String> strArr = new java.util.ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(char elm : charArr){
            if(elm != marker){
                sb.append(elm);
            }else{
                strArr.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        strArr.add(sb.toString());
        return strArr.toArray(new String[0]);
    }


    /*
     * Returns the index of the first occurrence of sub in str
     * or -1 if there is no occurrence of sub in str at all.
     * Be careful, we ask you to make CASE SENSITIVE comparison between str and sub.
     */
    public static int indexOf(String str, String sub){
        if(!str.contains(sub)){
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        char[] subCharArr = sub.toCharArray();
        for(int i = 0 ; i<charArr.length; i ++){
            sb = new StringBuilder();
            if(charArr[i] == subCharArr[0]){
                try {
                    for (int a = 0; a < subCharArr.length; a++) {
                        if (charArr[i + a] != subCharArr[a]) {
                            break;
                        } else {
                            sb.append(charArr[i + a]);
                        }
                    }
                }catch (Exception e){
                    return -1;
                }
            }
            if(sb.toString().equals(sub)){
                return i;
            }
        }
        return -1;
    }


    public static String toLowerCase(String str){
            StringBuilder sb = new StringBuilder();
            for(char elm : str.toCharArray()){
                sb.append(Character.toLowerCase(elm));
            }
            return sb.toString();
        }


    /*
     * Returns true if the string 'str' is a palindrome (a string that reads the same from
     * left to right AND from right to left).
     */
    public static boolean palindrome(String str){
        char[] charArr = str.toCharArray();
        int arrLgt = charArr.length;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if(arrLgt%2 == 0){
            for(int i =0; i<arrLgt/2 ; i++){
                sb1.append(charArr[i]);
                sb2.append(charArr[arrLgt-i-1]);
            }
        }else{
            for(int i =0; i< (arrLgt-1)/2;i++){
                sb1.append(charArr[i]);
                sb2.append(charArr[arrLgt-i-1]);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }


}
