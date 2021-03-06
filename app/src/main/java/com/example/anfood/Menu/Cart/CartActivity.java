package com.example.anfood.Menu.Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anfood.Adapter.ListCartAdapter;
import com.example.anfood.Function.DatMonAn;
import com.example.anfood.Model.Cart;
import com.example.anfood.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
Toolbar tb;
RecyclerView rv_list_cart;
Button btn_cart_xacnhan;
public ArrayList<Cart> dsCartActivity = new ArrayList<>();
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(CartActivity.this, "Đã click", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        //custom toolbar
        tb=findViewById(R.id.tb_cart);
        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), DatMonAn.class));
            }
        });
        //List cart
        rv_list_cart=findViewById(R.id.rv_cart_list_food);
        Cart cart = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        Cart cart2 = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        Cart cart3 = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        Cart cart4 = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        dsCartActivity.add(cart); dsCartActivity.add(cart2); dsCartActivity.add(cart3); dsCartActivity.add(cart4);
        ListCartAdapter adapter = new ListCartAdapter(dsCartActivity);
        rv_list_cart.setLayoutManager(new LinearLayoutManager(this));
        rv_list_cart.setAdapter(adapter);
        adapter.setOnItemClickListener(onItemClickListener);
        //List cart
        // chuyển sang màn xác nhận đơn
        btn_cart_xacnhan = findViewById(R.id.btn_cart_xacnnhan);
        btn_cart_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),ConfirmCart.class));
            }
        });
    }
}
