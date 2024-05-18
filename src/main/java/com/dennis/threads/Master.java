package com.dennis.threads;

import com.dennis.Init;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DennisMutethia
 */
public class Master {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            new Slave().run();
        }, 0, Integer.parseInt(Init.APPLICATION_PROPERTIES.getProperty("thread_refresh_secs")), TimeUnit.SECONDS);

    }
}
