import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q14442 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        if(n == 1 && m ==1){
            System.out.println(1);
            return;
        }
        int k = Integer.parseInt(strArr[2]);
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j ++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1,k});
        int[] moveI = {-1,1,0,0};
        int[] moveJ = {0,0,-1,1};
        int answer = Integer.MAX_VALUE;
        boolean arrive = false;
        boolean[][][] check = new boolean[n][m][k+1];
        check[0][0][k] = true;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            int idxI = idx[0];
            int idxJ = idx[1];
            for(int l = 0; l < 4 ; l ++){
                int curI = idxI + moveI[l];
                int curJ = idxJ + moveJ[l];
                int cnt = idx[2];
                int breakWall = idx[3];
                if(curI < 0 || curJ < 0 || curI >= n | curJ >= m)continue;
                if(check[curI][curJ][breakWall])continue;
                check[curI][curJ][breakWall] = true;
                if(map[curI][curJ] == 1){
                    if(breakWall == 0)continue;
                    breakWall -= 1;
                }
                if(curI == n-1 && curJ == m-1){
                    arrive = true;
                    answer = Math.min(answer,cnt+1);
                    continue;
                }
                queue.add(new int[]{curI,curJ,cnt+1,breakWall});
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
