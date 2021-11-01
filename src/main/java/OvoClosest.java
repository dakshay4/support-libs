/**
 * Created by dakshay on 22/10/2021.
 */
public class OvoClosest {
    public static void main(String[] args) {
        int ar[] =new int[]{0,2,5,6,7};
        int T=9;
        int length = ar.length;
        int low=0, high=length-1;
        int minVal = Integer.MAX_VALUE; int l=-1,r=-1;
        while(low<high){
            int temp = Math.abs(T-(ar[high]+ar[low]));
            if(temp<minVal) {
                l=low;r=high;
                minVal = temp;

            }
            if((ar[high]+ar[low])>T) high--;
            else  low++;
        }
        System.out.println("l: "+ l + "r: "+r);
    }
}
