package com.feiyun.concurrentwebserver.core;

import com.feiyun.concurrentwebserver.util.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread{
    private Socket socket;

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        handleClient(socket);
    }
    private void handleClient(Socket socket) {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
        ) {
            // get HTML response
            Text txt = new Text();
            outputStream.write(txt.getResponse().getBytes());
        } catch (IOException e) {
            LOGGER.error("Problem with communication", e);
        }
        LOGGER.info("Connection Processing Complete");
    }
}
