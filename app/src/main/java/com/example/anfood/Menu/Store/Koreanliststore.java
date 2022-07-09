package com.example.anfood.Menu.Store;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anfood.Adapter.DBAdapter;
import com.example.anfood.Adapter.ListStoreAdapter;
import com.example.anfood.Function.DatMonAn;
import com.example.anfood.Model.Store;
import com.example.anfood.R;

import java.util.ArrayList;

public class Koreanliststore extends AppCompatActivity {
    Context context;
    DBAdapter dbAdapter;

    Toolbar tb;
    RecyclerView rv_list_store;
    ArrayList<Store> dsStore = new ArrayList<>();
    ArrayList<Store> dsMock = new ArrayList<>();

    public static String store_title,store_vitri,store_rating;
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)v.getTag();
            int position = viewHolder.getAdapterPosition();
            Store st = dsStore.get(position);
            store_title = st.getTitle();
            store_vitri = st.getVitri();
            store_rating=st.getRating()+"";
            startActivity(new Intent(v.getContext(),StoreDetails.class));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_store);
        dbAdapter = new DBAdapter(Koreanliststore.this);
        //custom toolbar
        tb=findViewById(R.id.toolbar_store);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DatMonAn.class);
                startActivity(i);
            }
        });
        //custom toolbar
        rv_list_store = findViewById(R.id.rv_list_store);
//        Store[] stores = {
////                new Store(R.drawable.banhmi,"Gà rán KFC, Nguyễn Văn Cừ",4.5,"6km(45 phút)","Fast Food, thức ăn trưa, Món Châu Á"),
////                new Store(R.drawable.banhmi,"Gà rán KFC, Nguyễn Văn Cừ",4.5,"6km(45 phút)","Fast Food, thức ăn trưa, Món Châu Á"),
//
//        };
//
//        for(Store store: stores){
//            dsStore.add(store);
//        }
        String Korean = "Korean";
        dsStore = dbAdapter.geteverything();
        int images[] = {R.drawable.banhmi, R.drawable.logo};


        for(Store store: dsStore){
            if(store.getCountry().equals(Korean)){
                dsMock.add(store);
            }
        }
        for(Store store: dsMock){
            for(int img: images){
                store.setImg(img);
            }
        }
//        Log.e(dsStore.get(0).getTitle(), "Hello");
        ListStoreAdapter adapter = new ListStoreAdapter(dsMock);
        rv_list_store.setLayoutManager(new LinearLayoutManager(this));
        rv_list_store.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);

    }
}
