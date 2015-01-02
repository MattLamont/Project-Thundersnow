package com.example.thundersnowrebuild;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class PhotoGridActivity extends Activity 
{
	
	public int ROW_LENGTH;
	public int COLUMN_LENGTH;
	public int MARGIN;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		
		InitializeView( this );
		
		
		ScrollView scrollView = new ScrollView( this );
		LayoutParams scrollParams = new LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		LinearLayout containerLayout = new LinearLayout( this );
		LayoutParams containerParams = new LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		containerLayout.setOrientation(LinearLayout.VERTICAL);
		
		RelativeLayout rl0 = new RelativeLayout( this );
		rl0 = CreateHolders( this );
		rl0.setBackgroundColor(Color.WHITE);
		LinearLayout.LayoutParams lp0 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		RelativeLayout rl1 = new RelativeLayout( this );
		rl1 = CreateHolders( this );
		rl1.setBackgroundColor(Color.WHITE);
		LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		
		containerLayout.addView(rl0, lp0);
		containerLayout.addView(rl1, lp1);
		
		scrollView.addView( containerLayout, containerParams );
		
		setContentView( scrollView , scrollParams );
		
	}

	
	
	
	
	
	
	private void InitializeView(Context context) 
	{

		WindowManager wm = (WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();

		int width = display.getWidth();

		MARGIN = 4;

		COLUMN_LENGTH = Math.abs(width / 3) - (MARGIN);

		ROW_LENGTH = (int) Math.abs(COLUMN_LENGTH / 1.6) - (MARGIN);

	}

	
	
	
	
	
	
	
	
	private RelativeLayout CreateHolders( Context context )
	{
		
		RelativeLayout relativeLayout = new RelativeLayout(this);
		LayoutParams params = new LayoutParams(
				RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		relativeLayout.setLayoutParams(params);

		ImageButton[] img_arr = new ImageButton[14];

		for (int i = 0; i < 14; i++) {
			ImageButton imageButton = new ImageButton(context);
			imageButton.setBackgroundColor(Color.BLUE);
			img_arr[i] = imageButton;
		}
		
			

		RelativeLayout.LayoutParams lp0 = new RelativeLayout.LayoutParams(
				(COLUMN_LENGTH * 2), ROW_LENGTH * 2);
		lp0.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp0.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		lp0.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
		img_arr[0].setLayoutParams(lp0);
		img_arr[0].setScaleType(ScaleType.FIT_XY);
		img_arr[0].setId(99);
		relativeLayout.addView(img_arr[0], lp0);

		RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH);
		lp1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		lp1.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
		img_arr[1].setLayoutParams(lp1);
		img_arr[1].setScaleType(ScaleType.FIT_XY);
		img_arr[1].setId(1);
		relativeLayout.addView(img_arr[1], lp1);

		RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH * 2);
		lp2.addRule(RelativeLayout.BELOW, img_arr[1].getId());
		lp2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp2.addRule(RelativeLayout.ALIGN_LEFT, img_arr[1].getId());
		lp2.setMargins(0, 0, MARGIN, MARGIN);
		img_arr[2].setLayoutParams(lp2);
		img_arr[2].setScaleType(ScaleType.FIT_XY);
		img_arr[2].setId(2);
		relativeLayout.addView(img_arr[2], lp2);

		RelativeLayout.LayoutParams lp6 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH);
		lp6.addRule(RelativeLayout.BELOW, img_arr[2].getId());
		lp6.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp6.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[6].setLayoutParams(lp6);
		img_arr[6].setScaleType(ScaleType.FIT_XY);
		img_arr[6].setId(6);
		relativeLayout.addView(img_arr[6], lp6);

		RelativeLayout.LayoutParams lp7 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH * 2, ROW_LENGTH * 2);
		lp7.addRule(RelativeLayout.BELOW, img_arr[6].getId());
		lp7.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp7.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[7].setLayoutParams(lp7);
		img_arr[7].setScaleType(ScaleType.FIT_XY);
		img_arr[7].setId(7);
		relativeLayout.addView(img_arr[7], lp7);

		RelativeLayout.LayoutParams lp3 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH);
		lp3.addRule(RelativeLayout.BELOW, img_arr[0].getId());
		lp3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp3.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[3].setLayoutParams(lp3);
		img_arr[3].setScaleType(ScaleType.FIT_XY);
		img_arr[3].setId(3);
		relativeLayout.addView(img_arr[3], lp3);

		RelativeLayout.LayoutParams lp5 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH * 2);
		lp5.addRule(RelativeLayout.BELOW, img_arr[3].getId());
		lp5.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp5.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[5].setLayoutParams(lp5);
		img_arr[5].setScaleType(ScaleType.FIT_XY);
		img_arr[5].setId(5);
		relativeLayout.addView(img_arr[5], lp5);

		RelativeLayout.LayoutParams lp4 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH - 4, (ROW_LENGTH * 2) + 4);
		lp4.addRule(RelativeLayout.BELOW, img_arr[0].getId());
		lp4.addRule(RelativeLayout.ALIGN_RIGHT, img_arr[0].getId());
		lp4.setMargins(MARGIN, 0, 0, MARGIN);
		img_arr[4].setLayoutParams(lp4);
		img_arr[4].setScaleType(ScaleType.FIT_XY);
		img_arr[4].setId(4);
		relativeLayout.addView(img_arr[4], lp4);

		RelativeLayout.LayoutParams lp8 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH);
		lp8.addRule(RelativeLayout.BELOW, img_arr[5].getId());
		lp8.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp8.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[8].setLayoutParams(lp8);
		img_arr[8].setScaleType(ScaleType.FIT_XY);
		img_arr[8].setId(8);
		relativeLayout.addView(img_arr[8], lp8);

		RelativeLayout.LayoutParams lp9 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH);
		lp9.addRule(RelativeLayout.BELOW, img_arr[8].getId());
		lp9.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp9.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[9].setLayoutParams(lp9);
		img_arr[9].setScaleType(ScaleType.FIT_XY);
		img_arr[9].setId(9);
		relativeLayout.addView(img_arr[9], lp9);

		RelativeLayout.LayoutParams lp12 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, ROW_LENGTH);
		lp12.addRule(RelativeLayout.BELOW, img_arr[9].getId());
		lp12.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		lp12.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[12].setLayoutParams(lp12);
		img_arr[12].setScaleType(ScaleType.FIT_XY);
		img_arr[12].setId(12);
		relativeLayout.addView(img_arr[12], lp12);

		RelativeLayout.LayoutParams lp10 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH, (ROW_LENGTH * 2) + 4);
		lp10.addRule(RelativeLayout.BELOW, img_arr[7].getId());
		lp10.addRule(RelativeLayout.ALIGN_LEFT, img_arr[7].getId());
		lp10.setMargins(0, 0, 0, MARGIN);
		img_arr[10].setLayoutParams(lp10);
		img_arr[10].setScaleType(ScaleType.FIT_XY);
		img_arr[10].setId(10);
		relativeLayout.addView(img_arr[10], lp10);

		RelativeLayout.LayoutParams lp11 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH - 4, ROW_LENGTH);
		lp11.addRule(RelativeLayout.BELOW, img_arr[7].getId());
		lp11.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp11.addRule(RelativeLayout.ALIGN_LEFT, img_arr[1].getId());
		lp11.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[11].setLayoutParams(lp11);
		img_arr[11].setScaleType(ScaleType.FIT_XY);
		img_arr[11].setId(11);
		relativeLayout.addView(img_arr[11], lp11);

		RelativeLayout.LayoutParams lp13 = new RelativeLayout.LayoutParams(
				COLUMN_LENGTH - 4, ROW_LENGTH);
		lp13.addRule(RelativeLayout.BELOW, img_arr[11].getId());
		lp13.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		lp13.addRule(RelativeLayout.ALIGN_LEFT, img_arr[1].getId());
		lp13.setMargins(MARGIN, 0, MARGIN, MARGIN);
		img_arr[13].setLayoutParams(lp11);
		img_arr[13].setScaleType(ScaleType.FIT_XY);
		img_arr[13].setId(13);
		relativeLayout.addView(img_arr[13], lp13);

			
		
		return relativeLayout;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}
	
}
