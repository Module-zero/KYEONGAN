import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q16236 {
    static int[][] map;
    static LinkedList<int[]> queue;
    static int n ;
    static int[] moveI = {-1,1,0,0};
    static int[] moveJ = {0,0,-1,1};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 9){
                    queue.add(new int[]{i,j,2,0}); // 초기 상어의 위치를 queue에 넣는다. ( i,j,size,eatCnt)
                    map[i][j] = 0;
                }
            }
        }
        int answer = 0 ;
        LinkedList<int[]> tmpQueue = new LinkedList<>();
        while(!queue.isEmpty()) {
            int[] start = queue.remove();
            int startI = start[0];
            int startJ = start[1];
            int size = start[2];
            int eatCnt = start[3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(0 < map[i][j] && map[i][j] < size){
                        tmpQueue.add(new int[]{i,j});
                    }
                }
            }

            int minValue = Integer.MAX_VALUE;
            boolean arr = false;
            int findI = startI;
            int findJ = startJ;
            while(!tmpQueue.isEmpty()){
                int[] find = tmpQueue.remove();
                int tmp = bfs(startI,startJ,find[0],find[1],size);// startI,J -> findI,J 까지 가는 bfs를 구한다.
                if( tmp == -1)continue;
                if(minValue > tmp){
                    findI = find[0];
                    findJ = find[1];
                    minValue = tmp;
                }
                arr= true;
            }
            if(!arr)continue;
            answer += minValue;
            eatCnt += 1;
            if(eatCnt == size){
                size ++;
                eatCnt = 0;
            }
            map[findI][findJ] = 0;
            queue.add(new int[]{findI,findJ,size,eatCnt});
        }
        System.out.println(answer);
    }
    public static int bfs(int startI, int startJ, int findI, int findJ, int size){
        queue.add(new int []{startI,startJ,0});
        boolean[][] check = new boolean[n][n];
        check[startI][startJ] = true;
        boolean arrive = false;
        int answer = 0 ;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            int idxI = idx[0];
            int idxJ = idx[1];
            int cnt = idx[2];
            for(int i = 0 ; i < 4; i ++){
                int curI = idxI + moveI[i];
                int curJ = idxJ + moveJ[i];
                if(curI < 0 || curJ < 0 || curI >= n || curJ >= n)continue;
                if(map[curI][curJ] > size)continue;
                if(check[curI][curJ])continue;
                check[curI][curJ] = true;
                if(curI == findI && curJ == findJ){
                    arrive = true;
                    answer = cnt+1;
                    continue;
                }
                queue.add(new int[] {curI,curJ,cnt+1});
            }
        }
        if(arrive){
            return answer;
        }
        else{
            return -1;
        }
    }
}
