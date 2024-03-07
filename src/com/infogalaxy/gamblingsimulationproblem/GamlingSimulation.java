package com.infogalaxy.gamblingsimulationproblem;

import java.util.Random;

public class GamlingSimulation 
{
	private static final int STACK_PER_DAY = 100;
	private static final int BET_PER_GAME = 1;
	private static final int WIN = 1;
	private static final int LOOSE = 0;
	
	private static int winStack = 0;
	private static int looseStack = 0;
	
	public static void gameStatus()
	{
		System.out.println(" Stack Available = "+STACK_PER_DAY);
		System.out.println(" Bet Per Game = "+BET_PER_GAME);
		System.out.println(" Winning Stack = "+winStack);
		System.out.println(" Loose Stack = "+looseStack);
	}
	
	public static void gamePlay()
	{
		Random random = new Random();
		int playStatus = random.nextInt(9)%2;
		System.out.println(" Play Status = "+playStatus);
		if(playStatus == LOOSE)
		{
			looseStack +=1;
		}
		else
		{
			winStack +=1;
		}
	}
	public static void main(String[] args)
	{
		System.out.println(" Welcome to Gambling Simulation Problem Developed by Nikhil Patil ");
		gameStatus();
		gamePlay();
		System.out.println(" ************* ");
		gameStatus();
	}
	
}
