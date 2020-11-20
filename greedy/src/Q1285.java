import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1285 {
    static int n;
    static int minNum ;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        minNum = n*n+1;
        char[][] coins = new char[n][n];
        for(int i = 0; i < n ; i ++){
            coins[i] = bf.readLine().toCharArray();
        }
        change(coins,0);
        System.out.println(minNum);
    }
    public static void change(char[][] coins,int cur){
        if(cur == n){
            int cnt = 0;
            for(char[] i : coins){
                int tmp = 0;
                for(char j : i){
                    if(j == 'T'){
                        tmp ++;
                    }
                }
                cnt = cnt + Math.min(tmp,n-tmp);
            }
            minNum = Math.min(cnt,minNum);
            return;
        }
        change(coins,cur+1);
        for(int i = 0 ; i < n; i ++){
            coins[i][cur] = coins[i][cur] == 'H'?'T':'H';
        }
        change(coins,cur+1);
    }
}
