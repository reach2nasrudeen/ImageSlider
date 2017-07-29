package com.example.nasrudeen.imageslider;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class HotDealActvity extends AppCompatActivity {

    private static final String TAG = HotDealActvity.class.getSimpleName();
    private ViewPager viewPager;
    private CustomViewPagerAdapter mAdapter;
    private Handler handler;
    private final int delay = 2000;
    private int page = 0;
    Runnable runnable = new Runnable() {
        public void run() {
            if (mAdapter.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_deal_actvity);
//        setTitle(getString(R.string.hot_deal_menus));
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
        handler = new Handler();
        viewPager = (ViewPager)findViewById(R.id.hot_deal_view_pager);
        mAdapter = new CustomViewPagerAdapter(HotDealActvity.this, getTestData());
//        SlideshowPagerAdapter adapter = new SlideshowPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                page = position;
                switch (position){
                    case 0:
                        radioGroup.check(R.id.radioButton);
                        break;
                    case 1:
                        radioGroup.check(R.id.radioButton2);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton3);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
    public List<HotDealObject> getTestData() {
        List<HotDealObject> mTestData = new ArrayList<HotDealObject>();
        mTestData.add(new HotDealObject("$42.00", "", "Fried Fish with Sauce", "It is a long established fact that a reader will be distracted by the when looking at its layout.It is a long established fact that a reader will be distracted by the when looking at its layout"));
        mTestData.add(new HotDealObject("$30.00", "", "Rice and Bean with Sauce", "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC It is a long established fact that a reader will be distracted by the when looking at its layout"));
        mTestData.add(new HotDealObject("$23.00", "", "Baked Potato with Salad", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour It is a long established fact that a reader will be distracted by the when looking at its layout"));
        return mTestData;
    }
    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}
