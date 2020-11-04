package com.example.qlsv_tuan9_t5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "quanlisinhviennew.db";
    SQLiteDatabase sqLiteDatabase;

    Button btThem;
    ListView lvSinhVien;
    ArrayList<com.example.qlsv_tuan9_t5.SinhVien> listSinhVien;
    com.example.qlsv_tuan9_t5.AdapterSinhVien adapterSinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addControls();
        readData();
    }
    private void addControls(){
        btThem = (Button)findViewById(R.id.btThem);
        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.qlsv_tuan9_t5.MainActivity.this, com.example.qlsv_tuan9_t5.AddActivity.class);
                startActivity(intent);
            }
        });
        lvSinhVien = (ListView)findViewById(R.id.lvSinhVien);
        listSinhVien = new ArrayList<>();
        adapterSinhVien = new com.example.qlsv_tuan9_t5.AdapterSinhVien(this,listSinhVien);
        lvSinhVien.setAdapter(adapterSinhVien);
    }
    private void readData(){
        sqLiteDatabase = MyDatabase.initDatabase(this,DATABASE_NAME);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM sinhvien",null);
        listSinhVien.clear();
        for(int i = 0;i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String ngaySinh = cursor.getString(2);
            String lop = cursor.getString(3);
            byte[] anh = cursor.getBlob(4);
            listSinhVien.add(new com.example.qlsv_tuan9_t5.SinhVien(id,name,ngaySinh,lop,anh));
        }
        adapterSinhVien.notifyDataSetChanged();
    }
}