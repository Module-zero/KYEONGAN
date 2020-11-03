import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Q16947 {
    static ArrayList<Integer>[] list ;
    static StringBuilder sb = new StringBuilder();
    static boolean[] findCheck;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        list = new ArrayList[n+1];
        findCheck = new boolean[n+1];
        for(int i = 0 ; i <= n ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i ++){
            String[] strArr = bf.readLine().split(" ");
            list[Integer.parseInt(strArr[0])].add(Integer.parseInt(strArr[1]));
            list[Integer.parseInt(strArr[1])].add(Integer.parseInt(strArr[0]));
        }
        for(int i = 1 ; i<= n  ; i++){
            dfs(new Stack<Integer>(),i,new boolean[n+1],i,1,-1);
        }
        System.out.println(sb);
    }
    public static void dfs(Stack<Integer> stack,int start, boolean[] check,int current,int cnt, int circular){
        if(cnt >= 3){
            for(int num : list[current]){
                if(num == start || (!stack.isEmpty() && num != stack.peek() && check[num] )){
                    circular = num;
                    break;
                }
            }
        }
        if(circular != -1) {
            int num = 0;
            if(circular != start){
                int target ;
                while(!stack.isEmpty()){
                    target = stack.pop();
                    if(target == circular){
                        break;
                    }
                }
                while(!stack.isEmpty()){
                    stack.pop();
                    num ++;
                }
            }
            sb.append(num + " ");
            findCheck[start] = true;
            return;
        }
        check[current] = true;
        for(int num : list[current]){
            if(!check[num]){
                stack.push(current);
                dfs(stack,start,check,num,cnt+1,circular);
                if(findCheck[start]){
                    return;
                }
                stack.pop();
            }
        }
    }
}
