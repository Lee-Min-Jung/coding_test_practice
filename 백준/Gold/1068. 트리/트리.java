import java.io.*;
import java.util.*;

// 입력받은 정보를 바탕으로 인접 리스트를 만들기
    // -1이면 루트로 저장
    // -1 아니면 해당 인덱스와 입력받은 거 이용해서 에지리스트로 저장
// DFS나 BFS를 하면서 삭제할 노드를 탐색 시작하기 전까지만 탐색
    // 탐색하면서 탐색하고 있는 노드의 인접리스트를 보는데 부모만 있다면(이미 탐색 다 한 것) 리프노드로 간주하고 카운트 증가


public class Main {
    static int N, root, delNode;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 개수 저장 및 변수 초기화
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        // 인접리스트
        adjList = new ArrayList[N];
        for(int i = 0; i<N; i++){
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num != -1){
                adjList[i].add(num);
                adjList[num].add(i);
            }else{
                root = i;
            }
        }

        // 삭제할 노드 저장
        delNode = Integer.parseInt(br.readLine());

        //
        if(delNode == root){
            System.out.println(0);
        }else{
            DFS(root);
            System.out.println(answer);
        }


    }


    public static void DFS(int num){
        visited[num] = true;
        int child = 0;
        for(int n : adjList[num]){
            if(!visited[n] && n != delNode){
                child++;
                DFS(n);
            }
        }
        if(child == 0){
            answer++;
        }
    }





}

