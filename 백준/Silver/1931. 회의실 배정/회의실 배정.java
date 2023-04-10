
import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] times = new int[N][2];
        int answer = 0;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times, new Comparator<int[]>(){
            @Override
            public int compare(int[] S, int[] E){
                if(S[1] == E[1]){
                    return S[0] - E[0];
                }
                return S[1]-E[1];
            }
        });
        int end = -1;
        for(int i = 0; i<N; i++){
            if(times[i][0] >= end){
                end = times[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }


}

