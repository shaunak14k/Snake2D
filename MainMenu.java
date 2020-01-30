import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;

public class MainMenu extends JFrame implements ActionListener
{
	//*************************************************************
	//1) Display "CONGRATS" message for creating new HIGHSCORE
	//2) Fix the Turning bug
	//*************************************************************
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame f1 = new JFrame();
	
	private String mapS = "classic";
	private int gtype = 1;
	
	private String gtypeLabel = "Single Player";
	private String levelLabel = "Classic";
	
	//If called from MainMenu()
	
	
	/*public MainMenu(String x) 
	{ 
		f1.setVisible(false);
		f1.dispose();
		f1.dispatchEvent(new WindowEvent(f1, WindowEvent.WINDOW_CLOSING));
	}*/
	
	
	public MainMenu(int gtype,String mapS)
	{
		
		if(gtype == 1)
		{
			gtypeLabel = "Single Player";
			switch(mapS)
			{
				case "classic":	levelLabel = "Classic";
								break;
							
				case "Border":	levelLabel = "Box";
								break;
							
				case "level2":	levelLabel = "Obstacle-1";
								break;
							
				case "level3":	levelLabel = "Obstacle-2";
								break;
							
				default : 	levelLabel = "Classic";
							break;
			}
		}
		else if(gtype == 2)
		{
			gtypeLabel = "Two Players";
			switch(mapS)
			{
				case "game1" :	levelLabel = "Classic";
								break;
							
				case "game2":	levelLabel = "Fastest Finger First";
								break;
							
				case "game3":	levelLabel = "Best of 3";
								break;
							
							
				default : 	levelLabel = "Classic";
							break;
			}
		}
		
		
		JFrame f = new JFrame();		//Creating JFrame object f
		
		JButton start1 = new JButton("New Game");
		JButton map = new JButton("Level");
		JButton exit1 = new JButton("Quit");
		JButton gtypeB = new JButton("Game Type");
		JButton controls = new JButton("Controls");
		JButton credit = new JButton("Credits");
		
		//JPanel panel = new JPanel();
		
		JLabel lt = new JLabel(new ImageIcon("snake2d.png"));
		
		JLabel gtypeL = new JLabel("Game type    -   "+gtypeLabel);
		JLabel levelL = new JLabel("Level        -   "+levelLabel);
		
		//JLabel lmap = new JLabel("Map : ");
		//JLabel lmap2 = new JLabel(mapS);
		
		//Setting some settings for our JFrame
		f.setTitle("Snake2D");						//Set title of the frame
		f.setBounds(10 ,10 ,904, 699);					//Set bounds of the frame (borders)
		f.setResizable(false);							//User cannot resize the frame
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.DARK_GRAY );
		f.setLocationRelativeTo(null);	//Frame is in center of screen 
			
		//snakehome = new ImageIcon("snakehome.jpg");
		
		//setContentPane(new JLabel(new ImageIcon("snakehome.jpg")));
		
		f.setLayout(null);
		//f.add(panel);		//Adding panel to JFrame
		
		//Add icon to JFrame
		ImageIcon icon = new ImageIcon("frameIcon.png");
		f.setIconImage(icon.getImage());
		
		
		//Settings for Text : SNAKE GAME
		lt.setBounds(180, 60, 500, 80);	
		f.add(lt);
		
		//exit1.setBounds(300, 525, 290, 65);		//x,y,width,height

		
		//Settings for text gtypL
		gtypeL.setFont(new Font("Cooper black", Font.ITALIC, 15));
		gtypeL.setBounds(50, 520, 500, 16);
		gtypeL.setForeground(Color.orange);
		f.add(gtypeL); 
		
		//Settings fot text levelL
		levelL.setFont(new Font("Cooper black", Font.ITALIC, 15));
		levelL.setBounds(75, 550, 500, 16);
		levelL.setForeground(Color.orange);
		f.add(levelL);
		
		
		//Settings for JButton (START GAME)
		start1.setBounds(300, 200, 290, 65);		//x,y,width,height
		start1.setForeground(Color.white);
		start1.setFont(new Font("Cooper black", Font.BOLD, 30));
		start1.setBackground(Color.white);
		start1.setFocusable(false); 
		start1.setOpaque(false);
		start1.setBorderPainted(false);
		//start1.setContentAreaFilled(false);
		//start1.setBorderPainted(false);
		start1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	start1.setOpaque(true);
		    	start1.setBackground(Color.white);
		        start1.setForeground(Color.darkGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	start1.setOpaque(false);
		        start1.setBackground(Color.darkGray);
		        start1.setForeground(Color.white);
		    	
		    }
		});
		//panel.add(start1);	//Adding start button to JPanel
		f.add(start1);		//Adding start button to JFrame
		
		
		//Settings for JButton (SELECT MAP)
		map.setBounds(300, 265, 290, 65);		//x,y,width,height
		map.setForeground(Color.white);
		map.setFont(new Font("Cooper black", Font.BOLD, 30));
		map.setBackground(Color.white);
		map.setFocusable(false);
		//exit1.setFocusPainted(false);
		map.setOpaque(false);
		map.setBorderPainted(false);
		//map.setContentAreaFilled(false);
		map.addMouseListener(new java.awt.event.MouseAdapter()
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	map.setOpaque(true);
		    	map.setBackground(Color.white);
		    	map.setForeground(Color.darkGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	map.setOpaque(false);
		    	map.setBackground(Color.darkGray);
		    	map.setForeground(Color.white);
		    	
		    }
		});
		//panel.add(map);	//Adding start button to JPanel
		f.add(map);		//Adding start button to JFrame
		
		
		//Settings for JButton (GAME TYPE)
		gtypeB.setBounds(300, 330, 290, 65);		//x,y,width,height
		gtypeB.setForeground(Color.white);
		gtypeB.setFont(new Font("Cooper black", Font.BOLD, 30));
		gtypeB.setBackground(Color.white);
		gtypeB.setFocusable(false);
		gtypeB.setOpaque(false);
		gtypeB.setBorderPainted(false);
		gtypeB.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt)
		    {
		    	gtypeB.setOpaque(true);
		    	gtypeB.setBackground(Color.white);
		    	gtypeB.setForeground(Color.darkGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt)
		    {
		    	gtypeB.setOpaque(false);
		    	gtypeB.setBackground(Color.darkGray);
		    	gtypeB.setForeground(Color.white);
		    	
		    }
		});
		//panel.add(start1);	//Adding start button to JPanel
		f.add(gtypeB);		//Adding start button to JFrame
		
		
		//Settings for JButton (CONTROLS)
		controls.setBounds(300, 395, 290, 65);		//x,y,width,height
		controls.setForeground(Color.white);
		controls.setFont(new Font("Cooper black", Font.BOLD, 30));
		controls.setBackground(Color.white);
		controls.setFocusable(false);
		controls.setOpaque(false);
		controls.setBorderPainted(false);
		controls.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt)
		    {
		    	controls.setOpaque(true);
		    	controls.setBackground(Color.white);
		    	controls.setForeground(Color.darkGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt)
		    {
		    	controls.setOpaque(false);
		    	controls.setBackground(Color.darkGray);
		    	controls.setForeground(Color.white);
		    
		    }
		});
		//panel.add(start1);	//Adding start button to JPanel
		f.add(controls);		//Adding start button to JFrame
		
		//Settings for JButton (CONTROLS)
		credit.setBounds(300, 460, 290, 65);		//x,y,width,height
		credit.setForeground(Color.white);
		credit.setFont(new Font("Cooper black", Font.BOLD, 30));
		credit.setBackground(Color.white);
		credit.setFocusable(false);
		credit.setOpaque(false);
		credit.setBorderPainted(false);
		credit.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt)
		    {
		    	credit.setOpaque(true);
		    	credit.setBackground(Color.white);
		    	credit.setForeground(Color.darkGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt)
		    {
		    	credit.setOpaque(false);
		    	credit.setBackground(Color.darkGray);
		    	credit.setForeground(Color.white);
		    	
		    }
		});
		//panel.add(start1);	//Adding start button to JPanel
		f.add(credit);		//Adding start button to JFrame
		
		
		//Settings for JButton (EXIT)
		exit1.setBounds(300, 525, 290, 65);		//x,y,width,height
		exit1.setForeground(Color.white);
		
		exit1.setFont(new Font("Cooper black", Font.BOLD, 30));
		exit1.setBackground(Color.white);
		//exit1.setFocusPainted(false);
		//exit1.setContentAreaFilled(false);
		exit1.setFocusable(false);
		exit1.setOpaque(false);
		//exit1.setContentAreaFilled(false);
		//exit1.setFocusPainted(false);
		exit1.setBorderPainted(false);
		exit1.addMouseListener(new java.awt.event.MouseAdapter()
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt)
		    {
		    	exit1.setOpaque(true);
		    	exit1.setBackground(Color.white);
		    	exit1.setForeground(Color.darkGray);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	exit1.setOpaque(false);
		    	exit1.setBackground(Color.darkGray);
		    	exit1.setForeground(Color.white);
		    	
		    }
		});
		//panel.add(exit1);		//Adding exit button to JPanel
		f.add(exit1);		//Adding exit button to JFrame
		
		
		//Settings for WALLPAPER
		JLabel wallpaper = new JLabel(new ImageIcon("wall5.jpg"));
		wallpaper.setBounds(0, 0, 905, 700);
		f.add(wallpaper);
		System.out.println("Wall painted");
		
		/*//Settings for Text : MAP :
		lmap.setFont(new Font("Arial", Font.BOLD, 30));
		lmap.setBounds(670, 570, 390, 80);
		lmap.setForeground(Color.black);
		panel.add(lmap);
		f.add(lmap);
		*/
		//Settings for Text MAP_TYPE
		/*lmap2.setFont(new Font("Arial", Font.BOLD, 30));
		lmap2.setBounds(760, 570, 390, 80);
		lmap2.setForeground(Color.red);
		panel.add(lmap2);
		f.add(lmap2);
		*/
		this.gtype=gtype;
		this.mapS = mapS;
		
		f.setVisible(true);			//Invoke after adding all components
		//setVisible(true);
		
		start1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
		    {
				f.dispose();
			       	
				//************
				//After clicking on start first frame will get disposed and we make a new frame for our game
	        	
				System.out.println("\n Start Game is selected , Game has started");
				
				//JFrame f1 = new JFrame();
			        	
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
	    		
	    		/*
	    		if(mapS == "basic")
	    			f.add(basicGame);
	    		
	    		if(mapS == "border")
	    			f.add(borderGame);
	    		
	    		if(mapS == "")
	    			f.add(basicGame);
	    		*/
	    		
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
		    }
		});
				
		
		map.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				//After clicking (MAP) new JFrame should open
				
				f.dispose();
				
				System.out.println("\n MapMenu is selected");
				
				if(gtype == 1)
				{
					MapMenu();
					repaint();
				}
				else if(gtype == 2)
				{
					MapMenu2();
					repaint();
				}
				
			}
		});
		
		gtypeB.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				//After clicking (MAP) new JFrame should open
				
				f.dispose();
				
				System.out.println("\n MapMenu is selected");
				
				gtypeMenu();
				repaint();
				
			}
		});
		
		
		controls.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				//After clicking (MAP) new JFrame should open
				
				f.dispose();
				
				System.out.println("\n ControlsMenu is selected ");
				
				controlsMenu();
				
				repaint();
				
				
			}
		});
		
		credit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				f.dispose();
				
				JFrame f = new JFrame();		//Creating JFrame object f
				//Setting some settings for our JFrame
				f.setTitle("Snake2D");						//Set title of the frame
				f.setBounds(10 ,10 ,905, 700);					//Set bounds of the frame (borders)
				f.setResizable(false);							//User cannot resize the frame
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.getContentPane().setBackground(Color.DARK_GRAY );
				f.setLocationRelativeTo(null);
				f.getContentPane().setLayout(null);
				
				//Add icon to JFrame
				ImageIcon icon = new ImageIcon("frameIcon.png");
				f.setIconImage(icon.getImage());
				
				JButton back = new JButton("Back");
				//Settings for JButton (EXIT)
				//back.setBounds(350, 550, 190, 80);		//x,y,width,height
				//Settings for JButton (START GAME)
				back.setBounds(350, 550, 200, 65);		//x,y,width,height
				back.setForeground(Color.white);
				back.setFont(new Font("Cooper black", Font.PLAIN, 30));
				back.setBackground(Color.white);
				back.setFocusable(false); 
				back.setOpaque(false);
				back.setBorderPainted(false);
				back.addMouseListener(new java.awt.event.MouseAdapter() 
				{
					public void mouseEntered(java.awt.event.MouseEvent evt) 
					{
						back.setOpaque(true);
						back.setBackground(Color.white);
						back.setForeground(Color.darkGray);
					}
					
					public void mouseExited(java.awt.event.MouseEvent evt) 
					{
						back.setOpaque(false);
						back.setBackground(Color.darkGray);
						back.setForeground(Color.white);
						
					}
				});
				f.add(back);		//Adding start button to JFrame
				
				//Settings for WALLPAPER
				JLabel wallpaper = new JLabel(new ImageIcon("wall7.jpg"));		
				wallpaper.setBounds(0, 0, 905, 700);
				f.add(wallpaper);	
				
				
				back.addActionListener(new ActionListener() 
				{			
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("\n Back to MainMenu");
						
						//After clicking (Exit) the game frame should close
						f.dispose();
						
						new MainMenu(gtype,mapS);
					}
				});
			}
		});
		
		
		exit1.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("EXIT");
				//After clicking (Exit) the game frame should close
				System.exit(0);
			}
		});
		
		
	}
	
	
	/*public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(750, 570, 50, 50);
		
		g.setColor(Color.black);
		g.setFont(new Font("arial",Font.BOLD, 13));
		g.drawString(mapS, 750, 570);
	}*/
	
	
	
	public void controlsMenu()
	{
		JFrame f = new JFrame();		//Creating JFrame object f
		//Setting some settings for our JFrame
		f.setTitle("Snake2D");						//Set title of the frame
		f.setBounds(10 ,10 ,905, 700);					//Set bounds of the frame (borders)
		f.setResizable(false);							//User cannot resize the frame
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.DARK_GRAY );
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		
		//Add icon to JFrame
		ImageIcon icon = new ImageIcon("frameIcon.png");
		f.setIconImage(icon.getImage());
		
		JLabel singleP = new JLabel("Single Player : ");
		//Settings for Text
		singleP.setFont(new Font("Showcard gothic", Font.PLAIN, 16));
		singleP.setBounds(15, 15, 500, 18);
		singleP.setForeground(Color.cyan);
		//panel.add(singleP);
		f.add(singleP);
		
		JLabel singleP1 = new JLabel("UP          -   UP ARROW ");
		//Settings for Text
		singleP1.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		singleP1.setBounds(15, 50, 500, 12);
		singleP1.setForeground(Color.white);
		//panel.add(singleP);
		f.add(singleP1);
		
		JLabel singleP2 = new JLabel("DOWN   -   DOWN ARROW ");
		//Settings for Text
		singleP2.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		singleP2.setBounds(15, 65, 500, 12);
		singleP2.setForeground(Color.white);
		//panel.add(singleP);
		f.add(singleP2);
		
		JLabel singleP3 = new JLabel("LEFT      -   LEFT ARROW ");
		//Settings for Text
		singleP3.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		singleP3.setBounds(15, 80, 500, 12);
		singleP3.setForeground(Color.white);
		//panel.add(singleP);
		f.add(singleP3);
		
		JLabel singleP4 = new JLabel("RIGHT   -   RIGHT ARROW ");
		//Settings for Text
		singleP4.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		singleP4.setBounds(15, 95, 500, 12);
		singleP4.setForeground(Color.white);
		//panel.add(singleP);
		f.add(singleP4);
		
		
		//******************************************************************************************
		
		JLabel twoP = new JLabel("Two Players : ");
		//Settings for Text
		twoP.setFont(new Font("Showcard gothic", Font.PLAIN, 16));
		twoP.setBounds(15, 150, 500, 16);
		twoP.setForeground(Color.cyan);
		//panel.add(singleP);
		f.add(twoP);
		
		JLabel twoPx = new JLabel("GREEN SNAKE ");
		//Settings for Text
		twoPx.setFont(new Font("Showcard gothic", Font.PLAIN, 14));
		twoPx.setBounds(15, 180, 500, 16);
		twoPx.setForeground(Color.orange);
		//panel.add(singleP);
		f.add(twoPx);
		
		JLabel twoP1 = new JLabel("UP               -       'W' ");
		//Settings for Text 
		twoP1.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		twoP1.setBounds(15, 210, 500, 12);
		twoP1.setForeground(Color.green);
		//panel.add(singleP);
		f.add(twoP1);
		
		JLabel twoP2 = new JLabel("DOWN     -       'S' ");
		//Settings for Text
		twoP2.setFont(new Font("Cooper black", Font.PLAIN, 12));
		twoP2.setBounds(15, 225, 500, 12);
		twoP2.setForeground(Color.green);
		//panel.add(singleP);
		f.add(twoP2);
		
		JLabel twoP3 = new JLabel("LEFT            -       'A' ");
		//Settings for Text
		twoP3.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		twoP3.setBounds(15, 240, 500, 12);
		twoP3.setForeground(Color.green);
		//panel.add(singleP);
		f.add(twoP3);
		
		JLabel twoP4 = new JLabel("RIGHT        -       'D' ");
		//Settings for Text
		twoP4.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		twoP4.setBounds(15, 255, 500, 12);
		twoP4.setForeground(Color.green);
		//panel.add(singleP);
		f.add(twoP4);
		
		
		//**********
		JLabel twoPrx = new JLabel("RED SNAKE ");
		//Settings for Text
		twoPrx.setFont(new Font("Showcard gothic", Font.PLAIN, 14));
		twoPrx.setBounds(250, 180, 500, 16);
		twoPrx.setForeground(Color.orange);
		//panel.add(singleP);
		f.add(twoPrx);
		
		JLabel twoPr1 = new JLabel("UP          -   'UP ARROW' ");
		//Settings for Text
		twoPr1.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		twoPr1.setBounds(250, 210, 500, 12);
		twoPr1.setForeground(Color.red);
		//panel.add(singleP);
		f.add(twoPr1);
		
		JLabel twoPr2 = new JLabel("DOWN   -   'DOWN ARROW' ");
		//Settings for Text
		twoPr2.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		twoPr2.setBounds(250, 225, 500, 12);
		twoPr2.setForeground(Color.red);
		//panel.add(singleP);
		f.add(twoPr2);
		
		JLabel twoPr3 = new JLabel("LEFT      -   'LEFT ARROW' ");
		//Settings for Text
		twoPr3.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		twoPr3.setBounds(250, 240, 500, 12);
		twoPr3.setForeground(Color.red);
		//panel.add(singleP);
		f.add(twoPr3);
		
		JLabel twoPr4 = new JLabel("RIGHT   -   'RIGHT ARROW' ");
		//Settings for Text
		twoPr4.setFont(new Font("Showcard gothic", Font.PLAIN, 12));
		twoPr4.setBounds(250, 255, 500, 12);
		twoPr4.setForeground(Color.red);
		//panel.add(singleP);
		f.add(twoPr4);
		
		//***************************************************************************************
		
		JLabel game1 = new JLabel("Classic : ");
		//Settings for Text
		game1.setFont(new Font("Showcard gothic", Font.PLAIN, 16));
		game1.setBounds(15, 300, 500, 16);
		game1.setForeground(Color.orange);
		//panel.add(singleP);
		f.add(game1);
		
		JLabel game1a = new JLabel("Bigger snake wins.");
		//Settings for Text
		game1a.setFont(new Font("Showcard gothic", Font.PLAIN, 14));
		game1a.setBounds(15, 320, 500, 14);
		game1a.setForeground(Color.green.darker());
		//panel.add(singleP);
		f.add(game1a);
		
		//******************************************************************************************
		
		JLabel game2 = new JLabel("Fastest Finger First : ");
		//Settings for Text
		game2.setFont(new Font("Showcard gothic", Font.PLAIN, 16));
		game2.setBounds(15, 370, 500, 16);
		game2.setForeground(Color.orange);
		//panel.add(singleP);
		f.add(game2);
		
		JLabel game2a = new JLabel("Fastest Finger First. First one to kill, wins");
		//Settings for Text
		game2a.setFont(new Font("Showcard gothic", Font.PLAIN, 14));
		game2a.setBounds(15, 390, 500, 14);
		game2a.setForeground(Color.green.darker());
		//panel.add(singleP);
		f.add(game2a);
		
		//*************************************************************************************
		
		JLabel game3 = new JLabel("Best of 3 : ");
		//Settings for Text
		game3.setFont(new Font("Showcard gothic", Font.PLAIN, 16));
		game3.setBounds(15, 440, 500, 16);
		game3.setForeground(Color.orange);
		//panel.add(singleP);
		f.add(game3);
		
		JLabel game3a = new JLabel("Best of three between Red Snake and Green Snake.");
		//Settings for Text
		game3a.setFont(new Font("Showcard gothic", Font.PLAIN, 14));
		game3a.setBounds(15, 460, 500, 16);
		game3a.setForeground(Color.green.darker());
		//panel.add(singleP);
		f.add(game3a);
		
		
		//********************************************************************************
		
		JButton back = new JButton("Back");
		//Settings for JButton (EXIT)
		//back.setBounds(350, 550, 190, 80);		//x,y,width,height
		//Settings for JButton (START GAME)
		back.setBounds(350, 550, 200, 65);		//x,y,width,height
		back.setForeground(Color.white);
		back.setFont(new Font("Cooper black", Font.PLAIN, 30));
		back.setBackground(Color.white);
		back.setFocusable(false); 
		back.setOpaque(false);
		back.setBorderPainted(false);
		//one.setContentAreaFilled(false);
		//one.setBorderPainted(false);		
		
		back.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(true);
				back.setBackground(Color.white);
				back.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(false);
				back.setBackground(Color.darkGray);
				back.setForeground(Color.white);
				
			}
		});
		f.add(back);		//Adding start button to JFrame
			
		
		
		//Settings for WALLPAPER
		JLabel wallpaper = new JLabel(new ImageIcon("wall6.jpg"));		
		wallpaper.setBounds(0, 0, 905, 700);
		f.add(wallpaper);
		
		

		back.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Back to MainMenu");
				
				//After clicking (Exit) the game frame should close
				f.dispose();
				
				new MainMenu(gtype,mapS);
			}
		});
		
		

	}
	
	
	public void gtypeMenu()
	{
		JFrame f = new JFrame();		//Creating JFrame object f
		
		JButton one = new JButton(" Single Player");
		JButton two = new JButton(" Two Players");
		JButton back = new JButton("Back");
		
		
		switch(gtype)
		{
			case 1:	one.setIcon(new ImageIcon("tick.png"));
					break;
					
			case 2:	two.setIcon(new ImageIcon("tick.png"));
					break;
		}
		
		
			
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
		
		
		//Settings for Text : SNAKE GAME
		JLabel lt = new JLabel(new ImageIcon("snake2d.png"));
		lt.setBounds(180, 60, 500, 80);	
		f.add(lt);
		
		
		//Settings for JButton (START GAME)
		one.setBounds(285, 250, 320, 65);		//x,y,width,height
		one.setForeground(Color.white);
		one.setFont(new Font("Cooper black", Font.BOLD, 30));
		one.setBackground(Color.white);
		one.setFocusable(false); 
		one.setOpaque(false);
		one.setBorderPainted(false);
		//one.setContentAreaFilled(false);
		//one.setBorderPainted(false);
		one.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				one.setOpaque(true);
				one.setBackground(Color.white);
				one.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				one.setOpaque(false);
				one.setBackground(Color.darkGray);
				one.setForeground(Color.white);
				
			}
		});
		f.add(one);		//Adding start button to JFrame
			
		//Settings for JButton (START GAME)
		two.setBounds(285, 315, 320, 65);		//x,y,width,height
		two.setForeground(Color.white);
		two.setFont(new Font("Cooper black", Font.BOLD, 30));
		two.setBackground(Color.white);
		two.setFocusable(false); 
		two.setOpaque(false);
		two.setBorderPainted(false);
		//two.setContentAreaFilled(false);
		//two.setBorderPainted(false);
		two.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				two.setOpaque(true);
				two.setBackground(Color.white);
				two.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				two.setOpaque(false);
				two.setBackground(Color.darkGray);
				two.setForeground(Color.white);
				
			}
		});
		f.add(two);		//Adding start button to JFrame
		
			
				
		//Settings for JButton (START GAME)
		back.setBounds(350, 450, 200, 65);		//x,y,width,height
		back.setForeground(Color.white);
		back.setFont(new Font("Cooper black", Font.BOLD, 30));
		back.setBackground(Color.white);
		back.setFocusable(false); 
		back.setOpaque(false);
		back.setBorderPainted(false);
		//one.setContentAreaFilled(false);
		//one.setBorderPainted(false);
		back.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(true);
				back.setBackground(Color.white);
				back.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(false);
				back.setBackground(Color.darkGray);
				back.setForeground(Color.white);
				
			}
		});
		f.add(back);		//Adding start button to JFrame
		
				
		//Settings for WALLPAPER
		JLabel wallpaper = new JLabel(new ImageIcon("Wall5.jpg"));		
		wallpaper.setBounds(0, 0, 905, 700);
		f.add(wallpaper);
		
		
		one.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Basic is selected");
				
				//one.setBackground(Color.green);
				//two.setBackground(Color.orange);
				
				two.setIcon(null);
				one.setIcon(new ImageIcon("tick.png"));
				
				gtype = 1;
				
				gtypeLabel = "Single Player";
		    }
		});
						
				
		two.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Bordered is selected");
				
				//one.setBackground(Color.orange);
				//two.setBackground(Color.green);
				
				one.setIcon(null);
				two.setIcon(new ImageIcon("tick.png"));
				
				gtype = 2;
				
				gtypeLabel = "Two Players";
				System.out.println("Label changed");
			}
		});
		
		
		
				
				
		back.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Back to MainMenu");
				
				//After clicking (Exit) the game frame should close
				f.dispose();
				
				new MainMenu(gtype,mapS);
			}
		});

	}
	//MAP MENU For Two Players **************************************************************************************************************
	public void MapMenu2()
	{
		JFrame f = new JFrame();		//Creating JFrame object f
		
		JButton g1 = new JButton(" Classic");
		JButton g2 = new JButton(" Fastest Finger First");
		JButton g3 = new JButton(" Best of 3");
		JButton back = new JButton("Back");
		
		
		switch(mapS)
		{
			case "game1":	g1.setIcon(new ImageIcon("tick.png"));
							break;
					
			case "game2":	g2.setIcon(new ImageIcon("tick.png"));
							break;
			
			case "game3":	g3.setIcon(new ImageIcon("tick.png"));
							break;
							
			default:	g1.setIcon(new ImageIcon("tick.png"));
						break;

		}
			
		//Setting some settings for our JFrame
		f.setTitle("Snake2D");						//Set title of the frame
		f.setBounds(10 ,10 ,905, 700);					//Set bounds of the frame (borders)
		f.setResizable(false);							//User cannot resize the frame
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.DARK_GRAY );
		f.setLocationRelativeTo(null);
		
		f.setLayout(null);
		//f.add(panel);		//Adding panel to JFrame
		
		//Add icon to JFrame
		ImageIcon icon = new ImageIcon("frameIcon.png");
		f.setIconImage(icon.getImage());
		
		//Settings for Text : SNAKE GAME
		JLabel lt = new JLabel(new ImageIcon("snake2d.png"));
		lt.setBounds(180, 60, 500, 80);	
		f.add(lt);
		
		
		//Settings for JButton (START GAME)
		g1.setBounds(300, 220, 290, 65);		//x,y,width,height
		g1.setForeground(Color.white);
		g1.setFont(new Font("Cooper black", Font.BOLD, 30));
		g1.setBackground(Color.white);
		g1.setFocusable(false); 
		g1.setOpaque(false);
		g1.setBorderPainted(false);
		//g1.setContentAreaFilled(false);
		//g1.setBorderPainted(false);
		g1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				g1.setOpaque(true);
				g1.setBackground(Color.white);
				g1.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				g1.setOpaque(false);
				g1.setBackground(Color.darkGray);
				g1.setForeground(Color.white);
				
			}
		});	
		f.add(g1);		//Adding start button to JFrame
		
		//Settings for JButton (START GAME)
		g2.setBounds(245, 285, 400, 65);		//x,y,width,height
		g2.setForeground(Color.white);
		g2.setFont(new Font("Cooper black", Font.BOLD, 30));
		g2.setBackground(Color.white);
		g2.setFocusable(false); 
		g2.setOpaque(false);
		g2.setBorderPainted(false);
		//g2.setContentAreaFilled(false);
		//g2.setBorderPainted(false);
		g2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				g2.setOpaque(true);
				g2.setBackground(Color.white);
				g2.setForeground(Color.darkGray);
			}
					
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				g2.setOpaque(false);
				g2.setBackground(Color.darkGray);
				g2.setForeground(Color.white);
			}
		});
		f.add(g2);		//Adding start button to JFrame
			
			
		//Settings for JButton (START GAME)
		g3.setBounds(300, 350, 290, 65);		//x,y,width,height
		g3.setForeground(Color.white);
		g3.setFont(new Font("Cooper black", Font.BOLD, 30));
		g3.setBackground(Color.white);
		g3.setFocusable(false); 
		g3.setOpaque(false);
		g3.setBorderPainted(false);
		//one.setContentAreaFilled(false);
		//one.setBorderPainted(false);
		g3.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				g3.setOpaque(true);
				g3.setBackground(Color.white);
				g3.setForeground(Color.darkGray);
			}
				
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				g3.setOpaque(false);
				g3.setBackground(Color.darkGray);
				g3.setForeground(Color.white);
			}
		});
		f.add(g3);		//Adding start button to JFrame
								
		
		//Settings for JButton (START GAME)
		back.setBounds(350, 480, 200, 65);		//x,y,width,height
		back.setForeground(Color.white);
		back.setFont(new Font("Cooper black", Font.BOLD, 30));
		back.setBackground(Color.white);
		back.setFocusable(false); 
		back.setOpaque(false);
		back.setBorderPainted(false);
		//back.setContentAreaFilled(false);
		//back.setBorderPainted(false);
		back.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(true);
				back.setBackground(Color.white);
				back.setForeground(Color.darkGray);
			}
				
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(false);
				back.setBackground(Color.darkGray);
				back.setForeground(Color.white);
			}
		});
		f.add(back);		//Adding start button to JFrame
			
			
		//Settings for WALLPAPER
		JLabel wallpaper = new JLabel(new ImageIcon("Wall5.jpg"));		
		wallpaper.setBounds(0, 0, 905, 700);
		f.add(wallpaper);
		
		
		g1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Classic is selected");
				
				g1.setIcon(new ImageIcon("tick.png"));
				g2.setIcon(null);
				g3.setIcon(null);
				
				mapS = "game1";
				
				levelLabel = "Classic";
			}
		});	
							
		
		g2.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Fastest-finger-first is selected");
				
				g1.setIcon(null);
				g2.setIcon(new ImageIcon("tick.png"));
				g3.setIcon(null);
				
				mapS = "game2";
				
				levelLabel = "F-F-F";
			}
		});
		
		g3.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Best of 3 is selected");
				
				g1.setIcon(null);
				g2.setIcon(null);
				g3.setIcon(new ImageIcon("tick.png"));
				
				mapS = "game3";
			
				levelLabel = "Best of 3";
			}
		});
			
					
					
		back.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Back to MainMenu");
				
				//After clicking (Exit) the game frame should close
				f.dispose();
				
				new MainMenu(gtype,mapS);
			}
		});

	}

	
	
	//MAP MENU **************************************************************************************************************
	public void MapMenu()
	{
		JFrame f = new JFrame();		//Creating JFrame object f
		
		JButton basic = new JButton(" Classic");
		JButton border = new JButton(" Box");
		JButton level2 = new JButton(" Obstacle-1");
		JButton level3 = new JButton(" Obstacle-2");
		JButton back = new JButton("Back");
		

		switch(mapS)
		{
			case "classic":	basic.setIcon(new ImageIcon("tick.png"));
							break;
							
			case "Border":	border.setIcon(new ImageIcon("tick.png"));
							break;

			case "level2":	level2.setIcon(new ImageIcon("tick.png"));
							break;

			case "level3":	level3.setIcon(new ImageIcon("tick.png"));
							break;

			default	:	basic.setIcon(new ImageIcon("tick.png"));
						break;

		}
		
		
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
		
		//Settings for Text : SNAKE GAME
		JLabel lt = new JLabel(new ImageIcon("snake2d.png"));
		lt.setBounds(180, 60, 500, 80);	
		f.add(lt);
		
		
		//Settings for JButton (START GAME)
		basic.setBounds(300, 200, 290, 65);		//x,y,width,height
		basic.setForeground(Color.white);
		basic.setFont(new Font("Cooper black", Font.BOLD, 30));
		basic.setBackground(Color.white);
		basic.setFocusable(false); 
		basic.setOpaque(false);
		basic.setBorderPainted(false);
		//basic.setContentAreaFilled(false);
		//basic.setBorderPainted(false);
		basic.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				basic.setOpaque(true);
				basic.setBackground(Color.white);
				basic.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				basic.setOpaque(false);
				basic.setBackground(Color.darkGray);
				basic.setForeground(Color.white);
				
			}
		});
		f.add(basic);		//Adding start button to JFrame
		
		
		//Settings for JButton (START GAME)
		border.setBounds(300, 265, 290, 65);		//x,y,width,height
		border.setForeground(Color.white);
		border.setFont(new Font("Cooper black", Font.BOLD, 30));
		border.setBackground(Color.white);
		border.setFocusable(false); 
		border.setOpaque(false);
		border.setBorderPainted(false);
		//border.setContentAreaFilled(false);
		//border.setBorderPainted(false);
		border.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				border.setOpaque(true);
				border.setBackground(Color.white);
				border.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				border.setOpaque(false);
				border.setBackground(Color.darkGray);
				border.setForeground(Color.white);
				
			}
		});
		f.add(border);		//Adding start button to JFrame
		
		
		//Settings for JButton (START GAME)
		level2.setBounds(300, 330, 290, 65);		//x,y,width,height
		level2.setForeground(Color.white);
		level2.setFont(new Font("Cooper black", Font.BOLD, 30));
		level2.setBackground(Color.white);
		level2.setFocusable(false); 
		level2.setOpaque(false);
		level2.setBorderPainted(false);
		//level2.setContentAreaFilled(false);
		//level2.setBorderPainted(false);
		level2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				level2.setOpaque(true);
				level2.setBackground(Color.white);
				level2.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				level2.setOpaque(false);
				level2.setBackground(Color.darkGray);
				level2.setForeground(Color.white);
				
			}
		});
		f.add(level2);		//Adding start button to JFrame		
		
		
		//Settings for JButton (START GAME)
		level3.setBounds(300, 395, 290, 65);		//x,y,width,height
		level3.setForeground(Color.white);
		level3.setFont(new Font("Cooper black", Font.BOLD, 30));
		level3.setBackground(Color.white);
		level3.setFocusable(false); 
		level3.setOpaque(false);
		level3.setBorderPainted(false);
		//level3.setContentAreaFilled(false);
		//level3.setBorderPainted(false);
		level3.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				level3.setOpaque(true);
				level3.setBackground(Color.white);
				level3.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				level3.setOpaque(false);
				level3.setBackground(Color.darkGray);
				level3.setForeground(Color.white);
				
			}
		});
		f.add(level3);		//Adding start button to JFrame
				
				
		//Settings for JButton (START GAME)
		back.setBounds(350, 500, 200, 65);		//x,y,width,height
		back.setForeground(Color.white);
		back.setFont(new Font("Cooper black", Font.BOLD, 30));
		back.setBackground(Color.white);
		back.setFocusable(false); 
		back.setOpaque(false);
		back.setBorderPainted(false);
		//back.setContentAreaFilled(false);
		//back.setBorderPainted(false);
		back.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(true);
				back.setBackground(Color.white);
				back.setForeground(Color.darkGray);
			}
			
			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				back.setOpaque(false);
				back.setBackground(Color.darkGray);
				back.setForeground(Color.white);
				
			}
		});
		f.add(back);		//Adding start button to JFrame
		
		
		//Settings for WALLPAPER
		JLabel wallpaper = new JLabel(new ImageIcon("Wall5.jpg"));		
		wallpaper.setBounds(0, 0, 905, 700);
		f.add(wallpaper);
		
		
		basic.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Basic is selected");
				
				basic.setIcon(new ImageIcon("tick.png"));
				border.setIcon(null);
				level2.setIcon(null);
				level3.setIcon(null);
				
				mapS = "classic";
				
				levelLabel = "Classic";
		    }
		});
						
				
		border.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Bordered is selected");
				
				basic.setIcon(null);
				border.setIcon(new ImageIcon("tick.png"));
				level2.setIcon(null);
				level3.setIcon(null);
				
				mapS = "Border";
				
				levelLabel = "Box";
			}
		});
		
		level2.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Level2 is selected");
				
				basic.setIcon(null);
				border.setIcon(null);
				level2.setIcon(new ImageIcon("tick.png"));
				level3.setIcon(null);
						
				mapS = "level2";
				
				levelLabel = "Obstacle-1";
			}
		});
		
		level3.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Level3 is selected");
				
				basic.setIcon(null);
				border.setIcon(null);
				level2.setIcon(null);
				level3.setIcon(new ImageIcon("tick.png"));
						
				mapS = "level3";
				
				levelLabel = "Obstacle-2";
			}
		});
		
		
				
				
		back.addActionListener(new ActionListener() 
		{			
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("\n Back to MainMenu");
				
				//After clicking (Exit) the game frame should close
				f.dispose();
				
				new MainMenu(gtype,mapS);
			}
		});

	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		
	}
}//END OF CLASS	



/*
//If called from GameOverMenu()
public MainMenu(int x)
{
	JFrame f = new JFrame();		//Creating JFrame object f
	
	JButton start1 = new JButton("Start Game");
	JButton map = new JButton("Select Map");
	JButton exit1 = new JButton("Exit");
	
	
	
	JPanel panel = new JPanel();
	
	JLabel lt = new JLabel("Snake Game");
	
	//Setting some settings for our JFrame
	f.setTitle("Snake Game");						//Set title of the frame
	f.setBounds(10 ,10 ,905, 700);					//Set bounds of the frame (borders)
	f.setResizable(false);							//User cannot resize the frame
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.getContentPane().setBackground(Color.white );
		
	
	f.setLayout(null);
	f.add(panel);		//Adding panel to JFrame
		
	
	//Settings for JButton (START GAME)
	start1.setBounds(320, 250, 260, 80);		//x,y,width,height
	start1.setFont(new Font("Arial", Font.BOLD, 40));
	start1.setBackground(Color.orange);
	panel.add(start1);	//Adding start button to JPanel
	f.add(start1);		//Adding start button to JFrame
			
	//Settings for JButton (SELECT MAP)
	map.setBounds(321, 350, 260, 80);		//x,y,width,height
	map.setFont(new Font("Arial", Font.BOLD, 40));
	map.setBackground(Color.orange);
	panel.add(map);	//Adding start button to JPanel
	f.add(map);		//Adding start button to JFrame
			
			
	//Settings for JButton (EXIT)
	exit1.setBounds(350, 450, 190, 80);		//x,y,width,height
	exit1.setFont(new Font("Arial", Font.BOLD, 40));
	exit1.setBackground(Color.orange);
	panel.add(exit1);		//Adding exit button to JPanel
	f.add(exit1);		//Adding exit button to JFrame
	
	
	//Settings for Text
	lt.setFont(new Font("Arial", Font.BOLD, 60));
	lt.setBounds(275, 80, 390, 80);
	lt.setForeground(Color.red);
	lt.setForeground(Color.black);
	panel.add(lt);
	f.add(lt);
	
	
	start1.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
	    {
			
			//This frame will get disposed and game will continue in previous frame
			f.dispose();
        	
        	f1.setTitle("Snake Game");		//Set title of the frame
    		f1.setBounds(10 ,10 ,905, 700);	//Set bounds of the frame (borders)
	   		f1.setResizable(false);			//User cannot resize the frame
    		f1.setVisible(true);
    		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		f1.getContentPane().setBackground(Color.black);			        	
        
    		/*
    		if(mapS == "basic")
    			f.add(basicGame);
    		
    		if(mapS == "border")
    			f.add(borderGame);
    		
    		if(mapS == "")
    			f.add(basicGame);
    		*/  
/*
    		
    		Gameplay basicGame = new Gameplay();
    		
    		switch(mapS)
    		{
    			case "Basic" :	f1.add(basicGame);
    							break;
    							
    			
    							
    			default : 	f1.add(basicGame);
    						break;
    		}
			//************
			
        	
        	//***************
        }
	});
			
	map.addActionListener(new ActionListener() 
	{			
		public void actionPerformed(ActionEvent e)
		{
			//After clicking (MAP) new JFrame should open
			
			MapMenu();

			f.repaint();
		}
	});
	
	exit1.addActionListener(new ActionListener() 
	{			
		public void actionPerformed(ActionEvent e)
		{
			//After clicking (Exit) the game frame should close
			System.exit(0);
		}
	});
}
*/


