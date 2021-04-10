import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q11967 {
    static LinkedList<int[]>[][] map ;
    public static void main(String[]args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init = bf.readLine().split(" ");
        int N = Integer.parseInt(init[0]);
        map = new LinkedList[N+1][N+1];
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
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] light = new boolean[N+1][N+1];
        int curX = 1;
        int curY = 1;
        light[curX][curY] = true;
        int ans = 1;
        while(!map[curX][curY].isEmpty()){
            int[] idx = map[curX][curY].remove();


        }
        StringBuilder sb = new StringBuilder();

    }


}
