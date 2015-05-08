package com.example.zarinessan.glassconnect;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class SignIn extends ActionBarActivity {

    private String username;
    private String password;
    private EditText userNameE;
    private EditText passWordE;
    private Button login;
    private TextView myText = null;
    int problem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        login = (Button) findViewById(R.id.loginB);
        userNameE = (EditText) findViewById(R.id.userInE);
        passWordE = (EditText) findViewById(R.id.passInE);
        myText = (TextView)findViewById(R.id.Here_signIn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = userNameE.getText().toString();
                password = passWordE.getText().toString();
                loginUser();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);
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

    public void loginUser(){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if(e != null){
                    myText.setText("There was a problem with the information. Please try again.");
                }
                else {
                    myText.setText("You are now signed in");
                }
            }
        });
    }
}
