import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16956 {
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j ++){
                map[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] != 'W')continue;
                for(int k = 0 ; k < 4 ; k ++){
                    int curI = i + move[k][0];
                    int curJ = j + move[k][1];
                    if(curI < 0 || curJ < 0 || curI >=n || curJ >=m)continue;
                    if(map[curI][curJ] == 'S'){
                        System.out.println(0);
                        return;
                    }
                    if(map[curI][curJ]!='W') {
                        map[curI][curJ] = 'D';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1\n");
        for(char[] mm : map){
            for(char mmm : mm){
                sb.append(mmm);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
