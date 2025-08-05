package util;

// 커스텀 유틸리티 클래스
public class InputHandler {
    static public String[] handleInput(String input) throws Exception {
        String[] inputArr = input.split(" ");
        if (inputArr.length != 3) {
            throw new Exception("잘못된 입력");
        }
        return inputArr;
    }
}
