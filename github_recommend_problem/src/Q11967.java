import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q11967 {
    static LinkedList<int[]>[][] map ;
    static boolean[][] turn ;
    static int N;
    public static void main(String[]args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        N = Integer.parseInt(init[0]);
        map = new LinkedList[N+1][N+1];
        turn = new boolean[N+1][N+1];
        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1 ; j <= N ; j ++){
                map[i][j] = new LinkedList<>();
            }
        }
        int M = Integer.parseInt(init[1]);
        for(int i = 0 ; i < M ; i ++){
            String[] tmp = bf.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]) ;
            int y = Integer.parseInt(tmp[1]) ;
            int a = Integer.parseInt(tmp[2]) ;
            int b = Integer.parseInt(tmp[3]) ;
            map[x][y].add(new int[]{a,b});
        }
        int ans = 1;
        int res ;
        do{
            res = bfs();
            ans += res;
        }while(res != 0);
        System.out.println(ans);
    }
    public static int bfs(){
        int[][] move = {{1,0},{0,1}};
        int res = 0 ;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            while(!map[idx[0]][idx[1]].isEmpty()){
                int[] light = map[idx[0]][idx[1]].remove();
                if(!turn[light[0]][light[1]]) {
                    turn[light[0]][light[1]] = true;
                    res += 1;
                }
            }
            for(int i = 0 ; i < 2 ; i ++){
                int curX = idx[0]+move[i][0];
                int curY = idx[1]+move[i][1];
                if(curX > N|| curY > N)continue;
                if(!turn[curX][curY])continue;
                queue.add(new int[]{curX,curY});
            }
        }
        return res;
    }


}
