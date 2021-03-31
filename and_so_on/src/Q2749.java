import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q2749 {
    static Map<Long,Long> dp;
    static int MOD = 1000000;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(bf.readLine());
        dp = new HashMap<>();
        System.out.println(foo(N));
    }
    public static long foo(Long n ){
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        if( n == 3 ){
            return 2;
        }
        else if( n == 2 || n == 1){
            return 1;
        }
        else if( n == 0){
            return 0;
        }
        else {
            if(!dp.containsKey(n-(n/2)+1)){
                long num = foo(n-(n/2)+1) % MOD;
                dp.put(n-(n/2)+1,num);
            }
            if(!dp.containsKey(n/2)){
                long num = foo(n/2) % MOD;
                dp.put(n/2, num);
            }
            if( n%2 != 0){
                if(!dp.containsKey(n-(n/2))){
                    long num = foo(n-(n/2)) % MOD;
                    dp.put(n-(n/2),num);
                }
            }
            if(!dp.containsKey((n/2)-1)){
                long num = foo((n/2)-1) % MOD;
                dp.put((n/2)-1, num);
            }
            return (((dp.get(n/2)*dp.get(n-(n/2)+1)) % MOD)+((dp.get((n/2)-1)*dp.get(n-(n/2)))%MOD))%MOD;
        }
    }
}
