package com.example.anfood.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.anfood.MainActivity;
import com.example.anfood.Menu.Menu;
import com.example.anfood.R;

public class Register extends AppCompatActivity {
    EditText username, password, repassword;
    LottieAnimationView btn_signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText username = findViewById(R.id.username);

        password = findViewById(R.id.password);
        btn_signup = findViewById(R.id.btn_signup);
        repassword = findViewById(R.id.repassword);
        DB = new DBHelper(this);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_signup.playAnimation();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(Register.this,"Empty data provided.", Toast.LENGTH_LONG).show();
                }else {
                    if(TextUtils.equals(pass, repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(!checkuser) {
                            Boolean insert = DB.insertData(user, pass);
                            if(insert) {
                                btn_signup.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(Register.this, Login.class);
                                        Toast.makeText(Register.this,"Đăng Ký thành công", Toast.LENGTH_SHORT).show();
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                            } else {
                                Toast.makeText(Register.this,"Đăng Ký thất bại", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Register.this,"tài khoản đã đăng ký", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        Toast.makeText(Register.this,"Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
