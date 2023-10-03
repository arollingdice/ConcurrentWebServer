package com.feiyun.concurrentwebserver;

import com.feiyun.concurrentwebserver.config.Configuration;
import com.feiyun.concurrentwebserver.config.ConfigurationManager;
import com.feiyun.concurrentwebserver.core.ServerListenerThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *  Driver Class for the Http server
 */
public class HttpServer {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {
        LOGGER.info("Server Started");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        LOGGER.info("Using Port: " + conf.getPort());
        LOGGER.info("Using WebRoot: " + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot()) ;
            serverListenerThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
