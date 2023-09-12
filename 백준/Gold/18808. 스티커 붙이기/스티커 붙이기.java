import java.util.*;
import java.io.*;
public class Main {
    static int N, M, K;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        // 스티커 개수만큼 돌기
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[r][c];
            // 스티커 하나 저장
            for(int j = 0; j<r; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<c; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());   
                }
            }
            // 저장한 스티커의 붙일 수 있는 위치 확인
            findLocation(sticker);
            
            
        }
        // 정답 출력
        System.out.println(answer);
    }
    
    public static void findLocation(int[][] sticker){
        for(int i = 0; i<4; i++){
            if(i != 0){
                sticker = rotate(sticker);
            }
            // 노트북 맨 왼쪽 위부터 확인하며 붙일 수 있는지 보기
            int r = sticker.length;
            int c = sticker[0].length;
            for(int j = 0; j<N; j++){
                for(int k = 0; k<M; k++){
                    if(j+r > N || k+c > M){
                        break;
                    }
                    if(putOn(sticker, j, k)){
                        return;
                    }
                }
            }
        }
    }
    
    // 들어온 sticker를 90도씩 회전시킴
    public static int[][] rotate(int[][] sticker){
        int[][] newSticker = new int[sticker[0].length][sticker.length];
        for(int i = 0; i<newSticker.length; i++){
            for(int j = 0; j<newSticker[0].length; j++){
                newSticker[i][j] = sticker[sticker.length-j-1][i];
            }
        }
        return newSticker;
    }
    
    // 들어온 스티커를 현재 노트북에 붙일 수 있는지 확인
    public static boolean putOn(int[][] sticker, int startR, int startC){
        // 스티커 붙일 위치에 다른 스티커 붙여있는지 확인
        for(int i = startR; i<startR+sticker.length; i++){
            for(int j = startC; j<startC+sticker[0].length; j++){
                if(map[i][j] == 1 && sticker[i-startR][j-startC] == 1){
                    return false;
                }
            }
        }
        
        // 붙이기
        for(int i = startR; i<startR+sticker.length; i++){
            for(int j = startC; j<startC+sticker[0].length; j++){
                if(sticker[i-startR][j-startC] == 1){
                    map[i][j] = 1;
                    answer++;
                }
            }
        }
        return true;
        
    }



}