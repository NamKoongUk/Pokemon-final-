package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import model.dao.UserDao;
import model.vo.User;
import music.Music;

public class OpeningPage extends JPanel{

	private MainFrame mf;
	private OpeningPage op;
	private Map m;
	private Image droh = new ImageIcon("images/dr.png").getImage().getScaledInstance(300, 500, 0);
	private Image drpo = new ImageIcon("images/poke/7F.gif").getImage();
	private int alpha = 0;
	private int alpha2 = 0;
	private int increment = 10;
	private int starton = 0;
	private Music m_vill = new Music("opening.mp3", false);
	JLabel drlabel = new JLabel(new ImageIcon(droh));
	int x = 350,y = 20;
	private int count = 1;
	private String name = "d";
	private User user;
	
	public OpeningPage(MainFrame mf, User user) {

		/*this.mf = mf;
		this.op = this;
		this.setVisible(true);
		this.setBounds(0,0,1024,768);
		this.setBackground(Color.black);*/
		this.mf = mf;
		this.op = this;
		this.user = user;

		mf.add(this);

		//임시
		
		//ud.getUserList().get(0);

		this.setVisible(true);
		this.setBounds(0,0,1024,768);
		//mf.add(this);

		m_vill.start();
		UserDao ud = new UserDao(name);
		ud.saveUser();
		String[] talkList = new String[12];
		talkList[0] = "... ... ... ... ... ... ...";
		talkList[1] = "앗! 이게 누구야! 자네 이름이 뭐지?";
		talkList[2] = "반갑네! " + name + ".";
		talkList[3] = "포켓몬스터의 세계에 잘 왔단다!";
		talkList[4] = "내 이름은 오박사";
		talkList[5] = "모두에게는 포켓몬 박사라고 알려져 있단다.";
		talkList[6] = "... ... ... ... ... ... ...";
		talkList[7] = "이 세계에는 포켓몬이라 불리는 생명체가 도처에 살고 있다!";
		talkList[8] = "우리 인간은 포켓몬과 동고 동락 하고 있지.";
		talkList[9] = "나는 그런 포켓몬들을 자세히 알기 위해 연구를 계속 하고 있단다!";
		talkList[10] = "자.. 슬슬 여행을 시작해 볼까? 일단 내 연구소로 오렴!";
		talkList[11] = "자.. 슬슬 여행을 시작해 볼까? 일단 내 연구소로 오렴!";

		JTextField tTf = new JTextField(40);
		tTf.setOpaque(false);
		JLabel temp = new JLabel(new ImageIcon("images/dial.png"));
		temp.setBounds(60, 535, 900, 150);
		temp.setLayout(new BorderLayout());
		tTf.setText(talkList[0]);
		tTf.setBounds(60, 535, 900, 150);
		tTf.setEditable(false);
		tTf.setHorizontalAlignment(JTextField.CENTER);
		tTf.setFont(new Font("고딕체", Font.BOLD, 25));
		// tTf.setForeground(Color.white);
		// tTf.setBackground(Color.black);

		

		tTf.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}

			//대화창을 클릭하면 대사가 넘어감
			@Override
			public void mouseClicked(MouseEvent e) {
				if(count < talkList.length) {

					tTf.setText(talkList[count]);
					count++;
				}
				if(count == 7) {
					/*JLabel popo = new JLabel(new ImageIcon(drpo));
					System.out.println("dd");
					popo.setBounds(40, 50, 500, 500);
					popo.setVisible(true);
					op.add(popo);
					op.setComponentZOrder(popo, 0);*/

					pokeopen();

				}
				if(count == 2) {
					
					name = JOptionPane.showInputDialog("이름을 입력");
					talkList[2] = "반갑네! " + name + ".";
					ud.getUserList().get(0).setuName(name);
					System.out.println(ud.getUserList().get(0).getuName());
					//setName(name);
					

				}
				if(count > 11) {
					mf.remove(op);
					FadeOut fade = new FadeOut(mf);
					m_vill.stop();
					m_vill = new Music("item1.mp3", false);
					m_vill.start();
					fade.fadeout(mf,ud.getUserList().get(0));
					mf.requestFocus();
					
				}
			}
		});
		this.add(tTf);
		this.add(temp);
		this.setBackground(new Color(255, 255, 255,255));


	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void opening(MainFrame mf) {
		drlabel.setBounds(x, y, 300, 500);
		drlabel.setForeground(new Color(0,0,0,0));
		op.add(drlabel);
		Timer timer = new Timer(30, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				alpha += increment;
				if (alpha > 255) {
					//increment = -increment;
					alpha += increment;
				}
				/*if (alpha <= 0) {
					alpha = 0;
					increment = -increment;
				}*/
				try {
					drlabel.setForeground(new Color(0, 0, 0, alpha));
					drlabel.setLocation(x + alpha, y);
				}catch(Exception e1){

				}
			}
		});

		timer.start();
		if(alpha == 255) {

			timer.stop();

		}

	}

	public void pokeopen() {
		
		new Music("ggo.mp3", false).start();
		JLabel popo = new JLabel(new ImageIcon(drpo));
		popo.setBounds(130, 170, 500, 500);
		popo.setVisible(true);
		op.add(popo);
		op.setComponentZOrder(popo, 0);
		new Timer(30, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				alpha2 += increment;
				if (alpha2 > 100) {
					//increment = -increment;
					alpha2 += increment;

				}
				/*if (alpha <= 0) {
					alpha = 0;
					increment = -increment;
				}*/
				try {
					popo.setForeground(new Color(0, 0, 0, alpha));
					popo.setLocation(x + alpha2, y);
					System.out.println("ddd");
				}catch(Exception e1){

				}
			}
		}).start();
		if(alpha2 == 255) {

		//	timer2.stop();

		}
	}
}
