package project.uptown.sideproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Montrell on 5/31/2018.
 */

public class PaginationActivity  extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = PaginationActivity.class.getName();

    //UI REFERENCES
    Button registerBtn,signInBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagination);
        Log.d(TAG, "onCreate");
        initialize();
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
        registerBtn = findViewById(R.id.registerBtn);
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
}
