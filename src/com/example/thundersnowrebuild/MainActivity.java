package com.example.thundersnowrebuild;

import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.TransitionDrawable;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thundersnowrebuild.R;

public class MainActivity extends Activity 
{
	
	private Context mContext;
	private int screenWidth;
	
	private final int MARGIN = 4;
	private int buttonSize;
	private ImageButton[] buttonArray;
	
	private TextView headerText1;
	private TextView headerText2;
	private TextView startButton;
	private String startButtonColor;
	private final int TEXT_SIZE = 70;
	private final int TV_PADDING = 0;
	private final int TV_MARGIN = 8;
	
	private ImageButton currentPressedButton = null;
	private ImageButton previousPressedButton = null;
	
	private AlphaAnimation fadeIn;
	private AlphaAnimation fadeOut;
	
	private TranslateAnimation headerTextDisappear = null;
	private TranslateAnimation headerTextAppear;
	private TranslateAnimation startButtonDisappear;
	private TranslateAnimation startButtonAppear;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		mContext = this;
		
		setWidgetMeasurements();
		
		setContentView( assembleInitialContentView() );
		
		generateAnimations();
		
	}
	
	
	public void onStart()
	{
		super.onStart();
		
	}
	
	private void setWidgetMeasurements()
	{
		WindowManager wm = (WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		
		Point point = new Point();
		display.getSize( point );
		
		screenWidth = point.x;
		buttonSize = (point.x / 3) - (2*MARGIN);

	
	}
	
	private RelativeLayout assembleInitialContentView()
	{
		RelativeLayout parent = new RelativeLayout( mContext );
		RelativeLayout.LayoutParams parentParams = new RelativeLayout.LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.MATCH_PARENT );
		parent.setLayoutParams(parentParams);
		parent.setBackgroundResource(R.drawable.gaussian_grey);
		
		parent.addView( generateHeaderContent() );
		parent.addView( generateButtonContent() );
		return parent;
	}
	
	private LinearLayout generateHeaderContent()
	{
		LinearLayout parent = new LinearLayout( mContext );
		parent.setOrientation(LinearLayout.VERTICAL);
		RelativeLayout.LayoutParams parentParams = new RelativeLayout.LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT );
		parentParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		parent.setLayoutParams(parentParams);
		parent.setGravity(Gravity.RIGHT);
		Typeface typeFace = Typeface.createFromAsset(getAssets(),"fonts/advent_bold.ttf");
		
		headerText1 = new TextView( mContext );
		headerText1.setTypeface(typeFace);
		headerText1.setPadding(TV_PADDING, TV_PADDING, TV_PADDING, TV_PADDING);
		headerText1.setTextColor(Color.WHITE);
		headerText1.setTextSize(TEXT_SIZE);
		headerText1.setText("thunder");
		//headerText1.setBackgroundResource(R.drawable.text_view_background);
		headerText1.setBackgroundColor(Color.TRANSPARENT);
		
		headerText2 = new TextView( mContext );
		headerText2.setTypeface(typeFace);
		headerText2.setPadding(TV_PADDING, TV_PADDING, TV_PADDING, TV_PADDING);
		headerText2.setTextColor(Color.WHITE);
		headerText2.setTextSize(TEXT_SIZE);
		headerText2.setText("snow");
		//headerText2.setBackgroundResource(R.drawable.text_view_background);
		headerText2.setBackgroundColor(Color.TRANSPARENT);
		
		LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams( LayoutParams.WRAP_CONTENT , LayoutParams.WRAP_CONTENT);
		textParams.setMargins(0, 0, TV_MARGIN, 0);
		
		startButton = new TextView( mContext );
		startButton.setClickable(true);
		startButton.setText("start");
		startButton.setTypeface(typeFace);
		startButton.setTextSize(TEXT_SIZE-20);
		startButton.setVisibility(TextView.GONE);
		startButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				startButtonClicked();
			}
		});
		
		
		parent.addView(headerText1 , textParams);
		parent.addView(headerText2 , textParams);
		parent.addView(startButton, textParams);
		return parent;
		
	}
	
	private LinearLayout generateButtonContent()
	{
		LinearLayout parent = new LinearLayout( mContext );
		parent.setOrientation(LinearLayout.VERTICAL);
		LinearLayout child1 = new LinearLayout( mContext );
		child1.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout child2 = new LinearLayout( mContext );
		child2.setOrientation(LinearLayout.HORIZONTAL);
		buttonArray = new ImageButton[6];
		
		RelativeLayout.LayoutParams parentParams = new RelativeLayout.LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT );
		parentParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		LinearLayout.LayoutParams child1Params = new LinearLayout.LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT );
		LinearLayout.LayoutParams child2Params = new LinearLayout.LayoutParams( LayoutParams.MATCH_PARENT , LayoutParams.WRAP_CONTENT );
		
		{
			ImageButton iv = new ImageButton( mContext );
			iv.setImageResource(R.drawable.cellular_shell);
			iv.setBackgroundResource(R.drawable.cellular_square_background);
			iv.setScaleType(ScaleType.FIT_CENTER);
			iv.setId(1);
			iv.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					buttonTouchAnimation( arg0 );
				}
			});
			LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(buttonSize , buttonSize);
			ivParams.setMargins(MARGIN, MARGIN, 0, 0);
			buttonArray[0] = iv;
			child1.addView(iv , ivParams);
		}
		
		{
			ImageButton iv = new ImageButton( mContext );
			iv.setImageResource(R.drawable.automaton_generator);
			iv.setBackgroundResource(R.drawable.generator_square_background);
			iv.setScaleType(ScaleType.FIT_CENTER);
			iv.setId(2);
			iv.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					buttonTouchAnimation( arg0 );
				}
			});
			LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(buttonSize , buttonSize);
			ivParams.setMargins(MARGIN, MARGIN, 0, 0);
			buttonArray[1] = iv;
			child1.addView(iv , ivParams);
		}
		
		{
			ImageButton iv = new ImageButton( mContext );
			iv.setImageResource(R.drawable.totalistic_automatons);
			iv.setBackgroundResource(R.drawable.totalistic_square_background);
			iv.setScaleType(ScaleType.FIT_CENTER);
			iv.setId(3);
			iv.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					buttonTouchAnimation( arg0 );
				}
			});
			LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(buttonSize , buttonSize);
			ivParams.setMargins(MARGIN, MARGIN, MARGIN, 0);
			buttonArray[2] = iv;
			child1.addView(iv , ivParams);
		}
		
		{
			ImageButton iv = new ImageButton( mContext );
			iv.setImageResource(R.drawable.poly_int_pic);
			iv.setBackgroundResource(R.drawable.gallery_square_background);
			iv.setScaleType(ScaleType.FIT_CENTER);
			iv.setId(4);
			iv.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					buttonTouchAnimation( arg0 );
				}
			});
			LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(buttonSize , buttonSize);
			ivParams.setMargins(MARGIN, MARGIN, 0, MARGIN);
			buttonArray[3] = iv;
			child2.addView(iv , ivParams);
		}
		
		{
			ImageButton iv = new ImageButton( mContext );
			iv.setImageResource(R.drawable.about_picture);
			iv.setBackgroundResource(R.drawable.about_square_background);
			iv.setScaleType(ScaleType.FIT_CENTER);
			iv.setId(5);
			iv.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					buttonTouchAnimation( arg0 );
				}
			});
			LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(buttonSize , buttonSize);
			ivParams.setMargins(MARGIN, MARGIN, 0, MARGIN);
			buttonArray[4] = iv;
			child2.addView(iv , ivParams);
		}
		
		{
			ImageButton iv = new ImageButton( mContext );
			iv.setImageResource(R.drawable.update_log);
			iv.setBackgroundResource(R.drawable.update_square_background);
			iv.setScaleType(ScaleType.FIT_CENTER);
			iv.setId(6);
			iv.setOnClickListener( new OnClickListener()
			{
				@Override
				public void onClick(View arg0) 
				{
					buttonTouchAnimation( arg0 );
				}
			});
			LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(buttonSize , buttonSize);
			ivParams.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
			buttonArray[5] = iv;
			child2.addView(iv , ivParams);
		}
		
		parent.setLayoutParams(parentParams);
		parent.addView(child1, child1Params);
		parent.addView(child2, child2Params);
		
		return parent;
		
	}
	
	
	
	private void setFlickerAnimation( final ImageButton iv )
	{	
		final AlphaAnimation mfadeIn = new AlphaAnimation((float) 0.5, 1);
		mfadeIn.setInterpolator(new LinearInterpolator()); //add this
		mfadeIn.setDuration(750);
		
		fadeIn = mfadeIn;

		final AlphaAnimation mfadeOut = new AlphaAnimation(1, (float) 0.5);
		mfadeOut.setInterpolator(new LinearInterpolator()); //and this
		mfadeOut.setDuration(750);
		mfadeOut.setAnimationListener( new AnimationListener()
		{

			@Override
			public void onAnimationEnd(Animation animation) 
			{
				iv.setAnimation(fadeIn);
				iv.startAnimation(fadeIn);
			}


			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		mfadeIn.setAnimationListener( new AnimationListener()
		{

			@Override
			public void onAnimationEnd(Animation animation) 
			{
				iv.setAnimation(fadeOut);
				iv.startAnimation(fadeOut);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		fadeOut = mfadeOut;
		
	}
	
	private void generateAnimations()
	{
		
    	headerTextAppear = new TranslateAnimation(200,0,0,0);
    	headerTextAppear.setInterpolator(new LinearInterpolator());
    	headerTextAppear.setDuration(200);
    	headerTextAppear.setFillEnabled(true);
    	headerTextAppear.setFillAfter(true);
    	
    	
    	startButtonAppear = new TranslateAnimation(-750,0,0,0);
		startButtonAppear.setInterpolator(new DecelerateInterpolator());
    	startButtonAppear.setDuration(500);
    	startButtonAppear.setFillEnabled(true);
    	startButtonAppear.setFillAfter(true);
    	startButtonAppear.setAnimationListener(new AnimationListener()
    	{

			@Override
			public void onAnimationEnd(Animation animation) 
			{
				
			}

			@Override
			public void onAnimationRepeat(Animation animation) 
			{
				
			}

			@Override
			public void onAnimationStart(Animation animation) 
			{
				startButton.setTextColor(Color.parseColor(startButtonColor));
		    	startButton.setVisibility(TextView.VISIBLE);
			}
    		
    	});
    	
    	startButtonDisappear = new TranslateAnimation(0,500,0,0);
		startButtonDisappear.setInterpolator(new LinearInterpolator());
    	startButtonDisappear.setDuration(350);
    	startButtonDisappear.setFillEnabled(true);
    	startButtonDisappear.setFillAfter(true);
		
		headerTextDisappear = new TranslateAnimation(0,750,0,0);
    	headerTextDisappear.setInterpolator(new LinearInterpolator());
    	headerTextDisappear.setDuration(350);
    	headerTextDisappear.setFillEnabled(true);
    	headerTextDisappear.setFillAfter(true);
    	
	}
			
	private void changeHeaderText()
	{
		int id = currentPressedButton.getId() - 1;
	
		switch (id)
    	{
    		case 0:
    			headerText1.setText("cellular");
				headerText2.setText("automatons");
				startButtonColor = "#63A827";
				break;
    		case 1:
    			headerText1.setText("automaton");
				headerText2.setText("generator");
				startButtonColor = "#029acc";
				break;
    		case 2:
    			headerText1.setText("totalistic");
				headerText2.setText("automatons");
				startButtonColor = "#034684";
				break;
    		case 3:
    			headerText1.setText("gallery");
				headerText2.setText("viewer");
				startButtonColor = "#284550";
				break;
    		case 4:
    			headerText1.setText("about/");
				headerText2.setText("info");
				startButtonColor = "#d97326";
				break;
    		case 5:
    			headerText1.setText("update");
				headerText2.setText("log");
				startButtonColor = "#7d3c93";
				break;
    	}
	}
	
	
	private void buttonTouchAnimation( View v )
	{
		currentPressedButton = (ImageButton) v;
		
		if( previousPressedButton != null )
		{
			if( currentPressedButton.getId() == previousPressedButton.getId() )
			{ 
				return;
			}
		}
		
		int cid = currentPressedButton.getId() - 1;
		switch(cid)
		{
			case 0:
				currentPressedButton.setBackgroundResource(R.drawable.cellular_solid_background);
				break;
			case 1:
				currentPressedButton.setBackgroundResource(R.drawable.generator_solid_background);
				break;
			case 2:
				currentPressedButton.setBackgroundResource(R.drawable.totatlistic_solid_background);
				break;
			case 3:
				currentPressedButton.setBackgroundResource(R.drawable.gallery_solid_background);
				break;
			case 4:
				currentPressedButton.setBackgroundResource(R.drawable.about_solid_background);
				break;
			case 5:
				currentPressedButton.setBackgroundResource(R.drawable.update_solid_background);
				break;	
		}
		
		if( previousPressedButton != null )
		{
			int pid = previousPressedButton.getId() - 1;
			switch(pid)
			{
				case 0:
					previousPressedButton.setBackgroundResource(R.drawable.cellular_square_background);
					break;
				case 1:
					previousPressedButton.setBackgroundResource(R.drawable.generator_square_background);
					break;
				case 2:
					previousPressedButton.setBackgroundResource(R.drawable.totalistic_square_background);
					break;
				case 3:
					previousPressedButton.setBackgroundResource(R.drawable.gallery_square_background);
					break;
				case 4:
					previousPressedButton.setBackgroundResource(R.drawable.about_square_background);
					break;
				case 5:
					previousPressedButton.setBackgroundResource(R.drawable.update_square_background);
					break;	
			}
		}
		
		
		startButton.startAnimation(startButtonDisappear);
	    headerText1.startAnimation(headerTextDisappear);
	    headerText2.startAnimation(headerTextDisappear);
	    
	    new Handler().postDelayed(new Runnable() 
	    {
	        public void run() 
	        {
	            headerText1.clearAnimation();
	            headerText2.clearAnimation();
				changeHeaderText();
				headerText1.startAnimation(headerTextAppear);
				headerText2.startAnimation(headerTextAppear);
				startButton.startAnimation(startButtonAppear);
	        }
	    }, 750);
	    
	    setFlickerAnimation( currentPressedButton );
	    previousPressedButton = currentPressedButton;
	}
	
	
	private void startButtonClicked()
	{
		Intent intent = null;
		
		int id = currentPressedButton.getId() - 1;
		switch(id)
		{
			case 0:
				intent = new Intent(mContext , CellularAutomatanMain.class );
        		startActivity(intent);
				break;
			case 1:
				intent = new Intent(mContext , AutomatonGeneratorActivity.class );
        		startActivity(intent);
				break;
			case 2:
				intent = new Intent(mContext , TotalisticAutomatonMain.class );
        		startActivity(intent);
				break;
			case 3:
				intent = new Intent(mContext , PhotoGridActivity.class );
        		startActivity(intent);
				break;
			case 4:
				intent = new Intent(mContext , AboutActivity.class );
        		startActivity(intent);
				break;
			case 5:
				intent = new Intent(mContext , UpdateLog.class );
        		startActivity(intent);
				break;	
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.totalistic_automaton_main, menu);
		return true;
	}

}