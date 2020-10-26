import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.SQLType;

public class test {
    public static void main(String[] args)throws Exception{
        BufferedReader bf = new BufferedReader(new FileReader(new File("data.txt")));

        int numOfAllPlayers = Integer.parseInt(bf.readLine());
        int numOfQuickPlayers = Integer.parseInt(bf.readLine());
        String[] strTmp = bf.readLine().split(" ");
        char[] namesOfQuickPlayers = new char[numOfQuickPlayers];
        for(int i = 0 ; i < numOfQuickPlayers; i ++){
            namesOfQuickPlayers[i] = strTmp[i].charAt(0);
        }
        int numOfGames = Integer.parseInt(bf.readLine());
        String [] strArr = bf.readLine().split(" ");
        int[] numOfMovesPerGame = new int[numOfGames];
        for(int i = 0; i < numOfGames; i ++){
            numOfMovesPerGame[i] = Integer.parseInt(strArr[i]);
        }
        solution(numOfAllPlayers,numOfQuickPlayers,namesOfQuickPlayers,numOfGames,numOfMovesPerGame);
    }
    public static void solution(int numOfAllPlayers, int numOfQuickPlayers,char[] namesOfQuickPlayers,int numOfGames, int[] numOfMovesPerGame){
        char tagger = 'A';
        char[] players = new char[numOfAllPlayers-1];
        int[] playerCnt = new int[numOfAllPlayers];
        playerCnt[tagger-'A']++;
        for(int i = 1 ; i < numOfAllPlayers; i ++){
            players[i-1] = (char)(tagger+i);
        }
        int current = 0;
        int lastIdx = numOfAllPlayers-2;
        for(int i = 0 ; i < numOfGames; i ++){
            int round = numOfMovesPerGame[i];
            current += round;
            if(current < 0){
                current = lastIdx + current + 1;
            }
            if(current > lastIdx){
                current = current%( lastIdx+1 );
            }

            boolean change = true;
            for(char target : namesOfQuickPlayers){
                if(target == players[current]){
                    change = false;
                }
            }
            if(change){
                char tmp = tagger;
                tagger = players[current];
                players[current] = tmp;
            }
            playerCnt[tagger-'A'] ++;
        }

        for(int i = 0; i < players.length ; i ++){
            System.out.println(players[i]+" "+playerCnt[players[i]-'A']);
        }
        System.out.println(tagger+" "+playerCnt[tagger-'A']);
    }
}
