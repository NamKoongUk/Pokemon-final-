package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.BattleManager;
import controller.ItemManager;
import model.dao.ItemDao;
import model.vo.Ball;
import model.vo.Item;
import model.vo.Recovery;
import model.vo.User;

public class UserInvenPage extends JPanel {
	//0217-01
	private JPanel uivp;
	private MainFrame mf;
	private BattlePage bp;
	private UserMenuPage ump;
	private User user;
	private JPanel oldPage;
	private Map m;
	private BattleManager bm = new BattleManager();
	ArrayList<Item> itemList;
	ArrayList<Item> imgList;
	ArrayList<Item> iInfo;

	private JButton backButton = new JButton(new ImageIcon(("images/userMenuImages/backButton.PNG")));
	private JButton useButton = new JButton(new ImageIcon(("images/userMenuImages/useButton.PNG")));
	private JLabel userInvenPageBackLabel = new JLabel(new ImageIcon("images/userMenuImages/userInvenPageBack.png"));
	private JLabel itemInfoLabel = new JLabel();

	private ItemDao id = new ItemDao();

	public UserInvenPage(MainFrame mf,JPanel oldPage,User user,Map m, BattleManager bm) {
		this.mf = mf;
		this.ump = ump;
		this.uivp = this;
		this.user = user;
		this.oldPage = oldPage; // JPanel로 받아 userMenuPage, BattlePage를 받을수 있음
		this.itemList= (ArrayList<Item>) user.getUi_list();
		this.imgList= (ArrayList<Item>) user.getUi_list();
		this.iInfo= (ArrayList<Item>) user.getUi_list();
		
		userInvenPageBackLabel.setBounds(0, 0, 1024, 768);

		String[] iNameList = new String[itemList.size()];
		for(int i=0 ; i<iNameList.length ; i++) {
			iNameList[i] = itemList.get(i).getiName();
		}
		String[] iAmount = new String[itemList.size()];
		for(int i=0 ; i<iNameList.length ; i++) {
			iAmount[i] = itemList.get(i).getiAmount()+"";
		}
		//아이템정보에 이미지 띄우기---sm

		ImageIcon[] iImgList = new ImageIcon[imgList.size()];
		int num = 0;
		for(int i=0 ; i<iImgList.length ; i++) {
			iImgList[i] = new ImageIcon("images/itemImages/i00" + itemList.get(i).getiNo() + ".png");
			num++;
		}

		JList itemName = new JList(iNameList);
		itemName.setFont(new Font(getName(),Font.BOLD,17));
		itemName.setBounds(140, 130, 320, 480);
		itemName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		itemInfoLabel.setBounds(580, 130, 300, 300);
		itemInfoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

		JLabel itemImg = new JLabel();
		itemImg.setBounds(710, 130, 50, 50);

		String[] jta = new String[itemList.size()];
		JTextField jtaText = new JTextField(290);

		JLabel jl = new JLabel();
		jl.setBounds(585, 200, 290, 150);

		Item searchItem = null;

		String grade;
		int x=100;
		int y=100;

		for(int i=0; i<itemList.size(); i++) {
			searchItem = itemList.get(i);
			int iNum = searchItem.getiNo();
			if(searchItem.getiType() == 0) {

			}
			jta[i]=itemList.get(i).getiName() + ".\n"
					+itemList.get(i).getiInfo() + "\n";
			jl = new JLabel(jta[i]);
		}

		itemName.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				itemImg.setIcon(iImgList[itemName.getSelectedIndex()]);
			}
		});
		itemName.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				jtaText.setText(jta[itemName.getSelectedIndex()]+"");
				jtaText.setBounds(585, 200, 290, 150);
				jtaText.setEditable(false);
				jtaText.setHorizontalAlignment(JTextField.CENTER);
			}
		});
		this.add(jtaText);	    
		this.add(jl);
		this.add(itemImg);

		this.setLayout(null);
		this.setBackground(Color.WHITE);
		JLabel label = new JLabel();
		label.setText("가방 페이지");

		mf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == UserMenuPage.ESC) {
					mf.remove(uivp);
					uivp.setVisible(false);
				}
			}
		});


		JList itemAmountList = new JList(iAmount);
		itemAmountList.setFont(new Font(getName(),Font.BOLD,17));
		itemAmountList.setBounds(470, 130,50,480);
		itemAmountList.setEnabled(false);
		itemAmountList.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));



		useButton.setBounds(580, 460, 300, 150);
		useButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				useButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				useButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				//선택한 아이템이 있을때 다음페이지로 넘어감
				String userItemName = null;
				userItemName = itemName.getSelectedValue()+""; //선택한 아이템 리셋
				if(!(userItemName.equals("null"))) {
					uivp.setVisible(false);
					mf.remove(uivp);
				} else {
					JOptionPane.showMessageDialog(null, "아이템을 선택해주세요", "에러", JOptionPane.WARNING_MESSAGE);
				}
				ItemDao iList = new ItemDao();
				Item checkItem = null;
				checkItem = new ItemManager(user).itemReturn(userItemName);



				//배틀페이지에서 아이템 사용하는경우
				if(oldPage instanceof BattlePage) {
					if(checkItem instanceof Ball) {
						//못잡았을때
						if(!(bm.catchP(user, oldPage, m, checkItem))) {
							bm.setCtn(bm.getCtn() + 1);
							oldPage.setVisible(true);
						//잡았을때
						} else {
							
							bm.setCtn(bm.getCtn() + 1);
							oldPage.setVisible(false);
							mf.remove(oldPage);
							m.setVisible(true);
							m.setCantmove(false);
						}
					} else if(checkItem instanceof Recovery) {
						for(int i=0; i<itemList.size(); i++) {
							//선택한 아이템과 소지중인 아이템으로 번호를 받아 메소드 실행
							if(itemList.get(i).getiName().equals(userItemName)) {
								uivp.setVisible(false);
								mf.add(new PInfoPage(mf, uivp, user,userItemName)); //0217-01;
								/////아이템 사용후 이전페이지로 돌아왔을때 화면 업데이트 문제
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "지금은 사용할 수 없는 아이템입니다", "에러", JOptionPane.WARNING_MESSAGE);
						mf.add(uivp);
						uivp.setVisible(true);
					}
					//유저메뉴에서 아이템사용
				}else {
					if(checkItem instanceof Ball) {
						JOptionPane.showMessageDialog(null, "볼종류는 배틀중에만 사용할 수 있습니다", "에러", JOptionPane.WARNING_MESSAGE);
						mf.add(uivp);
						uivp.setVisible(true);
					} else {
						for(int i=0; i<itemList.size(); i++) {
							//선택한 아이템과 소지중인 아이템으로 번호를 받아 메소드 실행
							if(itemList.get(i).getiName().equals(userItemName)) {
								uivp.setVisible(false);
								mf.add(new PInfoPage(mf, uivp, user,userItemName)); //0217-01;
								/////아이템 사용후 이전페이지로 돌아왔을때 화면 업데이트 문제
							}
						}
					}
				}
			}
		});
		this.add(useButton);

		label.setBounds(450, 20, 200, 40);
		backButton.setBounds(905, 657, 90, 60);
		//뒤로가기 버튼
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				//클릭시 이벤트
				mf.remove(uivp);
				oldPage.setVisible(true);
				mf.requestFocus();
			}
		});
		this.add(backButton);
		this.add(itemInfoLabel);
		this.add(itemName);
		this.add(itemAmountList);
		this.add(userInvenPageBackLabel);
		this.add(label);
	}
	public JPanel getOldPage() {
		return this.oldPage;
	}

}
