package com.example.mychattingapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GuestActivity extends AppCompatActivity {
    TextView textJoinIP;
    TextView textmessageLog;
    EditText editGuestName;
    EditText editInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guest);

        textJoinIP = findViewById(R.id.JoinIP);
        textmessageLog = findViewById(R.id.textGuestMessage);
        editGuestName = findViewById(R.id.editGuestName);
        editInput = findViewById(R.id.editGuestInput);
        editInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == event.KEYCODE_ENTER && event.getAction() == event.ACTION_DOWN) {
                    String nick = editGuestName.getText().toString();
                    String message = editInput.getText().toString();
                    String log = nick + " : " + message;
                    String beforeLog = textmessageLog.getText().toString();
                    beforeLog = beforeLog + "\n " + log;
                    textmessageLog.setText(beforeLog);
                    editInput.setText("");

                }
                return false;
            }
        });

    }
}
