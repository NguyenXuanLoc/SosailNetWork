//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.sosailnetwork;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FontManager {
    static volatile FontManager instance;
    private Map<String, Float> originItemSize = new HashMap();
    private float scale = 1.0F;
    private FontManager.FontScaleType scaleType;

    public FontManager() {
        this.scaleType = FontManager.FontScaleType.NOT_SCALE_ALL;
    }

    public static FontManager getDefault() {
        FontManager localRef = instance;
        if (localRef == null) {
            Class var1 = FontManager.class;
            synchronized(FontManager.class) {
                localRef = instance;
                if (localRef == null) {
                    localRef = instance = new FontManager();
                }
            }
        }

        return localRef;
    }

    public Map<String, Float> getOriginItemSize() {
        return this.originItemSize;
    }

    public void setOriginItemSize(Map<String, Float> originItemSize) {
        this.originItemSize = originItemSize;
    }

    public FontManager.FontScaleType getScaleType() {
        return this.scaleType;
    }

    public void setScaleType(FontManager.FontScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }


    public static enum FontScaleType {
        SCALE_ALL,
        NOT_SCALE_ALL;

        private FontScaleType() {
        }
    }
}
