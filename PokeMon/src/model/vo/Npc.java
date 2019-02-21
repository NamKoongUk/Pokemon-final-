package model.vo;

import java.awt.Image;

public class Npc {
	
	private String nName;
	private Image nImg;
	
	public Npc() {}
	
	public Npc(String nName, Image nImg) {
		this.nName = nName;
		this.nImg = nImg;
	}

	public String getnName() {
		return nName;
	}

	public Image getnImg() {
		return nImg;
	}

	public void setnName(String nName) {
		this.nName = nName;
	}

	public void setnImg(Image nImg) {
		this.nImg = nImg;
	}
	

}
