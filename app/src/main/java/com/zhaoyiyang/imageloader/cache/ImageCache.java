package com.zhaoyiyang.imageloader.cache;

import android.graphics.Bitmap;

/**
 * Created by zhaoyiyang on 16/11/21.
 * 图片缓存的接口，定义了存入和取出两个抽象方法
 */

public interface ImageCache {
    public void put(String url, Bitmap bitmap);
    public Bitmap get(String url);
}
