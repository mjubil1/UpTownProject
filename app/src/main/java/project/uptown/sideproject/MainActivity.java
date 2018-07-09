package project.uptown.sideproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.TimerTask;

import project.uptown.sideproject.adapters.MainPagerAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getName();

    // UI REFERENCES
    Toolbar toolbar;
    FloatingActionButton fab;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager vp;
    Intent intent;
    LinearLayout sliderDots;
    MainPagerAdapter mainPagerAdapter;

    private int dotsCount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");

        initialize();

        dotsCount = mainPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        // Displays the nonactive dots to view
        for(int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot1));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8,0,8,0);

            sliderDots.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot1));

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                // Displays dots of active page for view
                for(int i = 0; i < dotsCount ; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot1));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot1));
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
        vp = findViewById(R.id.mainPager);

        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mainPagerAdapter);

        sliderDots = findViewById(R.id.sliderDots);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.nav_home:
                intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_redeem:
                intent = new Intent(MainActivity.this, RedeemActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(vp.getCurrentItem() == 0){
                        vp.setCurrentItem(1);
                    } else if(vp.getCurrentItem() == 1){
                        vp.setCurrentItem(2);
                    } else if(vp.getCurrentItem() == 2) {
                        vp.setCurrentItem(3);
                    } else if(vp.getCurrentItem() == 3){
                        vp.setCurrentItem(4);
                    } else {
                        vp.setCurrentItem(0);
                    }

                }
            });

        }
    }
}