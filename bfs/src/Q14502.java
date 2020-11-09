import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q14502 {
    static class Index{
        int i;
        int j;
        public Index(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    static int n;
    static int m;
    static int maxValue;
    static int[] moveI = {1,-1,0,0};
    static int[] moveJ = {0,0,1,-1};
    static int[][] memo;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        n = Integer.parseInt(strArr[0]); // 3
        m = Integer.parseInt(strArr[1]); // 4
        memo = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            String[] strArrr = bf.readLine().split(" ");
            for(int j = 0 ; j < m ; j ++){
                memo[i][j] = Integer.parseInt(strArrr[j]);
            }
        }

        choice(new Index[3],0,0,0,3);
        System.out.println(maxValue);
    }
    public static void choice(Index[] answer, int cnt, int i,int j,int k){
        if(cnt >= k){
            bfs(answer[0],answer[1],answer[2],new int[n][m]);
            return;
        }

        int nextI;
        int nextJ;
        if(j+1 >= m){
            nextI = i+1;
            nextJ = 0;
        }
        else{
            nextI = i;
            nextJ = j+1;
        }
        if(i>=n || j >= m){
            return;
        }
        if(memo[i][j] == 0) {
            answer[cnt] = new Index(i, j);
            choice(answer, cnt + 1, nextI, nextJ, k);
        }
        choice(answer,cnt,nextI,nextJ,k);

    }
    public static void bfs(Index wall1, Index wall2, Index wall3,int[][] map){
        memo[wall1.i][wall1.j] = 1;
        memo[wall2.i][wall2.j] = 1;
        memo[wall3.i][wall3.j] = 1;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = memo[i][j];
            }
        }
        LinkedList<Index> queue = new LinkedList<>();
        boolean[][] check = new boolean[n][m];
        for(int i = 0 ; i < n ; i ++){
            for(int j  = 0 ; j < m ;j++){
                if(map[i][j] != 2||check[i][j])continue;
                check[i][j] = true;
                queue.add(new Index(i,j));
                while(!queue.isEmpty()){
                    Index idx = queue.remove();
                    int startI = idx.i;
                    int startJ = idx.j;
                    for(int k = 0 ; k < 4 ;k ++){
                        int curI = startI + moveI[k];
                        int curJ = startJ + moveJ[k];
                        if(curI < 0 || curJ < 0 || curI >= n || curJ >= m)continue;
                        if(!check[curI][curJ]){
                            check[curI][curJ] = true;
                            if(map[curI][curJ] != 1){
                                map[curI][curJ] = 2;
                                queue.add(new Index(curI,curJ));
                            }
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for(int[] memoI : map){
            for(int j : memoI){
                if(j == 0){
                    cnt++;
                }
            }
        }
        if(maxValue < cnt){
            maxValue = cnt;
        }
        memo[wall1.i][wall1.j] = 0;
        memo[wall2.i][wall2.j] = 0;
        memo[wall3.i][wall3.j] = 0;
    }
}
