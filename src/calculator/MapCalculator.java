package calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapCalculator extends Calculator {
    // key, value
    final private Map<String, String> historyMap; // 계산기 이력이 저장된 맵
    private boolean flag = false;

    // 1. 기존 코드와의 호환성
    // 2. 확장 가능성
    public MapCalculator() { // 기본
        this.historyMap = new HashMap<>();
//        this.historyMap = new TreeMap<>();
    }

    @Override
    public double calculate(double num1, double num2, String operator) throws Exception {
        double result = super.calculate(num1, num2, operator);
        if (!flag) {
//            String history = "%f %s %f = %f".formatted(num1, operator, num2, result);
            // 길이가 고정적이지 않은 자료구조(데이터타입)에 추가를 할 때
            // add, push, append -> 셋 중에 하나로 추가 (메서드)
            String key = "%f %s %f".formatted(num1, operator, num2);
            String value = "%f".formatted(result);
            historyMap.put(key, value);
        }
        return result;
        // Calculator -> 추상클래스 -> calculate(double...)
    }

    @Override
    public int calculate(int num1, int num2, String operator) throws Exception {
        flag = true; // 킵니다
        int result = super.calculate(num1, num2, operator);
        // %d 정수, %f 실수
        String key = "%d %s %d".formatted(num1, operator, num2);
        String value = "%d".formatted(result);
        historyMap.put(key, value);
        flag = false; // 끕니다
        return result;
        // Calculator -> 추상클래스 -> calculate(int...)
    }

    @Override
    public void showHistory() {
        System.out.println("[\uD83E\uDD79 지금까지의 계산 결과]");
        // keySet
        // values
        // entrySet -> Entry
        for (Map.Entry entry : historyMap.entrySet()) { // 자리를 미리 만들어놓지 않음. 그냥 순회하면 된다
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        // 길이를 length가 아니라 'size'로...
//        for (int i = 0; i < historyList.size(); i++) {
//            System.out.println(historyList.get(i));
//        }
    }
}
