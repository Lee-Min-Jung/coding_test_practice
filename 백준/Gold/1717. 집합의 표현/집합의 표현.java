
import javax.swing.text.BadLocationException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];

        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(question == 0){
                union(a, b);
            }else{
                if(checkSame(a, b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
    public static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b){
            return true;
        }else{
            return false;
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }


}



