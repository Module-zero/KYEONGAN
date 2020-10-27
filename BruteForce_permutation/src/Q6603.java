import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.DoubleStream;

public class Q6603 {
    static ArrayList<String> list;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        list = new ArrayList<>();
        while(true){
            String[] strArr = bf.readLine().split(" ");
            if(strArr[0].equals("0")){
                break;
            }
            int n = Integer.parseInt(strArr[0]);
            int[] numArr = new int[n];
            for(int i = 0 ; i < n; i ++){
                numArr[i] = Integer.parseInt(strArr[i+1]);
            }
            select(numArr,new int[6],new boolean[n], 0,n,0);
            list.add("\n");
        }
        StringBuilder sb = new StringBuilder();
        for(String str : list){
            sb.append(str);
        }
        System.out.print(sb);
    }
    public static void select(int[] numArr,int[] answer, boolean[] check,int cnt,int n,int idx){
        if(cnt >= 6 || idx >= n){
            if(cnt >= 6) {
                String str = "";
                for (int num : answer) {
                    str += num + " ";
                }
                str += "\n";
                list.add(str);
            }
            return;
        }
        answer[cnt] = numArr[idx];
        select(numArr,answer,check,cnt+1,n,idx+1);
        select(numArr,answer,check,cnt,n,idx+1);
    }
}
