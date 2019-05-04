package com.cys.ladder.view;

import com.cys.ladder.domain.endpoint.Endpoint;

import java.util.Scanner;

public class InputView {

    public static Endpoint inputEndPoint(){
        return new Endpoint(getScanner().nextLine(),getScanner().nextLine());
    }

    public static Integer inputHeight() { return getScanner().nextInt();}

    private static Scanner getScanner(){
        return new Scanner(System.in);
    }
}
