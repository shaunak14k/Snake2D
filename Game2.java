import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game2 extends JPanel implements KeyListener,ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean play = true;
	
	private int timerCount = 0;
	
	//Images for the snake
	private ImageIcon rightmouth1;		
	private ImageIcon leftmouth1;
	private ImageIcon upmouth1;
	private ImageIcon downmouth1;
	
	
	private ImageIcon rightmouth2;		
	private ImageIcon leftmouth2;
	private ImageIcon upmouth2;
	private ImageIcon downmouth2;
	
	private ImageIcon snakeimage11;
	private ImageIcon snakeimage22;
	
	private int snakeXLength1[] = new int[750]; 		//X coordinate
	private int snakeYLength1[] = new int[750];		//Y coordinate
	
	private int snakeXLength2[] = new int[750]; 		//X coordinate
	private int snakeYLength2[] = new int[750];		//Y coordinate
	
	//Movement of the snake
	private boolean right1 = false;
	private boolean left1 = false;
	private boolean up1 = false;
	private boolean down1 = false;
	
	private boolean right2 = false;
	private boolean left2 = false;
	private boolean up2 = false;
	private boolean down2 = false;
	
	private Timer timer;
	
	private int delay = 120;
	
	private int snakeLength = 10;
	
	int score = 0;
	
	private int enemyXpos = 425;
	private int enemyYpos =350;
	
	//private int[] enemyXpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	//private int[] enemyYpos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private Random random = new Random();		//random variable
	
	//private int xPos;
	//private int yPos;
	
	private ImageIcon enemyImage;
	
	private int moves1=0;
	private int moves2=0;

	private int pauseDir1 = 0;		//Variable for pause direction
	private int pauseDir2 = 0;
	
	int highScore = 0;
	
	private boolean pause = false;


	int p1score = 0;
	int p2score = 0;
	
	int x = random.nextInt(100);

	private String barricades ="on";

	private String map = "F-F-F";
	
	JFrame f1 = new JFrame();
	
	public Game2(JFrame f1)
	{	
		this.f1 = f1;
		
		addKeyListener(this);		//Adding the keylistener to the const of Game2. Passing'this' because method defined in same class
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		
		timer = new Timer(delay, this);		//Timer(speed, object on which timer will work)
		timer.start();
		
		repaint();
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
	
	public void paint(Graphics g)		//We can draw things on JPanel using Graphics class. in this method we draw the snake as it moves1
	{
		
		if(!play)
		{
			g.dispose();
			return;
		}
		
		//******************************************************************************************************************************
		//Borders of title image
		//Paint board and text on the board	
				CommonClass c = new CommonClass();
				c.paint1(g,p1score,p2score,pause,map);
				
				if(barricades=="on")
				{
					//draw barricades for enemy
					g.setColor(Color.LIGHT_GRAY);
					
					g.fillRect(400, 325, 75, 25);	//UP
					g.fillRect(400, 325, 25, 75);	//LEFT
					g.fillRect(400, 375, 75, 25);	//DOWN
					g.fillRect(450, 325, 25, 75);	//RIGHT
				}
						
		//*******************************************************************************************************************************
		
		//Game is not started
		if(moves1 == 0)		
		{
			snakeXLength1[0] = 300;
			snakeYLength1[0] = 100;
			
			snakeXLength1[1] = 275;
			snakeYLength1[1] = 100;
			
			snakeXLength1[2] = 250;
			snakeYLength1[2] = 100;
			
			snakeXLength1[3] = 225;
			snakeYLength1[3] = 100;
			
			snakeXLength1[4] = 200;
			snakeYLength1[4] = 100;
			
			snakeXLength1[5] = 175;
			snakeYLength1[5] = 100;
			
			snakeXLength1[6] = 150;
			snakeYLength1[6] = 100;
			
			snakeXLength1[7] = 125;
			snakeYLength1[7] = 100;
			
			snakeXLength1[8] = 100;
			snakeYLength1[8] = 100;
			
			snakeXLength1[9] = 75;
			snakeYLength1[9] = 100;
		}
		
		
		
		
		
		//If game is not paused print the right1Head
		if(pauseDir1 ==0)
		{
			rightmouth1 = new ImageIcon("rightmouth1.png");
			rightmouth1.paintIcon(this, g, snakeXLength1[0], snakeYLength1[0]);
		}
		else
		{
			//Check the direction of the head and print accordingly
			switch(pauseDir1)
			{
				case 1:	rightmouth1 = new ImageIcon("rightmouth1.png");
						rightmouth1.paintIcon(this, g, snakeXLength1[0], snakeYLength1[0]);
						break;
						
				case 2: leftmouth1 = new ImageIcon("leftmouth1.png");
						leftmouth1.paintIcon(this, g, snakeXLength1[0], snakeYLength1[0]);
						break;
					
				case 3:	upmouth1 = new ImageIcon("upmouth1.png");
						upmouth1.paintIcon(this, g, snakeXLength1[0], snakeYLength1[0]);	
						break;
					
				case 4:	downmouth1 = new ImageIcon("downmouth1.png");
						downmouth1.paintIcon(this, g, snakeXLength1[0], snakeYLength1[0]);
						break;
			}
		}
		
		//Set images for every movement
		for(int i=0; i < snakeLength; i++)
		{
			//i==0 is condition for if head is in the picture so we change it accordingly
			if(i==0 && right1)
			{
				rightmouth1 = new ImageIcon("rightmouth1.png");
				rightmouth1.paintIcon(this, g, snakeXLength1[i], snakeYLength1[i]);
			}
			if(i==0 && left1)
			{
				leftmouth1 = new ImageIcon("leftmouth1.png");
				leftmouth1.paintIcon(this, g, snakeXLength1[i], snakeYLength1[i]);
			}
			if(i==0 && down1)
			{
				downmouth1 = new ImageIcon("downmouth1.png");
				downmouth1.paintIcon(this, g, snakeXLength1[i], snakeYLength1[i]);
			}
			if(i==0 && up1)
			{
				upmouth1 = new ImageIcon("upmouth1.png");
				upmouth1.paintIcon(this, g, snakeXLength1[i], snakeYLength1[i]);
			}
			//i!=0 is when head is not in the picture. In this case we print the body
			
			
			if(i != 0)
			{
				snakeimage11 = new ImageIcon("snakeimage11.png");
				snakeimage11.paintIcon(this, g, snakeXLength1[i], snakeYLength1[i]);
			}
		}
		
		
		//Check if snake collides the enemy
		//if(barricades == "off") {
		if(enemyXpos == snakeXLength1[0]  && enemyYpos == snakeYLength1[0])			//snakeXYLength[0] is head of the snake
		{			
			//score++;
			if(enemyXpos == snakeXLength2[0]  && enemyYpos == snakeYLength2[0])
			{
				//timerCount=0;
				
				//barricades="on";
				
				gWin("No One");
				
				return;
				//moves1=0;
				//moves2=0;
				
				//repaint();
		
				//gWin("No One");		
			
				//g.dispose();
			}
			else
			{
				//repaint();
				
				gWin("GREEN");
					//g.dispose();
			}
		}
		//Check if snake collides the enemy
				if(enemyXpos == snakeXLength2[0]  && enemyYpos == snakeYLength2[0])			//snakeXYLength[0] is head of the snake
				{			
					//score++;
					if(enemyXpos == snakeXLength1[0]  && enemyYpos == snakeYLength1[0])
					{
						//timerCount=0;
						
						//barricades="on";
						
						gWin("No One");
						return;
						
						//repaint();
				
						//gWin("No One");		
					
						//g.dispose();
					}
					else
					{
						//repaint();
						
						gWin("RED");
						//g.dispose();
					}
				}
		//}
		
		///*************************************************************************************************************************
		
		/*if((enemyXpos == snakeXLength1[0]  && enemyYpos == snakeYLength1[0]) || (enemyXpos == snakeXLength2[0]  && enemyYpos == snakeYLength2[0]))
		{
			moves1=0;
			moves2=0;
		}*/
		
		
		
	    // scheduling the timer instance 
		
		//ENEMY SHOULD BE GENERATED AFTER RANDOM AMOUNT OF TIME
		if((timerCount >= x)) 
		{
			barricades = "off";
			//repaint();
		}
		if(barricades == "on") 
		{
			//IF ANY SNAKE COLLIDES WITH THE OBSTACLE
			
			//BOTH
			if((((snakeXLength1[0]>375 && snakeXLength1[0]<475) && (snakeYLength1[0]>300 && snakeYLength1[0]<350))  ||
			    ((snakeXLength1[0]>375 && snakeXLength1[0]<425) && (snakeYLength1[0]>300 && snakeYLength1[0]<400)) ||
		   	    ((snakeXLength1[0]>375 && snakeXLength1[0]<475) && (snakeYLength1[0]>350 && snakeYLength1[0]<400)) ||
			    ((snakeXLength1[0]>425 && snakeXLength1[0]<475) && (snakeYLength1[0]>300 && snakeYLength1[0]<400)))
																&&
			   (((snakeXLength2[0]>375 && snakeXLength2[0]<475) && (snakeYLength2[0]>300 && snakeYLength2[0]<350))  ||
				((snakeXLength2[0]>375 && snakeXLength2[0]<425) && (snakeYLength2[0]>300 && snakeYLength2[0]<400)) ||
				((snakeXLength2[0]>375 && snakeXLength2[0]<475) && (snakeYLength2[0]>350 && snakeYLength2[0]<400)) ||
				((snakeXLength2[0]>425 && snakeXLength2[0]<475) && (snakeYLength2[0]>300 && snakeYLength2[0]<400))))
					{
					
						gWin("No One ");
						//repaint();
					}
				//Condition for player1 box
			else if(((snakeXLength1[0]>375 && snakeXLength1[0]<475) && (snakeYLength1[0]>300 && snakeYLength1[0]<350))  ||
				   ((snakeXLength1[0]>375 && snakeXLength1[0]<425) && (snakeYLength1[0]>300 && snakeYLength1[0]<400)) ||
				   ((snakeXLength1[0]>375 && snakeXLength1[0]<475) && (snakeYLength1[0]>350 && snakeYLength1[0]<400)) ||
				   ((snakeXLength1[0]>425 && snakeXLength1[0]<475) && (snakeYLength1[0]>300 && snakeYLength1[0]<400)))
				{

					gWin("RED");
					//repaint();
				}
				
				//Condition for player2 box
			else if(((snakeXLength2[0]>375 && snakeXLength2[0]<475) && (snakeYLength2[0]>300 && snakeYLength2[0]<350))  ||
				   ((snakeXLength2[0]>375 && snakeXLength2[0]<425) && (snakeYLength2[0]>300 && snakeYLength2[0]<400)) ||
				   ((snakeXLength2[0]>375 && snakeXLength2[0]<475) && (snakeYLength2[0]>350 && snakeYLength2[0]<400)) ||
				   ((snakeXLength2[0]>425 && snakeXLength2[0]<475) && (snakeYLength2[0]>300 && snakeYLength2[0]<400)))
				{
					gWin("GREEN");
					//repaint();
				}
			else
			{}
				
				
						
			

		}
		

	
		//PRINT ENEMY
		enemyImage = new ImageIcon("oneup.png");
		enemyImage.paintIcon(this, g, enemyXpos, enemyYpos);
	
         
		
		
		//g.dispose();	//Clear the frame for new components
				
		//************************************************************************************************************************************
		//Game is not started
		if(moves2 == 0)		
		{
			snakeXLength2[0] = 550;
			snakeYLength2[0] = 600;
			
			snakeXLength2[1] = 575;
			snakeYLength2[1] = 600;
			
			snakeXLength2[2] = 600;
			snakeYLength2[2] = 600;
			
			snakeXLength2[3] = 625;
			snakeYLength2[3] = 600;
			
			snakeXLength2[4] = 650;
			snakeYLength2[4] = 600;
			
			snakeXLength2[5] = 675;
			snakeYLength2[5] = 600;
			
			snakeXLength2[6] = 700;
			snakeYLength2[6] = 600;
			
			snakeXLength2[7] = 725;
			snakeYLength2[7] = 600;
			
			snakeXLength2[8] = 750;
			snakeYLength2[8] = 600;
			
			snakeXLength2[9] = 775;
			snakeYLength2[9] = 600;
		}
		
		
		
		//If game is not paused print the right1Head
		if(pauseDir2 == 0)
		{
			leftmouth2 = new ImageIcon("leftmouth2.png");
			leftmouth2.paintIcon(this, g, snakeXLength2[0], snakeYLength2[0]);
		}
		else
		{
			//Check the direction of the head and print accordingly
			switch(pauseDir1)
			{
				case 1:	rightmouth2 = new ImageIcon("rightmouth2.png");
						rightmouth2.paintIcon(this, g, snakeXLength2[0], snakeYLength2[0]);
						break;
						
				case 2: leftmouth2 = new ImageIcon("leftmouth2.png");
						leftmouth2.paintIcon(this, g, snakeXLength2[0], snakeYLength2[0]);
						break;
					
				case 3:	upmouth2 = new ImageIcon("upmouth2.png");
						upmouth2.paintIcon(this, g, snakeXLength2[0], snakeYLength2[0]);	
						break;
					
				case 4:	downmouth2 = new ImageIcon("downmouth2.png");
						downmouth2.paintIcon(this, g, snakeXLength2[0], snakeYLength2[0]);
						break;
			}
		}
		
		//Set images for every movement
		for(int i=0; i < snakeLength; i++)
		{
			//i==0 is condition for if head is in the picture so we change it accordingly
			if(i==0 && right2)
			{
				rightmouth2 = new ImageIcon("rightmouth2.png");
				rightmouth2.paintIcon(this, g, snakeXLength2[i], snakeYLength2[i]);
			}
			if(i==0 && left2)
			{
				leftmouth2 = new ImageIcon("leftmouth2.png");
				leftmouth2.paintIcon(this, g, snakeXLength2[i], snakeYLength2[i]);
			}
			if(i==0 && down2)
			{
				downmouth2 = new ImageIcon("downmouth2.png");
				downmouth2.paintIcon(this, g, snakeXLength2[i], snakeYLength2[i]);
			}
			if(i==0 && up2)
			{
				upmouth2 = new ImageIcon("upmouth2.png");
				upmouth2.paintIcon(this, g, snakeXLength2[i], snakeYLength2[i]);
			}
			//i!=0 is when head is not in the picture. In this case we print the body
			
			
			if(i != 0)
			{
				snakeimage22 = new ImageIcon("snakeimage22.png");
				snakeimage22.paintIcon(this, g, snakeXLength2[i], snakeYLength2[i]);
			}
		}
		
		//Check if snake collides with itself
		for(int i=1; i<snakeLength ;i++)
		{	
			if((snakeXLength1[0] == snakeXLength1[i] && snakeYLength1[0] == snakeYLength1[i]) && (snakeXLength2[0] == snakeXLength2[i] && snakeYLength2[0] == snakeYLength2[i]))
			{
				repaint();
				gWin("No One ");
			}
			else if(snakeXLength1[0] == snakeXLength1[i] && snakeYLength1[0] == snakeYLength1[i])
			{
				repaint();
				gWin("RED");
			}
			else if(snakeXLength2[0] == snakeXLength2[i] && snakeYLength2[0] == snakeYLength2[i])
			{
				repaint();
				gWin("GREEN");
			}
		}
		
				
				
				
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
		//g.dispose();	//Clear the frame for new components
		timerCount++;
		System.out.println("\n TIMER COUNT = "+timerCount);
		//repaint();
	}

	
	
	
	
	void gWin(String winner)
	{
		//new GameWinMusic();
		
		
		//Stop the snake
		right1=false;
		left1=false;
		up1=false;
		down1=false;
		
		right2=false;
		left2=false;
		up2=false;
		down2=false;
		
		moves1=0;
		moves2=0;
		
		repaint();
		
		//g.dispose();
		
		//if(highScore < score)
			//highScore = score;
		
		//new up1dateHighScore(highScore,1);
		
		//new MainMenu("clear");		//To clear the previous JFrame of the game
		
		
		TwoPlayerWin g1 = new TwoPlayerWin(2,"game2");
		g1.GameWin(winner);
		
		f1.dispose();
		
	}
	
	
	
	
//**********************************************************************************************************************************
	
	@Override
	public void actionPerformed(ActionEvent e) 		//This method will be called after timer.start()
	{
		// We also want to move the body of the snake along with its head
		// So before moving head we assign the position of the head to the position of the body part(circle) just behind the head
		//Here we move the snake 
		if(right1)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeYLength1[i+1] = snakeYLength1[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeXLength1[i] = snakeXLength1[i]+25;		//Move 25 pixels in right1
				}
				else
				{
					snakeXLength1[i] = snakeXLength1[i-1];		//Move 
				}
				if(snakeXLength1[i] > 850)		//if snake touches the border
				{
					snakeXLength1[i] = 25;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(left1)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeYLength1[i+1] = snakeYLength1[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeXLength1[i] = snakeXLength1[i]-25;		//Move 25 pixels in right1
				}
				else
				{
					snakeXLength1[i] = snakeXLength1[i-1];		//Move 
				}
				if(snakeXLength1[i] < 25)		//if snake touches the border
				{
					snakeXLength1[i] = 850;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(up1)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeXLength1[i+1] = snakeXLength1[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeYLength1[i] = snakeYLength1[i]-25;		//Move 25 pixels in right1
				}
				else
				{
					snakeYLength1[i] = snakeYLength1[i-1];		//Move 
				}
				if(snakeYLength1[i] < 75)		//if snake touches the border
				{
					snakeYLength1[i] = 625;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(down1)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeXLength1[i+1] = snakeXLength1[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeYLength1[i] = snakeYLength1[i]+25;		//Move 25 pixels in right1
				}
				else
				{
					snakeYLength1[i] = snakeYLength1[i-1];		//Move 
				}
				if(snakeYLength1[i] > 625)		//if snake touches the border
				{
					snakeYLength1[i] = 75;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		
		
		//***************************************************************************************************
		//FOR PLAYER-2
		if(right2)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeYLength2[i+1] = snakeYLength2[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeXLength2[i] = snakeXLength2[i]+25;		//Move 25 pixels in right1
				}
				else
				{
					snakeXLength2[i] = snakeXLength2[i-1];		//Move 
				}
				if(snakeXLength2[i] > 850)		//if snake touches the border
				{
					snakeXLength2[i] = 25;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(left2)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeYLength2[i+1] = snakeYLength2[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeXLength2[i] = snakeXLength2[i]-25;		//Move 25 pixels in right1
				}
				else
				{
					snakeXLength2[i] = snakeXLength2[i-1];		//Move 
				}
				if(snakeXLength2[i] < 25)		//if snake touches the border
				{
					snakeXLength2[i] = 850;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(up2)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeXLength2[i+1] = snakeXLength2[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeYLength2[i] = snakeYLength2[i]-25;		//Move 25 pixels in right1
				}
				else
				{
					snakeYLength2[i] = snakeYLength2[i-1];		//Move 
				}
				if(snakeYLength2[i] < 75)		//if snake touches the border
				{
					snakeYLength2[i] = 625;		//then replace the snake to the starting position so it comes out from the opposite border
				}
			}
			repaint();	//Refresh the screen
		}
		if(down2)
		{
			for(int i=snakeLength; i >= 0; i--)
			{
				//Last to first
				snakeXLength2[i+1] = snakeXLength2[i];		// So before moving head we assign the position of the head to the body part(circle) just behind the head
			}
			for(int i=snakeLength; i >= 0 ;i--)
			{
				if(i == 0)		//If this is head
				{
					snakeYLength2[i] = snakeYLength2[i]+25;		//Move 25 pixels in right1
				}
				else
				{
					snakeYLength2[i] = snakeYLength2[i-1];		//Move 
				}
				if(snakeYLength2[i] > 625)		//if snake touches the border
				{
					snakeYLength2[i] = 75;		//then replace the snake to the starting position so it comes out from the opposite border
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
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)			//if right1 arrow is pressed (moves1++)
		{
			System.out.println("right1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right2==false && left2==false && up2==false && down2==false && moves2>0)		//if game is stopped
			{
				return;
			}
			
			//Initially when snake is not moving, it cannot go in opposite(left1) direction.
			if(moves2 == 0)
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(up2 || down2)
			{
				if(snakeYLength2[0] == snakeYLength2[1])
					return;
			}
			//*************************************************************************
			
			moves2++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!left2)
			{
				right2 = true;
			}
			else
			{
				right2 = false;
				left2 = true;
			}
			up2 = false;
			down2 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)			//if left1 arrow is pressed (moves1++)
		{
			System.out.println("left1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right2==false && left2==false && up2==false && down2==false && moves2>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(up2 || down2)
			{
				if(snakeYLength2[0] == snakeYLength2[1])
					return;
			}
			//*************************************************************************
			
			moves2++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!right2)
			{
				left2 = true;
			}
			else
			{
				left2 = false;
				right2 = true;
			}
			up2 = false;
			down2 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)			//if up1 arrow is pressed (moves1++)
		{
			System.out.println("up1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right2==false && left2==false && up2==false && down2==false && moves2>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(left2 || right2)
			{
				if(snakeXLength2[0] == snakeXLength2[1])
					return;
			}
			//*************************************************************************
			
			moves2++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!down2)
			{
				up2 = true;
			}
			else
			{
				up2 = false;
				down2 = true;
			}
			left2 = false;
			right2 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)			//if down1 arrow is pressed (moves1++)
		{
			System.out.println("down1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right2==false && left2==false && up2==false && down2==false && moves2>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(left2 || right2)
			{
				if(snakeXLength2[0] == snakeXLength2[1])
					return;
			}
			//*************************************************************************
			
			moves2++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!up2)
			{
				down2 = true;
			}
			else
			{
				down2 = false;
				up2 = true;
			}
			left2 = false;
			right2 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		
//		/*************************************************************************************************************************************
		//FOR PLAYER-2
		if(e.getKeyCode() == KeyEvent.VK_D)			//if right1 arrow is pressed (moves1++)
		{
			System.out.println("right1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right1==false && left1==false && up1==false && down1==false && moves1>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(up1 || down1)
			{
				if(snakeYLength1[0] == snakeYLength1[1])
					return;
			}
			//*************************************************************************
			
			moves1++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!left1)
			{
				right1 = true;
			}
			else
			{
				right1 = false;
				left1 = true;
			}
			up1 = false;
			down1 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_A)			//if left1 arrow is pressed (moves1++)
		{
			System.out.println("left1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right1==false && left1==false && up1==false && down1==false && moves1>0)		//if game is stopped
			{
				return;
			}
			
			//Initially when snake is not moving, it cannot go in opposite(left1) direction.
			if(moves1 == 0)
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(up1 || down1)
			{
				if(snakeYLength1[0] == snakeYLength1[1])
					return;
			}
			//*************************************************************************
			
			moves1++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!right1)
			{
				left1 = true;
			}
			else
			{
				left1 = false;
				right1 = true;
			}
			up1 = false;
			down1 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_W)			//if up1 arrow is pressed (moves1++)
		{
			System.out.println("up1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right1==false && left1==false && up1==false && down1==false && moves1>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(left1 || right1)
			{
				if(snakeXLength1[0] == snakeXLength1[1])
					return;
			}
			//*************************************************************************
			
			moves1++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!down1)
			{
				up1 = true;
			}
			else
			{
				up1 = false;
				down1 = true;
			}
			left1 = false;
			right1 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		if(e.getKeyCode() == KeyEvent.VK_S)			//if down1 arrow is pressed (moves1++)
		{
			System.out.println("down1 arrow key is pressed");
			
			//Snake should not move if game is stopped
			if(right1==false && left1==false && up1==false && down1==false && moves1>0)		//if game is stopped
			{
				return;
			}
			
			//*********************************************************************
			//FIX THE TURNING BUG
			if(left1 || right1)
			{
				if(snakeXLength1[0] == snakeXLength1[1])
					return;
			}
			//*************************************************************************
			
			moves1++;
			
			// The snake cannot turn in opposite direction as this will result with collision to its own body
			// So if we press a key which will result in the opposite direction movement , snake should not listen aand should continue moving in the same direction
			if(!up1)
			{
				down1 = true;
			}
			else
			{
				down1 = false;
				up1 = true;
			}
			left1 = false;
			right1 = false;	
			
			timerCount--;
			
			repaint();
			
		}
		
		
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			//To restart the game using keyboard inputs
			//Nothing should happen if the game is still playing hence we put a condition
			/*if(right1==false && left1==false && up1==false && down1==false && !pause)		//if game is stopped & NOT paused (Game cannot be restarted while being paused)
			{
				moves1 = 0;
				score = 0;
				snakeLength = 3;
			}
			*/
			
			
			//If the game is paused then resume the game
			if(pause)		 
			{
				//check in what direction is the snake to keep it in the same direction
				switch(pauseDir1)
				{
					case 1:	right1 = true;
							break;
							 
					case 2: left1 = true;
							break;
						
					case 3:	up1 = true;
							break;
						
					case 4:	down1 = true;
							break;
				}
				
				//For player-2
				switch(pauseDir2)
				{
					case 1:	right2 = true;
							break;
							 
					case 2: left2 = true;
							break;
						
					case 3:	up2 = true;
							break;
						
					case 4:	down2 = true;
							break;
				}
				//reinitializing the variables for pause
				pause=false;
				pauseDir1=0;
				pauseDir2=0;
			}
			
			//repaint();
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			
			System.out.println("\n Game is paused");
			
			//If game is not started nothing should happen
			if(moves1 == 0 && moves2 == 0)
			{
				return;
			}
			
			/*//If game is stopped or game is over then quit the game
			if(right1 == false && left1 == false && up1 == false && down1 == false)
			{
				System.exit(0);
			}*/
			
			//Check in what direction the snake is and assign value to pauseDir1 according to the direction
			if(right1 == true)
				pauseDir1 = 1;
			
			else if(left1 == true)
				pauseDir1 = 2;
			
			else if(up1 == true)
				pauseDir1 = 3;
			
			else if(down1 == true)
				pauseDir1 = 4;
			
			//For player 2
			if(right2 == true)
				pauseDir2 = 1;
			
			else if(left2 == true)
				pauseDir2 = 2;
			
			else if(up2 == true)
				pauseDir2 = 3;
			
			else if(down2 == true)
				pauseDir2 = 4;
			
			//Stop the movement of the snake ie. pause the game
			up1=false;
			down1=false;
			right1=false;
			left1=false;
			
			up2=false;
			down2=false;
			right2=false;
			left2=false;
			
			pause = true;
			
			f1.dispose();
			
			PauseMenu ob = new PauseMenu(2,"game2");	
			ob.PauseMenuF(f1);			
			
			
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

