import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q9465 {
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < t ; i ++){
            int n = Integer.parseInt(bf.readLine());
            int[][] dp = new int[n+1][2];
            String[] strArr1 = bf.readLine().split(" ");
            String[] strArr2 = bf.readLine().split(" ");
            for(int c = 1 ; c <= n ; c ++){
                dp[c][0] = Integer.parseInt(strArr1[c-1]);
                dp[c][1] = Integer.parseInt(strArr2[c-1]);
            }
            int[][] check = new int[n+1][2];
            check[1][0] = dp[1][0];
            check[1][1] = dp[1][1];
            for(int j = 2 ; j <= n ; j ++) {
                for (int c = 0; c < 2; c++) {
                    int max1 = dp[j][c%2] + check[j-1][(c+1)%2];
                    max1 = max1 > dp[j][c%2] + check[j-2][(c+1)%2] ? max1 : dp[j][c%2]+check[j-2][(c+1)%2];
                    max1 = max1 > check[j-1][c%2] ? max1 : check[j-1][c%2];
                    check[j][c%2] = max1;
                }
            }
            int answer = check[n][0] > check[n][1] ? check[n][0] : check[n][1];
            sb.append(answer+"\n");
        }
        System.out.println(sb);
    }
}
