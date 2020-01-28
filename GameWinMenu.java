import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;



public class GameWinMenu implements ActionListener
{
	int x;
	
	int GameWin(int score,int highScore,int level)
	{
		gameWinMusic();
		
		UpdateHighScore ob = new UpdateHighScore();
		
		highScore = ob.updateScore(highScore,level);
		
		JFrame f = new JFrame();	 	//Creating JFrame object f
		
		JButton restart = new JButton("Restart Game");
		//JButton menu = new JButton("Main Menu");
		JButton exit1 = new JButton("Exit");
		
		//JPanel panel = new JPanel();
		
		JLabel lt = new JLabel("You Win !");
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
			
		
		//Settings for JButton (RESTART GAME)
		restart.setBounds(290, 250, 330, 80);		//x,y,width,height
		restart.setFont(new Font("Arial", Font.BOLD, 40));
		restart.setBackground(Color.orange);
		//panel.add(restart);	//Adding start button to JPanel
		f.add(restart);		//Adding start button to JFrame
		
		/*//Settings for JButton (Main Menu)
		menu.setBounds(310, 350, 295, 80);		//x,y,width,height
		menu.setFont(new Font("Arial", Font.BOLD, 40));
		menu.setBackground(Color.orange);
		panel.add(menu);	//Adding start button to JPanel
		f.add(menu);		//Adding start button to JFrame
		*/
		
		//Settings for JButton (EXIT)
		exit1.setBounds(360, 450, 190, 80);		//x,y,width,height
		exit1.setFont(new Font("Arial", Font.BOLD, 40));
		exit1.setBackground(Color.orange);
		//panel.add(exit1);		//Adding exit button to JPanel
		f.add(exit1);		//Adding exit button to JFrame
		
		
		//Settings for Text
		lt.setFont(new Font("Arial", Font.BOLD, 60));
		lt.setBounds(300, 80, 390, 80);
		lt.setForeground(Color.red);
		lt.setForeground(Color.red);
		//panel.add(lt);
		f.add(lt);
		
		//Settings for Text
		sc.setFont(new Font("Arial", Font.BOLD, 25));
		sc.setBounds(300, 175, 390, 40);
		sc.setForeground(Color.red);
		sc.setForeground(Color.green);
		//panel.add(sc);
		f.add(sc);
		
		//Settings for Text
		hsc.setFont(new Font("Arial", Font.BOLD, 25));
		hsc.setBounds(465, 175, 390, 40);
		hsc.setForeground(Color.red);
		hsc.setForeground(Color.green);
		//panel.add(hsc);
		f.add(hsc);
		
		
		restart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		    {
				System.out.println("\n Game is restarted");
				
				//f.repaint();
				f.dispose();
				
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
				
		/*menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Return to main menu
				
				f.dispose();
		
				
				//new MainMenu("clear");		//To clear the previous JFrame of the game
				
				new MainMenu();
				
				x=1;
			}
		});*/
		
		exit1.addActionListener(new ActionListener() 
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
			FileInputStream fileInputStream = new FileInputStream("victoryMusic.mp3");

			Player player; 
		
			player = new Player(fileInputStream);
			
			System.out.println("\n Victory Music is playing");
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

