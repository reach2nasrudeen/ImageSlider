package com.example.nasrudeen.imageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nasrudeen on 29/7/17.
 */

class CustomViewPagerAdapter extends PagerAdapter{
    private Context context;
    private List<HotDealObject> hotDealList;
    private LayoutInflater layoutInflater;
    public CustomViewPagerAdapter(Context context, List<HotDealObject> hotDealList) {
        this.context = context;
        this.hotDealList = hotDealList;
        this.layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return hotDealList.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.hot_deal_layout, container, false);
        HotDealObject mHotDealObject = hotDealList.get(position);
        ImageView favoriteIcon = (ImageView)view.findViewById(R.id.hot_deal_favorite);
        TextView hotDealPrice = (TextView)view.findViewById(R.id.hot_deal_price);
        ImageView hotDealFoodImage = (ImageView)view.findViewById(R.id.hot_deal_food_image);
        TextView hotDealFoodName = (TextView)view.findViewById(R.id.hot_deal_food_name);
        TextView hotDealFoodDescription = (TextView)view.findViewById(R.id.hot_deal_food_description);
        //bind value to the View Widgets
        hotDealPrice.setText(mHotDealObject.getDealPrice());
        hotDealFoodName.setText(mHotDealObject.getDealName());
        hotDealFoodDescription.setText(mHotDealObject.getDealDescription());
        container.addView(view);
        return view;
    }
}
