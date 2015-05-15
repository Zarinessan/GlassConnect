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



public class GetColumnInfo extends ActionBarActivity {

    private String myString;
    private TextView myText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_column_info);
        myString = " We are showing data for the column " + getString(R.string.example_column_upload) + " \n\n ";
        printColumnData();
       // newDisplay();
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

    public void printColumnData()
    {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(getString(R.string.table_name));
        query.whereNotEqualTo( getString(R.string.example_column_upload),"\0" );
        //query.whereEqualTo( getString(R.string.example_column_upload),getString(R.string.example_row_upload) );
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> list, ParseException e) {
                //newDisplay("starting done function");
                if (e == null) {
                   // newDisplay(Integer.toString(list.size()));
                    for(ParseObject current : list ) {
                        concatGlobal("", current.get(getString(R.string.example_column_upload)).toString());
                        //concatGlobal(current.getCreatedAt().toString(), "\n");
                        newDisplay(myString);

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

    public void concatGlobal(String title,String given)
    {
        myString = myString + title + " " + given + " \n";
    }

    public void newDisplay(String useThis)
    {
        myText = (TextView)findViewById(R.id.textView);
        String temp = "This is a temp string....";
        myText.setText(useThis);

    }
}
