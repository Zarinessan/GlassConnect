package com.example.zarinessan.glassconnect;

import android.app.Application;

import com.parse.Parse;


/**
 * Created by Zarinessan on 3/9/2015.
 */
public class GlassConnectApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "HdW6TyGXpGG0ateTG08q9tRiNsD9Ex5V3CZnnuYv", "4aGhsdMWT3ZzUPvThklFeXXCZ3QzrGcwa2dXdLwn");



    }

}


