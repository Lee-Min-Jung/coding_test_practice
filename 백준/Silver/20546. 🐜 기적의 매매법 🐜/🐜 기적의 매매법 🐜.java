import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int money;
    static int[] priceChange = new int[14];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        money = Integer.parseInt(st.nextToken());

        // 주식 가격 변동 저장
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<priceChange.length; i++){
            priceChange[i] = Integer.parseInt(st.nextToken());
        }

        // 준현
        int jm = money;
        int js = 0;
        for(int i = 0; i<priceChange.length; i++){
            int cur = priceChange[i];
            if(jm >= cur){
                js += jm / cur;
                jm = jm % cur;
            }
        }

        // 성민
        int sm = money;
        int ss = 0;
        int increC = 0;
        int decreC = 0;
        for(int i = 1; i<priceChange.length; i++){
            int cur = priceChange[i];
            if(priceChange[i-1] < priceChange[i]){
                decreC = 0;
                increC++;
            }
            if(priceChange[i-1] > priceChange[i]){
                increC = 0;
                decreC++;
            }
            if(increC >= 3){
                if(ss > 0){
                    sm += cur * ss;
                    ss = 0;
                }
            }
            if(decreC >= 3){
                if(sm >= cur){
                    ss += sm / cur;
                    sm = sm % cur;
                }
            }
        }
     
        // 수익
        int jProfit = jm + js * priceChange[priceChange.length-1];
        int sProfit = sm + ss * priceChange[priceChange.length-1];

        if(jProfit > sProfit){
            System.out.println("BNP");
        }else if(jProfit < sProfit){
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }




    }


}