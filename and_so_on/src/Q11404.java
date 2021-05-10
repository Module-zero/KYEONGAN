import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Q11404 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int MAX = 100000 * 100 ;
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int[][] map = new int[n+1][n+1];
        for(int i = 1 ; i <= n ; i ++){
            Arrays.fill(map[i],MAX);
            map[i][i] = 0;
        }
        for(int i = 0 ; i < m ; i ++){
            String[] str = bf.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            if(map[a][b] <= c) continue;
            map[a][b] = c;
            map[a][b] = c;
        }

        for(int k = 1; k <= n ; k ++){
            for(int i = 1; i <= n ; i ++){
                for(int j = 1 ; j <= n ; j ++){
                    int tmp = map[i][k] + map[k][j];
                    if(map[i][j] > tmp){
                        map[i][j] = tmp;
                    }
                }
            }
        }
        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; j <= n ; j ++){
                if(map[i][j] == MAX){
                    map[i][j] = 0;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
