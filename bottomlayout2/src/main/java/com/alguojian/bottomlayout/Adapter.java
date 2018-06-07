package com.alguojian.bottomlayout;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * 适配器
 *
 * @author alguojian
 * @date 2018/6/7
 */
public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private List<Integer> images = null;

    private int textSelectedColor = R.color.text_selected_color;
    private int textNotSelectedColor = R.color.text_not_selected_color;

    /**
     * 默认文字大小11 sp
     */
    private int textSize = 11;
    private Context mContext;
    private int mPosition = 0;


    public Adapter(@NonNull Context context, @NonNull List<String> texts) {
        super(R.layout.item_bottom_layout, texts);
        this.mContext = context;
    }

    public void setContent(@NonNull List<Integer> image) {
        this.images = image;
    }

    public void setTextColor(@NonNull int textSelectedColor, @NonNull int textNotSelectedColor) {
        this.textSelectedColor = textSelectedColor;
        this.textNotSelectedColor = textNotSelectedColor;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        ImageView imageView = helper.getView(R.id.image);
        TextView textView = helper.getView(R.id.text);
        textView.setTextSize(textSize);
        textView.setText(item);

        imageView.setImageDrawable(ContextCompat.getDrawable(mContext, images.get(helper.getAdapterPosition())));

        if (mPosition == helper.getAdapterPosition()) {
            imageView.setSelected(true);

            textView.setTextColor(ContextCompat.getColor(mContext, textSelectedColor));
        } else {
            imageView.setSelected(false);
            textView.setTextColor(ContextCompat.getColor(mContext, textNotSelectedColor));
        }
    }

    public void setPosition(int position) {
        this.mPosition = position;
        notifyDataSetChanged();
    }
}
