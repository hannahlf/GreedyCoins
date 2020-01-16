/**
 * Plays Greedy Coin game such that the computer never loses.
 * 
 * [ YOUR NAME GOES HERE]
 */
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;



public class GreedyCoinGame {
	LinkedList<Integer> coins = new LinkedList<Integer>();

	public GreedyCoinGame(String file) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) {
			//System.out.println(inFile.nextInt());
			// TO-DO store each coin in a linked list
			coins.add(inFile.nextInt());
		}

		inFile.close();
	}

	// prints the coins and their position
	public void printCoins() {
		System.out.println("+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ ");
		System.out.print("COINS: ");
		for(int i = 0; i < coins.size(); i++)
		{
			System.out.print(coins.get(i) + " ");

		}
		//Print index with for loop as well
		System.out.println();
		System.out.print("POSITION: ");
		for(int i = 0; i < coins.size(); i++)
		{
			System.out.print(i + " ");
		}

		//System.out.println("+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ " + "+ ");
	}

	public void playGame() {
		System.out.println("Let's play the coin game!");
		printCoins();
		Scanner keyboard = new Scanner(System.in);
		int index = 0;
		int red = 0;
		int blue = 1;
		int hScore = 0;
		int cScore = 0;
		int humanChoice;
		for(int i = 0; i < coins.size(); i++)
		{
			if(i % 2 == 0)
			{
				red = red + coins.get(i);
			}
			else
			{
				blue = blue + coins.get(i);
			}
		}
		System.out.println();
		System.out.println("red = " + red);
		System.out.println("blue = " + blue);
		if(blue > red)
		{
			System.out.println("Choose the blue coins to win the game." );
		}else
			System.out.println("Choose the red choins to win the game.");
		while(!coins.isEmpty())
		{
			System.out.println();
			System.out.println("Indicate the position of the coin you choose: ");
			humanChoice = keyboard.nextInt();
			hScore = coins.get(humanChoice);
			coins.remove(humanChoice);
			if(humanChoice%2 == 0)
			{
				index = coins.size() - 1;
			}else
			{
				index = 0;
			}
			System.out.println("Computer removed postion: " + index);
			cScore = coins.get(index);
			coins.remove(index);
			System.out.println("Your score: " + hScore + " Computer's score: " + cScore);
			printCoins();
		}
		System.out.println();
		System.out.println("You have finished the game!");
		System.out.println("Your score: " + hScore + " Computer's score: " + cScore);
		if(hScore > cScore)
		{
			System.out.println("Congrats you won!");
		}else
			System.out.println("Better luck next time!");
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Pass a file on the command line");
			System.exit(0);
		}

		GreedyCoinGame game = new GreedyCoinGame(args[0]);

		game.playGame();
	}

}
