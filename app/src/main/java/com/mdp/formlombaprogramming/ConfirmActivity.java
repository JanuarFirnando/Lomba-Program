package com.mdp.formlombaprogramming;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {
    private DatePickerDialog date;
    private Button btnTanggal, btnKonfirmasi;
    private TextView tvnama, tvjk, tvnowa, tvalamat, tvTanggal;
    private String nama, jeniskelamin, noWa, alamat;
    private String choosendate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);
        tvnama = findViewById(R.id.tv_nama);
        tvjk = findViewById(R.id.tv_jk);
        tvnowa = findViewById(R.id.tv_no_wa);
        tvalamat = findViewById(R.id.tv_Alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);

        Intent terima = getIntent();
        nama = terima.getStringExtra("varnama");
        jeniskelamin = terima.getStringExtra("varjk");
        noWa = terima.getStringExtra("varwa");
        alamat = terima.getStringExtra("varalamat");

        tvnama.setText(nama);
        tvjk.setText(jeniskelamin);
        tvalamat.setText(alamat);
        tvnowa.setText(noWa);
        btnTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();

                date = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String hari =Integer.toString(day);
                        choosendate = hari + " / " + bulan + " / " + tahun;
                        tvTanggal.setText(choosendate);

                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),
                    newCalendar.get(Calendar.DAY_OF_MONTH));

                date.show();
            }
        });
        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Mohon Perhatian");
                dialog.setMessage("Bahwa Sesungguhnya kami ingin bertanya apakah data anda sudah benar ?");
                dialog.setPositiveButton("Mungkin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this, "Maka Daripada itu, Daftar Anda Kami Anggap Ber Ha Sil", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                dialog.setNegativeButton("Gak Yakin sih", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this, "Karna Itu, Kami degan hormat meminta maaf atas ketidaknyamanannya", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                });
                dialog.show();
            }
        });
    }
}