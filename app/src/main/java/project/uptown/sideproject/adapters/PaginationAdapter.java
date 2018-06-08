package project.uptown.sideproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import project.uptown.sideproject.R;

/**
 * Created by Montrell on 6/7/2018.
 */

public class PaginationAdapter extends PagerAdapter {

    Context context;
    private LayoutInflater layoutInflater;
    private Integer [] paginationText = {R.string.slide1,R.string.slide2,R.string.slide3,R.string.slide4};

    public PaginationAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return paginationText.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pagination_layout, null);
        final TextView textView = view.findViewById(R.id.textView);

        if(position == 0){
            textView.setText(R.string.slide1);
        } else if(position == 1){
            textView.setText(R.string.slide2);
        } else if(position == 2) {
            textView.setText(R.string.slide3);
        } else if(position == 3){
            textView.setText(R.string.slide4);
            }


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}
