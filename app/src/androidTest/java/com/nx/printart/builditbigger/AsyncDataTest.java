package com.nx.printart.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AsyncDataTest {
    @Test
    public void asyncTest1() throws InterruptedException {
        //pass
        FetchJokeAsync task = new FetchJokeAsync();
        task.execute("http://api.icndb.com/jokes/random");
        TimeUnit.SECONDS.sleep(3);
        Assert.assertNotNull(task.getJoke());

    }
    @Test
    public void asyncTest2() throws InterruptedException {
        //fail
        FetchJokeAsync task = new FetchJokeAsync();
        task.execute("http://api.icndb.com/jo/random");
        TimeUnit.SECONDS.sleep(3);
        Assert.assertNotNull(task.getJoke());

    }
}
