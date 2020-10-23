package Searching;

// Given a sorted array and a number, find the element closest to the given number.
public class Closest_Number {
    public static int find(int[]arr, int ele){
        // Since the array is sorted, -> Binary Search
        int low = 0, high = arr.length-1, mid ,minDist = 9999,output = -1;
        while(low <= high){
            mid = (low + high)/2;
            if (minDist > Math.abs(arr[mid] - ele)){
                minDist = Math.abs(arr[mid] - ele);
                output = arr[mid];
            }
            if (arr[mid] > ele)
                high = mid-1;
            else if(arr[mid] < ele)
                low = mid+1;
            else if(arr[mid] == ele)
                break;
        }
        return output;
    }
    public static void main(String[] args) {
        int[]arr = {1,34,44,55,67,89,90};
        System.out.println(find(arr, 50));
    }
}
