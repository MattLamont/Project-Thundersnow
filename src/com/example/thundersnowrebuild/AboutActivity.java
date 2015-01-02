package com.example.thundersnowrebuild;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.example.thundersnowrebuild.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.widget.TextView;

public class AboutActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_activity_layout);
		
		
		TextView textView = (TextView) findViewById(R.id.log_text);
		
		
		
		try
		{
			AssetManager mngr = this.getAssets();
			BufferedReader reader = new BufferedReader(
			        new InputStreamReader(mngr.open("about_file")));
		
		 
		
			String line = null;
        
			try 
			{
			
				while((line = reader.readLine()) != null)
				{
					textView.append(line);
					textView.append("\n");
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
		
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_log, menu);
		return true;
	}

}
