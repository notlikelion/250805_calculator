package calculator;

public class ArrayCalculator extends Calculator {
    final private String[] historyArr; // 계산기 이력이 저장된 배열
    private int head = 0; // 어디까지 왔는지.
    private boolean flag = false;

    // 1. 기존 코드와의 호환성
    // 2. 확장 가능성
    public ArrayCalculator() { // 기본
        this.historyArr = new String[20];
        // {null, null, ...}
    }

    public ArrayCalculator(int size) { // 바꾸고 싶으면
        this.historyArr = new String[size];
        // 배열은 길이를 입력해줘야함.
        // ? -> 우리가 설정한 길이
    }

    @Override
    public double calculate(double num1, double num2, String operator) throws Exception {
        System.out.println("ArrayCalculator Double");
        double result = super.calculate(num1, num2, operator);
        if (!flag) {
            if (historyArr.length <= head) {
                throw new Exception("이력 배열 길이보다 지금까지의 히스토리가 깁니다");
            }
            historyArr[head++] = "%f %s %f = %f".formatted(num1, operator, num2, result);
        }
        return result;
        // Calculator -> 추상클래스 -> calculate(double...)
    }

    @Override
    public int calculate(int num1, int num2, String operator) throws Exception {
        System.out.println("ArrayCalculator INT");
        flag = true; // 킵니다
        int result = super.calculate(num1, num2, operator);
        // %d 정수, %f 실수
        if (historyArr.length <= head) {
            throw new Exception("이력 배열 길이보다 지금까지의 히스토리가 깁니다");
        }
        historyArr[head++] = "%d %s %d = %d".formatted(num1, operator, num2, result);
        flag = false; // 끕니다
        return result;
        // Calculator -> 추상클래스 -> calculate(int...)
    }

    @Override
    public void showHistory() {
        System.out.println("[\uD83E\uDD79 지금까지의 계산 결과]");
        for (String s : historyArr) {
            if (s == null) {
                return; // break;
            }
            System.out.println(s);
        }
    }
}
