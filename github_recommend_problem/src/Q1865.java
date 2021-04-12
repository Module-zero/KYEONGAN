import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q1865 {
    static int MAX = 10000000;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(bf.readLine());
        while(TC --> 0){
            String[] init = bf.readLine().split(" ");
            int N = Integer.parseInt(init[0]);
            int M = Integer.parseInt(init[1]);
            int W = Integer.parseInt(init[2]);
            int[][] list = new int[N+1][N+1];
            for(int i = 1 ; i <= N ; i ++){
                Arrays.fill(list[i],MAX);
                list[i][i] = 0;
            }
            for(int i = 0 ; i < M ; i ++){
                String[] tmp = bf.readLine().split(" ");
                int S = Integer.parseInt(tmp[0]);
                int E = Integer.parseInt(tmp[1]);
                int T = Integer.parseInt(tmp[2]);
                if( list[S][E] > T) {
                    list[S][E] = T;
                }
                if(list[E][S] > T){
                    list[E][S] = T;
                }
            }
            for(int i = 0 ; i < W ; i ++){
                String[] tmp = bf.readLine().split(" ");
                int S = Integer.parseInt(tmp[0]);
                int E = Integer.parseInt(tmp[1]);
                int T = Integer.parseInt(tmp[2]);
                if(list[S][E] > -T) {
                    list[S][E] = -T;
                }
            }

            for(int k = 1 ; k <= N ; k ++){
                for(int i = 1; i <= N ; i ++){
                    for(int j = 1; j <= N ; j ++){
                        int tmp = list[i][k] + list[k][j];
                        if(list[i][j] > tmp){
                            list[i][j] = tmp;
                        }
                    }
                }
            }
            boolean sure = false;
            for(int i = 1 ; i <= N ; i ++){
                for(int j = 1 ; j <= N ; j ++){
                    int tmp = list[i][j] + list[j][i];
                    if(tmp < 0){
                        sure = true;
                        break;
                    }
                }
                if(sure){
                    break;
                }
            }
            if(sure){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
