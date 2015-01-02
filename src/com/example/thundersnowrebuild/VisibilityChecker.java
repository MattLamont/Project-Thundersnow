package com.example.thundersnowrebuild;

public class VisibilityChecker 
{
	public boolean rule1;
	public boolean rule2;
	public boolean rule3;
	public boolean rule4;
	public boolean rule5;
	public boolean rule6;
	public boolean rule7;
	public boolean rule8;
	
	public VisibilityChecker( boolean[] truth_arr )
	{
		rule1 = truth_arr[0];
		rule2 = truth_arr[1];
		rule3 = truth_arr[2];
		rule4 = truth_arr[3];
		rule5 = truth_arr[4];
		rule6 = truth_arr[5];
		rule7 = truth_arr[6];
		rule8 = truth_arr[7];
	}
	
	
	public boolean calculateVisibility( int i, int j, int k )
	{
		if( i == 1 && j == 1 && k == 1)
		{
			return rule1;
		}
		if( i == 1 && j == 1 && k == 0)
		{
			return rule2;
		}
		if( i == 1 && j == 0 && k == 1)
		{
			return rule3;
		}
		if( i == 1 && j == 0 && k == 0)
		{
			return rule4;
		}
		if( i == 0 && j == 1 && k == 1)
		{
			return rule5;
		}
		if( i == 0 && j == 1 && k == 0)
		{
			return rule6;
		}
		if( i == 0 && j == 0 && k == 1)
		{
			return rule7;
		}
		if( i == 0 && j == 0 && k == 0)
		{
			return rule8;
		}
		
		return false;
	}
	

}
