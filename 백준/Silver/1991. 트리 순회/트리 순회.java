import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 개수
        N = Integer.parseInt(br.readLine());

        // 트리
        tree = new int[26][2];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.'){
                tree[node][0] = -1;
            }else{
                tree[node][0] = left - 'A';
            }

            if(right == '.'){
                tree[node][1] = -1;
            }else{
                tree[node][1] = right - 'A';
            }
        }


        // 순회
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    public static void preOrder(int now){
        if(now == -1){
            return;
        }
        System.out.print((char)(now+'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }

    public static void inOrder(int now){
        if(now == -1){
            return;
        }
        inOrder(tree[now][0]);
        System.out.print((char)(now+'A'));
        inOrder(tree[now][1]);
    }
    
    public static void postOrder(int now){
        if(now == -1){
            return;
        }
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.print((char)(now+'A'));
    }
}



