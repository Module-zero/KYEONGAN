import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Q16637 {
    static int[] number ;
    static char[] operator;
    static int n;
    static int max;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        String str = bf.readLine();
        if(n == 1){
            System.out.println(str);
            return;
        }
        number = new int[n/2+1];
        operator = new char[n/2];
        max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++){
            int tmp = str.charAt(i) - '0';
            if(0 <= tmp && tmp <= 9){
                number[i/2] = tmp;
            }
            else{
                tmp = tmp+'0';
                operator[i/2] = (char)tmp;
            }
        }
        select(new TreeSet<>(),0);
        System.out.println(max);
    }
    public static void select(TreeSet<Integer> ans, int cnt){
        if(cnt >= n/2){
            int[] num = Arrays.copyOf(number,n/2+1);
            char[] oper = Arrays.copyOf(operator,n/2);
//            print(num,oper);
            for(int i : ans){
                num[i] = calc(i,num,oper);
                num[i+1] = 0;
                oper[i] = '+';
            }
//            print(num,oper);
            int tmp = 0 ;
            for(int i = 0 ; i < n/2; i ++){
                tmp = calc(i,num,oper);
                num[i+1] = tmp;
            }
            max = Math.max(max,tmp);
            return;
        }
        ans.add(cnt);
        select(ans,cnt+2);
        ans.remove(cnt);
        select(ans,cnt+1);

    }
    public static int calc(int i ,int[] num,char[] oper){
        int tmp = 0 ;
        switch(oper[i]){
            case '+':
                tmp = num[i] + num[i+1];
                break;
            case '*':
                tmp = num[i] * num[i+1];
                break;
            case '-':
                tmp = num[i] - num[i+1];
                break;
            default:
                break;
        }
        return tmp;
    }
//    public static void print(int[] num, char[] oper){
//        for(int i = 0 ; i < n/2 ; i ++){
//            System.out.print(num[i]+" "+oper[i]+" ");
//        }
//        System.out.println(num[n/2]);
//    }
}
