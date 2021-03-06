package com.example.anfood.Menu.HoaDon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.anfood.Adapter.ListHoaDonAdapter;
import com.example.anfood.Menu.Menu;
import com.example.anfood.Model.Bill;
import com.example.anfood.R;

import java.util.ArrayList;

public class ListHoaDon extends AppCompatActivity {
Toolbar tb;
RecyclerView rv_list_hoadon;
ArrayList<Bill> dsBill = new ArrayList<>();
private View.OnClickListener onItemClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
        int position = viewHolder.getAdapterPosition();
        Bill bill = dsBill.get(position);
        startActivity(new Intent(ListHoaDon.this,HoaDonChiTiet.class));
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoa_don);
        //custom toolbar
        tb=findViewById(R.id.tb_lichsu_hoadon);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Menu.class));
            }
        });
        // list hoa đơn
        rv_list_hoadon=findViewById(R.id.rv_list_hoadon);
        Bill b1 = new Bill("11/01/2019 - 03:37","Gà rán KFC, Nguyễn Văn Cừ","11 thg 11, 03:37","237.000","Đã thanh toán",4.8);
        Bill b2 = new Bill("23/03/2019 - 10:12","Bánh xèo mười xiềm","12 thg 03, 02:17","135.000","Đã thanh toán",4.2);
        Bill b3 = new Bill("05/06/2019 - 02:14","Bia hơi Hải xồm","05 thg 02, 01:34","65.000","Đã thanh toán",2.2);
        dsBill.add(b1); dsBill.add(b2); dsBill.add(b3);
        ListHoaDonAdapter adapter = new ListHoaDonAdapter(dsBill);
        rv_list_hoadon.setLayoutManager(new LinearLayoutManager(this));
        rv_list_hoadon.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);

    }
}
