package com.example.thundersnowrebuild;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.example.thundersnowrebuild.DrawerSelectorProvider;
import com.example.thundersnowrebuild.GenerateView;
import com.example.thundersnowrebuild.R;

public class CellularAutomatanMain extends Activity
{
	public Context mContext = CellularAutomatanMain.this;
	public ArrayList<boolean[]> truthArrayList = new ArrayList();
	public GenerateView automatonView;
	public DrawerSelectorProvider mDSP;
	public FrameLayout mFrameLayout;
	public LinearLayout drawerLayout;
	public LinearLayout headerLayout;
	public MenuItem fullscreen;
	public int WIDTH = 0;
	public int HEIGHT = 0;
	public int currentPosition = 99;
	public int currentColor = Color.WHITE;
	public int currentResolution = 4;
	public boolean isFullscreenShown = false;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cellular_automatan_main);
		
		WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		
		Point point = new Point();
		display.getSize( point );
		WIDTH = point.x;
		HEIGHT = point.y;
		
		boolean truth_arr0[] = {false,false,false,true,true,true,true,false};
		boolean truth_arr1[] = {false,false,true,true,true,true,false,false};
		boolean truth_arr2[] = {false,true,false,true,true,false,true,false};
		boolean truth_arr3[] = {true,false,false,true,true,true,true,false};
		boolean truth_arr4[] = {false,false,true,true,false,false,true,false};
		boolean truth_arr5[] = {false,false,true,true,false,true,true,false};
		boolean truth_arr6[] = {false,false,true,true,true,true,true,false};
		boolean truth_arr7[] = {false,true,false,true,true,true,true,false};
		boolean truth_arr8[] = {false,true,true,false,false,true,true,false};
		boolean truth_arr9[] = {false,true,true,false,false,true,true,false};
		boolean truth_arr10[] = {false,true,true,false,false,true,true,false};
		boolean truth_arr11[] = {true,false,false,true,false,true,true,false};
		boolean truth_arr12[] = {true,false,false,true,false,true,true,false};
		boolean truth_arr13[] = {true,false,true,true,false,true,true,false};
		boolean truth_arr14[] = {true,false,true,true,true,true,false,false};
		boolean truth_arr15[] = {true,false,true,true,true,true,true,false};
		boolean truth_arr16[] = {true,true,false,true,true,true,false,false};
		boolean truth_arr17[] = {true,true,false,true,true,true,true,false};
		truthArrayList.add( truth_arr0 );
		truthArrayList.add( truth_arr1 );
		truthArrayList.add( truth_arr2 );
		truthArrayList.add( truth_arr3 );
		truthArrayList.add( truth_arr4 );
		truthArrayList.add( truth_arr5 );
		truthArrayList.add( truth_arr6 );
		truthArrayList.add( truth_arr7 );
		truthArrayList.add( truth_arr8 );
		truthArrayList.add( truth_arr9 );
		truthArrayList.add( truth_arr10 );
		truthArrayList.add( truth_arr11 );
		truthArrayList.add( truth_arr12 );
		truthArrayList.add( truth_arr13 );
		truthArrayList.add( truth_arr14 );
		truthArrayList.add( truth_arr15 );
		truthArrayList.add( truth_arr16 );
		truthArrayList.add( truth_arr17 );  
		
		
		TextView tv1 = (TextView) findViewById( R.id.tv1 );
		TextView tv2 = (TextView) findViewById( R.id.tv2 );
		
		
		Typeface typeFace = Typeface.createFromAsset(getAssets(),"fonts/advent_bold.ttf");
		
		tv1.setTypeface(typeFace);
		tv2.setTypeface(typeFace);
		
		mFrameLayout = (FrameLayout) findViewById( R.id.frame_lay);
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new ImageAdapter(this));
	    
	    LinearLayout headerLayout = (LinearLayout) findViewById( R.id.HeaderLayout );
    	headerLayout.setOnClickListener( new OnClickListener()
    	{

			@Override
			public void onClick(View v) 
			{
				if( currentPosition == 99 )
				{
					return;
				}
				
				drawerLayout.setVisibility(LinearLayout.GONE);
				LinearLayout headerLayout = (LinearLayout) findViewById( R.id.HeaderLayout );
				headerLayout.setBackgroundResource(R.drawable.transparent_rect_blue);
				Intent intent = new Intent( CellularAutomatanMain.this , AutomatonActivity.class );
            	Bundle bundle = new Bundle();
            	bundle.putBooleanArray("rules", truthArrayList.get( currentPosition ) );
            	bundle.putInt("color", currentColor );
            	bundle.putInt("resolution", currentResolution);
            	intent.putExtra("intent.rule", bundle);
        		startActivity(intent);
				
			}
    		
    	});
    	
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() 
	    {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id ) 
	        {
	        	drawerLayout = (LinearLayout) findViewById( R.id.drawer_frame_layout );
	        	drawerLayout.setVisibility(LinearLayout.GONE);
	        	setCurrentPosition( position );
	        	displayAutomatonView();
	        	showFullScreenIcon();
	        }
	    }); 
	}
	
	
	
	public void displayAutomatonView()     
	{
		if( currentPosition == 99 )
		{
			return;
		}
		
		Bundle bundle = new Bundle();
    	bundle.putBooleanArray("rules", truthArrayList.get(currentPosition) );
    	bundle.putInt("color", currentColor );
    	bundle.putInt("resolution", currentResolution);
    	automatonView = new GenerateView( mContext , bundle);
    
    	headerLayout = (LinearLayout) findViewById( R.id.HeaderLayout );
    	if( headerLayout.getChildCount() == 1 )
    	{
    		headerLayout.removeAllViews();
    		headerLayout.addView( automatonView );
    	}
    	
    	else
    	{
    		headerLayout.removeView( findViewById( R.id.tv1 ));
    		headerLayout.removeView( findViewById( R.id.tv2 ));
    		headerLayout.addView( automatonView );
    	}
    	
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) 
	{
		super.onPrepareOptionsMenu(menu);
		
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.cellular_automatons_menu , menu);
	    
	    ActionBar actionBar = getActionBar();
	    actionBar.setDisplayShowTitleEnabled(false);
	    Drawable actionBarBackground = this.getResources().getDrawable( R.drawable.cellular_actionbar_background );
	    actionBar.setBackgroundDrawable( actionBarBackground );
	    
	    fullscreen = menu.findItem( R.id.fullscreen );
	    if( isFullscreenShown == true )
	    {
	    	fullscreen.setVisible(true);
	    }
	    
	    mDSP = new DrawerSelectorProvider( mContext );
	    mDSP.addMenuItem( (String) "color_picker" );
	    mDSP.addMenuItem( (String) "resolution_picker" );
	    
	    return super.onPrepareOptionsMenu(menu);
	    
	}
	
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		drawerLayout = (LinearLayout) findViewById( R.id.drawer_frame_layout );
		drawerLayout.removeAllViewsInLayout();
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
		
		if( mItemId == R.id.fullscreen )
		{
			clickHeaderLayout();
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
	
	private void setCurrentPosition( int position )
	{
		currentPosition = position;
	}
	
	private void showFullScreenIcon()
	{	
		isFullscreenShown = true;
		
		this.invalidateOptionsMenu();
	}
	
	private void clickHeaderLayout()
	{
		headerLayout.performClick();
	}
}



	


