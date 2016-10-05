package com.youarenotin;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        MainFragment fragment_main = new MainFragment();
        LinearLayout buttons = (LinearLayout) findViewById(R.id.buttons);
        fragment_main.setButtons(buttons);
        transaction.add(R.id.fragment_container, fragment_main,MainFragment.class.getSimpleName()).commit();

        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintColor(Color.YELLOW);

//        PageFragment pageFra
// gment=new PageFragment();
//        transaction.add(R.id.fragment_container,pageFragment,PageFragment.class.getSimpleName()).commit();
    }


}
