
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positiveNums = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeNums = new PriorityQueue<>();
        int oneNums = 0;
        int zeroNums = 0;
        int answer = 0;
        for(int i = 0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 1){
                positiveNums.add(num);
            }else if(num == 1){
                oneNums++;
            }else if(num == 0){
                zeroNums++;
            }else{
                negativeNums.add(num);
            }
        }
        while(positiveNums.size() >= 2){
            int first = positiveNums.remove();
            int second = positiveNums.remove();
            answer += first*second;
        }
        if(!positiveNums.isEmpty()){
            answer += positiveNums.remove();
        }
        while(negativeNums.size() >= 2){
            int first = negativeNums.remove();
            int second = negativeNums.remove();
            answer += first*second;
        }
        if(!negativeNums.isEmpty() && zeroNums == 0){
            answer += negativeNums.remove();
        }
        answer += oneNums;
        System.out.println(answer);



    }


}

