import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Qprogrammers1 {
    static int MOD = 20170805;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] str = bf.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        int[][] cityMap = new int[m][n];
        for(int i = 0 ; i < m ; i ++){
            String[] tmp = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++){
                cityMap[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(solution(m,n,cityMap));
    }
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] check = new int[m][n]; // 0 == 좌우, 1 == 상하
        check[0][0] = 1;
        int[][] move = {{-1,0},{0,-1}};
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j ++){
                if(i == 0 && j == 0)continue;
                if(cityMap[i][j] == 1)continue;
                for(int k = 0 ; k < 2 ; k ++){
                    int curI = i + move[k][0];
                    int curJ = j + move[k][1];
                    if( 0 <= curI && curI < m && 0 <= curJ && curJ < n){
                        int val = check[curI][curJ];
                        while(cityMap[curI][curJ] == 2){
                            curI += move[k][0];
                            curJ += move[k][1];
                            if( 0 > curI || curI >= m || 0 > curJ || curJ >= n){
                                val = 0;
                                break;
                            }
                            val = check[curI][curJ];
                        }
                        check[i][j] = (check[i][j] + val) % MOD;
                    }
                }
            }
        }
        answer = check[m-1][n-1];
        return answer;
    }
}
