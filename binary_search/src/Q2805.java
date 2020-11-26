import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q2805 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        long n = Long.parseLong(str[0]);
        long m = Long.parseLong(str[1]);
        long[] tree = new long[(int)n];
        String[] treeStr = bf.readLine().split(" ");
        long left = 0;
        long right = 0;
        for(int i = 0 ; i < n ; i ++){
            tree[i] = Long.parseLong(treeStr[i]);
            right = Math.max(tree[i],right);
        }
        long answer = 0 ;
        while(left <= right){
            long mid = (left+right)/2;
            long cnt = 0 ;
            for(int i = 0 ; i < n ; i ++){
                if(tree[i] > mid) {
                    cnt += (tree[i] - mid);
                }
            }
            if(cnt >= m){
                left =  mid + 1;
                if(answer < mid){
                    answer = mid;
                }
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
