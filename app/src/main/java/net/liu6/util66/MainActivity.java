package net.liu6.util66;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import net.liu6.util662.SmartTextView.SmartText;
import net.liu6.util662.SmartTextView.SmartTextStyle;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv_1);
        SmartText smartText = new SmartText(tv1, getResources().getString(R.string.SmartTextView));
        smartText
                .addTextStyle(new SmartTextStyle()
                                .setTextColor(getResources().getColor(R.color.colorPrimary))
                )
                .addTextStyle(new SmartTextStyle()
                        .setTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .setListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "我可以点！！！", Toast.LENGTH_LONG).show();
                            }
                        })
                        .setWithUnderLine(true)
                )
                .addTextStyle(
                        new SmartTextStyle().setTextColor(getResources().getColor(R.color.dark))
                        .setListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "我不能点啊为什么点我，哼！！！", Toast.LENGTH_LONG).show();
                            }
                        })
                )
//                .addTextStyle(new SmartTextStyle().setTextColor(getResources().getColor(R.color.colorPrimaryDark)))
                .finish();

    }

}

