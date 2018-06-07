# android 底部导航栏


![](https://ws1.sinaimg.cn/mw690/3d6cbc08gy1fs2l1irsp4j20u01hcgmi.jpg)




使用如下：

1. 添加xml

```
  <com.alguojian.bottomlayout.BottomLayout
        android:id="@+id/bottomLayout"
        android:layout_width="match_parent"
        android:layout_height="50dp" />
```

2. 添加资源文件

```
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

```