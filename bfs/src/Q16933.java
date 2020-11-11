import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q16933 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr= bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        if(n == 1 && m ==1){
            System.out.println(1);
            return;
        }
        int k = Integer.parseInt(strArr[2]);
        int [][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][][][] check = new boolean[n][m][k+1][2];
        queue.add(new int[]{0,0,1,1,k}); // 1 낮 -1 밤
        int[] moveI = {-1,1,0,0};
        int[] moveJ = {0,0,-1,1};
        int answer = Integer.MAX_VALUE;
        boolean arrive = false;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            int idxI = idx[0];
            int idxJ = idx[1];
            for(int l = 0 ; l < 4 ; l ++){
                int curI = idxI + moveI[l];
                int curJ = idxJ + moveJ[l];
                int cnt = idx[2];
                int day = idx[3]; // 날
                int dayCheck = (day == -1)? 0 : day;
                int breakWall = idx[4]; // 벽 부수기
                if(curI < 0 || curJ < 0 || curI >= n || curJ >= m)continue;
                if(check[curI][curJ][breakWall][dayCheck])continue;
                check[curI][curJ][breakWall][dayCheck] = true;
                if(map[curI][curJ] == 1){
                    if(breakWall == 0 || day == -1) {
                        queue.add(new int[] {idxI,idxJ,cnt+1,day*(-1),breakWall});
                        continue;
                    }
                    breakWall -= 1;
                }
                if(curI == n-1 && curJ == m-1){
                    arrive = true;
                    answer = Math.min(answer,cnt+1);
                }
                queue.add(new int[] {curI,curJ,cnt+1,day*(-1),breakWall});
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

