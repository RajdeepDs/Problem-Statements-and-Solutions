package Problem_statements;

import Queue.Queue;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestPath {
    int[][]graph;
    public ShortestPath(int len){
        graph = new int[len][len];
    }
    public static void main(String[] args) {
        ShortestPath shortestPath = new ShortestPath(5);
        shortestPath.graph = new int[][]{{0, 3, 5, 99, 99}, {3, 0, 1, 1, 99}, {5, 1, 0, 2, 99}, {99, 2, 2, 0, 5}, {99, 99, 99, 5, 0}};
        shortestPath(shortestPath, 1);
    }
    public static void shortestPath(ShortestPath arr, int src){
        int[]distance = new int[arr.graph[src].length];
        Arrays.fill(distance, 99);
        distance[src] = 0;
        ArrayList<Integer> visited = new ArrayList<>();
        ArrayList<Integer> unvisited = new ArrayList<>();
        unvisited.add(src);
        while(unvisited.size() > 0){
            int min = minimumDist(unvisited);
            unvisited.remove((Integer) min);
            visited.add(min);
            Queue queue = new Queue();
            for(int i=0; i<arr.graph.length; i++){
                int m = minNode(arr.graph[min]);
                //System.out.println(m);

                if(!visited.contains(m))
                    queue.add(unvisited.get(m));
                queue.print();
                System.out.println();
            }

            System.out.println(queue.isEmpty());
            while(!queue.isEmpty()){
                int ele = queue.remove();
                System.out.println("distance[min] :" + distance[min]);
                System.out.println("arr.graph[min][ele] :"+arr.graph[min][ele]);
                System.out.println("distance[ele] :" + distance[ele]);
                if(distance[min] + arr.graph[min][ele] < distance[ele]){
                    distance[ele] = distance[min] + arr.graph[min][ele];
                    unvisited.add(ele);
                    System.out.println(unvisited);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }
    private static int minimumDist(ArrayList<Integer>unvisited){
        Integer[] arr = unvisited.toArray(new Integer[unvisited.size()]);
        int min = 99, pos = -1;
        for (int i=0; i<arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
                pos = i;
            }
        }
        return pos;
    }
    private static int minNode(int[]arr){
       // System.out.println(Arrays.toString(arr));
        int min = 99, pos = -1;
        for (int i=0; i<arr.length; i++){
            if(min >= arr[i]){
                min = arr[i];
                pos = i;
            }
        }
        return pos;
    }
}
