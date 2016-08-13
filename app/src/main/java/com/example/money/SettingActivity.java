package com.example.money;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    TextView pang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        pang=(TextView)findViewById(R.id.rollupText);
        pang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.rollupText:
            removeAllPreferences();
            break;
        }
    }

    // 값(ALL Data) 삭제하기
    private void removeAllPreferences(){
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this, "초기화 완료", Toast.LENGTH_SHORT).show();
        killApp(true);
    }
    public static void killApp(boolean killSafely) {
        if (killSafely) {
        /*
         * Notify the system to finalize and collect all objects of the app
         * on exit so that the virtual machine running the app can be killed
         * by the system without causing issues. NOTE: If this is set to
         * true then the virtual machine will not be killed until all of its
         * threads have closed.
         */
            System.runFinalizersOnExit(true);

        /*
         * Force the system to close the app down completely instead of
         * retaining it in the background. The virtual machine that runs the
         * app will be killed. The app will be completely created as a new
         * app in a new virtual machine running in a new process if the user
         * starts the app again.
         */
            System.exit(0);
        } else {
        /*
         * Alternatively the process that runs the virtual machine could be
         * abruptly killed. This is the quickest way to remove the app from
         * the device but it could cause problems since resources will not
         * be finalized first. For example, all threads running under the
         * process will be abruptly killed when the process is abruptly
         * killed. If one of those threads was making multiple related
         * changes to the database, then it may have committed some of those
         * changes but not all of those changes when it was abruptly killed.
         */
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
