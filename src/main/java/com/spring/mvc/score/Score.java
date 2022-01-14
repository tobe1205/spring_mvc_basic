package com.spring.mvc.score;


import lombok.*;

import java.util.Arrays;

@Getter @Setter @ToString
public class Score {
    //누적되는 순차번호를 만들기 위함
    private static int seq;

    // 클라이언트가 전달한 데이터
    private String name; //실명
    private String markName; /// 마킹된 이름
    private int kor, eng, math;


    //자체 생성 데이터
    private int stuNum; //학번
    private int total;  //총점
    private double average; //평균

    private Grade grade; // 학점

    public Score() {
        this.stuNum = ++seq;
    }
    public Score(String name,int kor,int eng,int math){ //클라이언트만 받는 값
        this();
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calcTotal();
//        changeMarkName();
        changeMarkName();

    }

    //총점과 평균을 구하는 메서드
    public void calcTotal() {
        this.total = this.kor + this.eng + this.math;
        this.average = Math.round(this.total / 3.0 * 100) / 100.0;

        if (average >= 90){
            grade = Grade.A;
        } else if(average >= 80){
            grade = Grade.B;
        } else if (average >= 70) {
            grade = Grade.C;
        } else if (average >= 60){
            grade = Grade.D;
        } else {
            grade = Grade.F;
        }

    }

    //이름 마킹 처리
    public void changeMarkName() {
        //성 추출
        String familyName = String.valueOf(this.name.charAt(0));
        //성을 제외한 이름 수
        int nameCount = name.length() - 1;
        for (int i = 0; i < nameCount; i++) {
            familyName += "*";
        }
        this.markName = familyName;

    }
    public void changeMarkName1(){
        char[] arr = new char[name.length()];
        for (int i = 0; i < name.length(); i++) {
            arr[i] = '*';
            arr[0] = name.charAt(0);
        }
        this.markName = new String(arr);
    }

}