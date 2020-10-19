package Problem_statements.Josephus_Problem;
/* Problem Statement

Josephus problem
There are n people standing in a queue waiting to be executed. The counting begins at the front of
the queue. In each step, k number of people are removed and again add one by one from the
queue. Then the next person is executed. The execution proceeds around the circle until only the
last person remains, who is given freedom.
Find that position where you want to stand and gain your freedom.
* */
public class Josephus_Problem {
    public static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else {
            return (josephus(n - 1, k )+k+1) % n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println("The chosen place is " + josephus(n, k));
    }
}