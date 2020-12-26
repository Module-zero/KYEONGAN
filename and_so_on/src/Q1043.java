import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q1043 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader (new FileReader(new File("data.txt")));

        String[] tmp = bf.readLine().split(" ");
        int people = Integer.parseInt(tmp[0]);
        int party = Integer.parseInt(tmp[1]);
        ArrayList<Integer>[] graph = new ArrayList[people+1];

        for(int i = 1 ; i <= people ; i ++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] knowArr = new int[t]; // 아는사람 배열
        for(int i = 0 ; i < t ; i ++){
            knowArr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<String> partyArr = new Stack<>(); // 파티 참가 인원을 자정할 목적

        // 파티를 그래프 형태로 입력받는다.
        for(int i = 0 ; i < party ; i ++){
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            partyArr.push(str);
            int r = Integer.parseInt(strArr[0]);
            for(int j = 1; j < r ; j++){
                int target = Integer.parseInt(strArr[j]);
                for(int k = j+1 ; k <= r ; k ++){
                    int num = Integer.parseInt(strArr[k]);
                    graph[target].add(num);
                    graph[num].add(target);
                }
            }
        }

        boolean[] know = new boolean[people+1]; // 아는사람 및 알게된사람 배열
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < t ; i ++){
            int target = knowArr[i];
            if(know[target])continue;
            queue.add(target);
            know[target] = true;
            while(!queue.isEmpty()){
                int start = queue.poll();
                for(int j = 0 ; j < graph[start].size() ; j ++){
                    int num = graph[start].get(j);
                    if(know[num])continue;
                    know[num] = true;
                    queue.add(num);
                }
            }
        }
        int ans = 0;
        while(!partyArr.isEmpty()){
            String target = partyArr.pop();
            String[] targetArr = target.split(" ");
            boolean check = true;
            for(int i = 1 ; i < targetArr.length ; i ++){
                int n = Integer.parseInt(targetArr[i]);
                if(know[n]){
                    check = false;
                    break;
                }
            }
            if(check){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
