import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q4963 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        StringBuilder sb = new StringBuilder();
        while(true){
            String[] str = bf.readLine().split(" ");
            if(str[0].equals("0") && str[1].equals("0")){
                break;
            }
            int w = Integer.parseInt(str[0]);
            int h = Integer.parseInt(str[1]);
            int[][] map = new int[h][w];
            for(int i = 0 ; i < h ; i ++){
                String[] strArr = bf.readLine().split(" ");
                for(int j = 0 ; j < w ; j++){
                    map[i][j] = Integer.parseInt(strArr[j]);
                }
            }
            int answer = 0 ;
            for(int i = 0 ; i < h ; i ++){
                for(int j = 0 ; j < w ; j++){
                    if(map[i][j] == 1) {
                        answer ++;
                        dfs(map, i, j, h, w);
                    }
                }
            }
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int[][] map,int i, int j,int h,int w){
        if (i < 0 || j < 0 || i >= h || j >= w || map[i][j] != 1) {
            return ;
        }
        map[i][j] = -1;
        dfs(map,i-1,j,h,w);
        dfs(map,i,j-1,h,w);
        dfs(map,i+1,j,h,w);
        dfs(map,i,j+1,h,w);
        dfs(map,i-1,j-1,h,w);
        dfs(map,i-1,j+1,h,w);
        dfs(map,i+1,j-1,h,w);
        dfs(map,i+1,j+1,h,w);
    }
}
