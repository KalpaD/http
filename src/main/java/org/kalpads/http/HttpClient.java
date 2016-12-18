package org.kalpads.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by KDS on 12/18/2016.
 */
public class HttpClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);

    public static void main(String [] args) throws IOException {
        HttpClient httpClient = new HttpClient();
        httpClient.doGet();
    }

    public void doGet() throws IOException {
       String host = "httpbin.org";
       int port    = 80;

       Socket socket = new Socket(host, port);
       BufferedReader in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()
        ));

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("TRACE /html HTTP/1.0");
        out.println();
        out.flush();

        String line;

        while ((line = in.readLine())  != null) {
            System.out.println(line);
        }

        in.close();
        out.close();
    }
}
