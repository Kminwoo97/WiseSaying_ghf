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
    public void t1(){
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        Assertions.assertThat(cmd).isEqualTo("안녕");
    }
    @Test
    @DisplayName("프로그램 시작시 타이틀 출력 그리고 종료")
    void t2(){
        //System.out 에 한 화면출력 금지 시작
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");

        //그 동안 출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString();

        TestUtil.clearSetOutToByteArray(output);

        Assertions.assertThat(rs).isEqualTo("안녕");
    }
}
