package project.uptown.sideproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

import project.uptown.sideproject.adapters.PaginationAdapter;

/**
 * Created by Montrell on 5/31/2018.
 */

public class PaginationActivity  extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = PaginationActivity.class.getName();

    //UI REFERENCES
    Button registerBtn,signInBtn;
    Intent intent;
    ViewPager vp;
    LinearLayout sliderDots;
    PaginationAdapter paginationAdapter;
    private int dotsCount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagination);
        Log.d(TAG, "onCreate");
        initialize();

        paginationAdapter = new PaginationAdapter(this);
        vp.setAdapter(paginationAdapter);

        dotsCount = paginationAdapter.getCount();
        dots = new ImageView[dotsCount];

        // Displays the nonactive dots to view
        for(int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);

            sliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // Displays dots of active page for view
                for(int i = 0; i < dotsCount ; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    /*-------Private Methods-------*/
    private void initialize() {
        vp = findViewById(R.id.paginationPager);
        registerBtn = findViewById(R.id.registerBtn);
        sliderDots = findViewById(R.id.sliderDots);
        registerBtn.setOnClickListener(this);
        signInBtn = findViewById(R.id.signInBtn);
        signInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.registerBtn:
                intent = new Intent(PaginationActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.signInBtn:
                intent = new Intent(PaginationActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            PaginationActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(vp.getCurrentItem() == 0){
                        vp.setCurrentItem(1);
                    } else if(vp.getCurrentItem() == 1){
                        vp.setCurrentItem(2);
                    } else if(vp.getCurrentItem() == 2) {
                        vp.setCurrentItem(3);
                    } else {
                        vp.setCurrentItem(0);
                    }

                }
            });

        }
    }
}
