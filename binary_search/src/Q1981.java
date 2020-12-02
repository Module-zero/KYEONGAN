import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1981 {
    static int [][] map;
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    static int n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        n = Integer.parseInt(bf.readLine());
        map = new int[n][n];
        int max = 0 ;
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            for(int j = 0 ;j < n ; j++){
                map[i][j] = Integer.parseInt(str[j]);
                max = Math.max(max,map[i][j]);
            }
        }
        int left = 0;
        int right = max;
        int answer  = right ;
        while(left <= right){
            int mid = (left+right)/2;
            if(go(mid)){
                right = mid - 1;
                answer = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
    public static boolean go(int diff){
        for(int i = 0 ; i + diff <= 200 ; i ++){
            if(dfs(i,i+diff)){
                return true;
            }
        }
        return false;
    }
    public static boolean dfs(int min,int max){
        if(min > map[0][0] || map[0][0] > max)return false;
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[n][n];
        queue.add(new int[]{0,0});
        check[0][0] = true;
        boolean arrive = false;
        while(!queue.isEmpty()){
            int[] idx = queue.remove();
            for(int i = 0 ; i < 4 ; i++){
                int curI = idx[0] + move[i][0];
                int curJ = idx[1] + move[i][1];
                if(curI < 0 || curJ < 0 || curI >= n || curJ >= n)continue;
                if(check[curI][curJ])continue;
                if(min > map[curI][curJ] || map[curI][curJ] > max)continue;
                check[curI][curJ] = true;
                if(curI == n-1 && curJ == n-1){
                    arrive = true;
                }
                queue.add(new int[]{curI,curJ});
            }
        }
        if(arrive){
            return true;
        }
        else{
            return false;
        }
    }
}
