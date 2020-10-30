import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q7576 {
    static int[][] tomato;
    static int n;
    static int m;
    static int[] x = {0,0,1,-1};
    static int[] y = {1,-1,0,0};
    static class Point{
        public int i ;
        public int j;
        public Point(int i , int j){
            this.i = i ;
            this.j = j;
        }
    }
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        m = Integer.parseInt(strArr[0]);
        n = Integer.parseInt(strArr[1]);
        tomato = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            String[] tomTmp = bf.readLine().split(" ");
            for(int j = 0 ; j < m ; j ++){
                tomato[i][j] = Integer.parseInt(tomTmp[j]);
            }
        }
        int answer = bfs(0);
        for(int[] tom : tomato){
            for(int num : tom){
                if(num == 0){
                    answer = -1;
                }
            }
        }
        System.out.println(answer);
    }
    public static int bfs(int answer){
        Point[] queue = new Point[1000*1000];
        int front = 0;
        int rear = 0;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ;j ++){
                if(tomato[i][j] == 1){
                    queue[rear++] = new Point(i,j);
                }
            }
        }
        while(front < rear) {
            Point p = queue[front++];
            int i = p.i;
            int j = p.j;
            for(int k = 0 ; k <= 3; k ++) {
                if (i + x[k] >= 0 && i + x[k] < n && j + y[k] >= 0 && j + y[k] < m) {
                    if (tomato[i + x[k]][j + y[k]] == -1) {
                        continue;
                    } else if (tomato[i + x[k]][j + y[k]] == 0) {
                        tomato[i + x[k]][j + y[k]] = tomato[i][j]+1;
                        answer = Math.max(answer,tomato[i][j]);
                        queue[rear++] = new Point(i + x[k], j + y[k]);
                    } else {
                        if (tomato[i][j]+1 < tomato[i + x[k]][j + y[k]]) {
                            tomato[i + x[k]][j + y[k]] = tomato[i][j]+1;
                            answer = Math.max(answer,tomato[i][j]);
                            queue[rear++] = new Point(i + x[k], j + y[k]);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
