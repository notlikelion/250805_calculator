package calculator;

// abstract -> 이걸 new할 수가 없다
// 1. 추상메서드(abstract 메서드)를 포함시켜서 이걸 상속 받는 클래스로 세부구현
// 2. 타입으로만 쓰겠다
public abstract class Calculator implements ICalculator {
    // abstract class + interface => 구현 책임이 최종 Calculator
}
