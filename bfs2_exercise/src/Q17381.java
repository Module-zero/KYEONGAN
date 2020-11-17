import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q17381 {
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    static char[] limit = {'U','D','R','L'};
    static int n;
    static int m;
    static char[][] maze;
    static boolean[][] clean;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);
        int q = Integer.parseInt(strArr[2]);
        maze = new char[n+1][m+1];
        for(int i = 1 ; i <= n; i ++){
            String str = bf.readLine();
            for(int j = 1 ; j <= m ; j++){
                maze[i][j] = str.charAt(j-1);
            }
        }
        for(int i = 0 ; i < q ; i++){
            int answer = 0;
            String[] idx = bf.readLine().split(" "); // startI startJ endI endJ
            clean = new boolean[n+1][m+1];
            int startI = Integer.parseInt(idx[0]);
            int startJ = Integer.parseInt(idx[1]);
            int endI = Integer.parseInt(idx[2]);
            int endJ = Integer.parseInt(idx[3]);
            dfs(startI,startJ,endI,endJ,new boolean[n+1][m+1][4],0,-1);
            for(boolean[] cc :clean){
                for(boolean c : cc){
                    if(c) {
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    public static void dfs(int i,int j, int endI, int endJ, boolean[][][] check, int cnt,int his){
        if(his == -1) {
            check[i][j][0] = true;
        }
        else{
            check[i][j][his] = true;
        }
        if(i == endI && j == endJ){
            for(int ii = 1 ; ii <= n ; ii++){
                for(int jj = 1 ; jj<= m ; jj++ ){
                    for(int kk = 0 ; kk < 4 ; kk++) {
                        if (check[ii][jj][kk]) {
                            clean[ii][jj] = check[ii][jj][kk];
                        }
                    }
                }
            }
        }
        for(int k = 0 ; k < 4 ; k++){
            int curI = i + move[k][0];
            int curJ = j + move[k][1];
            if(curI <= 0 || curI > m || curJ <= 0 || curJ > m)continue;
            if(maze[i][j] == limit[k])continue;
            if(check[curI][curJ][k])continue;
            dfs(curI,curJ,endI,endJ,check,cnt+1,k);
        }
        if(his != -1) {
            check[i][j][his] = false;
        }
    }
}
