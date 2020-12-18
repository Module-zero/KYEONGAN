import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Q10815 {
    public static void main(String[] args)throws Exception{
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int have = Integer.parseInt(bf.readLine());
        int[] haveCards = new int[have];
        String[] haveStr = bf.readLine().split(" ");
        for(int i = 0 ; i < have ; i++){
            haveCards[i] = Integer.parseInt(haveStr[i]);
        }
        Arrays.sort(haveCards);

        int cmpNum = Integer.parseInt(bf.readLine());
        String[] cmpStr = bf.readLine().split(" ");
        int[] cmpCard = new int[cmpNum];
        for(int i = 0 ; i < cmpNum ; i ++){
            cmpCard[i] = Integer.parseInt(cmpStr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < cmpNum ; i ++){
            int target = cmpCard[i];
            int left = 0;
            int right = have-1;
            boolean arrive = false;
            while(left <= right){
                int mid = (left + right)/2;
                if(target > haveCards[mid]){
                    left = mid+1;
                }
                else if(target < haveCards[mid]){
                    right = mid-1;
                }
                else{
                    arrive = true;
                    break;
                }
            }
            if(arrive){
                sb.append(1+" ");
            }
            else{
                sb.append(0+" ");
            }
        }
        System.out.println(sb);
    }
}
