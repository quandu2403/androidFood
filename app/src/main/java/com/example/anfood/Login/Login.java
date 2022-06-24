package com.example.anfood.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anfood.Adapter.HomeFoodAdapter;
import com.example.anfood.Menu.HomeFragment;
import com.example.anfood.Menu.Menu;
import com.example.anfood.R;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnlogin, btnsignup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsignin1);
        btnsignup = (Button) findViewById(R.id.btnsignup1);

        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("") ) {
                    Toast.makeText(Login.this, "Không hợp lệ ", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(Login.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Menu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Không hợp lệ 123", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Login.this, Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
