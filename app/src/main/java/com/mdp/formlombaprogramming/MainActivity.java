package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText etNama, etNowa, etAlamat, etPassword, etPin;
    private RadioGroup rgJK;
    private RadioButton rbJk;
    private Button btnDaftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNowa = findViewById(R.id.et_no_wa);
        etAlamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);
        rgJK = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString();
                String nowa = etNowa.getText().toString();
                String alamat = etAlamat.getText().toString();
                String Password = etPassword.getText().toString();
                String Pin = etPin.getText().toString();

                int JkId = rgJK.getCheckedRadioButtonId();
                rbJk = findViewById(JkId);

                String jk = rbJk.getText().toString();

                if(nama.trim().equals(""))
                {
                    etNama.setError("Nama tidak boleh Kosong");
                }
                 if(nowa.trim().equals(""))
                {
                    etNowa.setError("No WhatsUp tidak boleh Kosong");
                }
                 if(alamat.trim().equals(""))
                {
                    etAlamat.setError("Alamat tidak boleh Kosong");
                }
                 if(Password.trim().equals(""))
                {
                    etPassword.setError("Password tidak boleh Kosong");
                }
                 if(Pin.trim().equals(""))
                {
                    etPin.setError("Pin tidak boleh Kosong");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("varnama", nama);
                    intent.putExtra("varjk", jk);
                    intent.putExtra("varwa", nowa);
                    intent.putExtra("varalamat", alamat);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etAlamat.setText("");
        etNowa.setText("");
        etAlamat.setText("");
        etPin.setText("");
        etPassword.setText("");
    }
}