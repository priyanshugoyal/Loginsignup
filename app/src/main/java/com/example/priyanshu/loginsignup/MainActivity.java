package com.example.priyanshu.loginsignup;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDBHandler handler=new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
public void loginclick(View v1)
{
    if(v1.getId()==R.id.button) {
        EditText e1 = (EditText) findViewById(R.id.editText);
        EditText e2 = (EditText) findViewById(R.id.editText2);
        if(e1.getText().toString().isEmpty()&&e2.getText().toString().isEmpty())
            return;
        String str1 = e1.getText().toString();
        String str2 = e2.getText().toString();
        String pass1 = handler.searchPass(str1);
        if (str2.equals(pass1)) {
            Intent i = new Intent(MainActivity.this, Display.class);
            startActivity(i);
        } else {
            Toast.makeText(MainActivity.this, "username or password incorrect", Toast.LENGTH_SHORT).show();
        }
    }
    if (v1.getId() == R.id.button2) {
        Intent i = new Intent(MainActivity.this,Main2Activity.class);

        startActivity(i);
        }

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
