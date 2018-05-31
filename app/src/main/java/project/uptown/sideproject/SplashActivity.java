package project.uptown.sideproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getName();

    //UI REFERENCES
    ImageView rotate;
    Animation animation;
    Intent intent;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d(TAG,"onCreate");

        rotate = (ImageView) findViewById(R.id.rotate);
        animation = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.rotateanim);
        rotate.startAnimation(animation);

        thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    intent = new Intent(SplashActivity.this,PaginationActivity.class);
                    startActivity(intent);
                    finish();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
