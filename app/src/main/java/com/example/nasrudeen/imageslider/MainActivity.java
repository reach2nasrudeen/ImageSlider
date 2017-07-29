package com.example.nasrudeen.imageslider;

import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    int images[] = {R.drawable.three, R.drawable.five, R.drawable.three, R.drawable.five};
    MyCustomPagerAdapter myCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        myCustomPagerAdapter = new MyCustomPagerAdapter(MainActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);
    }
}
