
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

// 주어진 정보로 연결 그래프를 만든다
    // 진입차수 배열도 함께 만든다
// 위상 정렬을 수행한다


public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> arr;
    static int[] inDegree;
    static int[] selfTime;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        inDegree = new int[N+1];
        selfTime = new int[N+1];
        result = new int[N+1];

        for(int i = 0; i<=N; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            selfTime[i] = Integer.parseInt(st.nextToken());
            while(true){
                int pre = Integer.parseInt(st.nextToken());
                if(pre == -1){
                    break;
                }
                arr.get(pre).add(i);
                inDegree[i]++;
            }
        }

        topoSort();

        for(int i = 1; i<=N; i++){
            System.out.println(result[i] + selfTime[i]);
        }


    }

    public static void topoSort(){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : arr.get(now)){
                inDegree[next]--;
                result[next] = Math.max(result[next], result[now]+selfTime[now]);
                if(inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }


}




