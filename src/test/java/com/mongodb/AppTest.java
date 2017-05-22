package com.mongodb;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private static Logger LOG = Logger.getLogger(AppTest.class.getName());


    /**
     *
     */
    @Test
    public void runTest() {
        LOG.info("Starting Test...");

        new SimpleLoad();

        LOG.info("Ending Test...");
    }
}
