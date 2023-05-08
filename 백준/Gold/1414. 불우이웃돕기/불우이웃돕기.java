import java.io.*;
import java.util.*;
public class Main {
    static int N, sum, useEdge, result;
    static PriorityQueue<Edge> queue;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 저장 및 변수 초기화
        N = Integer.parseInt(br.readLine());
        sum = 0;
        queue = new PriorityQueue<>();
        parent = new int[N];
        useEdge = 0;
        result = 0;

        // 알파벳 읽어서 에지리스트 생성하여 우선순위 큐에 저장장
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] tempc = st.nextToken().toCharArray();
            for(int j = 0; j<N; j++){
                int temp = 0;
                if(tempc[j] >= 'a' && tempc[j] <= 'z'){
                    temp = tempc[j] - 'a' + 1; // tempc[j]와 소문자 a의 유니코드 값의 차이에 1을 더해 각 소문자를 1~26까지 매핑
                }else if(tempc[j] >= 'A' && tempc[j] <= 'Z'){
                    temp = tempc[j] - 'A' + 27;
                }
                sum += temp;
                if(i != j && temp != 0){
                    queue.add(new Edge(i, j, temp));
                }
            }
        }

        // parent 초기화
        for(int i = 0; i<N; i++){
            parent[i] = i;
        }

        // 최소신장트리 수행
        mst();

        // 결과 출력
        if(useEdge == N - 1){
            System.out.println(sum - result);
        }else{
            System.out.println(-1);
        }




    }

    public static void mst(){
        while(!queue.isEmpty()){
            Edge now = queue.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
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
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }



}

class Edge implements Comparable<Edge>{
    int s, e, v;
    Edge(int s, int e, int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(Edge o){
        return this.v - o.v;
    }
}
