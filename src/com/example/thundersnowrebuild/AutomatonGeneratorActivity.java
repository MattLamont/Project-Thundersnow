package com.example.thundersnowrebuild;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class AutomatonGeneratorActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.automaton_generator_layout);
		
		final RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
		final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);		
		final RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
		final RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
		final RadioButton radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
		final RadioButton radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
		final RadioButton radioButton7 = (RadioButton) findViewById(R.id.radioButton7);
		final RadioButton radioButton8 = (RadioButton) findViewById(R.id.radioButton8);
		
		
		
		Button generatorButton = (Button) findViewById(R.id.generator_button);
		
		generatorButton.setOnClickListener( new Button.OnClickListener()
        {
			
        	public void onClick(View v)
        	{
        		boolean radio_array[] = {false,false,false,false,false,false,false,false};
        		radio_array[0] = radioButton1.isChecked();
        		radio_array[1] = radioButton2.isChecked();
        		radio_array[2] = radioButton3.isChecked();
        		radio_array[3] = radioButton4.isChecked();
        		radio_array[4] = radioButton5.isChecked();
        		radio_array[5] = radioButton6.isChecked();
        		radio_array[6] = radioButton7.isChecked();
        		radio_array[7] = radioButton8.isChecked();
        		prepareAutomata( radio_array  );
        	}
        });
		
		
		
	}

	protected void prepareAutomata( boolean[] radio_array ) 
	{
		
		Bundle bundle = new Bundle( );
		bundle.putBooleanArray("rules", radio_array);
		GenerateView v = new GenerateView( this , bundle );
		setContentView( v );
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.automaton_generator, menu);
		return true;
	}


}
