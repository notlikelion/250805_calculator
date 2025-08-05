import calculator.ArrayCalculator;
import calculator.Calculator;
import calculator.ListCalculator;
import calculator.MapCalculator;

public class Application {
    // 진입점 -> 실행을 한다. 실행을 하면 이 친구를 찾아요.
    public static void main(String[] args) {
        // public -> 접근제어자 : 누구든 오세요 저를 쓰세요
        // static -> 이 클래스로 객체를 만들지 않아도, 별도 메모리에 있기 때문에
        // 자체적으로 실행 혹은 조회가 가능하다
        // void -> 메서드 => 반환하는 '값' => void (= null과 유사한 뜻)
        // => 나는 결과값이 없어 그러니까 나를 변수에 넣지마. 혹은 그냥 사용만 해.
        // main -> 메서드명. (...) => 매개변수(parameter) => 외부에서 주입받을 변수.
        // 값 = 인자, 인수 (argument).
        System.out.println("계산기가 실행되었습니다"); // 메서드
        // System -> 클래스. out. static 필드(멤버변수). println 메서드
        // -> 터미널(콘솔) => 출력.
//        Calculator cal = new Calculator();
        // 이거 안 됨? -> 추상클래스는 상속이나 타입 지정을 위해서 만들어진 거라 new를 통해서 생성 X
        // => 아직 미구현인 메서드들이 있어서...
        // 업캐스팅 -> Calculator(부모, 수퍼클래스) => ArrayCalculator(자식, 서브클래스)
//        Calculator cal = (Calculator) new ArrayCalculator();
        Calculator cal = new ArrayCalculator();
//        Calculator cal = new ListCalculator();
//        Calculator cal = new MapCalculator();
        try {
            // 메서드가 실행된다는 보장?
            int result = cal.calculate(2, 3, "+");
            System.out.println(result);
        } catch (Exception e) {
            System.err.println(e.getMessage()); // 그냥 에러 메시지
//            System.err.println(e.getStackTrace()); // 자세하게 모든 과정을 서술한 에러
        }

    }
}
