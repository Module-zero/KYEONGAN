/*
탈옥
- check(memo) 하는 배열은 int[][] 자료형이다.
- check(memo) 에는 방문시 문을 연 횟수를 적는다.
- check를 -1 초기화한다. ( 방문하지 않음)
- check 가 -1일경우는 무조건 방문 가능하며, 만약 -1이 아닐경우는 문을 연 횟수를 체크한다.
- 만약 check의 값보다 문을 연 횟수가 더 크다면 다음 과정을 진행한다.
- 만약 check의 값보다 문을 연 횟수가 더 적을 경우 check 값을 변경한 후 위치 및 횟수를 queue에 넣는다.

 */

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q9376 {
    static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    static int m;
    static char[][] map;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int t = Integer.parseInt(bf.readLine());
        for(int ttt = 0  ; ttt < t ; ttt++){
            String[] strArr = bf.readLine().split(" ");
            n = Integer.parseInt(strArr[0]);
            m = Integer.parseInt(strArr[1]);

            map = new char[n+2][m+2];
            int[][] thief = new int[2][2];
            int[][] out = new int[n+2][m+2];
            int[][] t1 = new int[n+2][m+2];
            int[][] t2 = new int[n+2][m+2];
            int countThief = 0;
            for(int i = 1 ; i <= n; i ++){
                String str = bf.readLine();
                for(int j = 1 ; j <= m ; j ++){
                    map[i][j] = str.charAt(j-1);
                    if(map[i][j] == '$'){
                        thief[countThief][0] = i;
                        thief[countThief][1] = j;
                        countThief++;
                    }
                }
            }
            for(int i = 0 ; i < n+2 ; i ++){
                for(int j = 0 ; j < m+2 ; j ++){
                    out[i][j] = -1;
                    t1[i][j] = -1;
                    t2[i][j] = -1;
                }
            }
            bfs(0,0,out);
            bfs(thief[0][0],thief[0][1],t1);
            bfs(thief[1][0],thief[1][1],t2);
            int answer = (n+2)*(m+2)+2;
            for(int i = 0 ; i < n+2 ; i ++){
                for(int j = 0 ; j < m+2; j ++){
                    if(map[i][j] == '*')continue;
                    int tmp = out[i][j] + t1[i][j] + t2[i][j];
                    if(map[i][j] == '#'){
                        tmp = tmp - 2;
                    }
                    answer =  Math.min(answer, tmp);
                }
            }
            System.out.println(answer);
        }
    }
    public static void bfs(int i, int j, int[][] memo){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j,0});
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            for(int k = 0; k < 4 ; k ++){
                int curI = idx[0] + move[k][0];
                int curJ = idx[1] + move[k][1];
                int cnt = idx[2];
                if(curI < 0 || curJ < 0 || curI>= n+2 || curJ >= m+2)continue;
                if (map[curI][curJ] == '*') continue;
                if (memo[curI][curJ] != -1)continue;
                if (map[curI][curJ] == '#') {
                    memo[curI][curJ] = cnt+1;
                    queue.addLast(new int[]{curI, curJ, cnt+1});
                }
                else{
                    memo[curI][curJ] = cnt;
                    queue.addFirst(new int[]{curI, curJ, cnt});
                }
            }
        }
    }
}
