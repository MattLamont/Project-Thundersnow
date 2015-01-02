package com.example.thundersnowrebuild;

import com.example.thundersnowrebuild.R.drawable;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class DrawerSelectorProvider 
{
	//Data Members
	
	Context mContext;
	
	LinearLayout ColorPickerDrawer;
	LinearLayout ResolutionPickerDrawer;
	
	int color_array[] = new int[7];
	int resolution_array[] = new int[5];
	
	int currentColor;
	int currentResolution;
	
	
	//Methods
	
	public DrawerSelectorProvider( Context context )
	{
		
		//initialize private data members
		mContext = context;
		
	}
	
	
	
	//used by calling activity to setup menu displays for the given menu item
	void addMenuItem( String itemName )
	{
		
		if( itemName == "color_picker")
		{
			fillColorPicker();
		}
		
		if( itemName == "resolution_picker")
		{
			fillResolutionPicker();
		}
			
	}



	//Fills linear layout with color picker options
	private void fillResolutionPicker() 
	{
		LinearLayout.LayoutParams colorDrawerParams = new LinearLayout.LayoutParams( LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT );
		ResolutionPickerDrawer = new LinearLayout( mContext );
		ResolutionPickerDrawer.setLayoutParams(colorDrawerParams);
		ResolutionPickerDrawer.setPadding(10, 10, 10, 10);
		ResolutionPickerDrawer.setClickable(true);
		ResolutionPickerDrawer.setBackgroundResource(drawable.drawer_border_background);
		ResolutionPickerDrawer.setOrientation(1);
		ResolutionPickerDrawer.setVisibility(LinearLayout.GONE);
		
		
		//params to be used for textview
		RelativeLayout.LayoutParams tv_params = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT );
		tv_params.setMargins(10, 10, 10, 10);
		
		
		//layout params for use in container layout
		RelativeLayout.LayoutParams layout_params = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		layout_params.setMargins(10, 10, 10, 10);
		
		Typeface typeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/advent_bold.ttf");
		
		//Adding Drawer Title
		TextView title = new TextView( mContext );
		title.setLayoutParams(tv_params);
		title.setTypeface(typeFace);
		title.setText("CELL SIZE");
		title.setTextColor(Color.WHITE);
		title.setTextSize(30);
		ResolutionPickerDrawer.addView(title);
		
		//create array of color values for image view 
		resolution_array[0] = 1;
		resolution_array[1] = 2;
		resolution_array[2] = 4;
		resolution_array[3] = 8;
		resolution_array[4] = 16;
	
				
		//create array of color names for text view
		String[] resolution_names = new String[7];
		resolution_names[0] = "LENGTH: 1";
		resolution_names[1] = "LENGTH: 2";
		resolution_names[2] = "LENGTH: 4";
		resolution_names[3] = "LENGTH: 8";
		resolution_names[4] = "LENGTH: 16";
		
		for( int i = 0 ; i < resolution_array.length ; i++ )
		{
			RelativeLayout containerLayout = new RelativeLayout( mContext );
			containerLayout.setClickable(true);
			containerLayout.setId(i);
			containerLayout.setBackgroundColor(Color.TRANSPARENT);
			containerLayout.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{
					int current_id = v.getId();
					ResolutionPickerDrawer.setVisibility(RelativeLayout.GONE);
					setCurrentResolution( current_id );
					LinearLayout temp = (LinearLayout) v.getParent();
					temp.performClick();
				}
			});
			
			
			TextView tv = new TextView( mContext );
			tv.setTypeface(typeFace);
			tv.setTextColor(Color.WHITE);
			tv.setText(resolution_names[i]);
			tv.setTextSize((float) 20 );
			
			containerLayout.addView(tv , tv_params);
			
			ResolutionPickerDrawer.addView(containerLayout , layout_params );
			
		}
	}

	
	//Fills linear layout with resolution picker options
	private void fillColorPicker() 
	{
		LinearLayout.LayoutParams colorDrawerParams = new LinearLayout.LayoutParams( LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT );
		ColorPickerDrawer = new LinearLayout( mContext );
		ColorPickerDrawer.setLayoutParams(colorDrawerParams);
		ColorPickerDrawer.setPadding(10, 10, 10, 10);
		ColorPickerDrawer.setClickable(true);
		ColorPickerDrawer.setBackgroundResource(drawable.drawer_border_background);
		ColorPickerDrawer.setOrientation(1);
		ColorPickerDrawer.setVisibility(LinearLayout.GONE);
		
		RelativeLayout.LayoutParams iv_params = new RelativeLayout.LayoutParams( 30 , 30 );
		iv_params.setMargins(10, 10, 10, 10);
		iv_params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		
		//params to be used for textview
		RelativeLayout.LayoutParams tv_params = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT );
		tv_params.setMargins(10, 10, 10, 10);
		
		
		//layout params for use in container layout
		RelativeLayout.LayoutParams layout_params = new RelativeLayout.LayoutParams( LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		layout_params.setMargins(10, 10, 10, 10);
		
		Typeface typeFace = Typeface.createFromAsset(mContext.getAssets(),"fonts/advent_bold.ttf");
		
		//Adding Drawer Title
		TextView title = new TextView( mContext );
		title.setLayoutParams(tv_params);
		title.setTypeface(typeFace);
		title.setText("CELL COLOR");
		title.setTextColor(Color.WHITE);
		title.setTextSize(30);
		ColorPickerDrawer.addView(title);
		
		//create array of color values for image view 
		color_array[0] = Color.BLUE;
		color_array[1] = Color.CYAN;
		color_array[2] = Color.GREEN;
		color_array[3] = Color.MAGENTA;
		color_array[4] = Color.RED;
		color_array[5] = Color.YELLOW;
		color_array[6] = Color.WHITE;
		
		//create array of color names for text view
		String[] color_names = new String[7];
		color_names[0] = "BLUE";
		color_names[1] = "CYAN";
		color_names[2] = "GREEN";
		color_names[3] = "MAGENTA";
		color_names[4] = "RED";
		color_names[5] = "YELLOW";
		color_names[6] = "WHITE";
		
		
		for( int i = 0 ; i < color_array.length ; i++ )
		{
			RelativeLayout containerLayout = new RelativeLayout( mContext );
			containerLayout.setClickable(true);
			containerLayout.setId(i);
			containerLayout.setBackgroundColor(Color.TRANSPARENT);
			containerLayout.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v) 
				{
					v.setBackgroundColor(Color.LTGRAY);
					int current_id = v.getId();
					ColorPickerDrawer.setVisibility(RelativeLayout.GONE);
					setCurrentColor( current_id );
					LinearLayout temp = (LinearLayout) v.getParent();
					temp.performClick();
				}
			});
			
			ImageView iv = new ImageView( mContext );
			iv.setLayoutParams( iv_params );
			iv.setBackgroundColor( color_array[i] );
			iv.setId(1);
			
			TextView tv = new TextView( mContext );
			tv.setTypeface(typeFace);
			tv.setTextColor(Color.WHITE);
			tv.setText(color_names[i]);
			tv.setTextSize((float) 20 );
			tv_params.addRule(RelativeLayout.RIGHT_OF, iv.getId() );
			
			containerLayout.addView(iv , iv_params);
			containerLayout.addView(tv , tv_params);
			
			ColorPickerDrawer.addView(containerLayout , layout_params );
			
		}
		
	}
	
	
	//returns the layout containing the color picker drawer
	public LinearLayout getColorPickerDrawer()
	{
		return ColorPickerDrawer;
		
	}
	
	public LinearLayout getResolutionPickerDrawer()
	{
		return ResolutionPickerDrawer;
	}
	
	private void setCurrentColor( int current_id )
	{
		currentColor = color_array[ current_id ];
	}
	
	private void setCurrentResolution( int current_id )
	{
		currentResolution = resolution_array[ current_id ];
	}
	
	
	public int getCurrentColor()
	{
		return currentColor;
	}
	
	public int getCurrentResolution()
	{
		return currentResolution;
	}
	
	
}
