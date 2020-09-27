package com.example.testkotlin.tabFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testkotlin.R;

import java.util.ArrayList;
import java.util.List;

public class JavaTabMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager = findViewById(R.id.viewPager_main);

        ViewPagerAdaper adaper = new ViewPagerAdaper(getSupportFragmentManager(), 0);
        adaper.addFragment(new JavaViewFragment1());
    }

    public class ViewPagerAdaper extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdaper(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
