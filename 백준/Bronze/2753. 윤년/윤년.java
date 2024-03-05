import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 변수
        int year = Integer.parseInt(st.nextToken());

        // 윤년구하기 : 4의 배수이면서, 100의 배수가 아닐때 또는 400의 배수일 때
        // 4의 배수인지 확인
        boolean isFour = false;
        if(year % 4 == 0) isFour = true;
        // 100의 배수인지 확인
        boolean isOnehundread = true;
        if(year % 100 != 0) isOnehundread = false;
        // 400의 배수인지 확인
        boolean isFourhundread = false;
        if(year % 400 == 0) isFourhundread = true;

        // 윤년 확인
        if(isFour && (!isOnehundread || isFourhundread)) System.out.println("1");
        else System.out.println("0");


    }



}



