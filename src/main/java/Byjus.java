/**
 * Created by dakshay on 13/10/2021.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Given an array arr[] consisting of N integers, find the length of the smallest subarray with a sum equal to K.

//        In linear time complexity
//
//        Input: arr[] = {2, 4, 6, 10, 2, 1}, K = 12  Output: 2
//      All possible subarrays with sum 12 are {2, 4, 6} and {10, 2}.
//        Input: arr[] = { 1, 2, 4, 3, 2, 4, 1 }, K = 7  Output: 2
//
//
//5,2,6,5,2,2,3,4,5,3  k = 7
//
//
//7-1 = 6     7-3 =4
//
//1, 3, 7, 10, 12, 16, 17
//
//
//
//1+2+4 = 7
//
//1,3,7,9,13,14
//-6, -4, 0, 2, 6, 7
//
//2,4,6,10,10,10 k 20
//2,6,12,22,32,42
//-18, -14, -8, 2, 12, 22

public class Byjus {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};int k=7;
        int low = 0;
        int high = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        while(high < n) {
            sum += nums[high++];
            while (sum >= k && low < n) {
                min = Math.min(min, (high - low + 1));
                sum -= nums[low++];
            }
        }
        System.out.println("Dakshay Low::" + min);
        int[] arr = {10, 20, 20, 20, 30, 30, 40};
        firstLastAppearance(arr, 20);
    }

    public static void firstLastAppearance(int[] nums, int element) {
        System.out.println("First" + binSearchModified(nums,element,0,nums.length-1));
    }

    public static int binSearchModified(int[] nums, int element, int low, int high) {
        int size = nums.length;
        int first=-1;int second=-1;
        if(low<high) {
            int mid = (low+high)/2;
            if(nums[mid]<element) {
                return binSearchModified(nums,element,mid+1,high);
            } else if(nums[mid]>element){
                return binSearchModified(nums,element,low,mid-1);
            } else if(nums[mid]==element){
               return binSearchModified(nums,element,low,mid-1);
            }
        }
        return low;
    }


}
//    Find the first and last appearance of a element in a sorted array
//        In log(n) time complexity
//
//        Input: [10 20 20 20 30 30 40]
//        Element: 20 if element = 30
//
//
//        O/p=1,4
//low = 0,high = 7, mid = 3
//        we need to move two directions , low = 0, high =3, (mid1=1) and low = 4, high=7(mid2=5)
//        if(a[mid1]<element) low=1, high=3 (mid1=2);
//        else
//low = 3, high 7
//mid = 5
//leftDirection(low,high);
