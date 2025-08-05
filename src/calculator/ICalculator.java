package calculator;

public interface ICalculator {
    // 숫자 1과 숫자 2를 연산자를 넣어서 연산 (정수)
    int calculate(int num1, int num2, String operator) throws Exception;

    // 숫자 1과 숫자 2를 연산자를 넣어서 연산 (실수)
    double calculate(double num1, double num2, String operator) throws Exception;

    // 같은 이름인데 나머지 요소들이 달라진다 -> 메서드 오버로딩
    // double calculate(double num1, double num2, String operator) throws Exception;
    // -> 메서드 시그니처 => 리턴하는 타입, 메서드명, (매개변수들) throws 체크해줘야할 예외들.
}
