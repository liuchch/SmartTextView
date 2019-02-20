package net.liu6.util662.SmartTextView;

import android.app.Activity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SmartText {

    private SpannableStringBuilder spannableStringBuilder;
//    private int textViewId;
//    private int textStringId;

    private TextView textView;
    private String oldTextString;
    private String newTextString;
    private int[] indexS;
    private int[] indexE;
    private int[] colorIdArray;
    Activity mActivity;

    List<SmartTextStyle> smartTextStyles;

    public SmartText(int textViewId, int textStringId, Activity activity) {
        mActivity = activity;
        smartTextStyles = new ArrayList<>();
        spannableStringBuilder = new SpannableStringBuilder();
        textView = activity.findViewById(textViewId);
        oldTextString = activity.getResources().getString(textStringId);
    }

    public SmartText addTextStyle(SmartTextStyle style) {
        smartTextStyles.add(style);
        return this;
    }

    public void finish() {
        int styleNum = smartTextStyles.size();
        colorIdArray = new int[styleNum];
        indexS = new int[styleNum];
        indexE = new int[styleNum];
        newTextString = oldTextString.replace("#6", "");
        newTextString = newTextString.replace("6#", "");
        spannableStringBuilder = new SpannableStringBuilder(newTextString);

        for (int i=0; i<styleNum; i++) {

            SmartTextStyle style = smartTextStyles.get(i);
            int colorId = style.getTextColor();
            colorIdArray[i] = getSysColor(colorId);

            indexS[i] = oldTextString.indexOf("#6");
            oldTextString = oldTextString.replaceFirst("#6", "");

            indexE[i] = oldTextString.indexOf("6#");
            oldTextString = oldTextString.replaceFirst("6#", "");

        }

        for (int i=0; i<styleNum; i++) {
            spannableStringBuilder.setSpan(
                    new ForegroundColorSpan(colorIdArray[i]),
                    indexS[i], indexE[i], Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
        textView.setText(spannableStringBuilder);
    }

    private int getSysColor(final int id) {
        return mActivity.getResources().getColor(id);
    }

}
