package com.example.zarinessan.glassconnect;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;


public class SignUp extends ActionBarActivity {


    private String username;
    private String password;
    private EditText userNameE;
    private EditText passWordE;
    private Button submit;
    private TextView myText = null;
    int problem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        submit = (Button) findViewById(R.id.submitUserB);
        userNameE = (EditText) findViewById(R.id.usernameF);
        passWordE = (EditText) findViewById(R.id.passwordF);
        myText = (TextView)findViewById(R.id.here);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = userNameE.getText().toString();
                password = passWordE.getText().toString();
                createUser();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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

    public void createUser(){
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    myText.setText("There was a problem with the information. Please try again.");
                }
                else {
                    myText.setText("Thanks for joining!");
                }
            }
        });
    }
}
