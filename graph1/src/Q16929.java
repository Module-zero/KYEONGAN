import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q16929 {
    static int n;
    static int m;
    static int[] mN = {0,0,1,-1};
    static int[] mM = {1,-1,0,0};
    static char[][] map;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] sizeArr = bf.readLine().split(" ");
        n = Integer.parseInt(sizeArr[0]);
        m = Integer.parseInt(sizeArr[1]);

        map = new char[n][m];
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j ++){
                map[i][j] = str.charAt(j);
            }
        }
        boolean answer = false;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(dfs(new boolean[n][m],i,j,i,j,0)){
                    answer = true;
                    break;
                }
            }
            if(answer)break;
        }
        System.out.println((answer == true ? "Yes" : "No"));
    }
    public static boolean dfs(boolean[][] check, int i, int j, int startI, int startJ,int cnt){
        if(map[i][j] != map[startI][startJ]){
            return false;
        }
        if (cnt >= 4 && map[startI][startJ] == map[i][j] && i == startI && j == startJ) {
           return true;
        }

        boolean answer = false;
        for(int k = 0 ; k < 4 ; k ++){
            int tmpI = i+mN[k];
            int tmpJ = j+mM[k];
            if(tmpI >= 0 && tmpJ >= 0 && tmpI < n &&tmpJ < m) {
                if (!check[tmpI][tmpJ]) {
                    check[tmpI][tmpJ] = true;
                    if (dfs(check, tmpI, tmpJ, startI, startJ, cnt + 1)) {
                        answer = true;
                        break;  
                    }
                    check[tmpI][tmpJ] = false;
                }
            }
        }
        return answer;
    }
}
