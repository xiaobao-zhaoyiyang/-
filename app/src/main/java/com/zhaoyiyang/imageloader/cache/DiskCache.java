package com.zhaoyiyang.imageloader.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.zhaoyiyang.imageloader.util.CloseUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhaoyiyang on 16/11/21.
 * 将图片缓存到SD卡中
 */

public class DiskCache implements ImageCache {
    // 图片缓存的位置文件夹地址
    private String cacheDir;

    public DiskCache(){

    }

    public DiskCache(String cachePath){
        this.cacheDir = cachePath;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fos = null;
        try {
            if (cacheDir == null){
                cacheDir = "sdcard/cache/";
            }
            fos = new FileOutputStream(cacheDir + url);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            CloseUtils.closeQuietly(fos);
        }
    }

    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }
}
