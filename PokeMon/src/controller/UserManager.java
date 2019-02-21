package controller;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import model.vo.User;

public class UserManager {
	User user;
	Font font = new Font("", Font.BOLD, 30);
	
	public UserManager(User user) {
		this.user = user;
	}
	
	public void userItemSet() {
		
	}
	public void saveUser() {
		
	}
	
	public void firstSelectPokemon(User user) { 
		//첫 포켓몬 선택하는 메소드
	}
	
	public JLabel getUserGold() {
		JLabel goldLabel = new JLabel();
		goldLabel.setFont(font);
		goldLabel.setText(user.getuGold()+"");
		return goldLabel;
	}

	public void setUserGold(int gold) {
		user.setuGold(gold);
	}
	//유저 닉네임 라벨로 만들어 리턴
	public JLabel viewUserName() {
		JLabel userNameLabel = new JLabel();
		userNameLabel.setText(user.getuName());
		userNameLabel.setFont(font);
		return userNameLabel;
	}
	public String viewUserTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("hh시 mm분");
		long diff = user.getuDate().getTime() - new Date().getTime();
		String time = sdf.format(diff);
		return time;
		
	}
	//유저 생성시간 라벨로 만들어 리턴
	public JLabel viewCreateTime() {
		JLabel createTimeLabel = new JLabel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh시 mm분");
		String time = sdf.format(user.getuDate());
		createTimeLabel.setText(time);
		createTimeLabel.setFont(new Font("",Font.CENTER_BASELINE, 18));
		return createTimeLabel;
	}
	//잡은 포켓몬 수 라벨로 만들어 리턴
	public JLabel viewUserGetPoke() {
		JLabel getPokeLabel = new JLabel();
		getPokeLabel.setText((user.getTp_list().size()+user.getUp_list().size()) + "마리");
		return getPokeLabel;
	}
}
