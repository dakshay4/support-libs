/**
 * Created by dakshay on 22/10/2021.
 */
public class Ovo {
    public static void main(String[] args) {
        int ar[] = new int[]{25,6, 7, 30, 40, 50};

        int length = ar.length;
        int pivotA=-1, pivotB=-1;
        for(int i=0;i<length-1;i++){
            if(ar[i]>ar[i+1]){ pivotA=i;break;}
        }
        for(int i=length-1;i>0;i--){
            if(ar[i]<ar[i-1]){ pivotB=i;break;}
        }
        System.out.println("pivotA: "+ pivotA + "pivotB: " + pivotB);

        if(pivotA!=-1 && pivotB!=-1) {
            int mn = Integer.MAX_VALUE; int mx = Integer.MIN_VALUE;
            for(int i=pivotA;i<=pivotB;i++) {
                mn = Math.min(mn,ar[i]);
                mx = Math.max(mx,ar[i]);
            }
            System.out.println("### mn: "+ mn + "mx: " + mx);

            for(int i=0;i<=pivotA;i++){
//                System.out.println("i: "+i);
                if(ar[i]>mn) {pivotA=i;break;}
            }
            for(int i=pivotB;i<length;i++){
                if(ar[i]>mn) {pivotB=i-1;break;}
            }

//            boolean flagA=true, flagB=false;
//            while(flagA){
//                if(ar[pivotA]>mn && pivotA>0) {pivotA--;}
//                else {flagA=false;}
//            }
//            while(flagB){
//                if(ar[pivotB]<mx && pivotB<(length-1)) {pivotB++;}
//                else {flagB=false;}
//            }
        }
        System.out.println("pivotA: "+ pivotA + "pivotB: " + pivotB);
    }
}
