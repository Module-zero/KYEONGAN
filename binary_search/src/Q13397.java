import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q13397 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] numArr = new int[n];
        String[] numStr = bf.readLine().split(" ");
        int max = 0;
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(numStr[i]);
            max = Math.max(max,numArr[i]);
        }

        int left = 0;
        int right = max;
        int answer = max;
        while(left <= right){
            int cnt = 1;
            int mid = (left+right)/2;
            int maxValue = numArr[0];
            int minValue = numArr[0];
            for(int i = 0 ; i < n ; i ++){
                maxValue = Math.max(maxValue,numArr[i]);
                minValue = Math.min(minValue,numArr[i]);
                if(maxValue - minValue > mid){
                    cnt++;
                    minValue = numArr[i];
                    maxValue = numArr[i];
                }
            }
            if(cnt <= m){
                answer = Math.min(answer,mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
