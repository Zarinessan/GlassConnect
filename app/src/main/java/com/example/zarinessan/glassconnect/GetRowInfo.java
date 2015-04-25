package com.example.zarinessan.glassconnect;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;

import java.util.List;



public class GetRowInfo extends ActionBarActivity {

    private String myString2;
    private TextView myText2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_row_info);
        myString2 = " We are showing data for rows with the value " + getString(R.string.example_row_upload) + "\n\n ";
        printRowData();
        //newDisplay2("hello");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_column_info, menu);
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

    public void printRowData()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
        query.whereEqualTo( getString(R.string.example_column_upload),getString(R.string.example_row_upload) );
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                //newDisplay("starting done function");
                if (e == null) {
                    //newDisplay(Integer.toString(list.size()));
                    for(ParseObject current : list ) {
                        concatGlobal2(getString(R.string.example_column_upload)+":", current.get(getString(R.string.example_column_upload)).toString());
                        concatGlobal2(current.getCreatedAt().toString(), "\n");
                        newDisplay2(myString2);

                    }
                    //newDisplay("Outside for loop ");
                }
                else {
                    Log.d("foo", "Error: " + e.getMessage());
                    // newDisplay("else ");
                }
                // newDisplay("ending done function");
            }
        });

    }

    public void concatGlobal2(String title,String given)
    {
        myString2 = myString2 + title + " " + given + " ";
    }

    public void newDisplay2(String useThis)
    {
        myText2 = (TextView)findViewById(R.id.Legendary);
        String temp = "This is a temp string....";
        myText2.setText(useThis);

    }
}
