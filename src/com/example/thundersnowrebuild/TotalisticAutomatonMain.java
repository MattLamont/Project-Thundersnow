package com.example.thundersnowrebuild;

import com.example.thundersnowrebuild.MainActivity;
import com.example.thundersnowrebuild.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView.ScaleType;
import android.widget.*;


public class TotalisticAutomatonMain extends Activity 
{
	
	public Context mContext;
	final public int MARGIN = 6;
	final public int HALF_MARGIN = MARGIN / 2;
	public int BUTTON_SIZE;
	public int IMAGE_LENGTH;
	public int IMAGE_HEIGHT;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		mContext = TotalisticAutomatonMain.this;
		setMeasurements( this );
		
		ScrollView scrollView = new ScrollView( this );
		scrollView.setBackgroundColor(Color.BLACK);
		LinearLayout l = generateContentView( this );
		LayoutParams lp = new LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT);
		scrollView.addView(l, lp);
		
		
		setContentView(scrollView, lp);
		
		LinearLayout child1 = (LinearLayout) l.findViewById(1);
		LinearLayout child2 = (LinearLayout) l.findViewById(2);
		LinearLayout child3 = (LinearLayout) l.findViewById(3);

		
		ImageButton FirstButton = (ImageButton)child1.findViewById(4);
		ImageButton SecondButton = (ImageButton)child1.findViewById(5);
		ImageButton ThirdButton = (ImageButton)child2.findViewById(6);
		ImageButton FourthButton = (ImageButton)child2.findViewById(7);
		ImageButton FifthButton = (ImageButton)child3.findViewById(8);
		ImageButton SixthButton = (ImageButton)child3.findViewById(9);
		
		
		
		FirstButton.setOnClickListener( new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(mContext , CellularAutomatanMain.class );
        		startActivity(intent);
        	}

        });
		
        SecondButton.setOnClickListener( new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(mContext , AutomatonGeneratorActivity.class );
        		startActivity(intent);
        	}
        });
        
        ThirdButton.setOnClickListener( new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(mContext , TotalisticAutomatonMain.class );
        		startActivity(intent);
        	}
        });
        
        FourthButton.setOnClickListener( new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(mContext , PhotoGridActivity.class );
        		startActivity(intent);
        	}
        });
        
        FifthButton.setOnClickListener( new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(mContext , UpdateLog.class );
        		startActivity(intent);
        	}
        });
        
        SixthButton.setOnClickListener( new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(mContext , AboutActivity.class );
        		startActivity(intent);
        	}
        });
        
	}

	

	
	public LinearLayout generateContentView( Context context )
	{
		
		LinearLayout parent = new LinearLayout( context );
		parent.setOrientation(LinearLayout.VERTICAL);
		
		{
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( IMAGE_LENGTH , IMAGE_HEIGHT );
			ImageView iv = new ImageView( context );
			iv.setBackgroundColor(Color.BLACK);
			iv.setImageResource(R.drawable.main_app_picture);
			iv.setScaleType(ScaleType.FIT_XY);
			lp.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
			parent.addView( iv , lp );
		}
		
		
		
		LinearLayout child1 = new LinearLayout( context );
		child1.setOrientation(LinearLayout.HORIZONTAL);
		child1.setId(1);
		
		{
			ImageButton i = new ImageButton( context );
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( BUTTON_SIZE , BUTTON_SIZE );
			lp.setMargins(MARGIN, 0, HALF_MARGIN , MARGIN);
			i.setBackgroundColor(Color.parseColor("#63A827"));
			i.setImageResource(R.drawable.cellular_shell);
			i.setScaleType(ScaleType.FIT_CENTER);
			i.setId(4);
			child1.addView(i, lp);
		}
		
		{
			ImageButton i = new ImageButton( context );
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( BUTTON_SIZE , BUTTON_SIZE );
			lp.setMargins(HALF_MARGIN, 0, MARGIN , MARGIN);
			i.setBackgroundColor(Color.parseColor("#029ACC"));
			i.setImageResource(R.drawable.automaton_generator);
			i.setScaleType(ScaleType.FIT_CENTER);
			i.setId(5);
			child1.addView(i, lp);
		}
		
		
		LinearLayout child2 = new LinearLayout( context );
		child2.setOrientation(LinearLayout.HORIZONTAL);
		child2.setId(2);
		
		{
			ImageButton i = new ImageButton( context );
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( BUTTON_SIZE , BUTTON_SIZE );
			lp.setMargins(MARGIN, 0, HALF_MARGIN , MARGIN);
			i.setBackgroundColor(Color.parseColor("#034684"));
			i.setImageResource(R.drawable.totalistic_automatons);
			i.setScaleType(ScaleType.FIT_CENTER);
			i.setId(6);
			child2.addView(i, lp);
		}
		
		{
			ImageButton i = new ImageButton( context );
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( BUTTON_SIZE , BUTTON_SIZE );
			lp.setMargins(HALF_MARGIN, 0, MARGIN , MARGIN);
			i.setBackgroundColor(Color.parseColor("#284550"));
			i.setImageResource(R.drawable.poly_int_pic);
			i.setScaleType(ScaleType.FIT_CENTER);
			i.setId(7);
			child2.addView(i, lp);
		}
		
		
		LinearLayout child3 = new LinearLayout( context );
		child3.setOrientation(LinearLayout.HORIZONTAL);
		child3.setId(3);
		
		{
			ImageButton i = new ImageButton( context );
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( BUTTON_SIZE , BUTTON_SIZE );
			lp.setMargins(MARGIN, 0, HALF_MARGIN , MARGIN);
			i.setBackgroundColor(Color.parseColor("#393939"));
			i.setImageResource(R.drawable.update_log);
			i.setScaleType(ScaleType.FIT_CENTER);
			i.setId(8);
			child3.addView(i, lp);
		}
		
		{
			ImageButton i = new ImageButton( context );
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams( BUTTON_SIZE , BUTTON_SIZE );
			lp.setMargins(HALF_MARGIN, 0, MARGIN , MARGIN);
			i.setBackgroundColor(Color.parseColor("#d97326"));
			i.setImageResource(R.drawable.about_picture);
			i.setScaleType(ScaleType.FIT_CENTER);
			i.setId(9);
			child3.addView(i, lp);
		}
		
		
		LayoutParams lp = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		parent.addView(child1, lp);
		parent.addView(child2, lp);
		parent.addView(child3, lp);
		
	
		return parent;
	}
	
	
	
	
	
	
	private void setMeasurements(Context context) 
	{
		
		WindowManager wm = (WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		
		Point point = new Point();
		display.getSize( point );
		
		IMAGE_LENGTH = point.x - (MARGIN * 2);
		IMAGE_HEIGHT = (int) (IMAGE_LENGTH / 1.278);
		
		BUTTON_SIZE = ( point.x / 2 ) - ( MARGIN + HALF_MARGIN );
		
	}





	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

}

