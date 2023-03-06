package org.example;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class TestUtil {
    public static Scanner genScanner(String input){
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());

        return new Scanner(in);

    }
}
