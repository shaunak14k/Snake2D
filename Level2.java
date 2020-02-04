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


//SNAKE LENGTH is 25pixels for one body

public class Level2 extends JPanel implements KeyListener,ActionListener
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private ImageIcon titleImage;		//Title of the game
	
	private boolean play = true;
	
	//Images for the snake
	/*private ImageIcon rightMouth;		
	private ImageIcon leftMouth;
	private ImageIcon upMouth;
	private ImageIcon downMouth;
	private ImageIcon snakeImage;
	*/
	
	private int snakeXLength[] = new int[750]; 		//X coordinate
	private int snakeYLength[] = new int[750];		//Y coordinate
	
	//Movement of the snake
	private boolean right = false;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	
	private Timer timer;
	private int delay = 150;
	
	private int snakeLength = 3;
	
	int score = 0;
	
	private int[] enemyXpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] enemyYpos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private ImageIcon enemyImage;
	
	private Random random = new Random();		//random variable
	
	private int xPos = random.nextInt(34);		//Range of random var is 34 for Xcoordinate of enemy
	private int yPos = random.nextInt(23);		//Range is random var is 23 for Ycoordinate of enemy
	
	private int moves=0;

	private int pauseDir = 0;		//Variable for pause direction

	private boolean pause = false;

	int highScore = 0;

	private String map = "Obstacle-1";

	JFrame f1 = new JFrame();
	
	
	public Level2(JFrame f1)
	{	
		this.f1 = f1;
		
		addKeyListener(this);		//Adding the keylistener to the const of Level2. Passing'this' because method defined in same class
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
		
		
		
		//Borders of title image
		//Paint board and text on the board	
				CommonClass c = new CommonClass();
				c.paint(g,score,snakeLength,pause,map,left,right,up,down,snakeXLength,snakeYLength,pauseDir,false);
		
		
		//Draw obstacles of Level2
		//Middle Box
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(400, 300, 100, 100);		//(x,y,widht,height)
		
		//Upper Left Obstacle
		g.fillRect(200, 175, 100,25);
		g.fillRect(200, 175, 25, 100);
		
		//Upper Right Obstacle
		g.fillRect(600, 175, 100,25);
		g.fillRect(675, 175, 25, 100);
		
		//Bottom Left Obstacle
		g.fillRect(200, 525, 100,25);
		g.fillRect(200, 450, 25, 100);
		
		//Bottom Right Obstacle
		g.fillRect(600, 525, 100,25);
		g.fillRect(675, 450, 25, 100);
	
		
				
		checkEnemyPosition();
		enemyImage = new ImageIcon("enemy.png");
		enemyImage.paintIcon(this, g, enemyXpos[xPos], enemyYpos[yPos]);
		
		
		//Check if snake collides the enemy
		if(enemyXpos[xPos] == snakeXLength[0]  && enemyYpos[yPos] == snakeYLength[0])			//snakeXYLength[0] is head of the snake
		{			
			score++;
			
			repaint();
			
			snakeLength++;
			
			//Check if player wins 
			if(snakeLength == 530)	//574-44=530
			{			
				repaint();
				gWin();
			}
			
			//Increase speed after every enemy is killed
			if(delay>65)
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
		
		for(int i=1; i<snakeLength ;i++)		//i=1 because at [0] there is head of the snake
		{
			// if x and y position of any body part of snake is same as x and y position of head of the snake
			if(snakeXLength[i] == snakeXLength[0] && snakeYLength[i] == snakeYLength[0])		//If snake collides with itself
			{
				
				gOver();
				
				
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
		
		
		//g.dispose();	//Clear the frame for new components
		
	}
	
	void checkEnemyPosition()
	{
		//if the enemy is allocated at a position on obstacle then regenerate enemy position until it is not on the obstacle positoin.
				//For center box obstacle
				while((enemyXpos[xPos]>375 && enemyXpos[xPos]<500) && (enemyYpos[yPos]>275 && enemyYpos[yPos]<400))
				{
					xPos = random.nextInt(34);		
					yPos = random.nextInt(23);		
				}
				//Condition for border of top left obstacle
				while(((enemyXpos[xPos]>175 && enemyXpos[xPos]<300) && (enemyYpos[yPos]>150 && enemyYpos[yPos]<200)) ||
				   ((enemyXpos[xPos]>175 && enemyXpos[xPos]<225) && (enemyYpos[yPos]>150 && enemyYpos[yPos]<275)))
				{
					xPos = random.nextInt(34);		
					yPos = random.nextInt(23);	
				}
				
				//Condition for border of top right obstacle
				while(((enemyXpos[xPos]>575 && enemyXpos[xPos]<700) && (enemyYpos[yPos]>150 && enemyYpos[yPos]<200)) ||
				   ((enemyXpos[xPos]>650 && enemyXpos[xPos]<700) && (enemyYpos[yPos]>150 && enemyYpos[yPos]<275)))
				{
					xPos = random.nextInt(34);		
					yPos = random.nextInt(23);	
				}
				
				//Condition for border of bottom left obstacle
				while(((enemyXpos[xPos]>175 && enemyXpos[xPos]<300) && (enemyYpos[yPos]>500 && enemyYpos[yPos]<550)) || 
				   ((enemyXpos[xPos]>175 && enemyXpos[xPos]<225) && (enemyYpos[yPos]>425 && enemyYpos[yPos]<550) ))
				{
					xPos = random.nextInt(34);		
					yPos = random.nextInt(23);	
				}
				 
				//Condition for border of bottom right obstacle
				while(((enemyXpos[xPos]>575 && enemyXpos[xPos]<700) && (enemyYpos[yPos]>500 && enemyYpos[yPos]<550)) ||
				   ((enemyXpos[xPos]>650 && enemyXpos[xPos]<700) && (enemyYpos[yPos]>425 && enemyYpos[yPos]<550)))
				{
					xPos = random.nextInt(34);		
					yPos = random.nextInt(23);	
				}
	}
	
	
	
	public void gOver()
	{
		//java.awt.Toolkit.getDefaultToolkit().beep();		//Creates a windows exclamation sound
		
		System.out.println("Game Over");
	
		//Stop the snake
		right=false;
		left=false;
		up=false;
		down=false;
		
		
		if(highScore < score)
			highScore = score;
		
		//new UpdateHighScore(highScore,2);
		
		//new MainMenu("clear");		//To clear the previous JFrame of the game
		
		
		GameOverMenu g1 = new GameOverMenu(1,"level2");
		g1.GameOver(score,highScore,2);
		
		//setVisible(false);
		f1.dispose();
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
		
		//new UpdateHighScore(highScore,2);
		
		//new MainMenu("clear");		//To clear the previous JFrame of the game
		
		
		GameWinMenu g1 = new GameWinMenu(1,"level2");
		g1.GameWin(score,highScore,2);
		
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
				snakeYLength[i+1] = snakeYLength[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
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
					snakeXLength[i] = snakeXLength[i]-25;		//Move 25 pixels in right
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
					snakeYLength[i] = snakeYLength[i]-25;		//Move 25 pixels in right
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
					snakeYLength[i] = snakeYLength[i]+25;		//Move 25 pixels in right
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
		
		//Check if it collides with obstacle
		if(right || left || up || down)
		{
			for(int i=snakeLength; i >= 0 ;i--)
			{
				//Condition for border of box
				if((snakeXLength[i]>375 && snakeXLength[i]<500) && (snakeYLength[i]>275 && snakeYLength[i]<400))
				{
					gOver();
				}
				
				//Condition for border of top left obstacle
				if(((snakeXLength[i]>175 && snakeXLength[i]<300) && (snakeYLength[i]>150 && snakeYLength[i]<200)) ||
				   ((snakeXLength[i]>175 && snakeXLength[i]<225) && (snakeYLength[i]>150 && snakeYLength[i]<275)))
				{
					gOver();
				}
				
				//Condition for border of top right obstacle
				if(((snakeXLength[i]>575 && snakeXLength[i]<700) && (snakeYLength[i]>150 && snakeYLength[i]<200)) ||
				   ((snakeXLength[i]>650 && snakeXLength[i]<700) && (snakeYLength[i]>150 && snakeYLength[i]<275)))
				{
					gOver();
				}
				
				//Condition for border of bottom left obstacle
				if(((snakeXLength[i]>175 && snakeXLength[i]<300) && (snakeYLength[i]>500 && snakeYLength[i]<550)) || 
				   ((snakeXLength[i]>175 && snakeXLength[i]<225) && (snakeYLength[i]>425 && snakeYLength[i]<550) ))
				{
					gOver();
				}
				
				//Condition for border of bottom right obstacle
				if(((snakeXLength[i]>575 && snakeXLength[i]<700) && (snakeYLength[i]>500 && snakeYLength[i]<550)) ||
				   ((snakeXLength[i]>650 && snakeXLength[i]<700) && (snakeYLength[i]>425 && snakeYLength[i]<550)))
				{
					gOver();
				}
			}
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
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)			//if left arrow is pressed (moves++)
		{
			System.out.println("LEFT arrow key is pressed");
			
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
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)			//if up arrow is pressed (moves++)
		{
			System.out.println("UP arrow key is pressed");
			
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
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)			//if down arrow is pressed (moves++)
		{
			System.out.println("DOWN arrow key is pressed");
			
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
				return;
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
			
			PauseMenu ob = new PauseMenu(1,"level2");	
			ob.PauseMenuF(f1);
			
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

