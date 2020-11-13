import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class Q14395 {
    static class History{
        long num;
        StringBuilder history;
        public History(long num, StringBuilder history){
            this.num = num;
            this.history = history;
        }
    }
    static long n = 1000000000L;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] strArr = bf.readLine().split(" ");
        long s = Long.parseLong(strArr[0]);
        long t = Long.parseLong(strArr[1]);
        if(s == t){
            System.out.println(0);
            return;
        }
        LinkedList<History> queue = new LinkedList<>();
        queue.add(new History(s,new StringBuilder()));
        Set<Long> check = new TreeSet<>();
        check.add(s);
        while(!queue.isEmpty()){
            History h = queue.remove();
            long number = h.num;
            if(number == t){
                System.out.println(h.history.toString());
                return;
            }
            if(0 <= number * number && number * number <= n){
                if(!check.contains(number*number)) {
                    check.add(number * number);
                    queue.add(new History(number * number, new StringBuilder(h.history).append("*")));
                }
            }
            if(0 <= number + number && number + number <= n){
                if(!check.contains(number+number)) {
                    check.add(number + number);
                    queue.add(new History(number + number, new StringBuilder(h.history).append("+")));
                }
            }
            if(0 <= number - number && number - number <= n){
                if(!check.contains(number-number)) {
                    check.add(number - number);
                    queue.add(new History(number - number, new StringBuilder(h.history).append("-")));
                }
            }
            if(number!=0 && 0 <= number / number && number / number <= n){
                if(!check.contains(number/number)) {
                    check.add(number / number);
                    queue.add(new History(number / number, new StringBuilder(h.history).append("/")));
                }
            }
        }
        System.out.println(-1);
    }
}
