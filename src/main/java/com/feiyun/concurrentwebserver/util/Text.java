package com.feiyun.concurrentwebserver.util;

public class Text {

    public String getCRLF() {
        return CRLF;
    }

    public String getHtml() {
        return html;
    }

    public String getResponse() {
        return response;
    }

    private final String html = "<html> <head><title>Simple Java HTTP Server </title></head>" +
            "<body><h1>This page is served by my simple Java HTTP server, LOL!</h1>" +
            "</body></html>";
    private final String CRLF = "\r\n"; // 13, 10 (ASCII)

    private final String response =
            "HTTP/1.1 200 OK" + CRLF +// status line : HTTP VERSION RESPONSE_CODE RESPONSE_MESSAGE
                    "Content-Length: " + html.getBytes().length + CRLF +  // HEADER
                    CRLF +
                    html +
                    CRLF + CRLF;
}
