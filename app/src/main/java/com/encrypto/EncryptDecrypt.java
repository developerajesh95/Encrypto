package com.encrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EncryptDecrypt extends AppCompatActivity {

    private String action = "";
    private EditText etInput;
    private TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt_decrypt);
        if (getIntent().getExtras() != null) {
            action = getIntent().getExtras().getString("action");
        }

        etInput = findViewById(R.id.etTextInput);
        tvOutput = findViewById(R.id.tvOutput);

        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etInput.getText().toString();
                performAction(action, input);
            }
        });


        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvOutput.setText("");
            }

            @Override
            public void afterTextChanged(Editable s) {
                tvOutput.setText("");
            }
        });

    }

    private void performAction(String action, String input) {
        if (!TextUtils.isEmpty(action)) {
            if (action.equalsIgnoreCase("encrypt")) {
                if (TextUtils.isEmpty(input)) {
                    Toast.makeText(this, "Please provide input", Toast.LENGTH_SHORT).show();
                } else {
                    tvOutput.setText(CommonFunctions.encrypt(input));
                }
            } else if (action.equalsIgnoreCase("decrypt")) {
                if (TextUtils.isEmpty(input)) {
                    Toast.makeText(this, "Please provide input", Toast.LENGTH_SHORT).show();
                } else {
                    tvOutput.setText(CommonFunctions.decrypt(input));
                }
            }
        }
    }

}
