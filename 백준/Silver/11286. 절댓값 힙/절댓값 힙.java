import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if(firstAbs == secondAbs){
                return o1 > o2 ? 1 : -1;
            }else{
                return firstAbs - secondAbs;
            }
        });

        for(int i = 0; i<N; i++){
            int request = Integer.parseInt(br.readLine());
            if(request == 0){
                if(myQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(myQueue.poll());
                }
            }else{
                myQueue.add(request);
            }
        }
    }
}