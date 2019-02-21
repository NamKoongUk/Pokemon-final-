package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.vo.User;

public class SavePage extends JPanel {
	private JPanel sp;
	private MainFrame mf;
	private UserMenuPage ump;
	private User user;
	
	private JButton saveButton = new JButton(new ImageIcon("images/userMenuImages/saveButtonBasic.PNG"));
	private JButton saveBackButton = new JButton(new ImageIcon("images/userMenuImages/saveBackButtonBasic.PNG"));
	
	public SavePage(MainFrame mf,UserMenuPage ump,User user) {
		this.mf = mf;
		this.sp = this;
		this.ump = ump;
		this.user = user;
		sp.setOpaque(false);
		sp.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		mf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == UserMenuPage.ESC) {
					mf.remove(sp);
					sp.setVisible(false);
				}
			}
		});
	
		JLabel label = new JLabel();
		label.setText("저장 페이지");
		label.setBounds(450, 20, 200, 40);
		
		saveButton.setBounds(305, 170, 430, 130);
		saveButton.setBorderPainted(false);
		saveButton.setFocusPainted(false);
		saveButton.setContentAreaFilled(false);
		//뒤로가기 버튼
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				saveButton.setIcon(new ImageIcon("images/userMenuImages/saveButtonEntered.PNG"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				saveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				saveButton.setIcon(new ImageIcon("images/userMenuImages/saveButtonBasic.PNG"));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				//저장 버튼
				//클릭시 이벤트

			}
		});
		
		saveBackButton.setBounds(315, 370, 430, 130);
		saveBackButton.setBorderPainted(false);
		saveBackButton.setFocusPainted(false);
		saveBackButton.setContentAreaFilled(false);
		//뒤로가기 버튼
		saveBackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				saveBackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				saveBackButton.setIcon(new ImageIcon("images/userMenuImages/saveBackButtonEntered.PNG"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				saveBackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				saveBackButton.setIcon(new ImageIcon("images/userMenuImages/saveBackButtonBasic.PNG"));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				saveBackButton.setIcon(new ImageIcon("images/userMenuImages/saveBackButtonBasic.PNG"));
				mf.remove(sp);
				ump.setVisible(true);
				mf.requestFocus();
			}
		});
		
		this.add(label);
		this.add(saveBackButton);
		this.add(saveButton);

	}

	
}
