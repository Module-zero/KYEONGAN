import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q16940 {
    static ArrayList<Integer>[] list ;
    static int[] answer ;
    static int ansNum = 0;
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int t = Integer.parseInt(bf.readLine());
        list = new ArrayList[t+1];
        for(int i = 0; i <= t; i ++){
            list[i] = new ArrayList<>();
        }
        answer = new int[t+1];
        for(int i = 1; i < t ; i ++){
            String[] strArr = bf.readLine().split(" ");
            list[Integer.parseInt(strArr[0])].add(Integer.parseInt(strArr[1]));
            list[Integer.parseInt(strArr[1])].add(Integer.parseInt(strArr[0]));
        }
        String[] strArr = bf.readLine().split(" ");
        for(int i = 0 ; i < t; i++){
            answer[i] = Integer.parseInt(strArr[i]);
        }
        if(answer[0] != 1){
            System.out.println(0);
            return;
        }
        
        int cnt = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[t+1];
        check[1] = true;
        queue.add(1);
        while(!queue.isEmpty()){
            int start = queue.remove();
            boolean[] tmpCheck = new boolean[t+1];
            for(int num : list[start]){
                tmpCheck[num] = true;
            }
            for(int i = 0 ; i < list[start].size() ; i ++){
                if (tmpCheck[answer[cnt]]) {
                    queue.add(answer[cnt]);
                    check[answer[cnt]] = true;
                    cnt++;
                }
            }
        }
        if(t != cnt){
            System.out.println(0);
            return ;
        }
        System.out.println(1);
    }
}
