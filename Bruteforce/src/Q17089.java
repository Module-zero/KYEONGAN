import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q17089 {
    static boolean[][] relation;
    static int[] relCount;
    static int N;
    static int M;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        relation = new boolean[N+1][N+1];
        relCount = new int[N+1];
        for(int i = 0 ; i < M ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            relation[a][b] = true;
            relation[b][a] = true;
            relCount[a] ++;
            relCount[b] ++;
        }
        solve(0,0,new int[3]);
        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
    public static void solve(int idx, int select,int[] answer){
        if(select >= 3){
            int tmp = 0;
            for(int i = 0 ; i < 3 ; i ++){
                for(int j = 0 ; j < 3 ; j ++){
                    if(i == j)continue;
                    if(relation[answer[i]][answer[j]]){
                        tmp --;
                    }
                }
                tmp += relCount[answer[i]];
            }
            ans = Math.min(ans,tmp);
            return;
        }
        if(idx > N){
            return;
        }
        solve(idx+1, select,answer);
        boolean sure = true;
        for(int i = 0 ; i < select; i ++){
            if(!relation[answer[i]][idx]){
                sure = false;
            }
        }
        if(sure) {
            answer[select] = idx;
            solve(idx + 1, select + 1, answer);
        }
    }
}
