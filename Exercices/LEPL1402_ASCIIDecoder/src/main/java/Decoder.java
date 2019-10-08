import java.util.ArrayList;
import java.util.Arrays;

public class Decoder {

    /*
     * Forbidden characters are passed as an array of int.
     * Each element of this array correspond to the decimal ASCII code
     * of a forbidden character OR null if there's no forbidden character
     * If you encounter one of these forbidden character
     * you must ignore it when you translate your sentence.
     *
     * the 2D array "sentences" contain a set of decimal ASCII code we want you
     * to translate. Each sub-element of this array is a different sentence.
     * Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
     * to your decode method, you should return : [ "*HX", "bco/7" ]
     *
     * You should NEVER return null or an array containing null
     */
    public static String[] decode(int[] forbidden, String[][] sentences){
        ArrayList<Integer> forbidenArr = new ArrayList<Integer>();
        if(forbidden != null){
            for(int i : forbidden){
                forbidenArr.add(i);
            }
        }
        ArrayList<String> stringArr = new ArrayList<String>();
        for(String[] elm : sentences){
            StringBuilder sb = new StringBuilder();
            for(String i: elm){
                if(forbidden != null){
                    if(forbidenArr.contains(Integer.parseInt(i))){
                    }else{
                        sb.append(Character.toString((char) Integer.parseInt(i)));
                    }
                }else{
                    sb.append(Character.toString((char) Integer.parseInt(i)));
                }
            }
            stringArr.add(sb.toString());
        }
        return stringArr.toArray(new String[0]);
    }


}