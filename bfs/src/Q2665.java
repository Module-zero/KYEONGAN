import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2665 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < n ; j ++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        System.out.println(dijkstra(map,n));
    }
    public static int dijkstra(int[][] map,int n){
        int res = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] memo = new int[n][n];
        for(int i = 0 ; i < n ; i ++) {
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        memo[0][0] = 0;
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] idx = pq.poll();
            for(int k = 0 ; k < 4 ; k ++){
                int curX = idx[0] + move[k][0];
                int curY = idx[1] + move[k][1];
                int cnt = idx[2];
                if( 0 > curX || 0 > curY || curX >= n || curY >= n)continue;
                if(map[curX][curY] == 0)
                    cnt ++;
                if(memo[curX][curY] <= cnt) continue;
                memo[curX][curY] = cnt;
                if(curX == n-1 && curY == n-1){
                    res = Math.min(res,cnt);
                }
                else{
                    pq.add(new int[]{curX,curY,cnt});
                }
            }
        }
        return res;
    }
}
