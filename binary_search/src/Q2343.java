import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2343 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] movies = new int[n];
        String[] mov = bf.readLine().split(" ");
        int max = 0;
        for(int i = 0 ; i < n ; i ++){
            movies[i] = Integer.parseInt(mov[i]);
            max = Math.max(max,movies[i]);
        }
        int start = max;
        int end = max * n;
        int answer = end;
        while(start <= end){
            boolean success = true;
            int[] divide = new int[m];
            int mid = (start+end)/2;
            int cnt = 0;
            for(int i = 0 ; i < n ; i ++){
                if(divide[cnt] + movies[i] > mid){
                    cnt++;
                    if(cnt >= m){
                        success = false;
                        break;
                    }
                }
                divide[cnt]+=movies[i];
            }
            if(success){
                answer = Math.min(mid,answer);
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(answer);
    }
}
