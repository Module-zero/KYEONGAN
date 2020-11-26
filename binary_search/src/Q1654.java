import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q1654 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        long[] line = new long[n];
        long max = 0;
        for(int i = 0 ; i < n ; i ++){
            line[i] = Integer.parseInt(bf.readLine());
            max = Math.max(line[i],max);
        }
        long left = 1;
        long answer = 0;
        long right = max;
        while(left <= right){
            System.out.println(left+","+right);
            long mid = (left+right)/2;
            long cnt = 0;
            for(int i = 0 ; i < n ; i ++){
                cnt = cnt + (line[i]/mid);
            }
            if(cnt >= k){
                left = mid+1;
                answer = Math.max(answer,mid);
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
