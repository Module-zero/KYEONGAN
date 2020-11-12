import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q16236 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        int[][] distance = new int[n][n];
        ArrayList<int[]>[] list = new ArrayList[7];
        for(int i = 0 ; i <= n ; i ++){
            list[i] = new ArrayList<>();
        }
        LinkedList<int[]> queue = new LinkedList<>(); // 각 물고기 크기별로 좌표를 적어둔다.
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++){
                map[i][j] = Integer.parseInt(str[j]);
                if(0 < map[i][j] && map[i][j] < 7 ) {
                    list[map[i][j]].add(new int[]{i, j, 1}); // 물고기는 list에 추가한다.
                }
                else{
                    queue.add(new int[]{i,j,2,0}); // 초기 상어의 위치를 queue에 넣는다.
                }
            }
        }
        int[] moveI = {-1,1,0,0};
        int[] moveJ = {0,0,-1,1};
        boolean[][] check = new  boolean[n][n];
        while(!queue.isEmpty()){
            int[] start = queue.remove();
            int idxI = start[0];
            int idxJ = start[1];
            int size = start[2];
            int cnt = start[3];
            int answer = Integer.MAX_VALUE;
            int tmpStartI = idxI;
            int tmpStartJ = idxJ;
            for(int i = 1 ; i < size ; i ++){
                for(int j = 0 ; j < list[i].size() ; j ++){
                    int[] tmp = list[i].get(j);
                    int min = Math.abs((idxI - tmp[0]) + (idxJ - tmp[1]);
                    if(answer > min){
                        answer = min;
                        tmpStartI = 
                    }
                }
            }
        }
    }
}
