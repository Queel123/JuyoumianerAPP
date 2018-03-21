package com.jiayu.jyme.juyoumian_v1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.leon.lib.settingview.LSettingItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    private ImageView mIvHeadshots;
    private LSettingItem mSettingItemFootMark;
    private LSettingItem mSettingItemJoinIn;
    private LSettingItem mSettingItemNewMessage;
    private LSettingItem mSettingItemReminder;
    private LSettingItem mSettingGetLocation;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mIvHeadshots = (ImageView) getActivity().findViewById(R.id.headshots);
        mSettingItemFootMark = (LSettingItem) getActivity().findViewById(R.id.item_footmark);
        mSettingItemJoinIn = (LSettingItem) getActivity().findViewById(R.id.item_join_in);
        mSettingItemNewMessage = (LSettingItem) getActivity().findViewById(R.id.item_new_message);
        mSettingItemReminder = (LSettingItem) getActivity().findViewById(R.id.item_reminder);


        //头像设置页面
        mIvHeadshots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "你以后可以在这里换头像哦", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mSettingItemNewMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                getActivity().startActivity(intent);
            }
        });


        /*@Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.item_footmark:
                    Toast.makeText(getApplicationContext(), "我的消息", Toast.LENGTH_SHORT).show();
                    break;
            }
        }*/
    }

}