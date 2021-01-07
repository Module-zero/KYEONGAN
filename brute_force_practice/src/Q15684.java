import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q15684 {
    static int N;
    static int M;
    static int H;
    static int[][] map;
    static int res = 4;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] info = bf.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        H = Integer.parseInt(info[2]);
        if(M == 0 || M == 1){
            System.out.println(M);
            return ;
        }
        map = new int[N+2][H+1];

        for(int i = 0 ; i < M ; i ++){
            String[] str = bf.readLine().split(" ");
            int h = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[1]);
            map[n][h] = n+1;
            map[n+1][h] = n;
        }
        print();
        solve(0,1,1,new int[3][2]);
        if(res > 3){
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }
    public static void solve(int select, int i, int j, int[][] answer){
        if(select >= 3 || j > H){
            for(int ii = 0 ; ii < select ; ii ++){
                int n = answer[ii][0]; // i
                int h = answer[ii][1]; // j
                map[n][h] = n+1;
                map[n+1][h] = n;
            }
            boolean success = true;
            for(int n = 1 ; n <= N ; n ++){
                if(!go(n)){
                    success = false;
                    break;
                }
            }
            if(success){
                if( res > select){
                    res = select;
                    print();
                }
            }
            for(int ii = 0 ; ii < select ; ii ++){
                int n = answer[ii][0];
                int h = answer[ii][1];
                map[n][h] = 0;
                map[n+1][h] = 0;
            }
            return ;
        }
        if(i >= N){
            solve(select,1,j+1,answer);
        }
        else{
            if(map[i+1][j] == 0 && map[i][j] == 0) {
                answer[select][1] = j;
                answer[select][0] = i;
                solve(select + 1, i+2, j , answer);
            }
            solve(select,i+1,j,answer);
        }
    }
    public static boolean go(int start){
        int cur = start;
        for(int i = 1 ; i <= H; i ++){
            if(map[cur][i] == 0)continue;
            cur = map[cur][i];
        }
        if(cur != start){
            return false;
        }
        return true;
    }
    public static void print(){
        for(int[] m : map){
            for(int mm : m){
                System.out.print(mm+" ");
            }
            System.out.println(" ");
        }
        System.out.println("---------["+res+"]");
    }
}
