package com.lgx.test.common;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;

/**
 * Created by harry  on 2017/5/3.
 */

public class HtmlTextView extends AppCompatTextView {

    public HtmlTextView(Context context) {
        super(context);
        setText(fromHtml(getText().toString()));
    }

    public HtmlTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setText(fromHtml(getText().toString()));
    }

    public HtmlTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setText(fromHtml(getText().toString()));
    }


    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}
