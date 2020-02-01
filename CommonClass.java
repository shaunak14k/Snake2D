import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CommonClass extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon titleImage;
	private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	private ImageIcon downMouth;
	private ImageIcon upMouth;
	private ImageIcon snakeImage;

	boolean right,left,up,down;

	
	
	public CommonClass()
	{}
	
	//FOR One Player
	public void paint(Graphics g,int score,int snakeLength,boolean pause,String map, boolean left, boolean right, boolean up, boolean down, int snakeXLength[],int snakeYLength[],int pauseDir)
	{
//		//ImageIcon grass = new ImageIcon("wall4.jpg");
		//grass.paintIcon(this, g, 0, 0);
		
		//Borders of title image
		g.setColor(Color.white);
		g.drawRect(24, 10, 852, 55); 
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		
		//Border of gameplay
		g.setColor(Color.white);
		g.drawRect(24, 74, 850, 576); 
		g.setColor(Color.black);
		ImageIcon bg = new ImageIcon("background1.png");
		bg.paintIcon(this, g, 25, 75);
		//g.fillRect(25, 75, 850, 576);
		
		//Draw the pause option
		g.setColor(Color.orange);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Press ESC to pause the game", 50, 42);
		
		//Draw the scores
		g.setColor(Color.orange);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Score  : "+score, 780, 30);
		
		//Draw gameType  and level
		g.drawString("Single Player", 630, 30);
		g.setColor(Color.white);
		g.drawString(map,650,50);
		
		//Draw the highscore
		g.setColor(Color.orange);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		
		//Check which level's highScore should be shown
		int level;
		switch(map)
		{
			case "Classic":	level = 0;
							break;
							
			case "Box":		level = 1;
							break;
						
			case "Obstacle-1":	level = 2;
								break;
								
			case "Obstacle-2":	level = 3;
								break;
								
			default:	level = 0;
						break;
		}
		//Draw HighSCore
		UpdateHighScore ob = new UpdateHighScore();
		int highScore = ob.displayHighScore(level);
		g.drawString("Highscore  : "+highScore, 748, 50);
		
		
		
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
		g.drawRect(24, 10, 852, 55); 
		
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//Border of Game2
		//Border of gameplay
		g.setColor(Color.white);
		g.drawRect(24, 74, 850, 576); 
		g.setColor(Color.black);
		ImageIcon bg = new ImageIcon("background1.png");
		bg.paintIcon(this, g, 25, 75);
		//g.fillRect(25, 75, 850, 576);
		
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
		g.setColor(Color.orange);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Press ESC to pause the game", 50, 42);
		
		//Draw the scores
		g.setColor(Color.green.darker());
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Green  : "+p1score, 770, 30);
		
		//Draw gameType and level
		g.setColor(Color.orange);
		g.drawString("Two Players", 630, 30);
		g.setColor(Color.white);
		g.drawString(level,650,50);
		
		//Draw the length
		g.setColor(Color.red);
		g.setFont(new Font("Cooper black",Font.PLAIN, 14));
		g.drawString("Red      : "+p2score, 770, 50);
	}


	
	
}