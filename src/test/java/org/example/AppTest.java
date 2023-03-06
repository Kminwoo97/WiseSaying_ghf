package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTest {

    //테스트 유틸 테스트 시작
    @Test
    @DisplayName("스캐너에 키보드가 아닌 문자열을 입력으로 설정")
    public void t1() {
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        Assertions.assertThat(cmd).isEqualTo("안녕");
    }

    @Test
    @DisplayName("프로그램 시작시 타이틀 출력 그리고 종료")
    void t2() {
        //System.out 에 한 화면출력 금지 시작
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");

        //그 동안 출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString();

        TestUtil.clearSetOutToByteArray(output);

        Assertions.assertThat(rs).isEqualTo("안녕");
    }
    //테스트 유틸 테스트 끝


    //앱 테스트 시사작
    @Test
    @DisplayName("프로그램 시작시 타이틀 출력 그리고 종료")
    void t3(){
        //종료 명령어 입력
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        //종료 명령어를 입력한 Scanner를 App.class에 전달해서 run()함수 실행한다.
        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        Assertions.assertThat(rs)
                .contains("== 명언 앱 ==")
                .contains("명령) ")
                .contains("프로그램이 종료되었습니다.")
                .doesNotContain("올바르지 않은 명령입니다.");
    }

    @Test
    @DisplayName("잘못된 명영어 입력에 대한 처리")
    void t4(){
//        //여러 줄 입력 받기 -> """ 더블쿼터 3개
//        Scanner sc = TestUtil.genScanner("""
//                종료2
//                """);
//        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
//
//        //종료 명령어를 입력한 Scanner를 App.class에 전달해서 run()함수 실행한다.
//        new App(sc).run();
//
//        String rs = output.toString();
//        TestUtil.clearSetOutToByteArray(output);

        String rs = AppTestRunner.run("종료2");

        Assertions.assertThat(rs)
                .contains("올바르지 않은 명령입니다.");
    }



}
