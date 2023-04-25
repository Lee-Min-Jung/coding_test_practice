
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// 같은 파티에 참석했던 사람들을 한 집합으로 합친다
    // 이때 A 파티에서 1과 2가 합쳐지고, B 파티에서 2와 3합쳐지면 결국 123이 합쳐진거다.
    // 이는 결국 진실을 아는 사람과 한 번이라도 같은 파티에 참석한 사람은 진실을 알게 되니, 진실을 아는 사람이라고 인식해야 하기 때문에 필요하다
// 파티 참여자에게 find를 적용하고, 진실을 알고 있는 사람에게 find를 적용해서 둘이 같은 집합이라면 거짓을 말 할 수 없다

public class Main {
    static int[] trueP;
    static ArrayList<Integer>[] party;
    static int[] parent;
    static int result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        trueP = new int[T];
        party = new ArrayList[M];


        for(int i = 0; i<T; i++){
            trueP[i] = sc.nextInt();
        }

        for(int i = 0; i<M; i++){
            party[i] = new ArrayList<Integer>();
            int party_size = sc.nextInt();
            for(int j = 0; j<party_size; j++){
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        for(int i = 0; i<M; i++){
            int firstPeople = party[i].get(0);
            for(int j = 1; j<party[i].size(); j++){
                union(firstPeople, party[i].get(j));
            }
        }

        for(int i = 0; i<M; i++){
            int cur = party[i].get(0);
            boolean isPossiple = true;
            for(int j = 0; j< trueP.length; j++){
                if(find(cur) == find(trueP[j])){
                    isPossiple = false;
                    break;
                }
            }
            if(isPossiple){
                result++;
            }
        }

        System.out.println(result);




    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }




}



