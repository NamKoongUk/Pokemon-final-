package model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class User implements java.io.Serializable{

	private String uName;
	private Date uDate;
	private int uGold;
	private ArrayList<Pokemon> up_list;
	private ArrayList<Item> ui_list;
	private ArrayList<Pokemon> tp_list;
	private ArrayList<Pokemon> ep_list;
	private int scd = 0;

	//0217-01 닉네임만 받아서 초기화 
	public User(String uName) {
		this.uName = uName;
		this.uDate = new Date();
		this.uGold = 3000;
		this.up_list = new ArrayList<Pokemon>();
		this.ui_list = new ArrayList<Item>();
		this.tp_list = new ArrayList<Pokemon>();
		this.ep_list = new ArrayList<Pokemon>();
	}

	public User(String uName, Date uDate, int uGold, ArrayList<Pokemon> up_list, ArrayList<Item> ui_list, ArrayList<Pokemon> tp_list, ArrayList<Pokemon> ep_list) {
		super();
		this.uName = uName;
		this.uDate = uDate;
		this.uGold = uGold;
		this.up_list = up_list;
		this.tp_list = tp_list;
		this.ep_list = ep_list;
	}

	public ArrayList<Pokemon> getEp_list() {
		return ep_list;
	}

	public void setEp_list(ArrayList<Pokemon> ep_list) {
		this.ep_list = ep_list;
	}

	public void setUp_list(ArrayList<Pokemon> up_list) {
		this.up_list = up_list;
	}

	public void setUi_list(ArrayList<Item> ui_list) {
		this.ui_list = ui_list;
	}

	public void setTp_list(ArrayList<Pokemon> tp_list) {
		this.tp_list = tp_list;
	}

	/*public User(String uName) {
      super();
      this.uName = uName;
      this.uDate = new Date();
      this.uGold = 3000;
      this.ui_list = new ArrayList<Item>(0);
      this.up_list = new ArrayList<Pokemon>(0);
      this.tp_list = new ArrayList<Pokemon>(0);
   }*/
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public Date getuDate() {
		return uDate;
	}
	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}
	public int getuGold() {
		return uGold;
	}
	public void setuGold(int uGold) {
		this.uGold = uGold;
	}
	public List<Pokemon> getUp_list() {
		return up_list;
	}

	public ArrayList<Item> getUi_list() {
		return ui_list;
	}

	public List<Pokemon> getTp_list() {
		return tp_list;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tp_list == null) ? 0 : tp_list.hashCode());
		result = prime * result + ((uDate == null) ? 0 : uDate.hashCode());
		result = prime * result + uGold;
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + ((ui_list == null) ? 0 : ui_list.hashCode());
		result = prime * result + ((up_list == null) ? 0 : up_list.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (tp_list == null) {
			if (other.tp_list != null)
				return false;
		} else if (!tp_list.equals(other.tp_list))
			return false;
		if (uDate == null) {
			if (other.uDate != null)
				return false;
		} else if (!uDate.equals(other.uDate))
			return false;
		if (uGold != other.uGold)
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (ui_list == null) {
			if (other.ui_list != null)
				return false;
		} else if (!ui_list.equals(other.ui_list))
			return false;
		if (up_list == null) {
			if (other.up_list != null)
				return false;
		} else if (!up_list.equals(other.up_list))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [uName=" + uName + ", uDate=" + uDate + ", uGold=" + uGold + ", up_list=" + up_list + ", ui_list="
				+ ui_list + ", tp_list=" + tp_list + "]";
	}

	public int getScd() {
		return scd;
	}

	public void setScd(int scd) {
		this.scd = scd;
	}


}