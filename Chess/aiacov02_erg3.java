/** 
 *  Author:        Andreas Iacovou
 *  Written:       20/11/2014 
 *  Last updated:  27/11/2014 
 * 
 *  Compilation:   javac aiacov02_erg3.java 
 *  Execution:     java aiacov02_erg3 
 *   
 * This program initializes a checkboard and then asks the white player to play. the program checks if the move is valid and if it's not 
 * it asks again for input. if the move is valid the program goes on and executes it. The program stops when one of the two players 
 * inputs the word "quit". Then a form appears containing the last state of the chessboard designed with the help of the graphics and picrures.
 * 
 */
public class aiacov02_erg3 {
	public static int indexi=0,indexj=0,indexX=0,indexY=0;
	public static void InitializeCheckBoard(char[][] checkboard){
		char[][] checkboard1 = {{'r','n','b','k','q','b','n','r'},
								{'p','p','p','p','p','p','p','p'},
								{' ',' ',' ',' ',' ',' ',' ',' '},
								{' ',' ',' ',' ',' ',' ',' ',' '},
								{' ',' ',' ',' ',' ',' ',' ',' '},
								{' ',' ',' ',' ',' ',' ',' ',' '},
								{'P','P','P','P','P','P','P','P'},
								{'R','N','B','K','Q','B','N','R'}};
		for(int i=0; i<checkboard.length; i++)
			for(int j=0; j<checkboard.length; j++)
				checkboard[i][j]=checkboard1[i][j];	
	
	}
	
	public static void printBoard(char[][] checkboard, boolean isblackcaptured, boolean iswhitecaptured, char[] blackcaptured, char[] whitecaptured){
		if(iswhitecaptured){
			System.out.println(" White pieces captured : ");
			System.out.print(whitecaptured[0]);
			for(int i=1; i<whitecaptured.length-1; i++){
				if(whitecaptured[i]!=' ') System.out.print( ", " + whitecaptured[i]); 
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("     a   b   c   d   e   f   g   h     ");
		System.out.println("   +---+---+---+---+---+---+---+---+  ");
		for(int i=checkboard.length-1; i>=0; i--){
			System.out.print(" " + (i+1) + " | ");
			for(int j=0; j<checkboard.length; j++){
				System.out.print(checkboard[i][j] + " | ");
			}
			System.out.println(i+1);
			System.out.println("   +---+---+---+---+---+---+---+---+  ");
		}
		System.out.println("     a   b   c   d   e   f   g   h     ");
		
		if(isblackcaptured){
			System.out.println();
			System.out.println(" Black pieces captured : ");
			System.out.print(blackcaptured[0]);
			for(int i=1; i<whitecaptured.length-1; i++){
				if(blackcaptured[i]!=' ') System.out.print( ", " + blackcaptured[i]);
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
	public static String inputMove(boolean turn){
		if(turn) System.out.print("White moves: ");
		else  System.out.print("Black moves: ");
		String move = StdIn.readString();
		return move;
	}
	
	public static boolean isWhite(char pawntype){
		if(pawntype == 'p' || pawntype=='r' || pawntype=='n' || pawntype=='b' || pawntype=='q' || pawntype=='k') return true;
		else return false;
	}
	
	public static char transform(char newpawn){
		System.out.println();
		System.out.println("Promote pawn to q b n r : ");
		String promotion = StdIn.readString();
		newpawn = promotion.charAt(0);
		return newpawn;
	}
	
	public static void printGraphicsBoard(char[][] checkboard, int checkboardlength){
		StdDraw.setXscale(0, checkboardlength);
		StdDraw.setYscale(0, checkboardlength);
		
		for (int i = 0; i < checkboardlength; i++){
			for (int j = 0; j < checkboardlength; j++){
				if ( ((i+j) % 2) == 0)
					StdDraw.setPenColor(StdDraw.BLACK);
				else 
					StdDraw.setPenColor(StdDraw.WHITE);
				
				StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
				if(checkboard[i][j]!= ' ')
					if(checkboard[i][j]== 'p') StdDraw.picture(i+0.5,j+0.5, "pawnwhite.png" );
					else if(checkboard[i][j]== 'r') StdDraw.picture(i+0.5, j+0.5, "towerwhite.png" );
					else if(checkboard[i][j]== 'b') StdDraw.picture(i+0.5, j+0.5, "Bishopwhite.png" );
					else if(checkboard[i][j]== 'n') StdDraw.picture(i+0.5, j+0.5, "knightwhite.png" );
					else if(checkboard[i][j]== 'q') StdDraw.picture(i+0.5, j+0.5, "queenwhite.png" );
					else if(checkboard[i][j]== 'k') StdDraw.picture(i+0.5, j+0.5, "kingwhite.png" );
					else if(checkboard[i][j]== 'P') StdDraw.picture(i+0.5, j+0.5, "pawnblack.png" );
					else if(checkboard[i][j]== 'B') StdDraw.picture(i+0.5, j+0.5, "Bishopblack.png" );
					else if(checkboard[i][j]== 'R') StdDraw.picture(i+0.5, j+0.5, "towerblack.png" );
					else if(checkboard[i][j]== 'N') StdDraw.picture(i+0.5, j+0.5, "knightblack.png" );
					else if(checkboard[i][j]== 'Q') StdDraw.picture(i+0.5, j+0.5, "queenblack.png" );
					else if(checkboard[i][j]== 'K') StdDraw.picture(i+0.5, j+0.5, "kingblack.png" );
				
				
			}
		}
		
	}
	
	public static boolean isMoveValid(String move, char[][] checkboard, boolean turn){
		String index = "";
		char position1=' '; char position2 = ' ';
		if(move.length() == 4){
			index = move.charAt(0) + "";

			if(index.equals("1") || index.equals("2") || index.equals("3") || index.equals("4") || index.equals("5") || index.equals("6") || index.equals("7") || index.equals("8")){
				indexi=Integer.parseInt(index)-1;
				if(move.charAt(1)=='a') indexj= 0;
				else if(move.charAt(1)=='b') indexj=1;
				else if(move.charAt(1)=='c') indexj=2;
				else if(move.charAt(1)=='d') indexj=3;
				else if(move.charAt(1)=='e') indexj=4;
				else if(move.charAt(1)=='f') indexj=5;
				else if(move.charAt(1)=='g') indexj=6;
				else if(move.charAt(1)=='h') indexj=7;
				else return false;
				
				index = move.charAt(2) + "";
				if(index.equals("1") || index.equals("2") || index.equals("3") || index.equals("4") || index.equals("5") || index.equals("6") || index.equals("7") || index.equals("8")){
					indexX = Integer.parseInt(index)-1;
					if(move.charAt(3)=='a') indexY= 0;
					else if(move.charAt(3)=='b') indexY=1;
					else if(move.charAt(3)=='c') indexY=2;
					else if(move.charAt(3)=='d') indexY=3;
					else if(move.charAt(3)=='e') indexY=4;
					else if(move.charAt(3)=='f') indexY=5;
					else if(move.charAt(3)=='g') indexY=6;
					else if(move.charAt(3)=='h') indexY=7;
					else return false;
			
					position1 = checkboard[indexi][indexj];
					position2 = checkboard[indexX][indexY];
					if(position1 != ' '){
						if(turn){
							if(isWhite(position2)==false){
								if(position1=='p'){
									if(indexi==1 && indexX==(indexi+2) && indexY==indexj)
										if(position2 ==' ' && checkboard[indexX-1][indexY]==' ')
											return true;
										else;
									else if(indexX==indexi+1 && indexY==indexj && position2 ==' ')
										return true;
									else if(indexX==indexi+1 && (indexY==indexj+1 || indexY==indexj-1) && position2!= ' ')
										return true;
								}
								else if(position1=='r'){
									if(indexX==indexi)
										if (indexY>indexj){
											for(int i=indexj+1; i<indexY; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexY+1; i<indexj; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
									else if(indexY==indexj)
										if(indexX>indexi){
											for(int i=indexi+1; i<indexX; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexX+1; i<indexi; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}		
											
										
								}
								else if(position1=='n'){
									if((indexX==indexi+2 || indexX==indexi-2) && (indexY==indexj+1 || indexY==indexj-1))
										return true;
									else if((indexY==indexj+2 || indexY==indexj-2) && (indexX==indexi+1 || indexX==indexi-1))
										return true;
								}
								else if(position1=='b'){
									if(Math.abs(indexX-indexi)==Math.abs(indexY-indexj))
										if(indexX>indexi && indexY>indexj){
											int j= indexj+1;
											for(int i=indexi+1; i<indexX; i++){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
											return true;
										}
										else if(indexX>indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexi+1; i<indexX; i++){
												if(checkboard[i][j]!= ' ') return false;
												j--;
											}
											return true;
										}
										else if(indexX<indexi && indexY>indexj){
											int j=indexj+1;
											for(int i=indexi-1; i>indexX; i--){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
											return true;
										}
										else if(indexX<indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexi-1; i>indexX; i--){
												if(checkboard[i][j]!= ' ') return false;
												j--;
											}
											return true;
										}
								}
								else if(position1=='q'){
									if(indexX==indexi)
										if (indexY>indexj){
											for(int i=indexj+1; i<indexY; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexY+1; i<indexj; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
									else if(indexY==indexj)
										if(indexX>indexi){
											for(int i=indexi+1; i<indexX; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexX+1; i<indexi; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}
									else if(Math.abs(indexX-indexi)==Math.abs(indexY-indexj))
										if(indexX>indexi && indexY>indexj){
											int j= indexj+1;
											for(int i=indexi+1; i<indexX; i++){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
											return true;
										}
										else if(indexX>indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexi+1; i<indexX; i++){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
											return true;
										}
										else if(indexX<indexi && indexY>indexj){
											int j=indexj+1;
											for(int i=indexi-1; i>indexX; i--){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
											return true;
										}
										else if(indexX<indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexX+1; i<indexi; i++){
												if(checkboard[i][j]!= ' ') return false;
												j--;
											}
											return true;
										}
								
								}
								else if(position1=='k'){
									if(indexX==indexi+1 && (indexY==indexj || indexY==indexj+1 || indexY==indexj-1)) return true;
									else if(indexX==indexi-1 && (indexY==indexj || indexY==indexj+1 || indexY==indexj-1)) return true;
									else if(indexX==indexi && (indexY==indexj-1 || indexY==indexj+1)) return true;
								}
							}	
							
						}
						else{
							if(isWhite(position2)|| position2==' '){
								if(position1=='P'){
									if(indexi==6 && indexX==(indexi-2) && indexY==indexj)
										if(position2 ==' ' && checkboard[indexX+1][indexY]==' ')
											return true;
										else;
									else if(indexX==indexi-1 && indexY==indexj && position2 ==' ')
										return true;
									else if(indexX==indexi-1 && (indexY==indexj+1 || indexY==indexj-1) && position2!= ' ')
										return true;
								}
								else if(position1=='R'){
									if(indexX==indexi)
										if (indexY>indexj){
											for(int i=indexj; i<indexY; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexY; i<indexj; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
									else if(indexY==indexj)
										if(indexX>indexi){
											for(int i=indexi; i<indexX; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexi; i<indexX; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}		
											
										
								}
								else if(position1=='N'){
									if((indexX==indexi+2 || indexX==indexi-2) && (indexY==indexj+1 || indexY==indexj-1))
										return true;
									else if((indexY==indexj+2 || indexY==indexj-2) && (indexX==indexi+1 || indexX==indexi-1))
										return true;
								}
								else if(position1=='B'){
									if(Math.abs(indexX-indexi)==Math.abs(indexY-indexj))
										if(indexX>indexi && indexY>indexj){
											int j= indexj+1;
											for(int i=indexi+1; i<indexX-indexi; i++){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
											return true;
										}
										else if(indexX>indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexi+1; i<indexX-indexi; i++){
												if(checkboard[i][j]!= ' ') return false;
												j--;
											}
										}
										else if(indexX<indexi && indexY>indexj){
											int j=indexj+1;
											for(int i=indexi-1; i>indexX; i--){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
										}
										else if(indexX<indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexi-1; i>indexX; i--){
												if(checkboard[i][j]!= ' ') return false;
												j--;
											}
										}
								}
								else if(position1=='Q'){
									if(indexX==indexi)
										if (indexY>indexj){
											for(int i=indexj; i<indexY; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexY; i<indexj; i++)
												if(checkboard[indexi][i]!= ' ') return false;
											return true;
										}	
									else if(indexY==indexj)
										if(indexX>indexi){
											for(int i=indexi; i<indexX; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}	
										else{
											for(int i=indexi; i<indexX; i++)
												if(checkboard[i][indexj]!= ' ') return false;
											return true;
										}
									else if(Math.abs(indexX-indexi)==Math.abs(indexY-indexj))
										if(indexX>indexi && indexY>indexj){
											int j= indexj+1;
											for(int i=indexi+1; i<indexX-indexi; i++){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
											return true;
										}
										else if(indexX>indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexi+1; i<indexX-indexi; i++){
												if(checkboard[i][j]!= ' ') return false;
												j--;
											}
										}
										else if(indexX<indexi && indexY>indexj){
											int j=indexj+1;
											for(int i=indexi-1; i>indexX; i--){
												if(checkboard[i][j]!= ' ') return false;
												j++;
											}
										}
										else if(indexX<indexi && indexY<indexj){
											int j=indexj-1;
											for(int i=indexi-1; i>indexX; i--){
												if(checkboard[i][j]!= ' ') return false;
												j--;
											}
										}
								
								}
								else if(position1=='K'){
									if(indexX==indexi+1 && (indexY==indexj || indexY==indexj+1 || indexY==indexj-1)) return true;
									else if(indexX==indexi-1 && (indexY==indexj || indexY==indexj+1 || indexY==indexj-1)) return true;
									else if(indexX==indexi && (indexY==indexj-1 || indexY==indexj+1)) return true;
								}
							}	
						}
						
							
						
					}		
				}
				
			}	
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		char newpawn = ' ';
		int checkboardlength = 8;
		int maxcaptured = 16;
		char[][] checkboard = new char[checkboardlength][checkboardlength];
		InitializeCheckBoard(checkboard);
		boolean turn = true;
		
		char blackcaptured[] = new char[maxcaptured];
		char whitecaptured[] = new char[maxcaptured];
		for(int i=0; i<maxcaptured; i++){
			blackcaptured[i] = ' ';
			whitecaptured[i] = ' ';
		}
		int blackcounter=0, whitecounter=0;
		boolean isblackcaptured = false;
		boolean iswhitecaptured = false;
		printBoard(checkboard, isblackcaptured, iswhitecaptured, blackcaptured, whitecaptured);
		String move = "";
		move = inputMove(turn);
		while(!move.equals("quit")){
			while(!isMoveValid(move, checkboard, turn)){
				System.out.println();
				System.out.println("Invalid move! Please try again!");
				move = inputMove(turn);				
			}
			if(turn) turn=false;
			else turn=true;
			if (checkboard[indexX][indexY]!= ' ')
				if(isWhite(checkboard[indexX][indexY])){
					whitecounter++;
					whitecaptured[whitecounter-1] = checkboard[indexX][indexY];
					iswhitecaptured=true;
				}
				else{
					blackcounter++;
					blackcaptured[blackcounter-1] = checkboard[indexX][indexY];
					isblackcaptured=true;
				}
			checkboard[indexX][indexY] = checkboard[indexi][indexj];
			checkboard[indexi][indexj]= ' ';
			printBoard(checkboard,isblackcaptured,iswhitecaptured,blackcaptured, whitecaptured);
			if((checkboard[indexX][indexY]=='p' || checkboard[indexX][indexY]=='P')  && (indexX==7 || indexX==0)){
				newpawn = transform(newpawn);
				checkboard[indexX][indexY] = newpawn;
				printBoard(checkboard,isblackcaptured,iswhitecaptured,blackcaptured, whitecaptured);
			}
			
			move = inputMove(turn);
			
		}
		printGraphicsBoard(checkboard, checkboardlength);
		
		
	}

}
