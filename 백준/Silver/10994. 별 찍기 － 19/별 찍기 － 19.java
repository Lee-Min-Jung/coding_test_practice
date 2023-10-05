import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N;
    static char[][] star;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        N = 4 * N - 3;
        star = new char[N][N];

        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                star[i][j] = ' ';
            }
        }
        makeStar(0, N);
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }
    public static void makeStar(int start, int len){
        if(len <= start){
            return;
        }
        for(int i = start; i<len; i++){
            star[start][i] = '*';
            star[len-1][i] = '*';
            star[i][start] = '*';
            star[i][len-1] = '*';
        }
        makeStar(start+2, len-2);
    }
}