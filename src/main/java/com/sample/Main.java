package com.sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        JobBoard jobBoard = new JobBoard();
        jobBoard.loadURL("https://www.indeed.com/");
        jobBoard.inputTilteLocation("Test Engineer", "Seattle");
        List<JobData> jobDataList = jobBoard.getJobPost();
        jobBoard.clickElement();
        for (JobData job: jobDataList) {
            System.out.println(job);
        }


    }
}
