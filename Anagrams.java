package Sorting;

import java.util.*;


// Sorting array of Strings with the respective Anagrams
public class Anagrams {
    public static String anagrams(String[] arr){
    ArrayList<String> arr2 = new ArrayList<>(arr.length);
    HashMap<String,String> hashMap = new HashMap<>();
    for (String str : arr){
            if (hashMap.containsKey(sort(str))){
                hashMap.put(sort(str), str);
            }else {
                hashMap.put(sort(str), str);
            }
    }
    Iterator iterator = hashMap.entrySet().iterator();
    while (iterator.hasNext()){
        Map.Entry mapElement = (Map.Entry)iterator.next();
        for (String str : arr){
            if (sort(str).equals(mapElement.getKey())){
                arr2.add(str);
            }
        }
    }
        return String.valueOf(arr2);
    }
    public static String sort(String arr){
        char[] ch = arr.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
        String[]arr = new String[]{"abcd", "abhiraj", "dcba", "kale", "rajabhi", "new", "ekal"};
        System.out.println(anagrams(arr));
    }
}
