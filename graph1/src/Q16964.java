import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Q16964 {
    static ArrayList<Integer>[] list ;
    static int t;
    static int[] answer;

    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        t = Integer.parseInt(bf.readLine());
        list = new ArrayList[t+1];
        for(int i = 0 ; i <= t ; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1 ; i < t; i ++){
            String[] strArr = bf.readLine().split(" ");
            list[Integer.parseInt(strArr[0])].add(Integer.parseInt(strArr[1]));
            list[Integer.parseInt(strArr[1])].add(Integer.parseInt(strArr[0]));
        }
        String[] strArr = bf.readLine().split(" ");
        answer = new int[t];
        int[] order = new int[t+1];
        for(int i = 0 ; i < t; i ++){
            answer[i] = Integer.parseInt(strArr[i]);
            order[answer[i]] = i;
        }
        if(answer[0] != 1){
            System.out.println(0);
            return ;
        }

        for(int i = 0 ; i <= t ; i ++){
            Collections.sort(list[i], (a, b) -> order[b] - order[a]);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int cnt = 1;
        boolean[] check = new boolean[t+1];

        while(!stack.isEmpty()){
            int start = stack.pop();
            if(start == answer[cnt]){
                cnt++;
            }
            check[start] = true;
            for(int i : list[start]){
                if(!check[i]){
                    stack.push(i);
                }
            }
        }
        if(cnt != t){
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }
}
