import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2110 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        long n = Long.parseLong(str[0]);
        long m = Long.parseLong(str[1]);

        long[] wifi = new long[(int)n];
        long left = 1;
        long right = 0;
        for(int i = 0 ; i < n ; i ++){
            wifi[i] = Long.parseLong(bf.readLine());
            right = Math.max(right,wifi[i]);
        }
        Arrays.sort(wifi);
        long answer = 0;
        if(m-2 == 0){
            System.out.println(wifi[(int)(n-1)] - wifi[0]);
            return;
        }
        while(left<=right){
            long cnt = m-2;
            long mid = (left+right)/2;
            int start = 0;
            int end = (int)(n-1);
            for(int i = 1 ; i < n-1; i++){
                if(wifi[i] - wifi[start] >= mid && wifi[end] - wifi[i] >= mid){
                    cnt--;
                    start = i;
                }
                if(cnt <= 0)break;
            }
            if(cnt == 0){
                left = mid +1;
                if(answer < mid){
                    answer = mid;
                }
            }
            else{
                right = mid -1;
            }
        }
        System.out.println(answer);
    }
}
