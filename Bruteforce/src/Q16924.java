import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q16924 {
    static int i;
    static int j;
    static char[][] map;
    static int[][] move = {{0,1},{1,0},{0,-1},{-1,0},{0,0}};
    static boolean check[][];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        i = Integer.parseInt(size[0]);
        j = Integer.parseInt(size[1]);
        map = new char[i+1][j+1];
        check = new boolean[i+1][j+1];
        sb = new StringBuilder();
        char[] charArr;
        for(int ii = 1 ; ii <= i ; ii++){
            charArr = bf.readLine().toCharArray();
            for(int jj = 1 ; jj <= j ; jj++){
                map[ii][jj] = charArr[jj-1];
            }
        }
        int ans = 0;
        for(int ii = 2 ; ii < i ; ii++) {
            for (int jj = 2; jj < j; jj++) {
                if(map[ii][jj]=='.')continue;
                int s = 0;
                for(int ss = 1; ; ss++){
                    if (search(ii, jj, ss)) {
                        s = ss;
                    }
                    else{
                        break;
                    }
                }
                if (s > 0) {
                    sb.append(ii).append(" ").append(jj).append(" ").append(s).append("\n");
                    ans++;
                    for (int k = ii - s; k <= ii + s; k++) {
                        check[k][jj] = true;
                    }
                    for (int k = jj - s; k <= jj + s; k++) {
                        check[ii][k] = true;
                    }
                }
            }
        }
        if(ans == 0){
            System.out.println(-1);
            return;
        }
        for(int ii = 1 ; ii <= i ; ii++){
            for(int jj = 1 ; jj <= j ;jj++){
                if(map[ii][jj]=='.')continue;
                if(check[ii][jj] == false){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(ans+"\n"+sb);
    }
    public static boolean search(int r,int c,int n) {
        for(int ii = 0 ; ii < 4 ; ii ++){
            int curI = r+(move[ii][0]*n);
            int curJ = c+(move[ii][1]*n);
            if(0 >= curI || curI > i || 0 >= curJ || curJ > j || map[curI][curJ] == '.'){
                return false;
            }
        }
        return true;
    }
}
