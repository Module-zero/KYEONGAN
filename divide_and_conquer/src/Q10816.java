import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Q10816 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int n = Integer.parseInt(bf.readLine());
        String[] nStr = bf.readLine().split(" ");
        HashMap<Integer,Integer> nNum = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            int num = Integer.parseInt(nStr[i]);
            if(nNum.containsKey(num)){
                nNum.put(num,nNum.get(num)+1);
            }
            else{
                nNum.put(num,1);
            }
        }

        int m = Integer.parseInt(bf.readLine());
        String[] mStr = bf.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i ++){
            int target = Integer.parseInt(mStr[i]);
            if(nNum.containsKey(target)){
                sb.append(nNum.get(target)+" ");
            }
            else{
                sb.append(0+" ");
            }
        }
        System.out.println(sb);
    }
}
