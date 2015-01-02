package com.example.thundersnowrebuild;

import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.lang.Math;

public class QuiltView extends View
{
	public final int picture_count = 20;
	public final int width;
	public final int first_column;
	public final int second_column;
	

	public QuiltView(Context context) 
	{
		super(context);
		int orientation = context.getResources().getConfiguration().orientation;
		
		RelativeLayout relativeLayout = new RelativeLayout(context);
		LayoutParams params = new LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		relativeLayout.setLayoutParams(params);
		relativeLayout.setBackgroundColor( Color.BLACK );
		
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		
		width = display.getWidth();
		
		first_column = Math.abs( width / 3 );
		second_column = first_column * 2;
		
		ImageView column_one_view = new ImageView(context);
		ImageView column_two_view = new ImageView(context);
		
		column_one_view.setLayoutParams( new LayoutParams( 1 , LayoutParams.MATCH_PARENT));
		column_one_view.setBackgroundColor( Color.WHITE );
		column_two_view.setLayoutParams( new LayoutParams( 1 , LayoutParams.MATCH_PARENT));
		column_two_view.setBackgroundColor( Color.WHITE );
		
		
		
		
		
		
	}

}
