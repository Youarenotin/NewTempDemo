package com.youarenotin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by youarenotin on 16/9/7.
 */
public class PageAdapter extends RecyclerView.Adapter<PageHolder> {
    private Context mContext;

    public PageAdapter(Context mContext) {
        this.mContext = mContext;
    }



    @Override
    public PageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(mContext, R.layout.item_page, null);

        PageHolder pageHolder = new PageHolder(itemView);
        return pageHolder;
    }

    @Override
    public void onBindViewHolder(PageHolder holder, int position) {
//        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//        layoutParams.height=mContext.getResources().getDisplayMetrics().widthPixels/2;
//        holder.itemView.setLayoutParams(layoutParams);
        holder.iv.setImageResource(R.drawable.chat_video_call_normal);
        ViewGroup.LayoutParams params = holder.iv.getLayoutParams();
        params.height=mContext.getResources().getDisplayMetrics().widthPixels/4;
        params.width=mContext.getResources().getDisplayMetrics().widthPixels/5;
        holder.iv.setLayoutParams(params);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeginAnimToShopCar(view);
            }
        });
    }

    private void BeginAnimToShopCar(View view) {
        int[] viewPos = new int[2];
        view.getLocationInWindow(viewPos);
        int[] carPos=new int[2];

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
