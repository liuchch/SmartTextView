package net.liu6.util662.SmartTextView;

import android.view.View;


public class SmartTextStyle {

    private int textColor;
    private View.OnClickListener listener;
    private boolean withUnderLine = false;


    public boolean isWithUnderLine() {
        return withUnderLine;
    }

    public SmartTextStyle setWithUnderLine(boolean withUnderLine) {
        this.withUnderLine = withUnderLine;
        return this;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public SmartTextStyle setListener(View.OnClickListener listener) {
        this.listener = listener;
        return this;
    }



    public int getTextColor() {
        return textColor;
    }

    public SmartTextStyle setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }
}
