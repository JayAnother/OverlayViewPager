package org.jay.overlayviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jay.overlayviewpager.overlayviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TutorialItemVM> tutorialItemVMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        TutorialPagerAdapter adapter=new TutorialPagerAdapter(this,tutorialItemVMS);
        HorizontalInfiniteCycleViewPager viewPager= (HorizontalInfiniteCycleViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("jay","position"+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initData() {
        tutorialItemVMS = new ArrayList<>();
        int[] tutorialItemImage = {
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher
        };
        String[] tutorialItemTitle = {
                getString(R.string.transaction_favorite),
                getString(R.string.transaction_favorite),
                getString(R.string.transaction_favorite),
                getString(R.string.transaction_favorite),
                getString(R.string.transaction_favorite),
        };
        String[] tutorialItemDescription = new String[]{
                getString(R.string.tutorial_desc),
                getString(R.string.tutorial_desc),
                getString(R.string.tutorial_desc),
                getString(R.string.tutorial_desc),
                getString(R.string.tutorial_desc),
        };
        for (int i = 0; i < tutorialItemImage.length; i++) {
            TutorialItemVM tutorialItemVM = new TutorialItemVM();
            tutorialItemVM.setImage(tutorialItemImage[i]);
            tutorialItemVM.setTitle(tutorialItemTitle[i]);
            tutorialItemVM.setDescription(tutorialItemDescription[i]);
            tutorialItemVMS.add(tutorialItemVM);
        }

    }
}
