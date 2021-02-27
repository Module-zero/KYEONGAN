import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q2021SOMA3 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] str = bf.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int e = Integer.parseInt(str[2]);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(e);
        String[] num = bf.readLine().split(" ");
        for(int i = 0 ; i < n; i ++){
            list.add(Integer.parseInt(num[i]));
        }
        Collections.sort(list);
        int idx = list.indexOf(e);
        int r = idx+1;
        int l = idx-1;
        int cnt = 0;
        int rCur = 0;
        int lCur = 0;
        while(cnt < m){
            int lGap = Integer.MAX_VALUE;
            int rGap = Integer.MAX_VALUE;
            if(l >= 0 ){
                lGap = e - list.get(l);
            }
            if( r < list.size()){
                rGap = list.get(r) - e;
            }
            if(rGap > lGap){
                l --;
                lCur = lGap;
            }
            else{
                r ++;
                rCur = rGap;
            }
            cnt ++;
        }
        System.out.println(rCur+lCur);
    }
}
