import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q14466 {
    static int N;
    static int K;
    static int R;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        K = Integer.parseInt(init[1]);
        R = Integer.parseInt(init[2]);
        int[][] map = new int[N+1][N+1];
        for(int i = 0 ; i < R ; i ++){
            String[] road = bf.readLine().split(" ");
            int r = Integer.parseInt(road[0]);
            int c = Integer.parseInt(road[1]);
            int rp = Integer.parseInt(road[2]);
            int cp = Integer.parseInt(road[3]);
            map[r][c] += calc(r,c,rp,cp);
            map[rp][cp] += calc(rp,cp,r,c);
        }
        int[][] cow = new int[K][2];
        for(int i = 0 ; i < K ; i ++){
            String[] str = bf.readLine().split(" ");
            cow[i][0] = Integer.parseInt(str[0]);
            cow[i][1] = Integer.parseInt(str[1]);
        }
        bfs(cow,map);
    }
    public static void bfs(int[][] cow, int[][] map){
        int[][] move = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        LinkedList<int[]> queue = new LinkedList<>();
        int ans = 0;
        for(int i = 0 ; i < K ; i ++){
            int startI = cow[i][0];
            int startJ = cow[i][1];
            queue.add(new int[]{startI,startJ});
            boolean[][] check = new boolean[N+1][N+1];
            check[startI][startJ] = true;
            while(!queue.isEmpty()){
                int[] idx = queue.remove();
                for(int k = 0 ; k < 4; k ++){
                    int curI = idx[0]+move[k][0];
                    int curJ = idx[1]+move[k][1];
                    if(0 >= curI||0 >= curJ|| curI > N || curJ > N)continue;
                    if(check[curI][curJ])continue;
                    if(isBlock(map[idx[0]][idx[1]],k))continue;
                    check[curI][curJ] = true;
                    queue.add(new int[]{curI,curJ});
                }
            }
            for(int j = i ; j < K ; j ++){
                if(check[cow[j][0]][cow[j][1]])continue;
                ans ++;
            }
        }
        System.out.println(ans);
    }
    public static boolean isBlock(int map, int num){
        for(int i = 0 ; i < 4 ; i ++){
            if((map&(1<<i)) != 0){
                if(i == num) {
                    return true;
                }
            }
        }
        return false;
    }
    public static int calc(int r, int c , int rp, int cp){
        int i = r - rp;
        int j = c - cp;
        int res;
        if(i == 0){
            if(j == 1){
                // 좌
                res = 1;
            }
            else{
                // 우
                res = 2;
            }
        }
        else{
            if(i == 1){
                // 상
                res = 4;
            }
            else{
                // 하
                res = 8;
            }
        }
        return res;
    }
}

