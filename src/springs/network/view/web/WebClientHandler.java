package springs.network.view.web;

import java.io.*;
import java.net.*;
import java.util.*;

public class WebClientHandler extends Thread {

    Socket ClientSocket = null;
    BufferedReader Input = null;
    DataOutputStream Output = null;

    public WebClientHandler(Socket client) throws IOException {
        ClientSocket = client;
        Input = new BufferedReader(new InputStreamReader (ClientSocket.getInputStream()));
        Output = new DataOutputStream(ClientSocket.getOutputStream());
    }

    public void run() {
        try {
            go();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void go() throws Exception {

        System.out.println("client " + ClientSocket.getInetAddress() + ":"
                + ClientSocket.getPort() + " connected");

        StringBuffer outBuffer = new StringBuffer();
        outBuffer.append("<b>This is the Web Server's root end-point</b><br/>");
        outBuffer.append("Version 0.0.00.01<br/>");
        outBuffer.append("<br/>");

        String requestString = Input.readLine();

        outBuffer.append("requestString: " + requestString + "<br/>");
        System.out.println("requestString: " + requestString);

        String headerLine = requestString;

        StringTokenizer tokenizer = new StringTokenizer(headerLine);

        String httpMethod = tokenizer.nextToken();
        outBuffer.append("httpMethod:" + httpMethod + "<br/>");
        System.out.println("httpMethod:" + httpMethod);

        String httpQueryString = tokenizer.nextToken();
        outBuffer.append("httpQueryString:" + httpQueryString + "<br/>");
        System.out.println("httpQueryString:" + httpQueryString);

        outBuffer.append("<br/>");
        System.out.println();

        while (Input.ready())
        {
            String line = Input.readLine();
            if(line.trim().length()>0) {
                outBuffer.append(line + "<br/>");
                System.out.println(line);
            }
        }

        boolean found = false;
        if (httpMethod.equals("GET")) {
            if (httpQueryString.equals("/")) {
                SendResponse(200, outBuffer.toString(), false);
                found = true;
            } else {
                String fileName = httpQueryString.replaceFirst("/", "");
                fileName = URLDecoder.decode(fileName);
                URL url = getClass().getResource(fileName);
                if (url != null)
                    fileName = url.getPath();
                if (new File(fileName).isFile()){
                    SendResponse(200, fileName, true);
                    found = true;
                }
            }
        }

        if (!found) {
            SendResponse(404, "<b>resource not found<br/>" +
                    "<a href='http://127.0.0.1:5000'>home</a></b>", false);
        }

    }

    public void SendResponse(int statusCode, String responseString, boolean isFile) throws Exception {

        String statusLine = null;
        String serverdetails = "Server: Java HTTPServer";
        String contentLengthLine = null;
        String fileName = null;
        String contentTypeLine = "Content-Type: text/html" + "\r\n";
        FileInputStream fin = null;

        if (statusCode == 200)
            statusLine = "HTTP/1.1 200 OK" + "\r\n";
        else
            statusLine = "HTTP/1.1 404 Not Found" + "\r\n";

        if (isFile) {
            fileName = responseString;
            fin = new FileInputStream(fileName);
            contentLengthLine = "Content-Length: " + Integer.toString(fin.available()) + "\r\n";
            if (!fileName.endsWith(".htm") && !fileName.endsWith(".html"))
                contentTypeLine = "Content-Type: \r\n";
        }
        else {
            String outStart = "<html><title>HTTP Server in java</title><body>";
            String outEnd = "</body></html>";
            responseString = outStart + responseString + outEnd;
            contentLengthLine = "Content-Length: " + responseString.length() + "\r\n";
        }

        // output the HTTP header
        Output.writeBytes(statusLine);
        Output.writeBytes(serverdetails);
        Output.writeBytes(contentTypeLine);
        Output.writeBytes(contentLengthLine);
        Output.writeBytes("Connection: close\r\n");
        Output.writeBytes("\r\n");

        // output the content
        if (isFile) {
            byte[] buffer = new byte[1024] ;
            int bytesRead;
            while ((bytesRead = fin.read(buffer)) != -1 ) {
                Output.write(buffer, 0, bytesRead);
            }
            fin.close();
        }
        else
            Output.writeBytes(responseString);

        Output.close();
    }

}