import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q14888 {
    static int[] numArr;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    static int n;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        n = Integer.parseInt(bf.readLine());
        numArr = new int[n];
        String[] strArr = bf.readLine().split(" ");
        for(int i = 0 ; i < n ; i ++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        String[] opArr = bf.readLine().split(" ");
        int[] operNum = new int[4];
        for(int i = 0 ; i < 4 ; i ++){
            operNum[i] = Integer.parseInt(opArr[i]);
        }
        select(new int[n-1],operNum,0);
        System.out.println(maxValue);
        System.out.println(minValue);
    }
    public static void select(int[] answer,int[] operNum,int cnt){
        if(cnt >= n-1){
            int tmp = numArr[0];
            for(int i = 0 ; i < n-1 ; i ++){
                tmp = calc(tmp,numArr[i+1],answer[i]);
            }
            minValue = Math.min(tmp,minValue);
            maxValue = Math.max(tmp,maxValue);
            return;
        }
        for(int i = 0 ; i < 4 ; i ++){
            if(operNum[i] != 0){
                operNum[i]--;
                answer[cnt] = i;
                select(answer,operNum,cnt+1);
                operNum[i]++;
            }
        }
    }
    public static int calc(int a,int b,int op){

        switch(op){
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            default:
                return a / b;
        }
    }
}
