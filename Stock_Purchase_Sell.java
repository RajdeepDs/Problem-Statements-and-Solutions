package Searching;

public class Stock_Purchase_Sell {
    public static void check(int[]arr){
        int buyDay = 0, sellDay = 0;
        int low  = 999999999,high = 0;
        for (int i=0; i<arr.length; i++){
            if (arr[i] < low){
                low = arr[i];
                buyDay = i;
            }
            if (arr[i] > high) {
                high = arr[i];
                sellDay = i;
            }
        }
        System.out.println("Highest Buy Day : " + buyDay + " Stock :" + low);
        System.out.println("Highest Sell Day : " + sellDay + " Stock :" + high);
    }
    public static void main(String[] args) {
        int[]arr = {12, 34, 22, 56, 63, 23, 93, 29, 18, 91, 37};
        check(arr);
    }
}
