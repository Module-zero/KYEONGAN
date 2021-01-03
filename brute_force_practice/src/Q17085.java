import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q17085 {
    static int N;
    static int M;
    static char[][] map;
    static int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
    static int ans = 0;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        map = new char[N][M];
        for(int i = 0 ; i < N ; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = str.charAt(j);
            }
        }
        solve();
        System.out.println(ans);
    }
    public static void solve(){
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++){
                if(map[i][j] != '#')continue;
                int n = 0;
                while(true) {
                    boolean success = false;
                    for (int k = 0; k < 4; k++) {
                        int curI = i + (move[k][0] * n);
                        int curJ = j + (move[k][1] * n);
                        if (0 > curI || 0 > curJ || curI >= N || curJ >= M)break;
                        if(map[curI][curJ] != '#')break;
                        if (k == 3){
                            success = true;
                        }
                    }
                    if(success){
                        int count = (n*4)+1;
                        for(int x = i-n ; x <= i+n ; x++){
                            map[x][j] = '*';
                        }
                        for(int x = j-n ; x <= j+n ; x++){
                            map[i][x] = '*';
                        }
                        int another = check(i,j);
                        if( ans < another*count) {
                            ans = another*count;
                        }
                        for(int x = i-n ; x <= i+n ; x ++){
                            map[x][j] = '#';
                        }
                        for(int x = j-n ; x <= j+n ; x++){
                            map[i][x] = '#';
                        }
                        n++;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }
    public static int check(int startI,int startJ){
        int tmpRes = 0;
        for(int i = startI ; i < N ; i ++){
            for(int j = startJ ; j < M ; j ++){
                if(map[i][j] != '#')continue;
                int tmp = 0;
                while(true) {
                    boolean res = false;
                    for (int l = 0; l < 4; l++) {
                        int curI = i + (move[l][0] * (tmp+1));
                        int curJ = j + (move[l][1] * (tmp+1));
                        if (curI < 0 || curJ < 0 || curI >= N || curJ >= M) break;
                        if (map[curI][curJ] != '#') break;
                        if (l == 3) {
                            res = true;
                        }
                    }
                    if (res) {
                        tmp ++;
                    }
                    else{
                        break;
                    }
                }
                if(tmp > tmpRes) {
                    tmpRes = tmp;
                }
            }
        }
        return (tmpRes*4)+1;
    }
    public static void print(){
        for(char[] cc : map){
            for(char c : cc){
                System.out.print(c);
            }
            System.out.println("");
        }
        System.out.println("--------------");
    }
}
