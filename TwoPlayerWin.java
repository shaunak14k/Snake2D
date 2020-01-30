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



public class TwoPlayerWin implements ActionListener
{
	int x;
	
	int gtype;
	String mapS;
	
	public TwoPlayerWin(int gtype,String mapS) 
	{
		//super(gtype, mapS);
		this.gtype = gtype;
		this.mapS = mapS;
	}
	
	int GameWin(String winner)
	{
		
		//UpdateHighScore ob = new UpdateHighScore();
		
		//System.out.println("STARTED ");
		
		gameWinMusic();
		
		JFrame f = new JFrame();	 	//Creating JFrame object f
		
		//System.out.println("CREATED");
		
		JButton restart = new JButton("Play again");
		JButton menu = new JButton("Main Menu");
		JButton exit = new JButton("Quit");
		
		//Setting some settings for our JFrame
		f.setTitle("Snake2D");						//Set title of the frame
		f.setBounds(10 ,10 ,905, 700);					//Set bounds of the frame (borders)
		f.setResizable(false);							//User cannot resize the frame
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.DARK_GRAY );
		f.setLocationRelativeTo(null);
				
		f.setLayout(null);
		
		//Add icon to JFrame
		ImageIcon icon = new ImageIcon("frameIcon.png");
		f.setIconImage(icon.getImage());
		
		//JPanel panel = new JPanel();
		
		JLabel win = new JLabel(winner+" Wins !");
		
		//Settings for Text : SNAKE GAME
		JLabel lt = new JLabel(new ImageIcon("gameOver.png"));
		lt.setBounds(180, 60, 500, 80);	
		f.add(lt);
				
		
		System.out.println("HEYYY");
				
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
		win.setFont(new Font("Cooper black", Font.BOLD, 22));
		win.setBounds(360, 150, 390, 40);
		win.setForeground(Color.orange);
		f.add(win);		
		
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
				
				f1.setTitle("Snake2D");		//Set title of the frame
	    		f1.setBounds(10 ,10 ,905, 700);	//Set bounds of the frame (borders)
		   		f1.setResizable(false);			//User cannot resize the frame
	    		f1.setVisible(true);
	    		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		f1.getContentPane().setBackground(Color.black);		
	    		f1.setLocationRelativeTo(null);
				
	    		//Add icon to JFrame
	    		ImageIcon icon = new ImageIcon("frameIcon.png");
	    		f1.setIconImage(icon.getImage());
	    		
	    		Game1 g1 = new Game1(f1);
    			
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
    			}
	    		
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
		
		
		return x;
		
		
	}
	
	void gameWinMusic()
	{
		try 
		{
			FileInputStream fileInputStream = new FileInputStream("victory1.mp3");

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
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}

}

