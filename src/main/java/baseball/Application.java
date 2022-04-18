package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static com.sun.corba.se.impl.activation.ServerMain.printResult;

public class Application {
    public static void main(String[] args) {

        // 게임 재도전 여부에 대한 응답 값
        boolean again = true;

        while(again) {
            try{
                doGame();
            } catch(IllegalArgumentException e){
                System.out.println("1 또는 2를 입력하세요.\n게임을 새로 시작하려면 1, 종료하려면 2.");
            } catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            // 게임 재시작 여부 확인
            again = playAgain();
        }

        System.out.println("게임이 종료되었습니다.");
    }

    private static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer;
        answer = Console.readLine();

        if(answer.equals("1")){
            // 재시작
            return true;
        }
        // 2 입력 시, 종료
        if(answer.equals("2")){
            //정상종료
            return false;
        }

        // 그 외의 경우(사용자 입력값이 1,2가 아닌 경우), false 반환 대신, IAException 발생
        throw new IllegalArgumentException();

    }

    public static void doGame(){
        List<Integer> arrComputer = new ArrayList<>(3);    //컴퓨터 값(랜덤값) 저장 배열
        List<Integer> arrPlayer = new ArrayList<>(3);  //사용자 값(입력값) 저장 배열

        // 3자리 랜덤 숫자 생성(camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange())
        for (int i=0; i<3; i++){
            arrComputer.add(pickNumberInRange(0,9));
        }

        int strike; //스트라이크 갯수
        int ball; //볼 갯수
        int strikeAndBall; //스트라이크+볼 갯수
        // strikeAndBall = 0 인 경우, 낫싱 힌트

        String result = ""; //아웃(3 스트라이크) 체크를 위한 변수

        // TODO: while문 수행하는 부분을 별도 함수로 분리
        // 3 스트라이크인 경우, 반복 중지
        while(!result.equals("3스트라이크")){
            System.out.println("숫자를 입력해주세요 : ");
            String userNum;
            userNum = Console.readLine();

            // 사용자 입력값이 3자리가 아닌 경우, illegal 처리
            try{
                checkUserNum(userNum);
            } catch(IllegalArgumentException e){
                System.out.println("3자리 숫자를 입력해주세요.");
            }

            // 사용자 입력값의 자릿수를 배열에 저장
            arrPlayer = saveUserNum(userNum, arrPlayer);

            // 스트라이크, 볼, 아웃(낫싱) 결정
            strikeAndBall = countStrikeAndBall(arrComputer, arrPlayer);
            strike = countStrike(arrComputer, arrPlayer);
            ball = strikeAndBall-strike;

            // 결과 출력
            result = printResult(strikeAndBall, strike, ball);
            System.out.println(result);
        }

    }

    private static String printResult(int strikeAndBall, int strike, int ball) {
        if(strikeAndBall==0){
            return "낫싱";
        }
        if(strike==0){
            return ball+"볼";
        }
        if(ball==0){
            return strike+"스트라이크";
        }
        return ball+"볼 "+strike+"스트라이크";
    }

    public static void checkUserNum(String playerNum){
        // TODO: 사용자 입력 값이 숫자가 아닌 경우, illegal 처리

        // 사용자 입력 값이 3자리가 아닌 경우, illegal 처리
        if(playerNum.length() != 3){
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }

    }

    public static List<Integer> saveUserNum(String userNum, List<Integer> arrPlayer){
        for(int i=0; i<arrPlayer.size(); i++){
            arrPlayer.add(userNum.charAt(i)-48);
        }
        return arrPlayer;
    }

    public static int countStrike(List<Integer> arrComputer, List<Integer> arrPlayer){
        int result = 0;
        for(int i=0; i<arrPlayer.size(); i++){
            result = countSameNumPosition(result, arrComputer, arrPlayer, i);
        }
        return result;
    }
    public static int countSameNumPosition(int result, List<Integer> arrComputer, List<Integer> arrPlayer, int i){
        if(arrComputer.get(i).equals(arrPlayer.get(i))){
            result+=1;
        }
        return result;
    }

    public static int countStrikeAndBall(List<Integer> arrComputer, List<Integer> arrPlayer){
        int result = 0;
        for (Integer integer : arrPlayer) {
            result = countSameNum(result, arrComputer, integer);
        }
        return result;
    }

    public static int countSameNum(int result, List<Integer> arrComputer, int playerNum){
        if(arrComputer.contains(playerNum)){
            result+=1;
        }
        return result;
    }
}
