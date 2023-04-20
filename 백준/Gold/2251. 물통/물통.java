
import javax.swing.text.BadLocationException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited = new boolean[201][201];
    static int[] now = new int[3];
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        Collections.sort(answer);

        for(int n : answer){
            System.out.print(n + " ");
        }


    }

    public static void bfs() {
        Queue<Bottle> q = new LinkedList<>();
        q.offer(new Bottle(0, 0, now[2]));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Bottle bottle = q.poll();
            int A = bottle.A;
            int B = bottle.B;
            int C = bottle.C;

            if (A == 0) {
                answer.add(C);
            }

            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;
                if (next[to[i]] >= now[to[i]]) {
                    next[from[i]] = next[to[i]] - now[to[i]];
                    next[to[i]] = now[to[i]];
                }
                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.offer(new Bottle(next[0], next[1], next[2]));
                }
            }
        }
    }

    static class Bottle {
        int A;
        int B;
        int C;

        public Bottle(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}



