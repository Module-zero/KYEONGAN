import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeSet;

public class Q1016 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] size = bf.readLine().split(" ");
        long min = Long.parseLong(size[0]);
        long max = Long.parseLong(size[1]);
        long sq_max = (long)Math.sqrt(max) + 1;
        LinkedList<Long> prime = new LinkedList<>();
        for(long i = 2 ; i <= sq_max ; i ++){
            long p = i*i;
            prime.add(p);
        }
        long ans = 0;
        TreeSet<Long> check = new TreeSet<>();
        for(long i :prime){
            long min_num = min;
            if(min_num % i != 0){
                min_num = ((min_num/i) + 1) * i;
            }
            for(long l = min_num; l <= max ; l+=i){
                if(check.contains(l))continue;
                check.add(l);
                ans++;
            }
        }

        System.out.println(max-min-ans+1);
    }
}
