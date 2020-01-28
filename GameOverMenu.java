import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class GameOverMenu implements ActionListener
{

	int gtype;
	String mapS;
	
	public GameOverMenu(int gtype, String mapS) {
		//super(gtype, mapS);
		// TODO Auto-generated constructor stub
		
		this.gtype = gtype;
		this.mapS = mapS;
	}

	

	int x = 0;
	
	int GameOver(int score,int highScore,int level) 
	{
		
		//gameOverMusic();
		
		UpdateHighScore ob = new UpdateHighScore();
			
		highScore = ob.updateScore(highScore,level);
		
		JFrame f = new JFrame();	 	//Creating JFrame object f
		
		JButton restart = new JButton("Play again");
		JButton menu = new JButton("Main Menu");
		JButton exit = new JButton("Quit");
		
		JLabel sc = new JLabel("Score - "+score);
		JLabel hsc = new JLabel("High Score - "+highScore);
		
		//Setting some settings for our JFrame
		f.setTitle("Game Over");						//Set title of the frame
		f.setBounds(10 ,10 ,905, 700);					//Set bounds of the frame (borders)
		f.setResizable(false);							//User cannot resize the frame
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.DARK_GRAY );
		f.setLocationRelativeTo(null);
			
		f.setLayout(null);
		//f.add(panel);		//Adding panel to JFrame
			
		
		//Settings for Text : SNAKE GAME
		JLabel lt = new JLabel(new ImageIcon("gameOver.png"));
		lt.setBounds(180, 60, 500, 80);	
		f.add(lt);
		
		
		//Settings for JButton (START GAME)
		restart.setBounds(300, 250, 290, 65);		//x,y,width,height
		restart.setForeground(Color.white);
		restart.setFont(new Font("Cooper black", Font.BOLD, 30));
		restart.setBackground(Color.white);
		restart.setFocusable(false); 
		restart.setOpaque(false);
		restart.setBorderPainted(false);
		//restart.setContentAreaFilled(false);
		//restart.setBorderPainted(false);
		restart.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				restart.setOpaque(true);
				restart.setBackground(Color.white);
				restart.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				restart.setOpaque(false);
				restart.setBackground(Color.darkGray);
				restart.setForeground(Color.white);
				
			}
		});
		f.add(restart);		//Adding start button to JFrame
		
		
		//Settings for JButton (START GAME)
		menu.setBounds(300, 315, 290, 65);		//x,y,width,height
		menu.setForeground(Color.white);
		menu.setFont(new Font("Cooper black", Font.BOLD, 30));
		menu.setBackground(Color.white);
		menu.setFocusable(false); 
		menu.setOpaque(false);
		menu.setBorderPainted(false);
		//menu.setContentAreaFilled(false);
		//menu.setBorderPainted(false);
		menu.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				menu.setOpaque(true);
				menu.setBackground(Color.white);
				menu.setForeground(Color.darkGray);
			}
					
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				menu.setOpaque(false);
				menu.setBackground(Color.darkGray);
				menu.setForeground(Color.white);
				
			}
		});
		f.add(menu);		//Adding start button to JFrame
		
		
		//Settings for JButton (START GAME)
		exit.setBounds(347, 450, 200, 65);		//x,y,width,height
		exit.setForeground(Color.white);
		exit.setFont(new Font("Cooper black", Font.BOLD, 30));
		exit.setBackground(Color.white);
		exit.setFocusable(false); 
		exit.setOpaque(false);
		exit.setBorderPainted(false);
		//exit.setContentAreaFilled(false);
		//exit.setBorderPainted(false);
		exit.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				exit.setOpaque(true);
				exit.setBackground(Color.white);
				exit.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				exit.setOpaque(false);
				exit.setBackground(Color.darkGray);
				exit.setForeground(Color.white);
				
			}
		});
		f.add(exit);		//Adding start button to JFrame
		
		
		//Settings for Text
		sc.setFont(new Font("Cooper black", Font.BOLD, 22));
		sc.setBounds(270, 150, 390, 40);
		sc.setForeground(Color.orange);
		//panel.add(sc);
		f.add(sc);
		
		//Settings for Text
		hsc.setFont(new Font("Cooper black", Font.BOLD, 22));
		hsc.setBounds(440, 150, 390, 40);
		hsc.setForeground(Color.orange);
		//panel.add(hsc);
		f.add(hsc);
		
		
		//Settings for WALLPAPER
		JLabel wallpaper = new JLabel(new ImageIcon("Wall5.jpg"));		
		wallpaper.setBounds(0, 0, 905, 700);
		f.add(wallpaper);
					
				
		
		
		JFrame f1 = new JFrame();
		
		
		restart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		    {
				System.out.println("\n Game is restarted");
				
				//f.repaint();
				f.dispose();
				
				f1.setTitle("Snake Game");		//Set title of the frame
	    		f1.setBounds(10 ,10 ,905, 700);	//Set bounds of the frame (borders)
		   		f1.setResizable(false);			//User cannot resize the frame
	    		f1.setVisible(true);
	    		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		f1.getContentPane().setBackground(Color.black);		
	    		f1.setLocationRelativeTo(null);
				
	    		
	    		if(gtype == 1)
	    		{
	    			Gameplay basicGame = new Gameplay(f1);
	    			
	    			switch(mapS)
	    			{
	    				case "classic" :	f1.add(basicGame);
	    								//f1.dispose();
	    								break;
	    							
	    				case "Border":	BorderGame borderGame = new BorderGame(f1);
	    								f1.add(borderGame);
	    								break;
	    							
	    				case "level2":	Level2 l2 = new Level2(f1); 
	    								f1.add(l2);
	    								
	    								break;
	    							
	    				case "level3":	Level3 l3 = new Level3(f1);
	    								f1.add(l3);
	    								break;
	    							
	    				default : 	f1.add(basicGame);
	    							//f1.remove(basicGame);
	    							break;
	    			}
	    		}
	    		else if(gtype == 2)
	    		{
	    			/*TwoPlayerGame g1 = new TwoPlayerGame(f1);
	    			
	    			switch(mapS)
	    			{
	    				case "game1" :	f1.add(g1);
	    								break;
	    							
	    				case "game2":	Game2 g2 = new Game2(f1);
	    								f1.add(g2);
	    								//f.dispose();
	    								break;
	    							
	    				case "game3":	Game3 g3 = new Game3(f1);
	    								f1.add(g3);
	    								break;
	    							
	    							
	    				default : 	f1.add(g1);
	    							break;
	    			}*/
	    		}
	    		
	    		
			     x = 0;
				//************
				//After clicking on start first frame will get disposed and we make a new frame for our game
	        	
				/*JFrame f1 = new JFrame();
			        	
	        	f1.setTitle("Snake Game");		//Set title of the frame
	    		f1.setBounds(10 ,10 ,905, 700);	//Set bounds of the frame (borders)
		   		f1.setResizable(false);			//User cannot resize the frame
	    		f1.setVisible(true);
	    		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		f.getContentPane().setBackground(Color.black);			        	
	        
	    		f1.add(gameplay);*/
	        	
	        	//***************
	        }
		});
				
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Return to main menu
				
				f.dispose();
				
				new MainMenu(gtype,mapS);
		
				
				//new MainMenu("clear");		//To clear the previous JFrame of the game
				
				//new MainMenu();
				
				x=1;
			}
		});
		
		exit.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				
				System.out.println("\n EXIT");
				//After clicking (Exit) the game frame should close
				System.exit(0);
			}
		});
		
		System.out.println("Returning x ");
		return x;
	}
	
	void gameOverMusic()  
	{
		try 
		{
			FileInputStream fileInputStream = new FileInputStream("gameover.mp3");

			Player player; 
		
			player = new Player(fileInputStream);
			
			System.out.println("Game Over Music is playing");
			player.play();
		
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(JavaLayerException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	//********************************************************************************************************
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}

}



/*java.sql.Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
java.sql.PreparedStatement ps1 = null;

try
{
	System.out.println("Entered in UpdateHighScore");
	
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/snakegame","root","");

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
							highScore = rs.getInt(1);
						}
						break;	
					
			case 1:		rs = stmt.executeQuery("SELECT  `HighScore` FROM `highscore` WHERE LevelName='BorderLevel' ");
						while(rs.next())
						{
							highScore = rs.getInt(1);
						}
						break;	
				
			case 2:		rs = stmt.executeQuery("SELECT  `HighScore` FROM `highscore` WHERE LevelName='Level-2' ");
						while(rs.next())
						{
							highScore = rs.getInt(1);
						}
						break;	
					
			case 3:		rs = stmt.executeQuery("SELECT  `HighScore` FROM `highscore` WHERE LevelName='Level-3' ");
						while(rs.next())
						{
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
}*/

					