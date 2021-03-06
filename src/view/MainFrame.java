package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.GameEngineCallbackController;
import controller.PlaceBetController;
import controller.RollHouseController;
import controller.RollPlayerController;
import controller.WindowController;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame
{
	public JButton jBBet;
    public JButton jBRollHouse;
    public JButton jBRollPlayer;
    private JMenu jEdit;
    private JMenu jFile;
    public JLabel jLABDice1;
    public JLabel jLABDice2;
    public JLabel jLabName;
    public JMenuItem jMIAdd;
    private JMenuBar menuBar;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    public JTextArea jTAresult;
    public JTextField jTFBet;
    public JTable table;
	
	
	public GameEngine ge;
    AddPlayer ap;
    GameEngineCallbackController gecbc;
    public GameEngineCallbackGUI gecg;
    PlaceBetController pbc;
    RollPlayerController rpc;
    RollHouseController rhc;
    WindowController wc;
    public boolean GUIrolling = false; 
    public String currentPlayer;
 
//	JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT); 
//	List<Player> players = new ArrayList<Player>();
//	
//	JPanel dicePanel = new JPanel();
//	JScrollPane info = new JScrollPane((Component) players);
	
	/**
     * Creates new form MainFrame
     */
	public MainFrame(GameEngine ge) 
	{
		initComponents();
		this.ge = ge;
//		this.ge.addGameEngineCallback(gecg);
		ap = new AddPlayer(ge);
		gecbc = new GameEngineCallbackController(ge,this);
		ap = new AddPlayer(ge);
        pbc = new PlaceBetController(ge, this);
        rpc = new RollPlayerController(ge, this);
        rhc = new RollHouseController(ge, this);
        wc = new WindowController(this);
        this.jLABDice1.setIcon(new ImageIcon("df1.png"));
        this.jLABDice2.setIcon(new ImageIcon("df1.png"));
        this.setVisible(true);

//		try 
//		{
//			jbInit();
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
	}
	
//	private void jbInit() throws Exception 
//	{
//		this.getContentPane().add(jsp, java.awt.BorderLayout.CENTER);
//		jsp.add(info, JSplitPane.LEFT);
//		jsp.add(dicePanel, JSplitPane.RIGHT);
//	    jsp.setDividerLocation(0.5);
//		jsp.setOneTouchExpandable(true);
//	}
	
	private void initComponents() 
	{

		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		jLABDice1 = new javax.swing.JLabel();
		jLABDice2 = new javax.swing.JLabel();
		jBRollPlayer = new javax.swing.JButton();
		jBRollHouse = new javax.swing.JButton();
		jLabName = new javax.swing.JLabel();
		jTFBet = new javax.swing.JTextField();
		jBBet = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTAresult = new javax.swing.JTextArea();
		menuBar = new javax.swing.JMenuBar();
		jFile = new javax.swing.JMenu();
		jMIAdd = new javax.swing.JMenuItem();
		jEdit = new javax.swing.JMenu();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(51, 102, 255));
		setMinimumSize(new java.awt.Dimension(720, 450));
		setPreferredSize(new java.awt.Dimension(720, 450));

		table.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"ID", "Name", "Points", "Bets", "Result"
				}
				));

		jScrollPane1.setViewportView(table);

		jLABDice1.setBackground(new java.awt.Color(255, 153, 153));

		jBRollPlayer.setText("Roll Player");


		jBRollHouse.setText("Roll House");
		jBRollHouse.setPreferredSize(new java.awt.Dimension(109, 29));


		jLabName.setBackground(new java.awt.Color(255, 255, 255));
		jLabName.setForeground(new java.awt.Color(153, 0, 204));

		jBBet.setText("Place Bet");


		jTAresult.setColumns(20);
		jTAresult.setRows(5);
		jScrollPane2.setViewportView(jTAresult);

		jFile.setText("File");

		jMIAdd.setText("Add Player");

		jMIAdd.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMIAddActionPerformed(evt);
			}
		});
		
		jFile.add(jMIAdd);

		menuBar.add(jFile);

		jEdit.setText("Edit");
		menuBar.add(jEdit);

		setJMenuBar(menuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(6, 6, 6)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGap(4, 4, 4)
										.addComponent(jTFBet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(40, 40, 40)
										.addComponent(jBBet)))
						.addGap(4, 4, 4)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jLABDice1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(51, 51, 51)
										.addComponent(jLABDice2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(60, 60, 60)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jBRollPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jBRollHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup()
										.addGap(10, 10, 10)
										.addComponent(jLabName, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGap(24, 24, 24)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(6, 6, 6)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(14, 14, 14)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jTFBet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jBBet)))
				.addGroup(layout.createSequentialGroup()
						.addGap(20, 20, 20)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jBRollPlayer)
										.addGap(11, 11, 11)
										.addComponent(jBRollHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 
												javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGap(20, 20, 20)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLABDice1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLABDice2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(30, 30, 30)
						.addComponent(jLabName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(30, 30, 30)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
				);
		//Automatically resize the frame
		pack();
	}
	    
	private void jMIAddActionPerformed(java.awt.event.ActionEvent evt) 
	{
		ap.setVisible(true);
	}
	
	public void doRefDices(DicePair r)
    {
        switch(r.getDice1())
        {
            case 1:
                this.jLABDice1.setIcon(new ImageIcon("df1.png"));
                break;
            case 2:
                this.jLABDice1.setIcon(new ImageIcon("df2.png"));
                break;
            case 3:
                this.jLABDice1.setIcon(new ImageIcon("df3.png"));
                break;
            case 4:
                this.jLABDice1.setIcon(new ImageIcon("df4.png"));
                break;
            case 5:
                this.jLABDice1.setIcon(new ImageIcon("df5.png"));
                break;
            case 6:
                this.jLABDice1.setIcon(new ImageIcon("df6.png"));
                break;
        }
        switch(r.getDice2())
        {
            case 1:
                this.jLABDice2.setIcon(new ImageIcon("df1.png"));
                break;
            case 2:
                this.jLABDice2.setIcon(new ImageIcon("df2.png"));
                break;
            case 3:
                this.jLABDice2.setIcon(new ImageIcon("df3.png"));
                break;
            case 4:
                this.jLABDice2.setIcon(new ImageIcon("df4.png"));
                break;
            case 5:
                this.jLABDice2.setIcon(new ImageIcon("df5.png"));
                break;
            case 6:
                this.jLABDice2.setIcon(new ImageIcon("df6.png"));
                break;
        }
    }

    public void doRefName(String name,DicePair dp)
    {
        this.jLabName.setText(name + ": ROLLING Dice 1: " + dp.getDice1()
                + ",  Dice 2: " + dp.getDice2()
                + " .. Total: " + (dp.getDice1()+dp.getDice2()));
    }
    
	public void doRefTable() 
	{
	     DefaultTableModel dtm = new DefaultTableModel();
	        
	        String[] tableHeads = new String[]{"ID", "Name", "Points","Bets","Result"};
	        
	        dtm.setColumnIdentifiers(tableHeads);
	        
	        List<Player> data = (List)ge.getAllPlayers();
	        
	        for(int i = 0; i < data.size();i++)
	        {
	            Player p = data.get(i);
	            {
	                
	                Object[] dataRow =
	                {p.getPlayerId(), p.getPlayerName(), p.getPoints(),p.getBet(),
	                    p.getRollResult() == null? "" : p.getRollResult().getDice1()
	                        + p.getRollResult().getDice2()};
	                
	                dtm.addRow(dataRow);
	            }
	        }
	        
	        this.table.setModel(dtm);
	}
	
    public void doRefTextArea(DicePair dp,GameEngine ge)
    {
        String houseInfo = "";
        
        houseInfo = "HOUSE:" + " *RESULT* Dice 1: " + dp.getDice1() +
                "  Dice 2: " + dp.getDice2()  + " ..Total: " + (dp.getDice1()+dp.getDice2())+"\n";
        
      
        
        for(Player p:ge.getAllPlayers())
        {
            houseInfo += p.toString()+"\n";
        }
        
        this.jTAresult.setText(houseInfo);
    }

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) 
//    {
//    	try 
//    	{
//    		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//    			if ("Nimbus".equals(info.getName())) {
//    				javax.swing.UIManager.setLookAndFeel(info.getClassName());
//    				break;
//    			}
//    		}
//    	} 
//    	catch (ClassNotFoundException ex) 
//    	{
//    		java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    	}
//    	catch (InstantiationException ex) 
//    	{
//    		java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    	} catch (IllegalAccessException ex) 
//    	{
//    		java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    	} 
//    	catch (javax.swing.UnsupportedLookAndFeelException ex) 
//    	{
//    		java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    	}
//
//    	/* Create and display the form */
//    	java.awt.EventQueue.invokeLater(new Runnable() 
//    	{
//    		public void run() 
//    		{
//    			new MainFrame(ge).setVisible(true);
//    		}
//    	});
//    }
}
