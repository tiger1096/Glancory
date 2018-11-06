package com.glancory.glancory.Utils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhangqi on 18/11/5.
 */

public class HttpConnectionUtils {
    public static HttpURLConnection getConnection(String data) throws Exception {
        URL url = new URL("http://192.168.199.150:8080/GlancoryServer/LoginServlet");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setReadTimeout(5000);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        connection.setRequestProperty("Content-Tpye", "application/x-www-form-urlencoded ");
        connection.setRequestProperty("Content-Length", data.length() + "");

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(data.getBytes());

        return connection;
    }
}
