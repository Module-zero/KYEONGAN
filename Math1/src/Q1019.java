import java.io.*;

public class Q1019 {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] answer = new int[10];
        int last = Integer.parseInt(bf.readLine());
        int dec = 1;
        int start = 1;
        // 페이지를 이동하면서 하나하나 카운트한다.
        // 시작 - 증가, 끝 - 감소 --> 두 페이지가 만나는 지점 종료
        // 만약 시작페이지의 일의자리가 0, 끝페이지의 일의자리가 9 일경우는 규칙이 있다.
        // 끝 페이지/10 - 시작 페이지/10 + 1 * 자릿수 = 0 - 9 의 의 개수
        // ex) 30 , 89 일 경우 8 - 3 + 1 = 6 * 1 => 1의자리에 있는 0 - 9 는 각각 6개씩
        //     3, 8 의 일의자리를 0, 9 즉 , 3->10 8 -> 9 를해야하지만 8 < 9 이므로
        //     감소를 하다가 3보다 작거나 같아질것이다.

        //     따라서 자릿수 = 10 이므로 8 - 3 는 10번.
        while(start <= last){
            while(last%10 != 9 && start <= last){
                calc(answer,last,dec);
                last --;
            }
            if(last < start)break;
            while(start%10 != 0 && start <= last){
                calc(answer,start,dec);
                start++;
            }
            start /= 10;
            last /= 10;
            for(int i = 0 ; i < 10 ; i ++){
                answer[i] += ((last - start) + 1) * dec;
            }
            dec *= 10;
        }

        for(int a : answer){
            System.out.print(a+" ");
        }
    }
    public static void calc(int[] answer, int num, int dec){
        while(num > 0){
            answer[num%10] += dec;
            num /= 10;
        }
    }
}
