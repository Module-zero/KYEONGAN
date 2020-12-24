import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Q1744 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        LinkedList<Integer> plus = new LinkedList<>();
        LinkedList<Integer> minus = new LinkedList<>();
        int answer = 0 ;
        for(int i = 0 ; i < n ; i ++){
            int tmp = Integer.parseInt(bf.readLine());
            if(tmp > 1){
                plus.push(tmp);
            }
            else if(tmp <= 0){
                minus.push(tmp);
            }
            else{
                answer += tmp;
            }
        }
        Collections.sort(minus);
        Collections.sort(plus, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        while(minus.size() > 1 && plus.size() > 1){
            int mFirst = minus.poll();
            int pFirst = plus.poll();
            int mSecond = minus.poll();
            int pSecond = plus.poll();
            answer += (mFirst * mSecond);
            answer += (pFirst * pSecond);
        }
        while(!minus.isEmpty()){
            int tmp = minus.poll();
            if(!minus.isEmpty()){
                int tmp2 = minus.poll();
                answer += (tmp * tmp2);
            }
            else{
                answer += tmp;
            }
        }
        while(!plus.isEmpty()){
            int tmp = plus.poll();
            if(!plus.isEmpty()){
                int tmp2 = plus.poll();
                answer += (tmp * tmp2);
            }
            else{
                answer += tmp;
            }
        }
        System.out.println(answer);
    }
}
//
