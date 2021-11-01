package MachineCoding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by dakshay on 22/10/2021.
 */
public class PrimitiveRefrence {
    public static void main(String[] args) {
        Integer[] ar = new Integer[]{1,2,3};
        for(int i=0;i<ar.length;i++){
            shift(ar[i],ar);
        }
        for(int i=0;i<ar.length;i++){
            System.out.println(ar[i]);
        }

        implementHasMapSet();


    }

    private static void implementHasMapSet() {
        Map<String, Set<Integer>> myWord = new HashMap<String, Set<Integer>>();
        Set<Integer> mySet = new HashSet<Integer>(); mySet.add(3);
        mySet.add(9);
        mySet.add(1);
        myWord.put("word1", mySet);
        System.out.println("asdasd: "+myWord);
    }

    private static void shift(Integer i, Integer[] ar) {
        i*=i;
        ar[0]=10;
    }
}
