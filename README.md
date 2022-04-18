# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
* 미션은 기능요구사항,프로그래밍요구사항,과제진행요구사항 세가지로구성되어 있다.
* 특히 기능을 구현하기 전에 기능목록을 만들고,기능단위로 commit하는 방식으로 진행한다.
* 기능요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 기능 요구사항 정의
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
* 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
* 게임플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고,
* 컴퓨터는 게임플레이어가 입력한 숫자에 대한 결과를 출력한다.
* 이같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 프로그래밍 요구사항 정의
* 숫자야구게임을 실행하는 시작점은 src/main/java폴더의 baseball.Application의 main()이다.
* 숫자야구게임은 JDK 8버전에서 실행가능해야한다. JDK8에서 정상동작하지 않을 경우 0점처리한다.
* JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
* Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
* 프로그램 구현을 완료했을 때 src/test/java폴더의 baseball.ApplicationTest에 있는 2개의 TestCase가 성공해야한다. 테스트가 실패할 경우 0점처리한다. ApplicationTest에서 제공하는 2개의 TestCase는 숫자야구게임구현을 위한 최소한의 TestCase이다.
* 필수요구사항은 아니지만 제공하는 소스코드를 참고해 숫자야구게임을 위한 모든 TestCase를 추가해보는것도 테스트에 대한 좋은 연습이 될 수 있다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
* indent(인덴트,들여쓰기) depth를 2가 넘지 않도록 구현한다. (1까지만 허용한다.)
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트:indent(인덴트,들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 자바8에 추가된 stream api를 사용하지 않고 구현해야한다. 단,람다는 사용가능하다.
* else 예약어를 쓰지 않는다.
    * 힌트:if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  •함수(또는메소드)가 한가지 일만 잘하도록 구현한다.
* 도메인로직에 단위테스트를 구현해야한다. 단,UI(System.out,System.in,Scanner)로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    * 힌트는 MVC패턴 기반으로 구현한 후 View,Controller를 제외한 Model에 대한 단위테스트를 추가하는 것에 집중한다.
    * JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 사용법을 학습한 후 JUnit5 기반 단위테스트를 구현한다.

## 과제 제출 전 체크리스트 - 0점 방지
* 터미널에서 “java-version”을 실행해 자바8인지 확인한다. 또는 Eclipse,Intellij와 같은 IDE의 자바8로 실행하는지 확인한다.
* 터미널에서 Windows 사용자의 경우 “gradlew.batcleantest” 명령을 실행할 때 모든 테스트가 통과하는지 확인한다.
    * Mac 또는 Linux 사용자의 경우 “./gradlewcleantest” 명령 