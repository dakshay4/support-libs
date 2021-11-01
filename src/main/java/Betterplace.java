import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by dakshay on 27/10/2021.
 */
public class Betterplace {
    public static void main(String[] args) {
//        try {
//            int[] ar = {1,2,3,4,-9};
//            int size = ar.length;
//            int low = 0, high = size - 1;
//            while (low < high) {
//                if (ar[low] > 0 && ar[high] < 0) {
//                    swap(ar, low++, high--);
//                }
//                if (ar[low] < 0) low++;
//                if (ar[high] > 0) high--;
//            }
//            for(int i=0;i<size;i++)
//            System.out.print(ar[i]+", ");
//        }catch (Exception ex) {
//            System.out.println(ex);
//        }

        pairCount();
    }

    public static void swap(int[] ar, int a,int b) {
        int temp = ar[b];
        ar[b] = ar[a];
        ar[a] = temp;
    }

    public static void pairCount(){
        try {
            int[] ar = {1, 1, 1, 1};
            int sum = 2;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < ar.length; i++) {
                Integer val = map.get(ar[i]);
                if (val != null) {
                    map.put(ar[i], val + 1);
                } else {
                    map.put(ar[i], 1);
                }
            }
            int result = 0;
            for (Map.Entry entry : map.entrySet()) {
                int key = (int) entry.getKey();
                int anotherKey = sum - key;
                if (map.get(anotherKey) != null) {
                    result += (int) entry.getValue() * map.get(anotherKey);
                    map.put(key, null);
                    map.put(anotherKey, null);
                }
            }
            System.out.println(result);
        }catch (Exception e) {
            System.out.println(e);
        }

    }

}

// {1,1,1,1}, sum =2
//1=>4
//        3->2
//        4-> 6
//        5->6*4 = 24
//        6->24*5 =
//key == anotherKey
//24


// 1 => 4
//{1, 5, 5, 7, -1, 1, 1} sum = 6
//<diff,count>
//{<1=>3> < 5=>2> <7=>1> <-1=>1>}
//(1,5) (1,5) (1,5) (1,5),(1,5),(1,5) (7,-1)

//1st iteration ,  <5,0>    =>
//        2nd iteration,  1st step  <1,0>       2ndStep <5,1>
//        3rd iteration,  1st step <-1,0>
//        4th iteration,  1st step <7,0>   <-1,1>
//
//<5,1><-1,1><7,0>
