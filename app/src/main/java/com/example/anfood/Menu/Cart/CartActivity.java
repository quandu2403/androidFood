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

        tb.setNavigationIcon(R.drawable.ic_back);
        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), DatMonAn.class));
            }
        });
        //List cart

        Cart cart = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        Cart cart2 = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        Cart cart3 = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        Cart cart4 = new Cart("acb",287.987,"Combo beef steak - Size Vừa - \n" +
                "Đế giày",1);
        dsCartActivity.add(cart); dsCartActivity.add(cart2); dsCartActivity.add(cart3); dsCartActivity.add(cart4);

        rv_list_cart.setLayoutManager(new LinearLayoutManager(this));


        //List cart
        // chuyển sang màn xác nhận đơn

     
    }
}
