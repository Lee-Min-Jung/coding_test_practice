
import java.io.*;
import java.util.*;

// 주어진 정보를 이용해서 연결리스트를 만든다
    // 이때 진입차수 배열도 만든다
// 진입 차수 배열을 돌면서 위상 정렬을 진행한다

public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static int[] inDegree;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        inDegree = new int[N+1];
        arr = new ArrayList<>();
        for(int i = 0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 1; i<=M; i++){
            int front = sc.nextInt();
            int back = sc.nextInt();
            arr.get(front).add(back);
            inDegree[back]++;
        }

        topoSort();


    }

    public static void topoSort(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now + " ");
            for(int next : arr.get(now)){
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}



