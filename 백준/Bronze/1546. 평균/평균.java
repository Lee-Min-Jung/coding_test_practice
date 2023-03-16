// 모든 점수 중 최댓값을 구한다
// 모든 점수를 돌면서 주어진 공식에 대입한다
    // 위에서 나온 값을 sum에 더한다
// sum과 모든 점수 개수를 이용해 평균을 구한다
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] grades = new int[count];
        int sum = 0;
        
        for(int i = 0; i<grades.length; i++){
            grades[i] = sc.nextInt();
        }
        int max = grades[0];
        for(int i = 0; i<grades.length; i++){
            if(grades[i] > max){
                max = grades[i];
            }
            sum += grades[i];
        }
        System.out.print(sum*100.0/max/count);
        
    }
}