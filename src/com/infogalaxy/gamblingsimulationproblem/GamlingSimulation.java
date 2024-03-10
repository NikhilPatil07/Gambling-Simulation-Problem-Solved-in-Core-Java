package com.infogalaxy.gamblingsimulationproblem;


import java.util.Random;
import java.util.Scanner;

public class GamlingSimulation 
{
	private static final int STACK_PER_DAY = 100;
	private static final int BET_PER_GAME = 1;
	private static final int WIN = 1;
	private static final int LOOSE = 0;
	
	
	public static void gameStatus()
	{
//		System.out.println(" Stack Available = "+STACK_PER_DAY);
//		System.out.println(" Bet Per Game = "+BET_PER_GAME);
	
	}
	
	public static void gamePlay()
	{
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int[] winAmount = new int[30];
		int[] looseAmount = new int[30];
		int [] maxLost = new int[30];
		int [] maxWin = new int[30];
		
		
		int winDay = 0;
		int looseDay = 0;
		int maxL = 0;
		int maxW = 0;
		int indexL = 0;
		int indexW = 0;
		int choice = 'y';
		
		do
		{
			for(int i = 0; i < 30; i++)
			{
				int winStack = 0;
				int looseStack = 0;
				
				System.out.println(" Day : "+(i+1));
	
				while(true)
				{
//					gameStatus();
					int playStatus = random.nextInt(9)%2;
//					System.out.println(" Play Status = "+playStatus);
					if(playStatus == LOOSE)
					{
						looseStack += 1;
					}
					else
					{
						winStack += 1;
					}
					if(looseStack == STACK_PER_DAY / 2)
					{
						looseDay++;
						if(looseStack > winStack)
						{
							maxLost[i] =looseStack - winStack;
							if(maxL < maxLost[i])
							{
								maxL = maxLost[i];
								indexL = i=1;
							}
						}
						break;
					}
					if(winStack == STACK_PER_DAY/2)
					{
						winDay++;
						if(looseStack < winStack)
						{
							maxWin[i] = winStack - looseStack;
							if(maxW < maxWin[i])
							{
								maxW = maxWin[i];
								indexW = i+1;
							}
						}
						break;
					}
				
				}
		
	
			looseAmount[i] = looseStack;
			winAmount[i] = winStack;
			
			System.out.println(" Winning Stack = "+winStack);
			System.out.println(" Loose Stack = "+looseStack);
			
			System.out.println(" MaxLost : " +maxLost[i]);
			System.out.println(" MaxWon : " +maxWin[i]);
			
			System.out.println(" Loose Amount = "+looseAmount[i]);
			System.out.println(" Win Amount = "+winAmount[i]);
			
			System.out.println("*********************************");
		}
		System.out.println(indexL+ " is the Unluckiest Day , Lost RS : " +maxL );
		System.out.println(indexW + " is the Luckiest Day , Win Rs : " +maxW );
		System.out.println(" Total Days Lost : "+looseDay);
		System.out.println(" Total Days Win : "+winDay);
		
		System.out.println(" Do you Want to Continue Playing ? : (Yes/No)");
		choice = scanner.next().charAt(0);
		
	}while(choice == 'y');
	}
	
		public static void main(String[] args)
		{
			System.out.println(" Welcome to Gambling Simulation Problem Developed by Nikhil Patil ");
		
			gamePlay();
		}
	
}
