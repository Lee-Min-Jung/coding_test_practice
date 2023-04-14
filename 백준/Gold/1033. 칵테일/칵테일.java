
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] A;
    static boolean visited[];
    static long lcm;
    static long D[];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;
        for(int i = 0; i<N; i++){
            A[i] = new ArrayList<Node>();
        }
        for(int i = 0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new Node(b,p,q));
            A[b].add(new Node(a,q,p));
            lcm *= (p*q)/gcd(p,q);
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for(int i = 1; i<N; i++){
            mgcd = gcd(mgcd, D[i]);
        }
        for(int i = 0; i<N; i++){
            System.out.print(D[i]/mgcd + " ");
        }

    }
    public static long gcd(long a, long b){
        if(b==0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    public static void DFS(int nodeIndex){
        visited[nodeIndex] = true;
        for(Node node : A[nodeIndex]){
            int next = node.getB();
            if(!visited[next]){
                D[next] = D[nodeIndex] * node.getQ() / node.getP();
                DFS(next);
            }
        }
    }


}

class Node{
    int b;
    int p;
    int q;

    public Node(int b, int p, int q){
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }
    public int getB(){
        return b;
    }

    public int getP(){
        return p;
    }

    public int getQ(){
        return q;
    }
}

