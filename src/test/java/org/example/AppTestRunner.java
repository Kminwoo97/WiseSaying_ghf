package org.example;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String cmd){

        //마지막에 "종료" 명령어 추가
        cmd += "\n종료";

        //여러 줄 입력 받기 -> """ 더블쿼터 3개
        Scanner sc = TestUtil.genScanner(cmd);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        //종료 명령어를 입력한 Scanner를 App.class에 전달해서 run()함수 실행한다.
        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}
