package ua.wan.ua;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	
	private JPanel imagelabel;

	private JPanel panel2;

	private JPanel panel1;

	private JButton btnGetImage;

	private JTextArea txtrEnterUrlHere;

	private JButton btnGetFile;

	private Choice choice;

	private Label label;

	private JButton btnView;

	private JScrollPane scrollPane;

	private JPanel panel;

	private JLabel imageLabel_1;

	private JMenuBar menuBar;

	private JMenu mnFile;

	private JMenuItem mntmSaveImage;

	private JMenu mnOptions;

	private JMenuItem mntmExit;


	
	

	
    public MainWindow(int width, int height ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setSize(611, 519);
	    getContentPane().setLayout(null);
	    panel2 = new JPanel(null);
	    
	    
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPane.setBounds(10, 36, 575, 433);
	    getContentPane().add(tabbedPane);
	    
	    setResizable(false);
	    
	    panel1 = new JPanel(null);
	    tabbedPane.addTab("Tab 1", panel1 );
	    
	    
	    txtrEnterUrlHere = new JTextArea();
	    txtrEnterUrlHere.setText("Enter URL here.....");
	    txtrEnterUrlHere.setBounds(10, 55, 550, 344);
	    panel1.add(txtrEnterUrlHere);
	    
	    btnGetImage = new JButton("Get Image");
	    btnGetImage.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0){
	    	   	try {
					Test.setImage(new URL(txtrEnterUrlHere.getText()));
	    	   	} catch (Exception e) {
					e.printStackTrace();
				    JOptionPane.showMessageDialog(null, "Invalid URL");
	    	   	}
	   
	    	}
	    });
	    
	    
	    btnGetImage.setBounds(10, 24, 129, 23);
	    panel1.add(btnGetImage);
	    
	    btnGetFile = new JButton("Get File");
	    btnGetFile.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    JFileChooser chouser = new JFileChooser();
	    	    int reply = chouser.showOpenDialog(null);
	    	    Test.setImage(chouser.getSelectedFile());
	    	}
	    });
	    btnGetFile.setBounds(169, 24, 129, 23);
	    panel1.add(btnGetFile);
	    tabbedPane.addTab("Tab 2", panel2 );
	    
	    choice = new Choice();
	    choice.setBounds(453, 10, 95, 20);
	    panel2.add(choice);
	    
	    choice.add("png");
	    choice.add("jpg");
	   
	    label = new Label("Format:");
	    label.setBounds(375, 10, 59, 22);
	    panel2.add(label);
	    
	    btnView = new JButton("View");
	    btnView.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent arg0) {
	    	 if(Test.getImage()==null){return;}
	    	  
	    	   imageLabel_1.setIcon(new ImageIcon(Test.getImage()));
	           imageLabel_1.updateUI();
	    	 
	    	}
	    });
	    btnView.setBounds(10, 10, 100, 23);
	    panel2.add(btnView);
	    
	    scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 44, 550, 350);
	    panel2.add(scrollPane);
	    
	    panel = new JPanel();
	    scrollPane.setViewportView(panel);
	    panel.setLayout(new BorderLayout(0, 0));
	    
	    imageLabel_1 = new JLabel("");
	    panel.add(imageLabel_1, BorderLayout.CENTER);
	    
	    menuBar = new JMenuBar();
	    menuBar.setBounds(0, 0, 605, 21);
	    getContentPane().add(menuBar);
	    
	    mnFile = new JMenu("FIle");
	    menuBar.add(mnFile);
	    
	    mntmSaveImage = new JMenuItem("Save Image");
	    mnFile.add(mntmSaveImage);
	    
	    mnOptions = new JMenu("Options");
	    menuBar.add(mnOptions);
	    
	    mntmExit = new JMenuItem("Exit");
	    mntmExit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			    System.exit(0);
			 }	
			});
	    mnOptions.add(mntmExit);

	    setVisible(true);
	}
}

