import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q2206 {
    static int n;
    static int m;
    static int[][] map;
    static int[] moveI = {-1,1,0,0};
    static int[] moveJ = {0,0,-1,1};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]);
        m = Integer.parseInt(strArr[1]);
        if(n == 1 && m == 1){
            System.out.println(1);
            return;
        }
        map = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            char[] mapTmp = bf.readLine().toCharArray();
            for(int j = 0 ; j < m ; j ++){
                map[i][j] = mapTmp[j]-'0';
            }
        }
        bfs(0,0);
    }
    public static void bfs(int i,int j){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1,1});
        boolean[][][] check = new boolean[n][m][2];
        check[0][0][0] = true;
        boolean arrive = false;
        int answer = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            int idxI = idx[0];
            int idxJ = idx[1];
            int cnt = idx[2];
            for(int k = 0 ; k < 4 ; k ++){
                int b = idx[3];
                int curI = idxI + moveI[k];
                int curJ = idxJ + moveJ[k];
                if(curI < 0 || curJ <0 || curI >= n || curJ >= m)continue;
                if(map[curI][curJ] == 1){
                    if(b == 0) continue;
                    b = 0;
                }
                if(!check[curI][curJ][b]){
                    check[curI][curJ][b] = true;
                    if(curI == n-1 && curJ == m-1){
                        arrive = true;
                        answer = Math.min(cnt+1,answer);
                        continue;
                    }
                    queue.add(new int[]{curI,curJ,cnt+1,b});
                }
            }
        }
        if(arrive){
            System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
}
