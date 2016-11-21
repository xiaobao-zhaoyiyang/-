package com.zhaoyiyang.imageloader.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by zhaoyiyang on 16/11/21.
 * 关闭的工具类
 */

public class CloseUtils {
    public static void closeQuietly(Closeable closeable){
        if (null != closeable){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
