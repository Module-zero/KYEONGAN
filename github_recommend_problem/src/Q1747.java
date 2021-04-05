import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1747 {
    static int MAX_NUM = 1003002;
    static boolean[] prime = new boolean[MAX_NUM];
    public static void main(String[ ]args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int res = makePrime(N);
        System.out.println(res);
    }
    public static int makePrime(int N){
        int ans = 1;
        prime[1] = true;
        for(int i = 2 ; i < MAX_NUM ; i ++){
            if(!prime[i]){
                for(int j = i+i; j < MAX_NUM ; j +=i){
                    prime[j] = true;
                }
                prime[i] = check(i);
                if(i >= N && !prime[i]){
                    ans = i;
                    break;
                }
            }
        }
        return ans;
    }
    public static boolean check(int num){
        String target = String.valueOf(num);
        int tLen = target.length();
        boolean odd = true;
        if(tLen%2 == 0){
            odd = false;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0 ;
        int lim = tLen / 2;
        while(i < lim){
            stack.push(target.charAt(i));
            i++;
        }
        if(odd){
            i ++;
        }
        boolean ans = false;
        while(!stack.isEmpty() && i < tLen){
            char tmp = stack.pop();
            if( tmp != target.charAt(i)){
                ans = true;
                break;
            }
            i++;
        }
        return ans;
    }
}
