import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.event.WindowEvent;
import java.util.Random;
//import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

//import javazoom.jl.decoder.JavaLayerException;
//import javazoom.jl.player.Player;

public class Gameplay extends JPanel implements KeyListener,ActionListener
{
	
	/**
	 * 
	 */ 
	public Gameplay()
	{}
	
	
	private static final long serialVersionUID = 1L;

	String map = "Classic";
	
	public ImageIcon titleImage;		//Title of the game
	
	public boolean play = true;
	
	//Images for the snake
	public ImageIcon rightMouth;		
	public ImageIcon leftMouth;
	public ImageIcon upMouth;
	public ImageIcon downMouth;
	public ImageIcon snakeImage;
	
	public int snakeXLength[] = new int[750]; 		//X coordinate
	public int snakeYLength[] = new int[750];		//Y coordinate
	
	//Movement of the snake
	public boolean right = false;
	public boolean left = false;
	public boolean up = false;
	public boolean down = false;
	
	public Timer timer;
	public int delay = 120;
	
	public int snakeLength = 3;
	
	int score = 0;
	
	public int[] enemyXpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	public int[] enemyYpos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	public ImageIcon enemyImage;
	
	public Random random = new Random();		//random variable
	
	public int xPos = random.nextInt(34);		//Range of random var is 34 for Xcoordinate of enemy
	public int yPos = random.nextInt(23);		//Range is random var is 23 for Ycoordinate of enemy
	
	public int moves=0;

	public int pauseDir = 0;		//Variable for pause direction

	public boolean pause = false;

	int highScore = 0;
	
	private int bigEnemyCount = 0;
	
	JFrame f1 = new JFrame();

	private ImageIcon bigEnemyImage;

	private int[] bigEnemyXpos = {125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750};
	private int[] bigEnemyYpos = {150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550};
	
	private int xPosBig = random.nextInt(25);
	private int yPosBig = random.nextInt(16);


	private boolean showBigEnemy = false;
	
	public Gameplay(JFrame f1)
	{	
		
		this.f1 = f1;
				
		addKeyListener(this);		//Adding the keylistener to the const of gameplay. Passing'this' because method defined in same class
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		
		timer = new Timer(delay, this);		//Timer(speed, object on which timer will work)
		timer.start();
		
	}
	
	//**********************************************************************************************************************************************
	/*
	The paint method is called by the Event Dispatch Thread (EDT) and is basically out of your control. We have set setVisible(true) hence it works automatically.
	  
	It works as follows: When you realize a user interface (call setVisible(true) in our case), Swing starts the EDT. This EDT thread then runs in the background
	and, whenever your component needs to be painted, it calls the paint method with an appropriate Graphics instance for you to use for painting.

	So, when is a component "needed" to be repainted? -- For instance when

	1. The window is resized
	2. The component is made visible
	3. When you call repaint()
	...
	Simply assume that it will be called, whenever it is necessary.*/
	
	//***********************************************************************************************************************************************************
	
	
//************************************************************************************************************************************
	
	public void paint(Graphics g)		//We can draw things on JPanel using Graphics class. in this method we draw the snake as it moves
	{
		
		
		if(!play)
		{
			g.dispose();
			return;
		}
		
		//Game is not started
		if(moves == 0)		
		{
			snakeXLength[0] = 100;
			snakeXLength[1] = 75;
			snakeXLength[2] = 50;
			
			snakeYLength[0] = 100;
			snakeYLength[1] = 100;
			snakeYLength[2] = 100;
		}
		//Text to Resume
		
		
		//Paint board and text on the board	
		CommonClass c = new CommonClass();
		c.paint(g,score,snakeLength,pause,map,left,right,up,down,snakeXLength,snakeYLength,pauseDir,false);
		
		
		enemyImage = new ImageIcon("enemy.png");
		enemyImage.paintIcon(this, g, enemyXpos[xPos], enemyYpos[yPos]);
		
		//Check if snake collides the enemy
		if(enemyXpos[xPos] == snakeXLength[0]  && enemyYpos[yPos] == snakeYLength[0])			//snakeXYLength[0] is head of the snake
		{			
			score++;

			repaint();
			
			snakeLength++;
			
			//Check if player wins 
			if(snakeLength == 574)
			{			
				repaint();
				gWin();
			}
			
			
			//Increase speed after every enemy is killed
			if(delay>55)
			{
				delay--;
				timer.stop();
				timer = new Timer(delay, this);		//Timer(speed, object on which timer will work)
				timer.start();
			}
			//Again generate random var for position new enemy
			xPos = random.nextInt(34);
			yPos = random.nextInt(23);
		}
		
		//************For bigEnemy******************************************************************
		if(score%10==0 && score!=0)
		{
			showBigEnemy  = true;
		}	
		
		if(showBigEnemy)
		{
			//System.out.println("YES");
			if(bigEnemyCount < 50)
			{
				bigEnemyImage = new ImageIcon("bigEnemy.png");
				bigEnemyImage.paintIcon(this, g, bigEnemyXpos[xPosBig], bigEnemyYpos[yPosBig]);
				
				g.setColor(Color.lightGray);
				g.drawRect(250, 600, 400, 5);
				g.setColor(Color.white);
				g.fillRect(250, 600, 400-(bigEnemyCount*8), 5);
				
				//Check if snake collides the BIGenemy
				if((snakeXLength[0] > bigEnemyXpos[xPosBig]-25 && snakeXLength[0] < bigEnemyXpos[xPosBig]+50) && (snakeYLength[0] > bigEnemyYpos[yPosBig]-25 && snakeYLength[0] < bigEnemyYpos[yPosBig]+50)) 
				{
					score += 3;

					repaint();
				
					snakeLength += 3;
				
					bigEnemyCount = 0;
					
					showBigEnemy = false;
			
					//Check if player wins 
					if(snakeLength == 574)
					{			
						repaint();
						gWin();
					}
			
					
					//Increase speed after every enemy is killed
					if(delay>55)
					{
						delay--;
						timer.stop();
						timer = new Timer(delay, this);		//Timer(speed, object on which timer will work)
						timer.start();
					}
					//Again generate random var for position new enemy
					xPosBig = random.nextInt(25);
					yPosBig = random.nextInt(16);
				}
			
				bigEnemyCount++;
			}
			
			else
			{
				bigEnemyCount = 0;
			
				showBigEnemy = false;
			
				repaint();
				//Again generate random var for position new enemy
				xPosBig = random.nextInt(25);
				yPosBig = random.nextInt(16);
			}	
		
		}
		//****************************************************************************888
		
		
		
		for(int i=1; i<snakeLength ;i++)		//i=1 because at [0] there is head of the snake
		{
			// if x and y position of any body part of snake is same as x and y position of head of the snake
			if(snakeXLength[i] == snakeXLength[0] && snakeYLength[i] == snakeYLength[0])		//If snake collides with itself
			{
				
				System.out.println("Game Over");
				
				g.dispose();
			
				
				//panel.setVisible(false);
				
				//panel.remove(g);
				
				//java.awt.Toolkit.getDefaultToolkit().beep();		//Creates a windows exclamation sound
				
				//Stop the snake
				right=false;
				left=false;
				up=false;
				down=false;
				
				//g.dispose();
				
				if(highScore < score)
					highScore = score;
				
				//new UpdateHighScore(highScore,0);
				
				//new MainMenu("clear");		//To clear the previous JFrame of the game
				
				
				GameOverMenu g1 = new GameOverMenu(1,"classic");
				g1.GameOver(score,highScore,0);
				
				//setVisible(false);
				f1.dispose();
				
				
				
				//For Restarting game using keyboard inputs
				/*
				g.setColor(Color.red);
				g.setFont(new Font("arial",Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);
				
				g.setFont(new Font("arial",Font.BOLD, 30));
				g.drawString("Press SPACE to restart", 280, 360);	
				
				g.setFont(new Font("arial",Font.BOLD, 30));
				g.drawString("Press ESCAPE to exit", 280, 400);	
				*/
			}
		}
		
		//bigEnemyCount++;
		System.out.println("enemyCOunt : "+bigEnemyCount);
		//g.dispose();	//Clear the frame for new components
		
	}
	
	void gWin()
	{
		
		
		//Stop the snake
		right=false;
		left=false;
		up=false;
		down=false;
		
		//g.dispose();
		
		if(highScore < score)
			highScore = score;
		
		//new UpdateHighScore(highScore,0);
		
		//new MainMenu("clear");		//To clear the previous JFrame of the game
		
		
		GameWinMenu g1 = new GameWinMenu(1,"classic");
		 g1.GameWin(score,highScore,0);
	
		 f1.dispose();
	}
	
	
	
//**********************************************************************************************************************************
	
	@Override
	public void actionPerformed(ActionEvent e) 		//This method will be called after timer.start()
	{
		// We also want to move the body of the snake along with its head
		// So before moving head we assign the position of the head to the position of the body part(circle) just behind the head
		//Here we move the snake 
		
		if(right)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeYLength[i+1] = snakeYLength[i];		// So before moving head we assign the position of the head to the body part just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeXLength[i] = snakeXLength[i]+25;		//Move 25 pixels in right
				}
				else
				{
					snakeXLength[i] = snakeXLength[i-1];		//Move 
				}
				if(snakeXLength[i] > 850)		//if snake touches the border
				{
					snakeXLength[i] = 25;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(left)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeYLength[i+1] = snakeYLength[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeXLength[i] = snakeXLength[i]-25;		//Move 25 pixels in left
				}
				else
				{
					snakeXLength[i] = snakeXLength[i-1];		//Move 
				}
				if(snakeXLength[i] < 25)		//if snake touches the border
				{
					snakeXLength[i] = 850;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(up)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeXLength[i+1] = snakeXLength[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeYLength[i] = snakeYLength[i]-25;		//Move 25 pixels in upward direction
				}
				else
				{
					snakeYLength[i] = snakeYLength[i-1];		//Move 
				}
				if(snakeYLength[i] < 75)		//if snake touches the border
				{
					snakeYLength[i] = 625;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(down)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeXLength[i+1] = snakeXLength[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeYLength[i] = snakeYLength[i]+25;		//Move 25 pixels down
				}
				else
				{
					snakeYLength[i] = snakeYLength[i-1];		//Move 
				}
				if(snakeYLength[i] > 625)		//if snake touches the border
				{
					snakeYLength[i] = 75;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		
	}
	
//****************************************************************************************************************************
	
	
	
	
//**********************************************************************************************************************************************8
	
	@Override
	public void keyPressed(KeyEvent e)			//This method will be called after pressing any key
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)			//if right arrow is pressed (moves++)
		{
			
			System.out.println("RIGHT arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right==false && left==false && up==false && down==false && moves>0)		//if game is stopped
			{
				return;
			}
			
			moves++;
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(up || down)
			{
				if(snakeYLength[0] == snakeYLength[1])
					return;
			}
			//*************************************************************************
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!left)
			{
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			up = false;
			down = false;	
			
			if(showBigEnemy)
				bigEnemyCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)			//if left arrow is pressed (moves++)
		{
			
			System.out.println("LEFT arrow key pressed");
			
			//Snake should not move if game is stopped
			if(right==false && left==false && up==false && down==false && moves>0)		//if game is stopped
			{
				return;
			}
			
			//Initially when snake is not moving, it cannot go in opposite(left) direction.
			if(moves == 0)
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(up || down)
			{
				if(snakeYLength[0] == snakeYLength[1])
					return;
			}
			//*************************************************************************
			
			moves++;
			
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!right)
			{
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			up = false;
			down = false;
			
			if(showBigEnemy)
				bigEnemyCount--;
			
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)			//if up arrow is pressed (moves++)
		{
			System.out.println("UP arrow key pressed");
			
			//Snake should not move if game is stopped
			if(right==false && left==false && up==false && down==false && moves>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(left || right)
			{
				if(snakeXLength[0] == snakeXLength[1])
					return;
			}
			//**********************************************************************
			
			moves++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen and should continue moving in the same direction
			if(!down)
			{
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
			left = false;
			right = false;
			
			if(showBigEnemy)
				bigEnemyCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)			//if down arrow is pressed (moves++)
		{
			
			System.out.println("DOWN arrow key pressed");
			
			//Snake should not move if game is stopped
			if(right==false && left==false && up==false && down==false && moves>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(left || right)
			{
				if(snakeXLength[0] == snakeXLength[1])
					return;
			}
			//**********************************************************************
			
			moves++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!up)
			{
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
			left = false;
			right = false;
			
			if(showBigEnemy)
				bigEnemyCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			//To restart the game using keyboard inputs
			//Nothing should happen if the game is still playing hence we put a condition
			/*if(right==false && left==false && up==false && down==false && !pause)		//if game is stopped & NOT paused (Game cannot be restarted while being paused)
			{
				moves = 0;
				score = 0;
				snakeLength = 3;
			}
			*/
			
			
			//If the game is paused then resume the game
			if(pause)		 
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
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			
			System.out.println("Game is paused");
			
			//If game is not started nothing should happen
			if(moves == 0)
			{
				pause=true;
			}
			
			/*//If game is stopped or game is over then quit the game
			if(right == false && left == false && up == false && down == false)
			{
				System.exit(0);
			}*/
			
			//Check in what direction the snake is and assign value to pausedir according to the direction
			if(right == true)
				pauseDir = 1;
			
			else if(left == true)
				pauseDir = 2;
			
			else if(up == true)
				pauseDir = 3;
			
			else if(down == true)
				pauseDir = 4;
			
			//Stop the movement of the snake ie. pause the game
			up=false;
			down=false;
			right=false;
			left=false;
			
			pause = true;
			
			f1.dispose();
			
			PauseMenu ob = new PauseMenu(1,"classic");	
			ob.PauseMenuF(f1);
			
			
			
		/*	f1.setTitle("Snake Game");		//Set title of the frame
    		f1.setBounds(10 ,10 ,905, 700);	//Set bounds of the frame (borders)
	   		f1.setResizable(false);			//User cannot resize the frame
    		f1.setVisible(true);
    		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		f1.getContentPane().setBackground(Color.black);		
    		f1.setLocationRelativeTo(null);
    		*/
    		//Gameplay basicGame = new Gameplay(f1);
			
			//repaint();
			
			/*JLabel pause = new JLabel("Test");
			pause.setText("Label Text");
			pause.setText("");*/
			
		}		
	}
	
	
	
	
	
//***************************************************************************************************************************
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
