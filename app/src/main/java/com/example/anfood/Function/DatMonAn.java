package com.example.anfood.Function;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.anfood.Adapter.GoiY_MontrangmiengAdapter;
import com.example.anfood.Menu.Cart.CartActivity;
import com.example.anfood.Menu.Menu;
import com.example.anfood.Menu.Store.Euroliststore;
import com.example.anfood.Menu.Store.Japaneseliststore;
import com.example.anfood.Menu.Store.Koreanliststore;
import com.example.anfood.Model.MonTrangMieng;
import com.example.anfood.R;
import com.example.anfood.Menu.Store.Asianliststore;

import java.util.ArrayList;

public class DatMonAn extends AppCompatActivity {
    EditText ed_timkiem;
    LinearLayout btn_asian;
    LinearLayout btn_euro;
    LinearLayout btn_korean;
    LinearLayout btn_japanese;
    ImageView btn_backhome,btn_cart;
    ArrayList<MonTrangMieng> dsdesert = new ArrayList<>();
    RecyclerView rv_list_desert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_mon_an);
        ed_timkiem = findViewById(R.id.ed_timkiem);
        btn_backhome = findViewById(R.id.btn_backhome);
        rv_list_desert = findViewById(R.id.rv_montrangmieng);
        MonTrangMieng mtm= new MonTrangMieng("sda","Cơm gà trứng");
        MonTrangMieng mtm2= new MonTrangMieng("sda","Mì hải sản");
        MonTrangMieng mtm3= new MonTrangMieng("sda","Phở bò tươi");
        dsdesert.add(mtm); dsdesert.add(mtm2);dsdesert.add(mtm3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_list_desert.setLayoutManager(layoutManager);
        GoiY_MontrangmiengAdapter adapter = new GoiY_MontrangmiengAdapter(dsdesert);
        rv_list_desert.setAdapter(adapter);
        // list mon trang miệng
        // click vào menu vào danh sách cửa hàng
        btn_asian = findViewById(R.id.btn_asian);
        btn_asian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Asianliststore.class));
            }
        });

        btn_euro = findViewById(R.id.btn_euro);
        btn_euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Euroliststore.class));
            }
        });
        btn_korean = findViewById(R.id.btn_korean);
        btn_korean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Koreanliststore.class));
            }
        });

        btn_japanese = findViewById(R.id.btn_japanese);
        btn_japanese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Japaneseliststore.class));
            }
        });

        // click vào menu vào danh sách cửa hàng
        //click vào back  về home
        btn_backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), Menu.class));
            }
        });
        // chuyển sang cart
        btn_cart = findViewById(R.id.btn_cart);
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), CartActivity.class));
            }
        });
    }
}
