package com.example.thundersnowrebuild;



import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;


public class SplashScreen extends Activity 
{

	private final int SPLASH_DISPLAY_LENGTH = 3000;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		RelativeLayout rl = new RelativeLayout( this );
		LayoutParams lp = new LayoutParams( LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		rl.setLayoutParams(lp);
		rl.setBackgroundResource(R.drawable.black_background);
		
		
		
		ImageView iv = new ImageView( this );
		iv.setBackgroundResource(R.drawable.splash_screen2);
		RelativeLayout.LayoutParams lp1 = new RelativeLayout.LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT );
		lp1.addRule(RelativeLayout.CENTER_VERTICAL);
		iv.setLayoutParams(lp1);
		iv.setId(1);
		
		ProgressBar pb = new ProgressBar( this );
		pb.setIndeterminate(true);
	
		
		RelativeLayout.LayoutParams relLP = new RelativeLayout.LayoutParams( 100 , 100 );
		relLP.addRule(RelativeLayout.CENTER_HORIZONTAL);
		relLP.addRule(RelativeLayout.BELOW, iv.getId() );
		relLP.setMargins(0, 40, 0, 0);
		pb.setLayoutParams( relLP );
		
		rl.addView( iv );
		rl.addView( pb );
		
		setContentView( rl );
		
		Runnable runnable = new Runnable()
		{

			@Override
			public void run() 
			{
				Intent mainIntent = new Intent( SplashScreen.this , MainActivity.class );
				SplashScreen.this.startActivity( mainIntent );
				SplashScreen.this.finish();
				
			}
			
		};
				
		Handler handler = new Handler();
		handler.postDelayed( runnable , SPLASH_DISPLAY_LENGTH);
			
	}
	
	

	
}
