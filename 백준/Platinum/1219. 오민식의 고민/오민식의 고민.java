

import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

// 에지리스트를 만들고 벨만 포드 알고리즘을 진행한다
    // 하지만 출발 노드부터 도착 노드까지 최단 거리가 아니라 최대 비용을 구해야 한다
    // 즉, 최대 비용 배열을 만든다
        // 출발 노드는 0이고, 이외의 노드는 적당히 작은 값으로 설정한다
    // 돈을 무한히 벌 수 있는 경우는 양의 사이클을 의미한다. 따라서, 양의 사이클이 아닌지를 확인해야 한다.
    // 에지 리스트를 순회하면서
        //[출발 노드로부터 해당 에지의 출발 노드까지의 값과 해당 에지의 도착 노드에서 벌 수 있는 값의 합에서 해당 에지의 가중치를 뺀 값]이 [출발 노드로부터 해당 에지의 도착 노드까지의 값]보다 크면 업데이트
        // 해당 에지의 출발 노드를 아직 방문하지 않아 값이 적당히 작은 값이라면 할 것이 없으니 패스
        // 해당 에지의 출발 노드가 양수 사이클에 연결된 노드라면 값을 MAX로 업데이트
    // 위의 순회를 충분히 큰 수 만큼 순회한다.
    // 순회를 할 때, 노드 개수 - 1 번의 반복 이후 업데이트 되는 경우는 사이클을 가진 경우다. 따라서 해당 에지의 종료 노드를 양의 사이클 연결 노드로 변경한다
// 비용 배열이 min이면 연결이 안 되어 있다는 것이니 gg
// 비용 배열이 MAX라는 것은 양의 사이클이라는 것이니 Gee
// 그 이외의 경우는 값을 가진 경우니 그 값을 리턴

public class Main {
    static int N, M, sCity, eCity;
    static Edge edges[];
    static long[] cost;
    static long[] cityMoney;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값 설정
        N = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 에지 리스트 생성
        edges = new Edge[M];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, v);
        }

        // 최대 비용 배열 생성
        cost = new long[N];
        for(int i = 0; i<N; i++){
            cost[i] = Long.MIN_VALUE;
        }

        // 벌 수 있는 값 배열 생성
        cityMoney = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        // 벨만 포드 수행 전 설정
        cost[sCity] = cityMoney[sCity];

        // 벨만 포드 수행
        bellFord();

        // 양의 순환 확인
//        for(int i = 0; i<M; i++){
//            Edge edge = edges[i];
//            if((cost[edge.start] + cityMoney[edge.end] - edge.price) > cost[edge.end]){
//                cost[edge.end] = Long.MAX_VALUE;
//            }
//        }



        // 최대 비용 배열 보며 출력
        if(cost[eCity] == Long.MIN_VALUE){
            System.out.println("gg");
        }else if(cost[eCity] == Long.MAX_VALUE){
            System.out.println("Gee");
        }else{
            System.out.println(cost[eCity]);
        }
    }

    public static void bellFord(){
        for(int i = 0; i<=N+100; i++){
            for(int j = 0; j<M; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;
                if(cost[start] == Long.MIN_VALUE){
                    continue;
                }else if(cost[start] == Long.MAX_VALUE){
                    cost[end] = Long.MAX_VALUE;
                }else if((cost[start] + cityMoney[end] - price) > cost[end]){
                    cost[end] = cost[start] + cityMoney[end] - price;
                    if(i >= N-1){
                        cost[end] = Long.MAX_VALUE;
                    }
                }
            }
        }
    }

}

class Edge{
    int start;
    int end;
    int price;

    public Edge(int start, int end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
}









