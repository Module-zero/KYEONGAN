import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

class Q2021SOMA1 {
    public static void main(String args[]) throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        String[] strArr = bf.readLine().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < strArr.length; i ++){
            map.put(strArr[i],i);
        }
        int k = Integer.parseInt(bf.readLine());
        ArrayList<Integer>[] list = new ArrayList[strArr.length];
        for(int i = 0 ; i < strArr.length; i ++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < k ; i ++){
            String[] str = bf.readLine().split(" ");
            int a = map.get(str[0]);
            int b = map.get(str[1]);
            list[a].add(b);
        }
        for(int i = 0 ; i < strArr.length; i ++){
            System.out.print(i+" : ");
            for(int aa : list[i]){
                System.out.print(aa+" ");
            }
            System.out.println(" ");
        }

    }
//    public static void solve(Stack<Integer> stack, int[] parent){
//        if()
//    }
}