import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q10971 {
    static int[][] city;
    static int n;
    static int minValue;
    public static void main(String[] args) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        city = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            String[] strArr = bf.readLine().split(" ");
            for(int j = 0 ; j < n ; j ++){
                city[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        minValue = Integer.MAX_VALUE;
        select(new int[n+1],new boolean[n],0);
        System.out.println(minValue);
    }
    public static void select(int[] answer, boolean[] check, int cnt){
        if(cnt >= n){
            answer[n] = answer[0];
            int tmp = 0;
            for(int i = 0 ; i < n ;i ++){
                if(city[answer[i]][answer[i+1]] == 0){
                    return;
                }
                tmp += city[answer[i]][answer[i+1]];
            }
            minValue = Math.min(tmp,minValue);
            return;
        }
        for(int i = 0 ; i < n ; i ++){
            if(!check[i]){
                check[i] = true;
                answer[cnt] = i;
                select(answer,check,cnt+1);
                check[i] = false;
            }
        }
    }

}
