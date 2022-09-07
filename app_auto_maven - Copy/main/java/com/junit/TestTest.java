package com.junit;

import com.run.GeneralRun;
import org.junit.Test;

import java.net.MalformedURLException;

public class TestTest{
    @Test
    public void a() throws MalformedURLException, InterruptedException{
        GeneralRun gr = new GeneralRun();
        gr.runTest("127.0.0.1:5555",
                "danworkhoff@gmail.com",
                "Pipocandoo Filmes",
                "pipocando filmes",
                "http://127.0.0.1:4725/wd/hub");
    }

    @Test
    public void b() throws MalformedURLException, InterruptedException{
        GeneralRun gr = new GeneralRun();
        gr.runTest("127.0.0.1:5585",
                "juditeschimit@gmail.com",
                "Pipocandoo Filmes",
                "pipocando filmes",
                "http://127.0.0.1:4726/wd/hub");
    }
}

