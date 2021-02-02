import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q16953 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        long A,B;

        String[] str = bf.readLine().split(" ");
        A = Integer.parseInt(str[0]);
        B = Integer.parseInt(str[1]);
        if( A == B){
            System.out.println(1);
            return ;
        }
        LinkedList<long[]> queue = new LinkedList<>();
        Map<Long,Long> check = new TreeMap();
        queue.add(new long[]{A,1});
        check.put(A,(long)1);
        while(!queue.isEmpty()){
            long[] idx = queue.remove();
            long num = idx[0];
            long cnt = idx[1]+1;
            if(num > B)continue;
            long dNum = num * 2;
            if(check.containsKey(dNum) && check.get(dNum) < cnt)continue;
            check.put(dNum,cnt);
            if(dNum != B){
                queue.add(new long[]{dNum,cnt});
            }

            long oneNum = num * 10 + 1;
            if(check.containsKey(oneNum) && check.get(oneNum) < cnt) continue;
            check.put(oneNum,cnt);
            if(oneNum != B){
                queue.add(new long[]{oneNum,cnt});
            }

        }
        if(check.containsKey(B)) {
            System.out.println(check.get(B));
        }
        else{
            System.out.println(-1);
        }
    }


}
