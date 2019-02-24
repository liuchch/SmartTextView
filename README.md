# SmartTextView

一个聪明的TextView 1.0.1版本已经可以实现对于一段文字中的部分文字更改字体颜色，以及添加点击事件。

1.需要将strings.xml文件中的文字通过"(-"和"-)"包起来，例如 <string name="SmartTextView">(-S-)mart(-T-)ext(-V-)(-iew-)</string>
2.SmartText smartText = new SmartText(tv1, getResources().getString(R.string.SmartTextView));
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
其中通过SmartText添加SmartTextStyle对"(-  -)"里面中的内容设置颜色 以及增加点击事件。点击事件和文字下划线都是可选功能。
