import java.util.*;

/**
 * Created by dakshay on 14/10/2021.
 */
public class Nykka {
//    private static Nykka nykka = null;
//
//
//
//    public static Nykka CreateSingleton(){
//        if(nykka==null) nykka = new Nykka();
//         return nykka;
//    }
    public static void main(String[] args) {
        Nykka nykka = new Nykka();
        List<Integer> arr = new ArrayList<>(); // "19:43"
        StringBuilder result = new StringBuilder("");
        Collections.addAll(arr,1,2,9,9); // "21:40"  // 1,0,4 // 0,4
//        {0,9,3,4} // "09:43"
//        {2,9,4,3 } // "23:49"
//        int[] firstHour = {0,1,2};
//        int[] secondHour = {0,1,2,3};
        calculateHour(arr,result,2);
        if(result!=null && !result.equals("")) {
            result.append(":");
            calculateMinute(arr, result, 5);
        } else {
            System.out.println("-1");
        }
        System.out.println(result);

    }

    public static void calculateHour(List<Integer> arr, StringBuilder result, int start) {
        int k=2;
        boolean flag = true;
        while(k>0 &&  flag) {
            for (int i = start; i >= 0; i--) {
                if (arr.contains(i)) {

                    flag=true;
                    result.append(i);
                    arr.remove((Object)i);
                    System.out.println("Hello {}"+ arr);
                    if (i == 2) {start = 3; break;}
                    else if (i == 0 || i == 1) {start = 9; break;}
                }else{
                    flag=false;
                }
            }
            k--;
        }
    }

    public static void calculateMinute(List<Integer> arr, StringBuilder result, int start) {
        int k=2;
        while(k>0) {
            for (int i = start; i >= 0; i--) {
                if (arr.contains(i)) {
                    result.append(i);
                    arr.remove((Object)i);
                    start = 9;
                    break;
                }
            }
            k--;
        }
    }

//
////1,2,9,9
//"19:29"
//
//"21:"
//hour 21,19
//minute 19,29
//
//12 ,19 , 19
//21, 29
//
//12,19,21 => 99, (29, 92) , 99
//        {
//            "12": ["99"],
//            "19":["29","92"],
//            "21" : ["99"]
//        }

// 6, 2, 9, 0

//"06" :["29"],
//"02" : ["69"],
//"20" : ["69","96"],

}