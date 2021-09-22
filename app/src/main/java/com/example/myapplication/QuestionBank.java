package com.example.myapplication;

public class QuestionBank {
    private String textQuestions [] = {
            "1. Apa Warna Bendera Indonesia ?",
            "2. Apa Warna Bendera Inggris ?",
            "3. Apa Warna Bendera India ?",
            "4. Apa Warna Bendera Incina ?",
    };
    private String multipleChoice [][] = {
            {"merah-putih","merah-hijau","merah-kuning","merah-pink"},
            {"merah-putih","merah-hijau","merah-kuning","merah-pink"},
            {"merah-putih","merah-hijau","merah-kuning","merah-pink"},
            {"merah-putih","merah-hijau","merah-kuning","merah-pink"},
    };
    private String mCorrectAnswer[] = {"merah-putih","merah-hijau","merah-kuning","merah-pink"};

    public int getLength(){return textQuestions.length;}

    public String getQuestion(int a){
        String question = textQuestions[a];
        return question;
    }
    public String getChoice(int index, int num){
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }
}
