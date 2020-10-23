package Problem_statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
    public static void main(String[] args) {
        int[][]graph = new int[][]{{0, 3, 5, 99, 99}, {3, 0, 1, 1, 99}, {5, 1, 0, 2, 99}, {99, 2, 2, 0, 5}, {99, 99, 99, 5, 0}};
        dijkstra(graph, 0);
    }
    public static void dijkstra(int[][]graph, int src){
        ArrayList<Integer>visited = new ArrayList<>();
        ArrayList<Integer>unvisited = new ArrayList<>();
        HashMap<Integer, Integer> distance = new HashMap<>();
        for(int i=0; i<graph[src].length; i++){
            distance.put(i, 99);
        }
        distance.put(src, 0);
        System.out.println(Arrays.deepToString(graph));
        unvisited.add(src);
        do{ // while unvisited length > 0
            int m = minNode(graph[src], visited);
            //System.out.println(m);
            if (m==-1) break;
            System.out.println("Min Node is : " + m);
            // Find its neighbouring Nodes
            for(int i=0; i<graph[m].length; i++){
                int min = minNode(graph[m], visited);
                System.out.println("Graph of m is : " + Arrays.toString(graph[m]));
                if (min==-1) break;
                System.out.println("The neighbouring node of m is : " + min);
                System.out.println("DIST ARE : " + distance);
                int dist = distance.get(m)+ graph[m][min];
                if( dist < distance.get(min)){
                    distance.put(min, dist);
                    unvisited.add(min);
                }
                visited.add(m);
            }
        } while(unvisited.size() > 0);
        System.out.println(visited);
        System.out.println(unvisited);
        System.out.println(distance);
    }
    private static int minNode(int[]arr,ArrayList<Integer>visited){
        // System.out.println(Arrays.toString(arr));
        int min = 100, pos = -1;
        for (int i=0; i<arr.length; i++){
            if(min >= arr[i] && !visited.contains(i) && arr[i]!=0){
                min = arr[i];
                pos = i;
            }
        }
      //  System.out.println(visited);
        return pos;
    }
}
