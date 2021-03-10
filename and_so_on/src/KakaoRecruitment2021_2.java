import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class KakaoRecruitment2021_2 {
    static ArrayList<String> check;
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        String[] orders = bf.readLine().split(" ");
        String[] courseTmp = bf.readLine().split(" ");
        int[] course = new int[courseTmp.length];
        for(int i = 0 ; i < courseTmp.length; i ++){
            course[i] = Integer.parseInt(courseTmp[i]);
        }
        for( String ans : solution(orders,course)){
            System.out.println(ans);
        }
    }
    public static String[] solution(String[] orders, int[] course){
        String[] answer = {};
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0 ; i < orders.length ; i ++){
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            String str = new String(tmp);
            orders[i] = str;
        }
        for(int T = 0 ; T < course.length ; T ++){
            int t_case = course[T];
            check = new ArrayList<>();
            for(int o = 0 ; o < orders.length; o ++) {
                select(orders[o], 0,0,t_case, new int[t_case]);
            }
            int max = 2;
            Stack<String> result = new Stack<>();
            for(String c : check) {
                int cnt = 0;
                for (int i = 0; i < orders.length; i++) {
                    int t = 0;
                    for(int j = 0 ; j < orders[i].length(); j ++){
                        if(orders[i].charAt(j) == c.charAt(t)){
                            t++;
                        }
                        if(t == t_case){
                            break;
                        }
                    }
                    if(t == t_case){
                        cnt ++;
                    }
                }
                if(cnt >= max){
                    if(cnt > max) {
                        max = cnt;
                        while (!result.isEmpty()) {
                            result.pop();
                        }
                    }
                    result.push(c);
                }
            }
            while(!result.isEmpty()) {
                res.add(result.pop());
            }
        }
        Collections.sort(res);
        answer = res.toArray(answer);
        return answer;
    }
    public static void select(String target, int idx, int cnt, int t_case, int[] ans){
        if(cnt == t_case){
            StringBuilder sb = new StringBuilder();
            for(int a : ans){
                sb.append(target.charAt(a));
            }
            if(!check.contains(sb.toString())) {
                check.add(sb.toString());
            }
            return;
        }
        if(idx >= target.length()){
            return ;
        }
        select(target,idx+1,cnt,t_case,ans);
        ans[cnt] = idx;
        select(target,idx+1,cnt+1,t_case,ans);
    }
}
