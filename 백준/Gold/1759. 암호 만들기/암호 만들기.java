import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String[] arr;
    static String[] output;
    static String[] moem = {"a", "e", "i", "o", "u"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[C];
        output = new String[L];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<C; i++){
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        bt(0, 0);


    }

    public static void bt(int depth, int position){
        if(depth == L){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<output.length; i++){
                sb.append(output[i]);
            }
            int moemCount = 0;
            int jaemCount = 0;
            for(int i = 0; i<5; i++){
                if(sb.toString().contains(moem[i])){
                    moemCount++;
                }
            }
            jaemCount = sb.toString().length() - moemCount;
            if(moemCount >= 1 && jaemCount >= 2){
                System.out.println(sb);
            }

            return;
        }
        for(int i = position; i<C; i++){
            output[depth] = arr[i];
            bt(depth+1, i+1);
        }
    }

}