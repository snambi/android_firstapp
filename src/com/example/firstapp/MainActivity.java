package com.example.firstapp;

import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private boolean assignedImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if(BuildConfig.DEBUG){
        	Log.d("Log", "app started");
        }
        
        RadioGroup radiogrp = (RadioGroup) findViewById(R.id.orientation);
        radiogrp.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch( checkedId ){
				case R.id.horizontal:
					group.setOrientation(LinearLayout.HORIZONTAL);
					break;
				case R.id.vertical:
					group.setOrientation(LinearLayout.VERTICAL);
					break;
				}
				
			}
		});
    }
    
    public void onClick( View view){
    	EditText text = (EditText) findViewById(R.id.editText1);
    	
    	
    	Toast t = Toast.makeText(this, 
    							("Text :" + text.getText().toString()), 
    							Toast.LENGTH_LONG);
    	t.show();
    }
    
    
    public void swapImage( View view ){
    	
    	AssetManager assetMgr = getAssets();
    	InputStream inputStream = null;
    	
    	ImageView image = (ImageView) findViewById(R.id.imageView1);
    	
    	if( assignedImage == false ){
    		image.setImageResource(R.drawable.android_assigned);
    		assignedImage = true;
    	}else{
    		image.setImageResource(R.drawable.android_initial);
    		assignedImage = false;
    	}
    	
    	
    }
}
