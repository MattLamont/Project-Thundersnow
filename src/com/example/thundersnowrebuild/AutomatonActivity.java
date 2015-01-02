package com.example.thundersnowrebuild;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AutomatonActivity extends Activity
{
	
	Context mContext = AutomatonActivity.this;
	DrawerSelectorProvider mDSP;
	GenerateView automatonView;
	LinearLayout drawerLayout;
	ScrollView sv;
	FrameLayout mFrameLayout;
	int currentColor = Color.WHITE;
	int currentResolution = 4;
	boolean[] truth_array;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		Bundle bundle = getIntent().getBundleExtra("intent.rule");
		currentColor = bundle.getInt("color");
		currentResolution = bundle.getInt("resolution");
		truth_array = bundle.getBooleanArray("rules");
		
		mFrameLayout = new FrameLayout( mContext );
		FrameLayout.LayoutParams frame_params = new FrameLayout.LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT);
		mFrameLayout.setLayoutParams(frame_params);
		
		sv = new ScrollView( mContext );
		ScrollView.LayoutParams params = new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		sv.setBackgroundColor(Color.BLACK);
		displayAutomatonView();
		
		mFrameLayout.addView(sv, params);
		super.onCreate(savedInstanceState);
		setContentView( mFrameLayout );
		
	}
	
	private void displayAutomatonView() 
	{
		
		Bundle bundle = new Bundle();
    	bundle.putBooleanArray("rules", truth_array );
    	bundle.putInt("color", currentColor );
    	bundle.putInt("resolution", currentResolution);
    	automatonView = new GenerateView( mContext , bundle);
    	sv.removeAllViews();
    	sv.addView( automatonView );
    	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		super.onCreateOptionsMenu(menu);
		
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.automaton_activity_menu , menu);
	    
	    ActionBar actionBar = getActionBar();
	    actionBar.setDisplayShowTitleEnabled(true);
	    actionBar.setTitle( (String) "AUTOMATON VIEWER");
	    Drawable actionBarBackground = this.getResources().getDrawable( R.drawable.cellular_actionbar_background );
	    actionBar.setBackgroundDrawable( actionBarBackground );
	    
	    mDSP = new DrawerSelectorProvider( mContext );
	    mDSP.addMenuItem( (String) "color_picker" );
	    mDSP.addMenuItem( (String) "resolution_picker" );
	    
	    return super.onCreateOptionsMenu(menu);
	    
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		drawerLayout = new LinearLayout( mContext );
		drawerLayout.setVisibility(LinearLayout.GONE);
		
		
		int mItemId = item.getItemId();
		
		if( mItemId == R.id.color_picker )
		{
			drawerLayout = mDSP.getColorPickerDrawer();
			drawerLayout.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					drawerLayout.setVisibility(LinearLayout.GONE);
					setCurrentColor();
					displayAutomatonView();
				}
						
			});
		}
		
		if( mItemId == R.id.resolution_picker )
		{
			drawerLayout = mDSP.getResolutionPickerDrawer();
			drawerLayout.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					drawerLayout.setVisibility(LinearLayout.GONE);
					setCurrentResolution();
					displayAutomatonView();
				}
						
			});
		}
		
		
		mFrameLayout.removeView( drawerLayout );
		mFrameLayout.addView(drawerLayout);
		
		if(drawerLayout.isShown())
		{
			drawerLayout.setVisibility(LinearLayout.GONE);
		}
		
		else
		{
			drawerLayout.setVisibility(LinearLayout.VISIBLE);
		}
		
		return false;
		
	}
	
	
	private void setCurrentColor()
	{
		currentColor = mDSP.getCurrentColor();
	}
	
	
	private void setCurrentResolution()
	{
		currentResolution = mDSP.getCurrentResolution();
	}
	
	

}
