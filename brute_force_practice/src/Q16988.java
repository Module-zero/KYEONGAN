import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q16988 {
    static int N;
    static int M;
    static int[][] map;
    static int max;
    static LinkedList<int[]> queue = new LinkedList<>();
    static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        map = new int[N][M];
        for(int i = 0 ; i < N ; i ++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 0 ; j < M ;j ++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        solve(new boolean[N][M],new int[2][2],0);
        System.out.println(max);
    }
    public static void solve(boolean[][] check,int[][] answer,int cnt){
        if(cnt == 2){
            for(int[] a : answer){
                int tmpI = a[0];
                int tmpJ = a[1];
                map[tmpI][tmpJ] = 1;
            }
            boolean[][] checkBfs = new boolean[N][M];
            int res = 0 ;
            for(int i = 0 ; i < N ; i ++){
                for(int j = 0 ; j < M ; j ++){
                    if(map[i][j] != 2)continue;
                    if(checkBfs[i][j])continue;
                    res += bfs(checkBfs,i,j);
                }
            }
            if(res > max) {
                max = res;
            }
            for(int[] a : answer){
                int tmpI = a[0];
                int tmpJ = a[1];
                map[tmpI][tmpJ] = 0;
            }
            return;
        }
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                if(map[i][j] != 0)continue;
                if(check[i][j])continue;
                check[i][j] = true;
                answer[cnt][0] = i;
                answer[cnt][1] = j;
                solve(check,answer,cnt+1);
                check[i][j] = false;
            }
        }
    }
    public static int bfs(boolean[][] answer,int i, int j){
        queue.add(new int[]{i,j});
        answer[i][j] = true;
        int tmp = 1;
        boolean returnZero = false;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            for(int k = 0 ; k < 4; k ++){
                int curI = idx[0]+move[k][0];
                int curJ = idx[1]+move[k][1];
                if(0 > curI || 0 > curJ || N <= curI || M <= curJ)continue;
                if(map[curI][curJ] == 0){
                    returnZero = true;
                    continue;
                }
                if(answer[curI][curJ])continue;
                if(map[curI][curJ] == 1)continue;
                answer[curI][curJ] = true;
                tmp ++;
                queue.add(new int[]{curI,curJ});
            }
        }
        if(returnZero){
            return 0;
        }
        else {
            return tmp;
        }
    }
}
