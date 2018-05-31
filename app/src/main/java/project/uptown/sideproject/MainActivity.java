package project.uptown.sideproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    //UI REFERENCES
    ImageView rotate;
    Animation animation, animation1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");

        initialize();

        animation = AnimationUtils.loadAnimation(this,R.anim.rotateanim);
        rotate.startAnimation(animation);

        animation1 = AnimationUtils.loadAnimation(this,R.anim.downanim);
        rotate.startAnimation(animation1);
        intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
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
        rotate = (ImageView) findViewById(R.id.rotate);
    }
}
