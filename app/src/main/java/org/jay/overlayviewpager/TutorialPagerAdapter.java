package org.jay.overlayviewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by JAY on 2018/2/23.
 */

public class TutorialPagerAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;

    private ArrayList<TutorialItemVM> tutorialItemVMS;

    public TutorialPagerAdapter(final Context context, ArrayList<TutorialItemVM> tutorialItemVMS) {
        this.tutorialItemVMS = tutorialItemVMS;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tutorialItemVMS.size();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;
        view = layoutInflater.inflate(R.layout.layout_tutorial_item, container, false);
        TutorialItemVM tutorialItemVM = tutorialItemVMS.get(position);
        ImageView imageView = view.findViewById(R.id.iv_image);
//        TextView title = view.findViewById(R.id.tv_title);
//        TextView description = view.findViewById(R.id.tv_description);
        imageView.setImageResource(tutorialItemVM.getImage());
//        title.setText(tutorialItemVM.getTitle());
//        description.setText(tutorialItemVM.getDescription());
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}
