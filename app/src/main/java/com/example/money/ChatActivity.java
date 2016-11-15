package com.example.money;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by 훈 on 2016-11-10.
 */
public class ChatActivity extends AppCompatActivity {

    SharedPreferences preferences;
    ListView listView;

    EditText editText;
    Button buttonSend;

    ChatAdapter chatAdapter;

    String nickname;
}
