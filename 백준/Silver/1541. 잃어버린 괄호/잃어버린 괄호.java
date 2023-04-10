
import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] minus = br.readLine().split("-");
        int answer = 0;
        for(int i = 0; i<minus.length; i++){
            int temp = 0;
            String[] plus = minus[i].split("\\+");
            for(int j = 0; j<plus.length; j++){
                temp += Integer.parseInt(plus[j]);
            }
            if(i == 0){
                answer = temp;
            }else{
                answer -= temp;
            }

        }
        System.out.println(answer);
    }


}

