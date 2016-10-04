package com.youarenotin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.easyandroidanimations.library.Animation;
import com.easyandroidanimations.library.AnimationListener;
import com.easyandroidanimations.library.SlideInAnimation;
import com.easyandroidanimations.library.SlideOutAnimation;

/**
 * Created by youarenotin on 16/9/6.
 */
public class MainFragment extends Fragment {
    ListView lv;

    private int disY = 0;
    LinearLayout buttons;
    private RelativeLayout container;
    private int minSlop;
    private boolean isSlideing;
    private float downY;
    private float moveY;
    private boolean showFuntions = true;
    int screenHight;
    int minActionDis = -1;
    int totalScrollDis = 0;
    String scrollDirection = "down";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fra_main, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add


        minSlop = ViewConfiguration.getTouchSlop();
        View title = view.findViewById(R.id.titleBar);
        lv = (ListView) view.findViewById(R.id.lv);
        ViewGroup.LayoutParams params = title.getLayoutParams();
        container = (RelativeLayout) view.findViewById(R.id.container);
        screenHight = getResources().getDisplayMetrics().heightPixels;
        minActionDis = screenHight / 4;
        params.height = screenHight / 5;
        title.setLayoutParams(params);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, new String[]{
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "177",
                "18",
                "19",
        }));

        lv.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int x, int y, int oldX, int oldY) {
            }
        });
        lv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent ev) {
                switch (ev.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downY = ev.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        disY = 0;
                        moveY = ev.getRawY();
                        if (moveY - downY > minSlop) {//下滑
                            disY = (int) (moveY - downY);
                            totalScrollDis += disY;
                            if (totalScrollDis > minActionDis) {
                                scrollDirection = "down";
                                disY = disY * 10 / 10;
                                if (container.getPaddingTop() < 0) {
                                    int paddingTop = container.getPaddingTop() + disY;
                                    if (paddingTop > 0)
                                        paddingTop = 0;
                                    container.setPadding(container.getPaddingLeft(), paddingTop, container.getPaddingRight(), container.getPaddingBottom());
                                }
                            }
                        } else if (downY - moveY > minSlop) {//上滑
                            disY = (int) (moveY - downY);
                            disY = disY * 8 / 10;
                            scrollDirection = "up";
                            if (container.getPaddingTop() > (-screenHight / 6)) {
                                int paddingTop = container.getPaddingTop() + disY;
                                if (paddingTop < -screenHight / 6)
                                    paddingTop = -screenHight / 6;
                                container.setPadding(container.getPaddingLeft(), paddingTop, container.getPaddingRight(), container.getPaddingBottom());
                            }
                        }
                        downY = moveY;
                        break;
                    case MotionEvent.ACTION_UP:
                        downY = 0;
                        moveY = 0;
                        disY = 0;
                        break;
                }

                return false;
            }
        });
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollDirection.equals("down") && scrollState == SCROLL_STATE_IDLE && !showFuntions) {
                    new SlideInAnimation(buttons).setListener(new AnimationListener() {
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            showFuntions = true;
                            totalScrollDis = 0;
                        }
                    }).setDirection(600).setDirection(4).animate();

                }
                if (scrollDirection.equals("up") && scrollState == SCROLL_STATE_IDLE && showFuntions) {
                    new SlideOutAnimation(buttons).setListener(new AnimationListener() {
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            showFuntions = false;
                        }
                    }).setDirection(600).setDirection(4).animate();

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    public void setButtons(LinearLayout rl) {
        this.buttons = rl;
    }
}
