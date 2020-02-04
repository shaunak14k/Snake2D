import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UpdateHighScore 
{
	int updateScore(int highScore,int level)
	{
		
		//FOR FILE STORAGE
		System.out.println("File Content : ");
		
		//String oldHighScore = "";
		int oldHS;
		
		int newHighScore = highScore; 
		
		
		String classicHS="",boxHS="",obs1HS="",obs2HS="";
		
		int cnt=0;
		
		try 
		{	 
			// open file to read
			Scanner scanner = new Scanner(new File("C:\\\\Users\\\\Shaunak\\\\eclipse-workspace\\\\Snake Game\\\\testFile\\\\singlePlayer.txt"));
			// read until end of file (EOF)
			while (scanner.hasNextLine()) 
			{
				
				//oldHighScore = scanner.nextLine();
				
				cnt++;
				
				System.out.println(cnt);
				
				switch(cnt)
				{
					case 1:	classicHS = scanner.nextLine();
							break;
							
					case 2:	boxHS = scanner.nextLine();	
							break;
					
					case 3:	obs1HS = scanner.nextLine();	
							break;
					
					case 4:	obs2HS = scanner.nextLine();	
							break;
				}
	    	}			
			// close the scanner
			scanner.close();
		
			
			File file = new File("C:\\Users\\Shaunak\\eclipse-workspace\\Snake Game\\testFile\\singlePlayer.txt");
			// if file doesnt exists, then create it
			if (!file.exists()) 
			{
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);    
			
			
//			/oldHS = Integer.parseInt(oldHighScore);    
		        	
			
			switch(level)
			{
				case 0:	oldHS = Integer.parseInt(classicHS);
					
						if(newHighScore > oldHS)	
						{
							bw.write(newHighScore+"\n"+boxHS+"\n"+obs1HS+"\n"+obs2HS);							
						}
						else
						{
							bw.write(oldHS+"\n"+boxHS+"\n"+obs1HS+"\n"+obs2HS);
							newHighScore = oldHS;	//if old is greater then new = old
						}
				
						bw.close();
						System.out.println("Done");
						break;
						
				case 1:	oldHS = Integer.parseInt(boxHS);
				
						if(newHighScore > oldHS)	
						{
							bw.write(classicHS+"\n"+newHighScore+"\n"+obs1HS+"\n"+obs2HS);							
						}
						else
						{
							bw.write(classicHS+"\n"+oldHS+"\n"+obs1HS+"\n"+obs2HS);
							
							newHighScore = oldHS;	//if old is greater then new = old
						}
		
						bw.close();
						System.out.println("Done");
						break;
				
				case 2:	oldHS = Integer.parseInt(obs1HS);
				
						if(newHighScore > oldHS)	
						{
							bw.write(classicHS+"\n"+boxHS+"\n"+newHighScore+"\n"+obs2HS);							
						}
						else
						{
							bw.write(classicHS+"\n"+boxHS+"\n"+oldHS+"\n"+obs2HS);		
							newHighScore = oldHS;	//if old is greater then new = old
						}
		
						bw.close();
						System.out.println("Done");
						break;
				
				case 3:	oldHS = Integer.parseInt(obs2HS);
				
						if(newHighScore > oldHS)	
						{
							bw.write(classicHS+"\n"+boxHS+"\n"+obs2HS+"\n"+newHighScore);							
						}
						else
						{
							bw.write(classicHS+"\n"+boxHS+"\n"+obs1HS+"\n"+oldHS);				
							newHighScore = oldHS;	//if old is greater then new = old
						}
		
						bw.close();
						System.out.println("Done");
						break;
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		 
		return newHighScore;
	}
	
	
	//*************************************************************************************************************************************************
	//DISPLAY ON BOARD
	
	int displayHighScore(int level)
	{	
		int highScore=0;
		
		//String oldHighScore = "";
				
		String classicHS="",boxHS="",obs1HS="",obs2HS="";
		
		int cnt=0;
		
		try 
		{	 
			// open file to read
			Scanner scanner = new Scanner(new File("C:\\\\Users\\\\Shaunak\\\\eclipse-workspace\\\\Snake Game\\\\testFile\\\\singlePlayer.txt"));
			// read until end of file (EOF)
			while (scanner.hasNextLine()) 
			{
				
				//oldHighScore = scanner.nextLine();
				
				cnt++;
				
				//System.out.println(cnt);
				
				switch(cnt)  
				{
				case 1:	classicHS = scanner.nextLine();
						break;
				
				case 2:	boxHS = scanner.nextLine();	
						break;
						
				case 3:	obs1HS = scanner.nextLine();	
						break;
				
				case 4:	obs2HS = scanner.nextLine();	
						break;
				}
			}
			scanner.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
				
		switch(level)
		{
			case 0:	highScore = Integer.parseInt(classicHS);
					break;
					
			case 1:	highScore = Integer.parseInt(boxHS);
					break;
			
			case 2:	highScore = Integer.parseInt(obs1HS);
					break;
			
			case 3:	highScore = Integer.parseInt(obs2HS);
					break;
			
			default :	highScore = Integer.parseInt(classicHS);
						break;	
		}
				 
		
		return highScore;
	}
		
	
	
	//*********************************************************************************************************************************8
		
	
	//For load game
	void loadGame()
	{
		
	}
		
		//FOR DATABASE CONNECTION (MYSQL)
		/*
		java.sql.Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		java.sql.PreparedStatement ps1 = null;
	
		try
		{
			System.out.println("Entered in UpdateHighScore");
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakegame","root","");
			
			//Class.forName("org.postgresql.Driver");
			//conn = DriverManager.getConnection("jdbc:postgresql://localhost/snakegame","root","");			//For PostgreSQL
		
			if(conn==null)
			{
				System.out.println("Connection failed");
			}
			else
			{
				stmt = conn.createStatement();
				
				
				switch(level)
				{
				case 0:		rs = stmt.executeQuery("SELECT  `HighScore` FROM `highscore` WHERE LevelName='BasicLevel' ");
							while(rs.next())
							{
								if(highScore > rs.getInt(1))		//if new highscore is greater than old highscore then change the highscore
								{	
									ps1 = conn.prepareStatement("UPDATE `highscore` SET `HighScore`= ? WHERE LevelName= ? ");
									ps1.setInt(1, highScore);
									ps1.setString(2, "BasicLevel");
									ps1.executeUpdate();
								}	
							}
							rs = stmt.executeQuery("SELECT `HighScore` FROM `highscore` WHERE LevelName='BasicLevel' ");
							while(rs.next())
							{
								System.out.println("\n High Score of 'BASIC-LEVEL' : "+rs.getInt(1));
								highScore = rs.getInt(1);
							}
							break;
						
							
				case 1:		rs = stmt.executeQuery("SELECT  `HighScore` FROM `highscore` WHERE LevelName='BorderLevel' ");
							while(rs.next())
							{
								if(highScore > rs.getInt(1))
								{	
									ps1 = conn.prepareStatement("UPDATE `highscore` SET `HighScore`= ? WHERE LevelName= ? ");
									ps1.setInt(1, highScore);
									ps1.setString(2, "BorderLevel");
									ps1.executeUpdate();
								}
							}
							rs = stmt.executeQuery("SELECT `HighScore` FROM `highscore` WHERE LevelName='BorderLevel' ");
							while(rs.next())
							{
								System.out.println("\n High Score of 'BORDER-LEVEL' : "+rs.getInt(1));
								highScore = rs.getInt(1);
							}
							break;	
						
				case 2:		rs = stmt.executeQuery("SELECT  `HighScore` FROM `highscore` WHERE LevelName='Level-2' ");
							while(rs.next())
							{
								if(highScore > rs.getInt(1))
								{	
									ps1 = conn.prepareStatement("UPDATE `highscore` SET `HighScore`= ? WHERE LevelName= ? ");
									ps1.setInt(1, highScore);
									ps1.setString(2, "Level-2");
									ps1.executeUpdate();
								}
							}
							rs = stmt.executeQuery("SELECT `HighScore` FROM `highscore` WHERE LevelName='Level-2' ");
							while(rs.next())
							{
								System.out.println("\n High Score of 'LEVEL-2' : "+rs.getInt(1));
								highScore = rs.getInt(1);
							}
							break;	
							
				case 3:		rs = stmt.executeQuery("SELECT  `HighScore` FROM `highscore` WHERE LevelName='Level-3' ");
							while(rs.next())
							{
								if(highScore > rs.getInt(1))
								{	
									ps1 = conn.prepareStatement("UPDATE `highscore` SET `HighScore`= ? WHERE LevelName= ? ");
									ps1.setInt(1, highScore);
									ps1.setString(2, "Level-3");
									ps1.executeUpdate();
								}
							}
							rs = stmt.executeQuery("SELECT `HighScore` FROM `highscore` WHERE LevelName='Level-3' ");
							while(rs.next())
							{
								System.out.println("\n High Score of 'LEVEL-3' : "+rs.getInt(1));
								highScore = rs.getInt(1);
							}
							break;	
							
				default : System.out.println("\n ERROR");
				
				}
				
				
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println("Error detected");
		}
		
		return highScore;
		*/
	
	
	
}
