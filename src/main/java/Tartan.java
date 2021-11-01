import javafx.util.Pair;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dakshay on 20/10/2021.
 */
public class Tartan {
    public Pair<Integer,Integer> matrixSerch(int[][] ar, int element) {
        int n = ar.length;
        int m = ar[0].length;
        int i = 0;
        int j = m-1;
        Pair<Integer, Integer> indexCoordinates = null;
        while ((j >= 0 && j < m) && (i >= 0 && i < n)) {
            if (ar[i][j] > element) j--;
            else if (ar[i][j] < element) i++;
            else {
                indexCoordinates = new Pair<>(i, j);break;
            }
        }
        Set s = new HashSet();
        s.add(null);
        s.add(1);
        Iterator is = s.iterator();
        while(is.hasNext()) {
            System.out.println("____OO___ "+is.next());
        }

        return indexCoordinates;
    }
     class CustomException extends Exception{
        CustomException(){
            super("asd");
        }
    }

    public static void main(String[] args) {
            int ar[][]={{1,3,7},{2,5,8},{4,9,10}};
            Tartan t = new Tartan();
            System.out.println(t.matrixSerch(ar,0));
        }
    }
