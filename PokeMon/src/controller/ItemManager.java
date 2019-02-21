package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.ItemDao;
import model.vo.Ball;
import model.vo.Item;
import model.vo.Pokemon;
import model.vo.Recovery;
import model.vo.Stone;
import model.vo.User;

public class ItemManager {

	private ItemDao id = new ItemDao();
	private User user;

	public ItemManager(User user) {
		this.user = user;
	}

	public void decreaseGold(int check) {
		System.out.println("ItemMamager로 옴");
		//구매 총액, 현재 유저 소지 금액을 가져와서 골드를 차감
		user.setuGold(user.getuGold() - check);
	}

	public void addInven(int iNo, int iAmount) {

		System.out.println("유저 인벤토리 추가 실행");
		System.out.println("선택한 아이템 번호 : " + iNo + " / 수량 : " + iAmount);
		Item item = new Item();
		item = id.getIList().get(iNo);
		item.setiAmount(iAmount);
		//유저 아이템리스트 가져오기
		ArrayList<Item> ui_list = user.getUi_list();

		Item searchItem = null;

		for(int i=0; i<ui_list.size(); i++) {
			//유저 아이템 리스트에 구매하려는 아이템이 있을경우
			if(ui_list.get(i).getiNo() == iNo) {
				searchItem = ui_list.get(i);
				iAmount = iAmount + ui_list.get(i).getiAmount();
				ui_list.get(i).setiAmount(iAmount);
				user.setUi_list(ui_list);
			}
		}
		if(searchItem == null) {
			//유저 아이템리스트에 없을때 아이템을 새로 추가
			user.getUi_list().add(item);
		}


		for(int i = 0; i < user.getUi_list().size(); i++) {
			if(user.getUi_list().get(i) == null) {
				System.out.print(i + " : 빈칸 | ");
			}else {
				System.out.print(" " + i + " : " + user.getUi_list().get(i).getiName() + " / "
						+ user.getUi_list().get(i).getiAmount() + "개 |");
			}
		}

	}
	
	public void subInven(int iNo, int iAmount) {
		
		System.out.println("유저 인벤토리 감소 실행");
		System.out.println("선택한 아이템 번호 : " + iNo + " / 수량 : " + iAmount);
		Item item = new Item();
		item = id.getIList().get(iNo);
		item.setiAmount(iAmount);
		//유저 아이템리스트 가져오기
		ArrayList<Item> ui_list = user.getUi_list();
		
		for(int i=0; i<ui_list.size();i++) {
			if(ui_list.get(i).getiNo()==iNo) {
				ui_list.get(i).setiAmount(ui_list.get(i).getiAmount()-1);
				if(ui_list.get(i).getiAmount()==0) {
					//수량이 0개 되면 삭제
					ui_list.remove(i);
				}
				
			}
		}
	}
	
	//0217-02
	public int useItem(int iNo,Pokemon poke) {
		
		ArrayList<Item> ui_list = user.getUi_list();
		Item useItem = null;
		
		for(int i=0; i<ui_list.size();i++) {
			if(ui_list.get(i).getiNo()==iNo) {
				useItem = ui_list.get(i);
				if(ui_list.get(i).getiAmount()==0) {
					//수량이 0개 되면 삭제
					ui_list.remove(i);
				}
				
			}
		}
		
		if(useItem instanceof Ball) {
			useItem = (Ball)id.getIList().get(iNo);
			
			System.out.println(poke.getpName() + "에게 " + useItem.getiName() + "사용");
			subInven(iNo, useItem.getiAmount());

			return ((Ball) useItem).getcProb();

		}else if(useItem instanceof Recovery) {
			//포켓몬 체력 회복
			//maxHp보다 낮을때만 사용가능
			if(poke.getpHp()<poke.getpMaxHp()) {
				subInven(iNo, useItem.getiAmount());
				poke.setpHp(poke.getpHp()+((Recovery) useItem).getAmount());
				//회복후에 현재 체력이 최대 체력보다 높을때 재조정
				if(poke.getpHp()>poke.getpMaxHp()) {
					poke.setpHp(poke.getpMaxHp());
				}
			}else {
				JOptionPane.showMessageDialog(null, "체력이 가득 찼습니다", "에러", JOptionPane.WARNING_MESSAGE);
			}
			
			return ((Recovery) useItem).getAmount();

		}else if(useItem instanceof Stone) {
			useItem = (Stone)id.getIList().get(iNo);
			
			if(((Stone) useItem).getStoneType() == poke.getpType() && poke.ispEvoType() == true) {
				System.out.println("진화가능");
				subInven(iNo, useItem.getiAmount());
				new EvolutionManager(user, poke);
			}else {
				if(poke.ispEvoType() == false) {
					JOptionPane.showMessageDialog(null, "진화의 돌을 사용할 수 있는 포켓몬이 아닙니다.", "에러", JOptionPane.WARNING_MESSAGE);
				}
				if(((Stone) useItem).getStoneType() != poke.getpType() && poke.ispEvoType() == true) {
					JOptionPane.showMessageDialog(null, "진화의 돌과 포켓몬 타입이 맞지 않습니다.", "에러", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			return ((Stone) useItem).getStoneType();
		}

		return 0;
	}
	public int useItem(String iName,Pokemon poke) {
		int iNo=0;
		for(int i=0; i<id.getIList().size();i++) {
			if(id.getIList().get(i).getiName().equals(iName)) {
				iNo = id.getIList().get(i).getiNo();
			}
		}
		return useItem(iNo,poke);
	}
	
	
	//아이템 이름을 비교하여 리턴
	public Item itemReturn(String iName) {
		Item item = null;
		ArrayList<Item> iList = user.getUi_list();
		for(int i=0; i<iList.size(); i++) {
			if(iList.get(i).getiName().equals(iName)) {
				item = iList.get(i);
			}
		}
		
		return item;
	}

}