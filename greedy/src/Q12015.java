import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 이분탐색을 이용해서 문제를 해결한다.
public class Q12015 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        int[] num = new int[n];
        String[] str = bf. readLine().split(" ");
        for(int i = 0 ; i < n ; i ++){
            num[i]=Integer.parseInt(str[i]);
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(num[0]);
        for(int i = 1 ; i < n ; i ++){
            int top = answer.get(answer.size()-1);
            int target = num[i];
            if(target > top){
                answer.add(num[i]);
            }
            else{
                int start = 0 ;
                int end = answer.size()-1;
                while(start < end){
                    int mid = (start+end)/2;
                    if(answer.get(mid) >= target){
                        end = mid;
                    }
                    else{
                        start = mid+1;
                    }
                }
                answer.set(end,target);
            }
        }
        System.out.println(answer.size());
    }
}
