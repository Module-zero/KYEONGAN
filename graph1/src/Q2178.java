import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2178 {
    static ArrayList<Point> list ;
    static class Point{
        public int i;
        public int j;
        public int cnt;
        public Point(int i , int j,int cnt){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        int[][] map = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i ++){
            char[] chArr = bf.readLine().toCharArray();
            for(int j = 1 ; j <= m ; j ++){
                map[i][j] = chArr[j-1]-'0';
            }
        }
        list = new ArrayList<>();
        int cnt = 1;
        bfs(map,n,m,cnt);
        System.out.println(map[n][m]);
    }
    public static void bfs(int[][] map, int n,int m,int cnt){
        int i = 1;
        int j = 1;
        list.add(new Point(i,j,cnt));
        while(!list.isEmpty()) {
            Point p = list.remove(0);
            i = p.i;
            j = p.j;
            cnt = p.cnt + 1;
            if(i - 1 > 0 && map[i-1][j] == 1){
                map[i-1][j] = cnt;
                list.add(new Point(i-1,j,cnt));
            }
            if(i + 1 <= n && map[i+1][j] == 1){
                map[i+1][j] = cnt;
                list.add(new Point(i+1,j,cnt));
            }
            if(j + 1 <= m && map[i][j+1] == 1){
                map[i][j+1] = cnt;
                list.add(new Point(i,j+1,cnt));
            }
            if(j - 1 > 0 && map[i][j-1] == 1){
                map[i][j-1] = cnt;
                list.add(new Point(i,j-1,cnt));
            }
        }
    }
}
