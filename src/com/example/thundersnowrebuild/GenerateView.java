package com.example.thundersnowrebuild;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;
import java.lang.Math;


public class GenerateView extends View
{
	
	
	public boolean[] truth_arr;
	int color = Color.WHITE;
	int resolution = 4;
	Context mContext;
	int mWidth = 0;
	int mHeight = 0;

	
	
	public GenerateView(Context context, Bundle bundle ) 
	{
		super(context);
		mContext = context;
		truth_arr = bundle.getBooleanArray("rules");
		color = bundle.getInt("color");
		resolution = bundle.getInt("resolution");
	}
	
	
	
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) 
	{
		WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point point = new Point();
		display.getSize( point );
		
		mWidth = point.x;
		mHeight = point.y * 2;
	    setMeasuredDimension( mWidth , mHeight );
	}
	

	@Override
	protected void onDraw(Canvas canvas) 
	{
		//Modifiers to be Edited
 		Paint myColor = new Paint();
		
/*----------------------Square Color Set--------------------------------*/		
		myColor.setColor( color );
/*----------------------Square Color Set--------------------------------*/
		
/*----------------------Square Side Length--------------------------------*/		
		final int square_size = resolution;
/*----------------------Square Side Length--------------------------------*/
		
		
		
		super.onDraw(canvas);
	
		Rect myRect = new Rect();
		myRect.set(0,0,canvas.getWidth() - 10 , canvas.getHeight());    
		
		Paint black = new Paint();
		black.setColor(Color.TRANSPARENT);
		black.setStyle(Paint.Style.FILL);
		
		
		
		canvas.drawRect(myRect, black);
		
		VisibilityChecker visibilityChecker = new VisibilityChecker( truth_arr );
		
		
		
		int vert_lines = (int) Math.floor( mHeight / square_size );
		int horiz_lines = (int) Math.floor( mWidth / square_size );
		
		String logString = "vert_lines = " + vert_lines + "orig = " + canvas.getHeight();
		String logString2 = "horiz_lines = " + horiz_lines + "orig = " + canvas.getWidth();
		Log.d("ThunderSnow", logString);
		Log.d("ThunderSnow", logString2);
		
		
		
		
		int[] previousLine = new int[horiz_lines + 1];
		int[] currentLine = new int[horiz_lines + 1];
		
		for(int i = 0; i <= horiz_lines ; i++)
		{
			if( i == Math.floor(horiz_lines / 2 ) )
			{
				previousLine[i] = 1;
				currentLine[i] = 1;
				canvas.drawRect((canvas.getWidth()/2) - (square_size/2), 1, canvas.getWidth()/ 2 + (square_size/2), square_size, myColor);
				//Log.d("ThunderSnow", "visibility 1 created");
			}
			else
			{
				previousLine[i] = 0;
				currentLine[i] = 0;
			}
		}
		
		
		int top = square_size;
		int bottom = square_size * 2;
		for(int i = 1; i <= vert_lines ; i++)
		{
			int left = 0;
			int right = square_size;
			
			for(int j = 1; j <= horiz_lines - 1; j++ )
			{
				
				
					if(visibilityChecker.calculateVisibility( previousLine[j-1], previousLine[j], previousLine[j+1]))
					{
						currentLine[j] = 1;
						canvas.drawRect(left, top, right, bottom, myColor);
					
						left += square_size;
						right += square_size;
					
					
					}
				
					else
					{
						currentLine[j] = 0;
						left += square_size;
						right += square_size;
					}
				
			}
			
			for(int k = 0; k <= horiz_lines; k++)
			{
				previousLine[k] = currentLine[k];
			}
	
			top+= square_size;
			bottom += square_size;
		}
		
			
			
	}

	
		
}	


