package controller;

import javax.swing.JOptionPane;

import model.dao.PokemonDao;
import model.vo.Pokemon;
import model.vo.User;

public class EvolutionManager {
	
	private User user;
	private PokemonDao pd = new PokemonDao();
	
	private int evoHP = 50;
	private int evoSpeed = 10;
	
	public EvolutionManager(User user, Pokemon poke) {
		
		System.out.println("진화의돌 진화 페이지");
		
		String beforePName = poke.getpName();
		Pokemon evoP = null;
		
		for(int i = 0; i < pd.getpList().size(); i++) {
			if(poke.getpNo() == pd.getpList().get(i).getpNo()) {
				evoP = pd.getpList().get(i+1);
			}
		}
		
		poke.setpName(evoP.getpName());
		poke.setpNo(evoP.getpNo());
		poke.setpMaxHp(poke.getpMaxHp() + evoHP);
		poke.setpSpeed(poke.getpSpeed() + evoSpeed);
		poke.setGrade(poke.getGrade() -1);
		poke.setpEvoType(evoP.ispEvoType());
		
		System.out.println(poke.getpName() + poke.getpNo());
		System.out.println(poke.ispEvoType());
		
		JOptionPane.showMessageDialog(null, beforePName + "이/가 " + evoP.getpName() + "으로 진화했습니다.", "진화성공", JOptionPane.WARNING_MESSAGE);
	}
}
