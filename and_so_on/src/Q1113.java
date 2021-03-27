import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Q1113 {
    static int[][] pool;
    static int[][] water;
    static int R;
    static int C;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] init= bf.readLine().split(" ");
        R = Integer.parseInt(init[0]);
        C = Integer.parseInt(init[1]);
        pool = new int[R][C];
        water = new int[R][C];
        int max = 0;
        for(int i = 0 ; i < R ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < C ; j ++){
                pool[i][j] = str.charAt(j) - '0';
                max = Math.max(pool[i][j],max);
            }
        }
        for(int i = 1 ; i < R-1 ; i ++){
            for(int j = 1 ; j < C-1 ; j ++){
                water[i][j] = max - pool[i][j];
            }
        }
        for(int t = max ; t >= 1 ; t --){
            for(int i = 1 ; i < R-1 ; i ++){
                for(int j = 1 ; j < C-1 ; j ++){
                    if(water[i][j] == 0 || pool[i][j] + water[i][j] != t)continue;
                    for(int k = 0 ; k < 4 ; k ++){
                        int curI = i + move[k][0];
                        int curJ = j + move[k][1];
                        if(pool[i][j] + water[i][j] > pool[curI][curJ] + water[curI][curJ]){
                            bfs(i,j,t);
                            break;
                        }
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 1 ; i < R - 1 ; i ++){
            for( int j = 1 ; j < C - 1 ; j ++){
                if(water[i][j] > 0) {
                    answer += water[i][j];
                }
            }
        }
        System.out.println(answer);
    }
    public static void bfs(int x,int y, int height){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,height});
        boolean[][] check = new boolean[R][C];
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            water[idx[0]][idx[1]] --;
            for(int i = 0 ; i < 4 ; i ++){
                int curI = idx[0] + move[i][0];
                int curJ = idx[1] + move[i][1];
                if(curI <= 0 || curJ <= 0 || curI >= R-1 || curJ >= C-1 )continue;
                if(check[curI][curJ])continue;
                check[curI][curJ] = true;
                if(water[curI][curJ] + pool[curI][curJ] == height && water[curI][curJ] > 0){
                    queue.add(new int[]{curI,curJ,height});
                }
            }
        }
    }
    public static void print(){
        System.out.println("------");
        for(int[] i : water){
            for(int ii : i){
                System.out.print(ii+" ");
            }
            System.out.println("");
        }
    }
}
