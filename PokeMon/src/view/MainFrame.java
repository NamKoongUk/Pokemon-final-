package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame() {
		this.setTitle("포켓몬스터EE");
		Toolkit tk = Toolkit.getDefaultToolkit();

		this.setSize(1024, 768);
		Dimension screen = tk.getScreenSize();

		int xpos = (int)(screen.getWidth() / 2 - getWidth() / 2);
		int ypos = (int)(screen.getHeight() / 2 - getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("images/itemImages/i000.PNG").getImage());
		new StartPage(this);
		//new Map(this);
		this.setVisible(true);
		this.setResizable(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




}
