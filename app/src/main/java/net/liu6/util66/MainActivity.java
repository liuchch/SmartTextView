package net.liu6.util66;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import net.liu6.util662.SmartTextView.SmartText;
import net.liu6.util662.SmartTextView.SmartTextStyle;

public class MainActivity extends AppCompatActivity {

    SpannableStringBuilder spannableStringBuilder;

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDate();

        tv1 = findViewById(R.id.tv_1);
        SmartText smartText = new SmartText(R.id.tv_1,R.string.SmartTextView, this);
        smartText.addTextStyle(new SmartTextStyle().setTextColor(R.color.colorPrimary))
                .addTextStyle(new SmartTextStyle().setTextColor(R.color.dark)).finish();

    }


    private void initDate() {
        String text = "H#*e*#l#*lo*# Wo#*rld*#";
        String textNew = text.replaceAll("#", "");
        textNew = textNew.replaceAll("\\*", "");
        spannableStringBuilder = new SpannableStringBuilder(textNew);

        int colorId[] = new int[] {
                getSysColor(R.color.colorAccent),
                getSysColor(R.color.colorPrimary),
                getSysColor(R.color.colorPrimaryDark)
        };
        int num = 3;
        int[] indexSE = new int[num*2];
        int i = 0;
        while (text.contains("*#")) {
            if (i % 2 == 1) {
                indexSE[i++] = text.indexOf("*#");
                text = text.replace("*#", "");
            } else {
                indexSE[i++] = text.indexOf("#*");
                text = text.replace("#*", "");
            }
        }

        for (i=0; i<num; i++) {
            spannableStringBuilder.setSpan(
                    new ForegroundColorSpan(colorId[i]),
                    indexSE[i*2], indexSE[i*2+1], Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        }
//        spannableStringBuilder.setSpan(
//                new ForegroundColorSpan(
//                        getSysColor(R.color.colorPrimaryDark)),
//                        2,5, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        TextView textView = findViewById(R.id.tv_hello_world);
        textView.setText(spannableStringBuilder);
    }

    private int getSysColor(final int id) {
        return getResources().getColor(id);
    }
}

