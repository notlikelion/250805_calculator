package calculator;

// abstract -> 이걸 new할 수가 없다
// 1. 추상메서드(abstract 메서드)를 포함시켜서 이걸 상속 받는 클래스로 세부구현
// 2. 타입으로만 쓰겠다
public abstract class Calculator implements ICalculator {
    // abstract class + interface => 구현 책임이 최종 Calculator


    @Override
    public int calculate(int num1, int num2, String operator) throws Exception {
        // 캐스팅 (변환하려고 하는 타입) -> 관련 타입이면 바꿔줌
        // int - double 숫자 계열 -> (...)
        // double 소수점 -> int 날아감.
        return (int) calculate((double) num1, (double) num2, operator);
    }

    @Override
    public double calculate(double num1, double num2, String operator) throws Exception {
        switch (operator) {
            case "+":
                return num1 + num2; // break가 별도로 필요 없음.
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                // 지원 안하는 연산자가 들어오면 어째요?
                throw new Exception("지원하지 않는 연산자입니다!");
        }
    }
}
