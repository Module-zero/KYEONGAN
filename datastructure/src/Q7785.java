import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q7785 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < n ; i ++){
            String[] str = bf.readLine().split(" ");
            String name = str[0];
            String status = str[1];
            if(status.equals("enter")){
                set.add(name);
            }
            else{
                set.remove(name);
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        for(String tmp : set){
            answer.add(tmp);
        }
        Collections.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String ans : answer){
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
