import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class test2 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int day = Integer.parseInt(bf.readLine());
        int width = Integer.parseInt(bf.readLine());
        int[][] block = new int[day][width];
        for(int i = 0 ; i < day ; i ++){
            String[] strArr = bf.readLine().split(" ");
            for(int j = 0; j < width; j ++){
                block[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        solution(day,width,block);
    }
    public static void solution(int day, int width, int[][] blocks){

        int answer = 0;
        int[] dp = new int[width];
        for(int k = 0 ; k < day; k ++) {
            int start = 0;
            int end = width-1;
            int i = start;
            int j = end;
            for(int z = 0 ; z < width ; z ++){
                dp[z] += blocks[k][z];
                System.out.print(dp[z]+" ");
            }
            System.out.println("");
            while(i < j){
                if(dp[start] < dp[end]) {
                    while (++i < j && dp[i] < dp[start]) ;
                    while (j > i && dp[j] < dp[end]) { --j;}
                }
                else{
                    while (--j > i && dp[j] < dp[end]) ;
                    while (i < j && dp[i] < dp[start]){ ++i;}
                }
                System.out.println(dp[i]+", "+dp[j]);
                for(int l = start+1 ; l < i; l++) {
                    int cement = dp[start] - dp[l];
                    int tmp = cement + dp[l];
                    tmp = Math.min(tmp, dp[i]);
                    System.out.print(cement+" ");
                    answer += cement;
                    dp[l] = tmp;
                }
                for(int m = end-1 ; m > j; m--){
                    int cement = dp[end] - dp[m];
                    int tmp =  cement + dp[m];
                    tmp = Math.min(tmp,dp[j]);
                    System.out.print(cement+" ");
                    answer += cement;
                    dp[m] = tmp;
                }
                start = i;
                end = j;
            }
            System.out.println(k +" : "+answer);
        }
        System.out.println(answer);
    }
}
