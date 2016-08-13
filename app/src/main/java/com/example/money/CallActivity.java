package com.example.money;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class CallActivity extends AppCompatActivity implements View.OnClickListener {
    Button callB;
    EditText PN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        setDefault();
    }

    private void setDefault() {
        callB=(Button) findViewById(R.id.callButton);
        PN = (EditText)findViewById(R.id.callNumber);
        callB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.callButton:
                callPhone();
                break;
        }
    }

    private void callPhone() {
        Uri uri;
        Intent intent;
        String data =PN.getText().toString();
        uri= Uri.parse("tel:"+data);
        intent= new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
}
