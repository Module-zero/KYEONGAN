import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
 // 틀림 다시 생각해보기

public class Q9874 {
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int ans = 0;
        for(int i = 0 ; i < n ; i ++){
            String[] init = bf.readLine().split(" ");
            int m = Integer.parseInt(init[1]);
            int a = -1;
            if(map.containsKey(m)){
                a = map.get(m);
            }
            map.put(m,a+1);
            ans += (a+1);
        }
        System.out.println(ans);
    }
}
