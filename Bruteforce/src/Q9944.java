import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q9944 {
    static int N ;
    static int M;
    static char[][] map;
    static int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
    static int min;
    static int cnt;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        for(int kk = 1 ;; kk ++){
            String[] arrTmp ;
            try {
                arrTmp = bf.readLine().split(" ");
            }catch (NullPointerException e){
                return;
            }
            N = Integer.parseInt(arrTmp[0]);
            M = Integer.parseInt(arrTmp[1]);
            map = new char[N][M];
            cnt = 0;
            for(int i = 0 ; i < N ; i ++){
                String tmp = bf.readLine();
                for(int j = 0 ; j < M ; j++){
                    map[i][j] = tmp.charAt(j);
                    if(map[i][j] == '.'){
                        cnt++;
                    }
                }
            }
            min = -1;
            for( int i = 0 ; i < N ; i ++){
                for(int j = 0 ; j < M ; j ++){
                    if(map[i][j] == '*')continue;
                    map[i][j] = '#';
                    int res = solve(i,j,cnt-1);
                    if(res != -1){
                        if(min == -1){
                            min = res;
                        }
                        else{
                            if( res < min){
                                min = res;
                            }
                        }
                    }
                    map[i][j] = '.';
                }
            }
            System.out.println("Case "+kk+": "+min);
        }
    }
    public static int solve(int i ,int j,int count){
        int ans = -1;
        if( count == 0){
            return 0;
        }
        for(int k = 0 ; k < 4 ; k ++){
            int curI = i;
            int curJ = j;
            boolean go = false;
            while(true){
                curI += move[k][0];
                curJ += move[k][1];
                if(curI < 0 || curJ < 0 || curI >= N || curJ >= M)break;
                if(map[curI][curJ] == '*' || map[curI][curJ] == '#')break;
                map[curI][curJ] = '#';
                go = true;
                count--;
            }
            curI -= move[k][0];
            curJ -= move[k][1];
            if(go){
                int step = solve(curI,curJ,count);
                if(step != -1){
                    if(ans == -1){
                        ans = step+1;
                    }
                    else{
                        if(ans > step){
                            ans = step+1;
                        }
                    }
                }
            }
            while(curI != i || curJ != j){
                if(map[curI][curJ] != '#')break;
                map[curI][curJ] = '.';
                count++;
                curI -= move[k][0];
                curJ -= move[k][1];
            }
        }
        return ans;
    }
    public static void print(int i, int j,int ans){
        for(char[] c : map){
            for(char cc : c){
                System.out.print(cc+" ");
            }
            System.out.println("");
        }
        System.out.println("-------[i: "+i+"]--[j :"+j+"]----------["+ans+"]");
    }
}
