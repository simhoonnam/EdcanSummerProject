package com.example.money;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton callB,messageB;
    TextView plB;
    ListView listview;
    ArrayList<String> arraylist;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayAdapter adapter;

    EditText moneyKey,pmKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startActivity(new Intent(this, SplashActivity.class));

        setDefault();

    }

    private void setDefault() {
        callB = (ImageButton)findViewById(R.id.callButton);
        messageB=(ImageButton)findViewById(R.id.messageButton);
        plB = (TextView) findViewById(R.id.pluseText);

        callB.setOnClickListener(this);
        messageB.setOnClickListener(this);
        plB.setOnClickListener(this);

        arraylist=new ArrayList<>();
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, arraylist);
        listview=(ListView)findViewById(R.id.moneyList);

        sharedPreferences = getSharedPreferences("WOW",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        listview.setAdapter(adapter);

        pmKey=(EditText)findViewById(R.id.pmText);
        moneyKey=(EditText)findViewById(R.id.moneyText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_information) {
            intent = new Intent(MainActivity.this, InformationActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.callButton:
                intent=new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent);
                break;
            case R.id.messageButton:
                intent=new Intent(MainActivity.this, MesseageActivity.class);
                startActivity(intent);
                break;
            case R.id.pluseText:
                savetoDB();
                break;
        }

    }

    private void savetoDB(){
        String moneyString=moneyKey.getText().toString().trim();
        String pmString=pmKey.getText().toString().trim();
        String lastString=pmString+moneyString;

        if (moneyString.equals("") || pmString.equals("")) {
            Toast.makeText(this, "공백없이 입력해주세요!", Toast.LENGTH_SHORT).show();
        }
        else {
            editor.putString(pmString, moneyString);
            editor.commit();
            arraylist.add(lastString);
            adapter.notifyDataSetChanged();
            pmKey.setText("");
            moneyKey.setText("");
            Toast.makeText(this, pmString + " "+ moneyString + " 저장되었습니다", Toast.LENGTH_SHORT).show();
        }
    }
}
