package com.example.anfood.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.anfood.MainActivity;
import com.example.anfood.Menu.Menu;
import com.example.anfood.R;

public class Register extends AppCompatActivity {
    EditText username, password, repassword;
    Button signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText username = findViewById(R.id.username);

        password = findViewById(R.id.password);
        signup = findViewById(R.id.btnOk);
        DB = new DBHelper(this);

//        signup.setOnClickListener(new View.OnClickListener()  {
//            @Override
//            public void onClick(View view) {
//                // stay
//
//                String user = username.getText().toString();
//                String pass = password.getText().toString();
//                String repass = repassword.getText().toString();
//
//
//
//                if(user.equals("") || pass.equals("") || repass.equals("")) {
//
//                    Toast.makeText(Register.this, "Không hợp lệ", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    if (pass.equals(repass)) {
//                        Boolean checkuser = DB.checkusername(user);
//                        if(checkuser == false) {
//                            Boolean insert = DB.insertData(user, pass);
//
//                            if(insert == true) {
//                                Intent intent = new Intent(getApplicationContext(), Login.class);
//                                Toast.makeText(Register.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                                startActivity(intent);
//                            } else {
//                                Toast.makeText(Register.this,"Đăng Ký thất bại", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(Register.this,"tài khoản đã đăng ký", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(Register.this,"Mật khẩu không hơp", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
                    Toast.makeText(Register.this,"Empty data provided.", Toast.LENGTH_LONG).show();
                }else {
                    Boolean insert = DB.insertData(user, pass);
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                    finish();
                }

//                String user = username.getText().toString();
//                String pass = password.getText().toString();
//                String repass = repassword.getText().toString();
//
//
//                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)){
//                    Toast.makeText(Register.this,"Empty data provided.", Toast.LENGTH_LONG).show();
//                }else {
////                    Boolean insert = DB.insertData(user, pass);
////                    Intent intent = new Intent(Register.this, Login.class);
////                    startActivity(intent);
////                    finish();
//                    if (pass === repass) {
//                        Boolean checkuser = DB.checkusername(user);
//                        if(checkuser == false) {
//                            Boolean insert = DB.insertData(user, pass);
//                            if(insert == true) {
//                                Intent intent = new Intent(getApplicationContext(), Login.class);
//                                Toast.makeText(Register.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                                startActivity(intent);
//                                finish();
//                            } else {
//                                Toast.makeText(Register.this,"Đăng Ký thất bại", Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
//                            Toast.makeText(Register.this,"tài khoản đã đăng ký", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(Register.this,"Mật khẩu không hơp", Toast.LENGTH_SHORT).show();
//                    }
//                }
            }
        });
    }
}
