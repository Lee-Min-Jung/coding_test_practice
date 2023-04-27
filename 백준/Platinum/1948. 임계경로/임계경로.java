

import java.io.*;
import java.util.*;

// 주어진 정보를 보고 연결리스트를 만든다
    // 임계 경로 값과 진입 차수 배열도 함께 만든다
// 1분도 쉬지 않고 달려야 하는 경로의 수는 특정 경로로 가는 시간이 최대 시간과 같은 것을 의미한다
// 그래서 1분도 쉬지 않고 달려야 하는 사람들이 지나는 도로의 수는 위에서 구한 경로의 노드의 수라고 할 수 있다
// 이걸 구하기 위해서는 도착 도시에서 역방향으로 위상 정렬을 수행한다
    // A 노드까지 오는데 걸리는 최대 시간 = B(A 바로 전) 노드까지 오는데 걸리는 최대 시간 + B에서 A까지 오는데 걸리는 시간일 경우 1분도 쉬지 않고 달려야 하는 도로에 해당한다

public class Main {
    static int N;
    static int M;
    static ArrayList<ArrayList<Node>> arr;
    static ArrayList<ArrayList<Node>> reverseArr;
    static int[] inDegree;
    static int[] routeValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        reverseArr = new ArrayList<>();
        inDegree = new int[N+1];
        routeValue = new int[N+1];

        // 연결리스트 초기화
        for(int i = 0; i<=N; i++){
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }

        // 연결리스트 생성, 진입차수 생성
        for(int i = 1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, val));
            reverseArr.get(end).add(new Node(start, val));
            inDegree[end]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startDosi = Integer.parseInt(st.nextToken());
        int endDosi = Integer.parseInt(st.nextToken());

        // 위상 정렬 실행
        topoSort(startDosi);
        
        // 역 위상 정렬 실행
        reverseTopoSort(endDosi);



    }

    public static void topoSort(int startDosi){
        Queue<Integer> q = new LinkedList<>();
        q.offer(startDosi);
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node next : arr.get(now)){
                inDegree[next.nodeIndex]--;
                routeValue[next.nodeIndex] = Math.max(routeValue[next.nodeIndex], routeValue[now]+next.value);
                if(inDegree[next.nodeIndex] == 0){
                    q.offer(next.nodeIndex);
                }
            }
        }

    }

    public static void reverseTopoSort(int endDosi){
        int resultCount = 0;
        boolean visited[] =  new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(endDosi);
        visited[endDosi] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(Node next : reverseArr.get(now)){
                if(routeValue[now] == routeValue[next.nodeIndex] + next.value){
                    resultCount++;
                    if(visited[next.nodeIndex] == false){
                        visited[next.nodeIndex] = true;
                        q.offer(next.nodeIndex);
                    }
                }
            }
        }
        System.out.println(routeValue[endDosi]);
        System.out.println(resultCount);
    }



}

class Node{
    int nodeIndex;
    int value;

    Node(int nodeIndex, int value){
        this.nodeIndex = nodeIndex;
        this.value = value;
    }
}




