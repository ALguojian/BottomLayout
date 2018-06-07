package com.alguojian.bottomlayout;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import java.util.List;

/**
 * 自定义底部导航栏
 *
 * @author alguojian
 * @date 2018/6/7
 */
public class BottomLayout extends LinearLayout {

    private List<Integer> images = null;
    private List<String> texts = null;
    private int textSelectedColor = R.color.text_selected_color;
    private int textNotSelectedColor = R.color.text_not_selected_color;
    private int textSize = 11;
    private Context mContext;

    public BottomLayout(Context context) {
        super(context);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.bottom_layout, this);

    }

    public void build(@NonNull OnclickListener onclickListener) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, images.size()));
        Adapter mAdapter = new Adapter(mContext, texts);
        mAdapter.setContent(images);
        mAdapter.setTextColor(textSelectedColor, textNotSelectedColor);
        mAdapter.setTextSize(textSize);
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            mAdapter.setPosition(position);
            onclickListener.onClickPosition(position);
        });
    }

    /**
     * @param textSelectedColor    选中时的文字颜色
     * @param textNotSelectedColor 未选中时的文字颜色
     * @return
     */
    public BottomLayout setTextColor(@NonNull int textSelectedColor, @NonNull int textNotSelectedColor) {
        this.textSelectedColor = textSelectedColor;
        this.textNotSelectedColor = textNotSelectedColor;
        return this;
    }

    /**
     * 字体大小，默认为11sp
     *
     * @param textSize
     * @return
     */
    public BottomLayout setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * 图片资源
     *
     * @param images drawable资源
     * @return
     */
    public BottomLayout setImages(@NonNull List<Integer> images) {
        this.images = images;
        return this;
    }

    public BottomLayout setTexts(@NonNull List<String> texts) {
        this.texts = texts;
        return this;
    }

}
