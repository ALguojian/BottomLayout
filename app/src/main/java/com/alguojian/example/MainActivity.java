package com.alguojian.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.alguojian.bottomlayout.BottomLayout;
import com.alguojian.bottomlayout.OnclickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomLayout bottomLayout = findViewById(R.id.bottomLayout);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("首页");
        strings.add("推广");
        strings.add("个人中心");
        bottomLayout.setTexts(strings);

        //选中时图片的背景，drawable-selected资源文件
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.weex_select_home_background_one);
        images.add(R.drawable.weex_select_home_background_two);
        images.add(R.drawable.weex_select_home_background_three);
        bottomLayout.setImages(images);

        //添加字体选中时以及未选中时字体颜色
        bottomLayout.setTextColor(R.color.colorAccent, R.color.colorPrimaryDark);

        /**
         * 设置字体大小，单位sp，默认是11sp
         */
        bottomLayout.setTextSize(14);

        //点击的回调
        bottomLayout.build(position -> System.out.println("=======点击了第" + position + "个"));
    }
}
