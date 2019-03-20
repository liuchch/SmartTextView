package net.liu6.util662.SmartTextView;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SmartText {

    private SpannableStringBuilder spannableStringBuilder;
    //    private int textViewId;
//    private int textStringId;

    private TextView textView;
    private String oldTextString;
    private int[] colorArray;
    private boolean[] withUnderLine;
    private View.OnClickListener[] onClickListeners;


    private List<SmartTextStyle> smartTextStyles;

    public SmartText(TextView textView, String text) {
                smartTextStyles = new ArrayList<>();
//        spannableStringBuilder = new SpannableStringBuilder();
        this.textView = textView;
        oldTextString = text;
    }

    public SmartText addTextStyle(SmartTextStyle style) {
        smartTextStyles.add(style);
        return this;
    }


    public void finish() {
        int styleNum = smartTextStyles.size();
        int[] indexS = new int[styleNum];
        int[] indexE = new int[styleNum];
        colorArray = new int[styleNum];
        withUnderLine = new boolean[styleNum];
        onClickListeners = new View.OnClickListener[styleNum];
        String newTextString = oldTextString.replace("(-", "");
        newTextString = newTextString.replace("-)", "");
//        spannableStringBuilder = new SpannableStringBuilder(newTextString);
        SpannableString spannableString = new SpannableString(newTextString);

        for (int i=0; i<styleNum; i++) {

            SmartTextStyle style = smartTextStyles.get(i);

            colorArray[i] = style.getTextColor();
            onClickListeners[i] = style.getListener();
            withUnderLine[i] = style.isWithUnderLine();

            indexS[i] = oldTextString.indexOf("(-");
            oldTextString = oldTextString.replaceFirst("\\(-", "");

            indexE[i] = oldTextString.indexOf("-)");
            oldTextString = oldTextString.replaceFirst("-\\)", "");

        }

        for (int i=0; i<styleNum; i++) {
//            spannableString.setSpan(
//                    new ForegroundColorSpan(colorArray[i]),
//                    indexS[i], indexE[i], Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            final int finalI = i;
            spannableString.setSpan(new ClickableSpan() {
                @Override
                public void onClick(@NonNull View widget) {
                    if (onClickListeners[finalI] != null) {
                        onClickListeners[finalI].onClick(widget);
                    }
                }

                @Override
                public void updateDrawState(@NonNull TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(colorArray[finalI]);
                    ds.setUnderlineText(withUnderLine[finalI]);
                }
            }, indexS[finalI], indexE[finalI], Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());//设置可点击状态
        textView.setHighlightColor(Color.TRANSPARENT); //设置点击后的颜色为透明
        textView.setText(spannableString);
    }


}
