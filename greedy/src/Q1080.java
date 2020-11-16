import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1080 {
    static int n;
    static int m;
    static int[][] a;
    static int[][] b;
    public static void main(String[] args )throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        a = new int[n][m];
        b = new int[n][m];
        for(int i = 0 ; i < n; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j++){
                a[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i = 0 ; i < n; i ++){
            String str = bf.readLine();
            for(int j = 0 ; j < m ; j++){
                b[i][j] = str.charAt(j)-'0';
            }
        }
        if(same()){
            System.out.println(0);
            return;
        }
        boolean answer = false;
        int cnt = 0 ;
        for(int i = 0 ; i < n-2; i ++){
            for(int j = 0 ; j < m-2; j ++){
                if(a[i][j] == b[i][j])continue;
                reverse(i,j);
                cnt++;
                if(same()){
                    answer = true;
                    break;
                }
            }
        }
        if(answer){
            System.out.println(cnt);
            return;
        }
        else{
            System.out.println(-1);
        }
    }
    public static void reverse(int i, int j){
        for(int k = i ; k <= i+2 ; k++){
            for(int l = j; l <= j+2 ; l++){
                a[k][l] = a[k][l] == 1 ? 0 : 1;
            }
        }
    }
    public static boolean same(){
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
