//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.sosailnetwork;

import android.widget.TextView;

public final class TextViewUtil {
    public TextViewUtil() {
    }

    public static void scaleUp(TextView textView, float originSize, float scale) {
        changeTextSize(textView, originSize * scale);
    }

    public static void changeTextSize(TextView textView, float size) {
        textView.setTextSize(0, size);
    }

    static void scaleUp(TextView textView) {
        float originSize = textView.getTextSize();
        if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
            originSize = (Float)FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
        } else {
            FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
        }

        changeTextSize(textView, originSize * FontManager.getDefault().getScale());
    }

    static void scaleUp(TextView textView, float scale) {
        float originSize = textView.getTextSize();
        if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
            originSize = (Float)FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
        } else {
            FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
        }

        changeTextSize(textView, originSize * scale);
    }

    static void scaleDown(TextView textView, float scale) {
        float originSize = textView.getTextSize() / scale;
        if (FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "") != null) {
            originSize = (Float)FontManager.getDefault().getOriginItemSize().get(textView.hashCode() + "");
        } else {
            FontManager.getDefault().getOriginItemSize().put(textView.hashCode() + "", originSize);
        }

        changeTextSize(textView, originSize);
    }
}
