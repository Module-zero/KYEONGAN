import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1261 {
    static class Pos{
        int i ;
        int j ;
        int value ;
        public Pos(int i ,int j ,int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
    static int[] goI = {0,1};
    static int[] goJ = {1,0};
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[1]);
        int m = Integer.parseInt(strArr[0]);
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            char[] strArr1 = bf.readLine().toCharArray();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = strArr1[j]-'0';
            }
        }

        LinkedList<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0,0,0));
        while(!queue.isEmpty()){
            Pos p = queue.remove();
            int i = p.i;
            int j = p.j;
            int val = p.value;
            for(int k = 0 ; k < 2; k++){
                int curI = i + goI[k];
                int curJ = j + goJ[k];
                if(curI < 0 || curJ < 0 || curI >= n || curJ >= m) continue;
                int curVal = val + map[curI][curJ];
                if(dp[curI][curJ] == 0){
                    dp[curI][curJ] = curVal;
                }
                else{
                    dp[curI][curJ] = Math.min(curVal,dp[curI][curJ]);
                }
                if(curI != n || curJ != m){
                    queue.add(new Pos(curI,curJ,dp[curI][curJ]));
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
