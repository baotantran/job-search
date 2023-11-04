package com.sample;

public class Main {
    public static void main(String[] args) {
        JobBoard jobBoard = new JobBoard();
        jobBoard.loadURL("https://www.indeed.com/");
        jobBoard.inputTilteLocation("Test Engineer", "Seattle");
    }
}
