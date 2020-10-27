import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q1339 {
    static ArrayList<String> list;
    static LinkedHashMap<Character,Integer> map; // 각 문자를 담는 배열
    static char[] arr;
    static int maxValue;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));
        int n = Integer.parseInt(bf.readLine());
        map = new LinkedHashMap<>();
        list = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            String str = bf.readLine();
            list.add(str);
            char[] chArr = str.toCharArray();
            for(char ch : chArr){
                map.put(ch,0);
            }
        }
        arr = new char[map.size()];
        Iterator<Character> it = map.keySet().iterator();
        int i = 0;
        while(it.hasNext()){
            char ch = it.next();
            arr[i] = ch;
            i++;
        }
        select(new int[map.size()],new boolean[map.size()],0, map.size());
        System.out.println(maxValue);
    }
    public static void select(int[] answer , boolean[] check, int cnt, int max){
        if(cnt >= max){
            for(int i = 0 ; i < arr.length; i++){
                map.put(arr[answer[i]],9-i);
            }
            int tmpNum = 0;
            for(String str : list){
                String tmp = "";
                char[] chArr = str.toCharArray();
                for(int i = 0 ; i < chArr.length; i ++){
                    tmp += map.get(chArr[i]);
                }
                tmpNum += Integer.parseInt(tmp);
            }
            maxValue = Math.max(maxValue,tmpNum);
            return;
        }
        for(int i = 0 ; i < max ; i ++){
            if(!check[i]){
                check[i] = true;
                answer[cnt] = i;
                select(answer,check,cnt+1,max);
                check[i] = false;
            }
        }
    }
}
