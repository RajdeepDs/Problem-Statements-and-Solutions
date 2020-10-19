package Problem_statements.CircularTour;

import java.util.ArrayDeque;

/*
There are N number of petrol pumps in a circular path.Each petrol pump have some limited amount of petrol.
You are given the amount of petrol each petrol pump has and the distance from next petrol pump.
Find if there is a circular tour possible to visit all the petrol pumps.
 */
public class CircularTour {
    public static int circularTour(int[][]arr, int n){
        ArrayDeque<Integer>queue = new ArrayDeque<>();
        int nextPump = 0, prevPump, count = 0, petrol =0;
        while(queue.size() != n){
            while (petrol >=0 && queue.size() != n){
                queue.add(nextPump);
                petrol += (arr[nextPump][0] - arr[nextPump][1]);
                nextPump = (nextPump + 1) % n;
            }
            while(petrol < 0 && queue.size() > 0){
                prevPump = queue.remove();
                petrol -= (arr[prevPump][0]- arr[prevPump] [1]);
            }
            count+=1;
            if (count == n){
                return -1;
            }
            if (petrol >= 0){
                return queue.pop();
            }else
                return -1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][]arr = {{8,6} , {1,4}, {7,6}};
        System.out.println("Circular Tour : " + circularTour(arr, 3));
    }
}
