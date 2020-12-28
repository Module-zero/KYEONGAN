import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q17088 {
    static int n;
    static int[] num;;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        if(n <= 2){
            System.out.println(0);
            return;
        }
        String[] str = bf.readLine().split(" ");
        num = new int[n];
        for(int i = 0 ; i < n ; i ++){
            num[i] = Integer.parseInt(str[i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = -1 ; i <= 1 ; i ++){
            for(int j = -1; j <= 1 ; j ++){
                int cnt = 0;
                if(j != 0){
                    cnt++;
                }
                int res = select((num[1]+i)-(num[0]+j),1,num[0]+j,cnt);
                if(min > res){
                    min = res;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
    }

    public static int select(int gap,int idx, int number, int cnt){
        if(idx >= n){
            return cnt;
        }
        for(int i = -1; i <= 1 ; i ++){
            if(((num[idx]+i) - number)== gap){
                if( i != 0){
                    cnt++;
                }
                return select(gap,idx+1,num[idx]+i,cnt);
            }
        }
        return Integer.MAX_VALUE;
    }
}
