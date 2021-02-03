import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1806 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] str = bf.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int[] numArr = new int[N+2];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0 ; i < N ; i ++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0 ;
        int j = 0 ;
        int sum = numArr[0] ;
        int ans = N+1 ;
        while(i <= j && j < N){
            if(sum < S){
                j++;
                sum += numArr[j];
            }
            else if(sum == S){
                int tmp = j - i + 1;
                if(ans > tmp){
                    ans = tmp;
                }
                j++;
                sum += numArr[j];
            }
            else{
                int tmp = j - i + 1;
                if(ans > tmp){
                    ans = tmp;
                }
                sum -= numArr[i];
                i++;
            }
        }
        if( ans <= N )
            System.out.println(ans);
        else
            System.out.println(0);
    }
}
