package com.youarenotin;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        MainFragment fragment_main = new MainFragment();
        LinearLayout buttons = (LinearLayout) findViewById(R.id.buttons);
        fragment_main.setButtons(buttons);
        transaction.add(R.id.fragment_container, fragment_main,MainFragment.class.getSimpleName()).commit();

//        PageFragment pageFra
// gment=new PageFragment();
//        transaction.add(R.id.fragment_container,pageFragment,PageFragment.class.getSimpleName()).commit();
    }


}
