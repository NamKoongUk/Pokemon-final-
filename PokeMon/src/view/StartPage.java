package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.dao.UserDao;
import model.vo.User;
import music.Music;

public class StartPage extends JPanel{

	private MainFrame mf;
	private JPanel stp;
	private User user;
	private Image mainPage = new ImageIcon("images/mainPage.gif").getImage();
	 private int alpha = 255;
	  private int increment = -5;
	  private JLabel label = new JLabel("게임 시작 버튼을 눌러주세요!");
		private Music m_vill = new Music("village.mp3", false);

	public StartPage(MainFrame mf) {
		this.mf = mf;
		this.stp = this;
		stp.setOpaque(false);
		stp.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		Image jlb = new ImageIcon("images/mainPage.gif").getImage().getScaledInstance(1000, 720, 0);
		JLabel jlb2 = new JLabel(new ImageIcon(jlb));
		jlb2.setBounds(0, 0, 1000, 720);
		jlb2.setForeground(new Color(0, 0, 0, 0));
		label.setForeground(new Color(255,255,255,255));
		label.setFont(new Font("돋움체", Font.BOLD, 30));
		label.setBounds(260, 180, 550, 200);
		Music m_main = new Music("start.mp3", false);
		m_main.start();
		
		
		Timer timer = new Timer(15, new ActionListener() {
			 
		      public void actionPerformed(ActionEvent e) {
		        alpha += increment;
		        if (alpha >= 255) {
		          alpha = 255;
		          increment = -increment;
		        }
		        if (alpha <= 0) {
		          alpha = 0;
		          increment = -increment;
		        }
		        label.setForeground(new Color(0, 0, 0, alpha));
		        
		      }
		    });
		
		timer.start();
		
		
		
		JButton startbtn = new JButton(new ImageIcon("images/startbtn.png"));
		JButton nextPage = new JButton(new ImageIcon("images/loadbtn.png"));
		startbtn.setSize(150,50);
		startbtn.setLocation(320,320);
		startbtn.setFont(new Font("바탕체", Font.BOLD, 13));

		nextPage.setSize(150,50);
		nextPage.setLocation(500,320);


		startbtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {


				OpeningPage opp = new OpeningPage(mf,user);
				m_vill.stop();
				m_vill = new Music("item1.mp3", false);
				m_vill.start();
				opp.opening(mf);
				opp.setVisible(true);
				mf.requestFocus(); 
				timer.stop();
				m_main.close();
				mf.remove(stp);
				
				

				/*mf.remove(stp);
	            m.setVisible(true);
	            mf.requestFocus();
	            ((Map) m).start();*/

				
			}
		});
		nextPage.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				 
				FadeOut fade = new FadeOut(mf);
				m_vill.stop();
				m_vill = new Music("item1.mp3", false);
				m_vill.start();
				fade.fadeout(mf,user);
				mf.requestFocus();
				timer.stop();
				m_main.close();
				mf.remove(stp);
			//	stp.setVisible(false);
			/*	UserDao ud = new UserDao("이름이름");
				ud.saveUser();*/
			//	mf.add(new Map(mf, ud.getUserList().get(0)));
			/*	UserDao ud = new UserDao("이름이름");
				ud.saveUser();
				
				mf.add(new Map(mf, ud.getUserList().get(0)));*/
				/*
				//ud.getUserList().get(0).setuGold(500);
				
				stp.setVisible(false);
				mf.remove(stp);
				mf.add(new Map(mf, ud.getUserList().get(0)));
				mf.requestFocus();
				stp.removeAll();*/

			}
		});
		stp.add(label);
		stp.add(jlb2);
		stp.add(startbtn);
		stp.add(nextPage);
		stp.setComponentZOrder(jlb2, 1);
		stp.setComponentZOrder(label, 0);
		stp.setComponentZOrder(startbtn, 0);
		stp.setComponentZOrder(nextPage, 0);
		mf.add(this);

	}

}


