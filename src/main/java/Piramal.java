import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dakshay on 20/10/2021.
 */
public class Piramal {
    public static void main(String[] args) {
        String A = "abcabc";
        int size = A.length();
        List<Character> nonRepeatingCharacters = new ArrayList<>();
        Map<Character,Boolean> nonRepeatingCharactersBool = new HashMap<>();
        for (int i = 0; i < size; i++) {

        }
    }


}

//
//"abcaabcd" => "aaabc##"
//
//<a,b,c>,
//        when we are at "a" index 4, we find that this character already present in nonRepeatingCharacters, we will remove that character from that list.
//        after removeing if nonRepeatingCharacters.size()>0 then result.append(nonRepeatingCharacters.get(0)) else result.append("#");
//
//<b,c>
//
//<c>
//
//
//<d>
//
//
//B="a"+nonRepeatingCharacters.get(0)+ // aaabc##
//        O(n*26)
//        {
//            "a" : false, => after a repeatation we can update it to false
//            "b" : true,
//            "c" : true
//        }