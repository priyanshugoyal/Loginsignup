package com.example.priyanshu.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    MyDBHandler handler = new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }

    public void onclicksubmit(View v) {
        if (v.getId() == R.id.button3) {
            EditText name = (EditText) findViewById(R.id.editText3);
            EditText email = (EditText) findViewById(R.id.editText4);
            EditText username = (EditText) findViewById(R.id.editText5);
            EditText password = (EditText) findViewById(R.id.editText6);
            EditText cpass = (EditText) findViewById(R.id.editText7);
            if(name.getText().toString().isEmpty()&&email.getText().toString().isEmpty()&&username.getText().toString().isEmpty()&&password.getText().toString().isEmpty()&&cpass.getText().toString().isEmpty())
                return;
            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String userstr = username.getText().toString();
            String passstr = password.getText().toString();
            String pass2str = cpass.getText().toString();
            if (!pass2str.equals(passstr)) {
                Toast.makeText(Main2Activity.this, "password does not match", Toast.LENGTH_SHORT).show();
            } else {
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUsername(userstr);
                c.setPass(passstr);
                handler.insertcontact(c);
                Toast.makeText(Main2Activity.this,"Data added successfully",Toast.LENGTH_SHORT).show();
                Intent i3=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i3);

            }


        }

    }
}
