/**
 * Created by dakshay on 22/10/2021.
 */
public class Freshworks {
    public static void main(String[] args) {
        int coins[]=new int[]{1,2,5};
        int amount= 11;

        int result[][] = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            result[i][0]=1;
        }
        for(int j=0;j<coins.length;j++) {
            for (int i = 1; i <= amount; i++) {
//                if(j==0 && coins[j]>i) result[j][i] =  0;
//                else if(j==0) result[j][i] = result[j][i-coins[j]];
//
//                if(coins[j]>i && j>=1) result[j][i] = result[j-1][i];
//                else if( j>=1){
//                   result[j][i] =  result[j][i-coins[j]]+result[j-1][i];
//                }
                int x = i>=coins[j] ? result[j][i-coins[j]]  : 0;
               int y = (j>=1) ?  result[j-1][i]: 0;
                result[j][i] = x+y;
            }
        }
        for(int j=0;j<coins.length;j++) {
            for (int i = 0; i <= amount; i++) {
                System.out.print(" " + result[j][i]);
            }
            System.out.println();
        }
        System.out.println(result[coins.length-1][amount]);
    }
}
//
//O(T*N*N);
//input
//ar [] = {7,11,5};
//Target = 18;
//
//ar[] = {2,1};
//target = 5
//
//ar [] = {8,3,5}
//target = 8
//    1 2 3 4 5 6 7 8
//8   0 0 0 0 0 0 0 1
//2   0 1 0 2 0 3 0 4
//3   0 0 1 0 2 2 3
//5
//        2
//        7-3 => 4
////        result[i][4]
//
//
////  [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18]
////2  1 0,1,0,1,0,1,0,1,0, 1,0, 1, 0,  1, 0, 1, 0, 1
////6  1 0,1,0,0,0,2,2,3,4, 5,6, 2, 3, 4, 5, 6 ,7, 3
////2  1 1,1
////9  1 1
////8  1 1
//
//
//2+2+1 = 5  Or 2+1+1+1 = 5
//5-2=3