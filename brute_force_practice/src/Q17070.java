import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q17070 {
    static int N;
    static int[][] map;
    static int[][] move = {{0,1},{1,0},{1,1}};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        N = Integer.parseInt(bf.readLine());
        map = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 1;j <= N ; j ++){
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        if(map[N][N]==1){
            System.out.println(0);
            return;
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,2,0}); // 0: 가로, 1: 세로, 2:대각선
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] idx = queue.remove();
            int posI = idx[0];
            int posJ = idx[1];
            int status = idx[2];
            for(int i = 0 ; i < 3 ; i ++){
                int curI = posI+move[i][0];
                int curJ = posJ+move[i][1];
                if(curI > N || curJ > N)continue;
                if(map[curI][curJ] == 1)continue; // 이동방향에 벽이있으면 불가능
                if(status == 0 && i == 1)continue; // 가로모양일떄 세로전진
                if(status == 1 && i == 0)continue; // 세로모양일때 가로전진
                // 대각전 이동 시 위 또는 왼쪽에 벽일경우 못감
                if(i == 2 && (map[curI-1][curJ]==1 || map[curI][curJ-1]==1))continue;
                if(curI == N && curJ == N){
                    ans ++;
                }
                else{
                    queue.add(new int[]{curI,curJ,i});
                }
            }
        }
        System.out.println(ans);
    }
}
