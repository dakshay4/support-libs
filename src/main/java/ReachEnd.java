import java.util.List;

/**
 * Created by dakshay on 09/10/2021.
 */
public class ReachEnd {

//    public static String reachTheEnd(List<String> grid, int maxTime) {
//        // Write your code here
//        int size = grid.size();
//        int n = grid.get(0).length();
//        int[][] gridarr = new int[size][n];
//        for(int i=0;i<size;i++){
//            for(int j=0;j<grid.get(i).length();j++) {
//                gridarr[i][j] = grid.get(i).charAt(j);
//            }
//        }
//        return "Yes";
//    }

    public static void main(String[] args) {
        System.out.println("Hello# "+totalBst(4));
    }




    public static int totalBst(int n) {
        int T[] = new int[n+1];
        T[0]=1;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<i;j++) {
                T[i]+=T[j]*T[i-j-1];
            }
        }
        return T[n];
    }
}
