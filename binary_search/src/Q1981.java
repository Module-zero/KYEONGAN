import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1981 {
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
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
        LinkedList<int[]> queue = new LinkedList<>();
        int answer  = right ;
        while(left <= right){
            int mid = (left+right)/2;
            boolean arrive = false;
            queue.add(new int[]{0,0,map[0][0],map[0][0]});
            boolean[][] check = new boolean[n][n];
            check[0][0]=true;
//            if(arrive(mid)){
//                right = mid - 1;
//                if(answer > mid){
//                    answer = mid;
//                }
//            }
//            else{
//                left = mid + 1;
//            }
        }
        System.out.println(answer);
    }
//    public static boolean arrive(int mid){
//
//    }
}
