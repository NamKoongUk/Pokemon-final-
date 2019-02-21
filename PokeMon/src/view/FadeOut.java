package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.dao.UserDao;
import model.vo.User;

public class FadeOut extends JPanel{

	private MainFrame mf;
	private Map m;
	private FadeOut fade;
	private int alpha = 0;
	private int increment = 10;
	private int starton = 0;
	
	public FadeOut(MainFrame mf){
		this.mf = mf;
		this.fade = this;

		this.setVisible(true);
		this.setBounds(0,0,1024,768);
		mf.add(this);
		this.setBackground(new Color(0, 0, 0,0));

		
		

	}
	public void fadeout(MainFrame mf,User user) {
		Timer timer = new Timer(40, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				alpha += increment;
				if (alpha > 255 && starton == 0) {
					//increment = -increment;
					starton = 1;
					//fade.setVisible(false);
					mf.remove(fade);
				/*	UserDao ud = new UserDao("이름이름");
					ud.saveUser(); */
					mf.add(new Map(mf, user));
				}
				/*if (alpha <= 0) {
					alpha = 0;
					increment = -increment;
				}*/
				try {
				fade.setBackground(new Color(0, 0, 0, alpha));
				}catch(Exception e1){
					
				}
			}
		});
		timer.start();
		if(alpha == 255) {
			timer.stop();
			
		}
	}

}
