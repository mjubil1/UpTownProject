package project.uptown.sideproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Montrell on 6/6/2018.
 */

public class ForgotPwdActivity extends AppCompatActivity {

    private static final String TAG = ForgotPwdActivity.class.getName();


    // UI REFERENCES

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);
        Log.d(TAG,"onCreate");

        initialize();
    }

      /*-------Private Methods-------*/
      private void initialize() {

      }
}
