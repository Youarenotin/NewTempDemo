package com.youarenotin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by youarenotin on 16/9/7.
 */
public class PageHolder extends RecyclerView.ViewHolder {
    public ImageView iv ;
    public View itemView;
    public Button btn;
    public PageHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        iv= (ImageView) itemView.findViewById(R.id.iv);
        btn= (Button) itemView.findViewById(R.id.btn_add);
    }
}
