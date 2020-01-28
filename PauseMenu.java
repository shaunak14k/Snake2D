import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PauseMenu 
{
	JFrame f = new JFrame();
	//JPanel panel = new JPanel();
	
	JFrame f1 = new JFrame();
	
	int gametype;
	String mapS;
	
	public PauseMenu(int gametype,String mapS)
	{
		this.gametype = gametype;
		this.mapS = mapS;
	}
	
	
	public void PauseMenuF(JFrame f1)
	{
		JButton resume = new JButton("Resume");
		JButton exit = new JButton("Quit");
		JButton menu = new JButton("Main Menu");
				
		f.setTitle("Snake Game");		//Set title of the frame
		f.setBounds(10 ,10 ,905, 700);	//Set bounds of the frame (borders)
		f.setResizable(false);			//User cannot resize the frame
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.DARK_GRAY );
		f.setLocationRelativeTo(null);

		f.setLayout(null);
		//f.add(panel);
		
		//Settings for Text : SNAKE GAME
		JLabel lt = new JLabel(new ImageIcon("gamePaused.png"));
		lt.setBounds(180, 60, 500, 80);	
		f.add(lt);
		
		
		//Settings for JButton (START GAME)
		resume.setBounds(300, 250, 290, 65);		//x,y,width,height
		resume.setForeground(Color.white);
		resume.setFont(new Font("Cooper black", Font.BOLD, 30));
		resume.setBackground(Color.white);
		resume.setFocusable(false); 
		resume.setOpaque(false);
		resume.setBorderPainted(false);
		//resume.setContentAreaFilled(false);
		//resume.setBorderPainted(false);
		resume.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				resume.setOpaque(true);
				resume.setBackground(Color.white);
				resume.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				resume.setOpaque(false);
				resume.setBackground(Color.darkGray);
				resume.setForeground(Color.white);
						
			}
		});
		f.add(resume);		//Adding start button to JFrame
		
		
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
			
		//Settings for WALLPAPER
		JLabel wallpaper = new JLabel(new ImageIcon("Wall5.jpg"));		
		wallpaper.setBounds(0, 0, 905, 700);
		f.add(wallpaper);
		
		
		//Adding JButtons and JLabel to the JFrame
		
		
		
		
		resume.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
	        {
				/*//check in what direction is the snake to keep it in the same direction
	    		switch(pauseDir)
	    		{
	    			case 1:	right = true;
	    					break;
	    					
	    			case 2: left = true;
	    					break;
	    				
	    			case 3:	up = true;
	    					break;
	    				
	    			case 4:	down = true;
	    					break;
	    		}
	    			
	    		//reinitializing the variables for pause
	    		pause=false;
	    		pauseDir=0;*/
				
				System.out.println("Game is resumed");
				
	        	f.dispose();  
	        	
	        	f1.setTitle("Snake Game");		//Set title of the frame
	    		f1.setBounds(10 ,10 ,905, 700);	//Set bounds of the frame (borders)
		   		f1.setResizable(false);			//User cannot resize the frame
	    		f1.setVisible(true);
	    		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		f1.getContentPane().setBackground(Color.black);	
	    		f1.setBackground(Color.black);
	    		f1.setLocationRelativeTo(null);
	        	
	        	//f.repaint();
				//f.dispose();
				
	        	
	        	
	 
				/*
				//Game should pause for 3 seconds before resuming
	        	try
	        	{
					//g.setColor(Color.red);
					
					
					repaint();
					TimeUnit.SECONDS.sleep(1);
					repaint();
					TimeUnit.SECONDS.sleep(1);
					repaint();
					TimeUnit.SECONDS.sleep(1);
					
					pause2 = false;
					//g.setFont(new Font("arial",Font.BOLD, 30));
					//g.drawString("Press Space to restart", 280, 340);
				} 
	        	/*
	        	The InterruptedException is thrown when a thread is waiting or sleeping and another thread interrupts it using the interrupt method in class
	        	Thread . So if you catch this exception, it means that the thread has been interrupted. 
	        	
	        	catch (InterruptedException e1)
	        	{
	        		e1.printStackTrace();
				}
	        	*/
	        }
		});
		
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Return to main menu
				
				f.dispose();
				
				f1.dispose();
				
				new MainMenu(gametype,mapS);
				
				/*if(pause)		 
				{
					//check in what direction is the snake to keep it in the same direction
					switch(pauseDir)
					{
						case 1:	right = true;
								break;
								
						case 2: left = true;
								break;
							
						case 3:	up = true;
								break;
							
						case 4:	down = true;
								break;
					}
					//reinitializing the variables for pause
					pause=false;
					pauseDir=0;
				}
				
				//The game should start and components should be reinitialized after clicking MAIN MENU
				right=false;
				left=false;
				up=false;
				down=false;
				
				play = false;
				
				moves = 0;
				score = 0;
				snakeLength = 3;
				
				repaint();
				
						//To clear the previous JFrame of the game
				
				f.dispose();
				panel.setVisible(false);

				
				new MainMenu();	//Called from gameover menu */
			}
		});
		
		
		
		exit.addActionListener(new ActionListener() 
		{	
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("EXIT");
				
				//After clicking (Exit) the game frame should close
				//f.dispose();
				System.exit(0);
			}
		});
	}
}
