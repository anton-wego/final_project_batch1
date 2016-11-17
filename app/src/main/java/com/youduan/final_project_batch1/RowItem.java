package com.youduan.final_project_batch1;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by youduan on 11/17/16.
 */

public class RowItem {
    TextView txtTitle;
    TextView counter;
    ImageView imageView;
    Button addBtn;
    Button minBtn;
    Integer buy;

    public RowItem(TextView txtTitle, TextView counter, ImageView imageView, Button addBtn, Button minBtn) {
        this.txtTitle = txtTitle;
        this.counter = counter;
        this.imageView = imageView;
        this.addBtn = addBtn;
        this.minBtn = minBtn;
    }

    public Integer getBuy() {
        return this.buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }
}
