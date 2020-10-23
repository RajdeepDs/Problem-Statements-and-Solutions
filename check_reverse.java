package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class check_reverse {
    public static void main(String[] args) {
        Integer[] arr = {5,10,4,3,2,1};
        List<Integer> arr2 =  Arrays.asList(arr);
        List<Integer> arr3 = arr2;
        Collections.sort(arr2);
        Collections.reverse(arr3);
        System.out.println(arr2.equals(arr3));
    }
}
