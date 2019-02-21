package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

@RunWith(AndroidJUnit4.class)
public class EndpointsTest {

    Context context = InstrumentationRegistry.getContext();

    @Test
    public void testAsyncTask() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch latch = new CountDownLatch(1);
        EndpointsAsyncTask task = new EndpointsAsyncTask() {
            @Override
            protected void onPostExecute(String joke) {
                assertNotNull(joke);
                if (joke != null) {
                    assertTrue(joke.length() > 0);
                    latch.countDown();
                }
            }
        };
        task.execute(context);
        latch.await();
    }
}
