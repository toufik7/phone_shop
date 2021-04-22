package com.example.shop;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String phoneList[];
    String similarPhones[];
    int brands[];
    int similar[];
    LayoutInflater inflter;


    public CustomAdapter(Context applicationContext, String[] phoneList,String[] similarPhones, int[] brands,int[] similar) {
        this.context = applicationContext;
        this.phoneList = phoneList;
        this.brands = brands;
        this.similarPhones = similarPhones;
        this.similar = similar;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return brands.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
       // TextView phone = (TextView) view.findViewById(R.id.tv);
        ImageView icon2 = (ImageView) view.findViewById(R.id.icon2);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        //phone.setText(phoneList[position]);
        icon.setImageResource(brands[position]);

       // ObjectAnimator animation = ObjectAnimator.ofFloat(icon, "y", 600);
        ValueAnimator va = ValueAnimator.ofFloat(800f, 0f);
        int mDuration = 2000; //in millis
        va.setDuration(mDuration);
        View finalView = view;
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                finalView.setTranslationX((float)animation.getAnimatedValue());
            }
        });
        va.start();



        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+ phoneList[position], Toast.LENGTH_SHORT).show();
               // animation.setDuration(1000);
               // animation.start();

            }
        });
        icon2.setImageResource(similar[position]);
        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+ similarPhones[position], Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }
}
