import java.util.*;
import java.io.*;

public class Main{
    static int[] rightCountArr;
    static int[] myCountArr;
    static int checkSecret;
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int totalLen = Integer.parseInt(st.nextToken());
        int partLen = Integer.parseInt(st.nextToken());
        int answer = 0;
        char dnaChar[] = new char[totalLen];
        rightCountArr = new int[4];
        myCountArr = new int[4];
        dnaChar = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i<4; i++){
            rightCountArr[i] = Integer.parseInt(st.nextToken());
            if(rightCountArr[i] == 0){
                checkSecret++;
            }
        }
        for(int i = 0; i<partLen; i++){
            add(dnaChar[i]);
        }
        if(checkSecret == 4){
            answer++;
        }
        for(int i = partLen; i<totalLen; i++){
            add(dnaChar[i]);
            remove(dnaChar[i-partLen]);
            if(checkSecret == 4){
                answer++;
            }
        }
        System.out.println(answer);
 
    }
    
    private static void add(char c){
        switch(c){
            case 'A':
                myCountArr[0]++;
                if(myCountArr[0] == rightCountArr[0]){
                    checkSecret++;
                }
                break;
           case 'C':
                myCountArr[1]++;
                if(myCountArr[1] == rightCountArr[1]){
                    checkSecret++;
                }
                break;
           case 'G':
                myCountArr[2]++;
                if(myCountArr[2] == rightCountArr[2]){
                    checkSecret++;
                }
                break;
           case 'T':
                myCountArr[3]++;
                if(myCountArr[3] == rightCountArr[3]){
                    checkSecret++;
                }
                break;     
        }
    }
    
    private static void remove(char c){
        switch(c){
            case 'A':
                if(myCountArr[0] == rightCountArr[0]){
                    checkSecret--;
                }
                myCountArr[0]--;
                break;
            case 'C':
                if(myCountArr[1] == rightCountArr[1]){
                    checkSecret--;
                }
                myCountArr[1]--;
                break;
            case 'G':
                if(myCountArr[2] == rightCountArr[2]){
                    checkSecret--;
                }
                myCountArr[2]--;
                break;
            case 'T':
                if(myCountArr[3] == rightCountArr[3]){
                    checkSecret--;
                }
                myCountArr[3]--;
                break;
        }
    }
}