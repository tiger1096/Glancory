package com.glancory.glancory.Utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by zhangqi on 18/11/6.
 */

public class StreamChangeStrUtils{
    public static String toChange(InputStream input) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte [] b = new byte[1024];
        int len = -1;
        while((len = input.read(b)) != -1) {
            bos.write(b, 0, len);
        }

        input.close();
        String response = new String(bos.toByteArray());
        return response;
    }
}
