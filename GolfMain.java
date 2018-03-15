import java.util.Scanner;
import java.util.Random;
public class GolfMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to TTY Golf!");

		int[][] Genesee2D = new int[18][3]; //18 rows(holes), 3 columns(Hole, Yards, Par)
		
		//Holes
		Genesee2D[0][0] = 1; Genesee2D[1][0] = 2; Genesee2D[2][0] = 3; Genesee2D[3][0] = 4; Genesee2D[4][0] = 5;
		Genesee2D[5][0] = 6; Genesee2D[6][0] = 7; Genesee2D[7][0] = 8; Genesee2D[8][0] = 9; Genesee2D[9][0] = 10;
		Genesee2D[10][0] = 11; Genesee2D[11][0] = 12; Genesee2D[12][0] = 13; Genesee2D[13][0] = 14; 
		Genesee2D[14][0] = 15; Genesee2D[15][0] = 16; Genesee2D[16][0] = 17; Genesee2D[17][0] = 18;
		//Yards
		Genesee2D[0][1] = 530; Genesee2D[1][1] = 305; Genesee2D[2][1] = 331; Genesee2D[3][1] = 201; Genesee2D[4][1] = 500;
		Genesee2D[5][1] = 226; Genesee2D[6][1] = 409; Genesee2D[7][1] = 410; Genesee2D[8][1] = 229; Genesee2D[9][1] = 433;
		Genesee2D[10][1] = 363; Genesee2D[11][1] = 174; Genesee2D[12][1] = 545; Genesee2D[13][1] = 419; Genesee2D[14][1] = 512;
		Genesee2D[15][1] = 410; Genesee2D[16][1] = 320; Genesee2D[17][1] = 170;
		//Par
		Genesee2D[0][2] = 5; Genesee2D[1][2] = 4; Genesee2D[2][2] = 4; Genesee2D[3][2] = 3; Genesee2D[4][2] = 5;
		Genesee2D[5][2] = 3; Genesee2D[6][2] = 4; Genesee2D[7][2] = 4; Genesee2D[8][2] = 3; Genesee2D[9][2] = 4;
		Genesee2D[10][2] = 4; Genesee2D[11][2] = 3; Genesee2D[12][2] = 5; Genesee2D[13][2] = 4; Genesee2D[14][2] = 5;
		Genesee2D[15][2] = 4; Genesee2D[16][2] = 4; Genesee2D[17][2] = 3;
		
		
		int[][] Clubs = new int[10][3]; // 10 different clubs, Mean, Std Dev
		
		//Club Number
		Clubs[0][0] = 1; Clubs[1][0] = 2; Clubs[2][0] = 3; Clubs[3][0] = 4; Clubs[4][0] = 5;
		Clubs[5][0] = 6; Clubs[6][0] = 7; Clubs[7][0] = 8; Clubs[8][0] = 9; Clubs[9][0] = 10;
		//Mean (Yards)
		Clubs[0][1] = 230; Clubs[1][1] = 215; Clubs[2][1] = 180; Clubs[3][1] = 170; Clubs[4][1] = 155;
		Clubs[5][1] = 145; Clubs[6][1] = 135; Clubs[7][1] = 125; Clubs[8][1] = 110; Clubs[9][1] = 50;
		//Std Dev (Yards)
		Clubs[0][2] = 30; Clubs[1][2] = 20; Clubs[2][2] = 20; Clubs[3][2] = 17; Clubs[4][2] = 15;
		Clubs[5][2] = 15; Clubs[6][2] = 15; Clubs[7][2] = 15; Clubs[8][2] = 10; Clubs[9][2] = 10;
		
		int[] Power = new int[10]; //Club Power
		Power[0] = 1; Power[1] = 2; Power[2] = 3; Power[3] = 4; Power[4] = 5; Power[5] = 6;
		Power[6] = 7; Power[7] = 8; Power[8] = 9; Power[9] = 10;
		
		int[][] Puttpower = new int[10][2]; //Putt Power
		
		//Putt Mean (feet)
		Puttpower[0][0] = 1; Puttpower[1][0] = 2; Puttpower[2][0] = 4; Puttpower[3][0] = 8; Puttpower[4][0] = 12;
		Puttpower[5][0] = 16; Puttpower[6][0] = 20; Puttpower[7][0] = 25; Puttpower[8][0] = 30; Puttpower[9][0] = 40;
		//Putt Std
		Puttpower[0][1] = 1; Puttpower[1][1] = 1; Puttpower[2][1] = 2; Puttpower[3][1] = 2; Puttpower[4][1] = 3;
		Puttpower[5][1] = 3; Puttpower[6][1] = 4; Puttpower[7][1] = 4; Puttpower[8][1] = 5; Puttpower[9][1] = 5;

		//Now lets Play the course at Genesee
		int x = 0;
		for (int i=0; i<=17; i++) {
			System.out.println("You are on hole " + Genesee2D[i][0] + ". " + Genesee2D[i][1]*3 + "feet. Par " + Genesee2D[i][2]); //Tells you which hole you are on. Array synced with i
			
			int distancefromhole = Genesee2D[i][1]; //setting distancefromhole variable
			int totaldistanceperhole = 0; //setting this variable as well
			
			while(distancefromhole >= 60) { //while the distance from the hole is not on the green
				int clubnum = choosingClub(); //setting clunum equal to the return of method choosingClub
				int powernum = choosingPower();
				
				int mean = Clubs[clubnum - 1][1]*3; //(clubnum-1) is the mean array value for that club. REMEMBER ITS YARDS
				int std = Clubs[clubnum-1][2]*3; 
				int power = Power[powernum - 1];
				
				int nextDistance = nextDistance(mean, std, power); //calling the method for nextDistance
				System.out.println("You hit the ball " + nextDistance + " feet!");
				
				totaldistanceperhole = totaldistanceperhole + nextDistance; //how far you've hit up to this point
				distancefromhole = Genesee2D[i][1]*3 - totaldistanceperhole; //distancefromhole gets smaller until 60
				
				if (distancefromhole < 0) { //if distance from hole is less than 0, set it equal to 59 to keep going
					distancefromhole = 59;
				}
				
				System.out.println("You are " + distancefromhole + " feet from the hole!");
				x = x + 1;
			}
			

			System.out.println("You are on the green. Time to putt!"); 
			
			int finaldistancefromhole = distancefromhole;
			int totalputtdistance = 0;
			while (finaldistancefromhole > 1) {
				int puttpower = choosingPuttPower(); //user chooses a puttpower
				int puttMean = Puttpower[puttpower - 1][0];
				int puttStd = Puttpower[puttpower - 1][1];
			
				int nextputtDistance = nextDistance(puttMean, puttStd, puttpower);
				
				totalputtdistance = totalputtdistance + nextputtDistance;
				finaldistancefromhole = Math.abs(distancefromhole - totalputtdistance); 
		
				if (finaldistancefromhole > 60) {
					finaldistancefromhole = 59;
				}
				System.out.println("You hit the ball " + nextputtDistance + " feet!");
				System.out.println("You are " + finaldistancefromhole + " feet from the hole!");
				x = x + 1;

			}
			System.out.println("You made it in the hole!)");
			System.out.println("You took " + x + " shots to get it into the hole.");
			if(x > Genesee2D[i][2]) {
				int d = x - Genesee2D[i][2];
				System.out.println("You are " + d + " shots over par");
			}
			else {
				int t = Genesee2D[i][2] - x;
				System.out.println("You are " + t + " shots under par!");
			}
			
			x = 0;
			
		}	
	
		
	}
	//METHODS
	
	public static int choosingClub() { //method for choosing club
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a club (1-10)");
		int clubNum = sc.nextInt();
		return clubNum;
		//int meanClubDistance = Clubs[clubNum-1][1];
		//int stdev = Clubs[clubNum-1][2];
		
	}
	
	public static int choosingPower() { //method for choosing power
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose a power (1-10)");
		int powernum = sc.nextInt();
		return powernum;
	}
	
	public static int nextDistance(int mean, int stdev, int power) { 
		double mean_scaled = mean*power / 10.0;
		double stdev_scaled = stdev*power/10.0;
		Random random = new Random(); //creating object random from the constructor in class Random
		double val = Math.abs(random.nextGaussian()*stdev_scaled+mean_scaled);
		return (int) val;
	}
	
	public static int choosingPuttPower() { //method for choosing the putting power
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose a putt power between (1-10)");
		int puttpower = sc.nextInt();
		return puttpower;
	}
	
	
}








