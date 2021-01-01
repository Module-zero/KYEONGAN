import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class B {
    static int ans;
    static String[] strArr;
    static TreeMap<String,Integer> list;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int T  = Integer.parseInt(bf.readLine());
        StringBuilder sb  = new StringBuilder();
        for(int t = 0 ; t < T ; t ++){
            int n = Integer.parseInt(bf.readLine());
            if(n >= 34){
                sb.append(0).append("\n");
                String tmp = bf.readLine();
                continue;
            }
            list = new TreeMap<>();
            strArr = new String[n];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            boolean zero = false;
            for(int i = 0 ; i < n ; i ++){
                String tmp = st.nextToken();
                if(!list.containsKey(tmp)){
                    list.put(tmp,0);
                }
                int val = list.get(tmp)+1;
                if(val >= 3){
                    zero = true;
                }
                list.put(tmp,val);
                strArr[i] = tmp;
            }
            if(zero){
                sb.append(0).append("\n");
                continue;
            }
            int[] answer = new int[3];
            ans = Integer.MAX_VALUE;
            solve(n,0,0,answer);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static void solve(int n,int idx,int select,int[] answer){
        if(select >= 3){
            int tmp = 0;
            tmp += calc(answer[0],answer[1]);
            tmp += calc(answer[1],answer[2]);
            tmp += calc(answer[2],answer[0]);
            ans = Math.min(ans,tmp);
            return;
        }
        if(idx >= n){
            return;
        }
        answer[select] = idx;
        solve(n,idx+1,select+1,answer);
        solve(n,idx+1,select,answer);
    }
    public static int calc(int a, int b){
        int dis = 0;
        for(int i = 0 ; i < 4 ; i ++){
            if(strArr[a].charAt(i) != strArr[b].charAt(i)){
                dis ++;
            }
        }
        return dis;
    }
}
