import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CommonClass extends JPanel implements KeyListener,ActionListener
{
	private ImageIcon titleImage;
	private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	private ImageIcon downMouth;
	private ImageIcon upMouth;
	private ImageIcon snakeImage;

	boolean right,left,up,down;
	private boolean pause;
	private int pauseDir;
	private int moves;
	private int[] snakeXLength;
	private int[] snakeYLength;
	private int snakeLength;

	public CommonClass(boolean right,boolean left,boolean up,boolean down,boolean pause,int moves,int pauseDir,int snakeXLength[],int snakeYLength[],int snakeLength)
	{
		this.right=right;
		this.up=up;
		this.left=left;
		this.down=down;
		this.moves=moves;
		this.pause=pause;
		this.pauseDir=pauseDir;
		this.snakeXLength=snakeXLength;
		this.snakeYLength=snakeYLength;
		this.snakeLength=snakeLength;
		
		addKeyListener(this);
	}
	
	public CommonClass()
	{}
	
	//FOR One Player
	public void paint(Graphics g,int score,int snakeLength,boolean pause,String level, boolean left, boolean right, boolean up, boolean down, int snakeXLength[],int snakeYLength[],int pauseDir)
	{
//		//ImageIcon grass = new ImageIcon("wall4.jpg");
		//grass.paintIcon(this, g, 0, 0);
		
		//Borders of title image
		g.setColor(Color.white);
		g.drawRect(24, 10, 850, 55); 
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//Border of gameplay
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577); 
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 576);
		
		//Draw the pause option
		g.setColor(Color.black);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Press ESC to pause the game", 50, 42);
		
		//Draw the scores
		g.setColor(Color.black);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Score   : "+score, 780, 30);
		
		//Draw gameType  and level
		g.drawString("Single Player", 630, 30);
		g.setColor(Color.white);
		g.drawString(level,650,50);
		
		//Draw the length
		g.setColor(Color.black);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Length : "+snakeLength, 780, 50);
				
		if(pause) 
		{	
			g.setColor(Color.red);
			
			
			//To print on the center : 
			g.setFont(new Font("Cooper black",Font.PLAIN, 25));
			g.drawString("Press SPACE to resume", 320, 360);
			
			
			//To print on the top left corner : 
			//g.setFont(new Font("arial",Font.BOLD, 14));
			//g.drawString("Press Space to resume", 100, 42);
		}
		
		//If game is not paused print the rightHead
				if(pauseDir ==0)
				{
					rightMouth = new ImageIcon("rightmouth.png");
					rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
				}
				else
				{
					//Check the direction of the head and print accordingly
					switch(pauseDir)
					{
						case 1:	rightMouth = new ImageIcon("rightmouth.png");
								rightMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
								break;
								
						case 2: leftMouth = new ImageIcon("leftmouth.png");
								leftMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
								break;
							
						case 3:	upMouth = new ImageIcon("upmouth.png");
								upMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);	
								break;
							
						case 4:	downMouth = new ImageIcon("downmouth.png");
								downMouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
								break;
					}
				}
				
				//Set images for every movement
				for(int i=0; i < snakeLength; i++)
				{
					//i==0 is condition for if head is in the picture so we change it accordingly
					if(i==0 && right)
					{
						rightMouth = new ImageIcon("rightmouth.png");
						rightMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
					}
					if(i==0 && left)
					{
						leftMouth = new ImageIcon("leftmouth.png");
						leftMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
					}
					if(i==0 && down)
					{
						downMouth = new ImageIcon("downmouth.png");
						downMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
					}
					if(i==0 && up)
					{
						upMouth = new ImageIcon("upmouth.png");
						upMouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
					}
					
					
					//i!=0 is when head is not in the picture. In this case we print the body
					
					
					
					Random random = new Random();		//random variable
					int randomInteger = random.nextInt(5);
					
					if(i != 0)
					{
						switch(randomInteger)
						{
							case 0:	snakeImage = new ImageIcon("snakeimage.png");
									snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
									break;
									
							case 1:	snakeImage = new ImageIcon("snakeimage1.png");
									snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
									break;
							
							case 2:	snakeImage = new ImageIcon("snakeimage2.png");
									snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
									break;
							
							case 3:	snakeImage = new ImageIcon("snakeimage3.png");
									snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
									break;
							
							case 4:	snakeImage = new ImageIcon("snakeimage4.png");
									snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
									break;
							
							default:	snakeImage = new ImageIcon("snakeimage2.png");
										snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
										break;
						}
						
						/*
						if(right)
						{
							System.out.println("HEYYYYYYYYY");
							snakeImage = new ImageIcon("snaketailRight.png");
							snakeImage.paintIcon(this, g, snakeXLength[i+1], snakeYLength[i+1]);
						}
						if(left)
						{
							System.out.println("HEYYYYYYYYY");
							snakeImage = new ImageIcon("snaketailLeft.png");
							snakeImage.paintIcon(this, g, snakeXLength[i+1], snakeYLength[i+1]);
						}
						if(up)
						{
							System.out.println("HEYYYYYYYYY");
							snakeImage = new ImageIcon("snaketailUp.png");
							snakeImage.paintIcon(this, g, snakeXLength[i+1], snakeYLength[i+1]);
						}
						if(down)
						{
							System.out.println("HEYYYYYYYYY");
							snakeImage = new ImageIcon("snaketailDown.png");
							snakeImage.paintIcon(this, g, snakeXLength[i+1], snakeYLength[i+1]);
						}
						*/
						
					}
				}
				
		
		repaint();
	}	
	
	//FOR Two PLAYERS
	public void paint1(Graphics g,int p1score, int p2score, boolean pause, String level)
	{
		
		
		
		g.setColor(Color.white);
		g.drawRect(24, 10, 850, 55); 
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//Border of Game2
		g.drawRect(24, 74, 851, 577); 
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 576);
		
		//Text to Resume
		if(pause) 
		{	
			g.setColor(Color.red);
			
			
			//To print on the center : 
			g.setFont(new Font("Cooper black",Font.PLAIN, 25));
			g.drawString("Press SPACE to resume", 320, 360);
			
		
			//To print on the top left1 corner : 
			//g.setFont(new Font("arial",Font.BOLD, 14));
			//g.drawString("Press Space to resume", 100, 42);
		}
		
		//Draw the pause option
		g.setColor(Color.black);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Press ESC to pause the game", 50, 42);
		
		//Draw the scores
		g.setColor(Color.black);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Green   : "+p1score, 770, 30);
		
		//Draw gameType and level
		g.drawString("Two Players", 630, 30);
		g.setColor(Color.white);
		g.drawString(level,650,50);
		
		//Draw the length
		g.setColor(Color.black);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Red : "+p2score, 770, 50);
	}

	

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}