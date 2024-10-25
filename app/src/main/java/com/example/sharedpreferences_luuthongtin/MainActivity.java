package com.example.sharedpreferences_luuthongtin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etMasv;
    private Button btnSave;
    private TextView tvResult;

    // Shared Preferences object
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etMasv = findViewById(R.id.etMaSV);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        // Load saved data when opening the app
        loadSavedData();

        // Save data on button click
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });


    }

    private void saveData() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String masv = etMasv.getText().toString();

        // Get SharedPreferences editor
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Store data
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("masv", masv);

        // Apply changes
        editor.apply();

        // Display saved data
        tvResult.setText("Thong tin đã lưu:\nHọ và tên: " + name + "\nEmail: " + email + "\nMã sinh viên: " + masv);
    }

    // Method to load saved data
    private void loadSavedData() {
        // Retrieve data from SharedPreferences
        String name = sharedPreferences.getString("name", "No Name");
        String email = sharedPreferences.getString("email", "No Email");
        String masv = sharedPreferences.getString("masv", "No MaSV");

        // Display retrieved data
        tvResult.setText("Thong tin đã lưu:\nHọ và tên: " + name + "\nEmail: " + email + "\nMã sinh viên: " + masv);
    }
}