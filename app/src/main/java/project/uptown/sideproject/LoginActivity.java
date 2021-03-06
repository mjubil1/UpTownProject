package project.uptown.sideproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getName();

    //UI REFERENCES
    TextView fgPwd;
    Button signInBtn,googleBtn,facebookBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        signInBtn = findViewById(R.id.signInBtn);
        signInBtn.setOnClickListener(this);
        googleBtn = findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(this);
        facebookBtn = findViewById(R.id.facebookBtn);
        facebookBtn.setOnClickListener(this);
        fgPwd = findViewById(R.id.forgotPwd);
        fgPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.signInBtn:
                Log.d(TAG,"Button clicked!");
                intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.googleBtn:
                Log.d(TAG,"Google Button clicked!");
                break;
            case R.id.facebookBtn:
                Log.d(TAG,"Facebook Button clicked!");
                break;
            case R.id.forgotPwd:
                Log.d(TAG,"Forgot Password clicked!");
                break;
        }
    }
}