import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNums = sc.next();
        int answer = 0;
        
        for(String sNum : sNums.split("")){
            answer += Integer.parseInt(sNum);    
        }
        
        System.out.print(answer);
    }
}