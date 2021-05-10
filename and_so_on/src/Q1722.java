import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1722 {
    static long[] factorial ;
    static int N ;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        factorial = new long[N+1];
        makeFactorial();
        String[] str = bf.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        if(Integer.parseInt(str[0]) == 1){
            makeStringArr(list);
            long target = Long.parseLong(str[1]);
            for(int i = 1 ; i < N ; i ++){
                long tmp = target - 1;
                if(tmp < 0 ){
                    tmp *= -1;
                    target = 0;
                }
                int num = (int)(tmp/factorial[N-i]);
                sb.append(list.remove(num)).append(" ");
                if(target == (N-i+1)*factorial[N-i]) {
                    target = factorial[N-i];
                }
                else{
                    target %= factorial[N - i];
                }
            }
            sb.append(list.remove(0));
        }
        else{
            makeStringArr(list);
            int sum = 1;
            for(int i = 1 ; i < N ; i ++){
                int tmp = list.indexOf(Integer.valueOf(str[i]));
                sum += (tmp*factorial[N-i]);
            }
            sb.append(sum);
        }
        System.out.println(sb.toString());
    }
    public static void makeStringArr(LinkedList<Integer> list){
        for(int i = 1; i <= N ; i ++){
            list.add(i);
        }
    }
    public static void makeFactorial(){
        factorial[1] = 1;
        for(int i = 2 ; i <= N ; i ++){
            factorial[i] = factorial[i-1] * i;
        }
    }

}
