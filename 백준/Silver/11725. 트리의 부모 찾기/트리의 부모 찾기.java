import java.io.*;
import java.util.*;

// 입력 받은 정보를 바탕으로 인접리스트를 만든다
// 인접리스트 루트에서 DFS를 시작한다.
    // 루트와 인접해있는 것의 부모는 루트로 결정된다
    // 루트 다음 거를 살펴볼 때, 루트는 이미 방문했으니 인접해있는 것 중 루트가 아닌 것을 방문하고 그때 그거의 부모가 루트 다음 거로 결정된다
    // 이렇게 위에서 본인의 부모는 다 결정이 되기 때문에 특정 노드의 인접리스트 중 아직 방문 안 한 것의 부모는 특정 노드가 될 수밖에 없다


public class Main {
    static int N;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 설정 및 변수 초기화
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        answer = new int[N+1];

        // 인접 리스트 생성
        adjList = new ArrayList[N+1];
        for(int i = 1; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjList[s].add(e);
            adjList[e].add(s);
        }

        // DFS 실행
        DFS(1);

        // 정답 출력
        for(int i = 2; i<=N; i++){
            System.out.println(answer[i]);
        }


    }

    public static void DFS(int num){
        visited[num] = true;
        for(int i : adjList[num]){
            if(!visited[i]){
                answer[i] = num;
                DFS(i);
            }
        }
    }






}

