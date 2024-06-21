package com.example.mychattingapp;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HostActivity extends AppCompatActivity {
    EditText editNickName;
    EditText editMessage;
    TextView textMessageLog;
    TextView textIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_host);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editNickName = findViewById(R.id.editHostName);
        editMessage = findViewById(R.id.editHostInput);
        textMessageLog = findViewById(R.id.textHostMessage);
        textIp = findViewById(R.id.hostIP);

        WifiManager wiffiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ipAddress = Formatter.formatIpAddress(wiffiManager.getConnectionInfo().getIpAddress());
        textIp.setText(ipAddress);

        editMessage.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getKeyCode() == event.KEYCODE_ENTER && event.getAction() == event.ACTION_DOWN){
                    String nick = editNickName.getText().toString();
                    String message = editMessage.getText().toString();
                    String log = nick + " : " + message;
                    String beforeLog = textMessageLog.getText().toString();
                    beforeLog = beforeLog + "\n "+log;
                    textMessageLog.setText(beforeLog);
                    editMessage.setText("");
                }
                return false;
            }
        });
    }
}