package Problem_statements;

import java.util.ArrayDeque;
import java.util.Queue;

class Node{
    int row, col, dist;
    Node(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class Lee_Problem {
    public static void main(String[] args) {
        int[][]maze =  {
                { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 0, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 0, 1, 0, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        Lee(maze, 0, 0, 9, 9);
    }
    private static final int[]row = {0, 1, -1, 0};
    private static final int[]col = {1, 0, 0, -1};

    private static final int MAX = 10;
    private static int min_dist = Integer.MAX_VALUE;

    public static boolean isValid(int[][]maze, int row, int col , boolean[][]visited){
        return row<MAX&&col<MAX&&row>=0&&col>=0&&!visited[row][col]&&maze[row][col]==1;
    }

    public static void Lee(int[][]maze, int i, int j, int x, int y){
        boolean[][]visited = new boolean[MAX][MAX];

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, j , 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            i = node.row;
            j = node.col;
            int dist = node.dist;

            if(i==x && j==y){
                min_dist = dist;
                break;
            }
                for (int k=0; k<4; k++)
                    if (isValid(maze, i + row[k], j + col[k], visited)) {
                        visited[i + row[k]][j + col[k]] = true;
                        queue.add(new Node(i + row[k], j + col[k], dist + 1));
                    }
        }
        if (min_dist!=Integer.MAX_VALUE)
            System.out.println("The minimum distance from ["+i+"]["+j+"] to ["+x+"]["+y+"] is : " + min_dist);
        else
            System.out.println("Couldn't find the path from source to destination.");
    }

}
