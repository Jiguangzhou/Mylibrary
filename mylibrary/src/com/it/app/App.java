package com.it.app;

import java.util.Scanner;

import com.it.dao.AdminDAO;
import com.it.dao.BookDAO;
import com.it.dao.BorrowDAO;
import com.it.dao.CardDAO;
import com.it.entity.Card;

public class App {
	Scanner sc = new Scanner(System.in);
	AdminDAO adminDAO = new AdminDAO();
	BookDAO bookDAO = new BookDAO();
	BorrowDAO borrowDAO = new BorrowDAO();
	CardDAO cardDAO = new CardDAO();

	public void start() {
		// ����Ա��½
		Login();
		while (true) {
			System.out.println("====ͼ�����ϵͳ====");
			System.out.println("1.����");
			System.out.println("2.����");
			System.out.println("3.����鼮");
			System.out.println("4.�޸��鼮");
			System.out.println("5.ɾ���鼮");
			System.out.println("6.�鿴�����鼮");
			System.out.println("7.����ָ���鼮");
			System.out.println("8.�½�ͼ��֤");
			System.out.println("9.�˳�ϵͳ");
			System.out.println("================");
			System.out.println("��ѡ��");
			String input = sc.next();
			if (input.equals("1")) {

			} else if (input.equals("2")) {

			} else if (input.equals("3")) {

			} else if (input.equals("4")) {

			} else if (input.equals("5")) {

			} else if (input.equals("6")) {

			} else if (input.equals("7")) {

			} else if (input.equals("8")) {
				// �½�ͼ��֤
				newCard();
			} else if (input.equals("9")) {
				System.out.println("���˳��ɹ�����");
				break;
			} else {
				System.out.println("��ѡ�����������ѡ�񣡡�");
			}
		}
		sc.close();
	}
	private void newCard(){
		Card card = new Card();
		card.setCode(getStr("��ţ�"));
		card.setName(getStr("������"));
		card.setTel(getStr("�绰��"));
		if(cardDAO.add(card)){
			System.out.println("success");
		}else{
			System.out.println("error");
		}
	}
	

	private void Login() {
		String name = getStr("�������û�����");
		String pwd = getStr("���������룺");
		if (adminDAO.find(name, pwd)) {
			System.out.println("��½�ɹ���");
		} else {
			System.out.println("�û������������");
			Login();
		}
	}

	private String getStr(String msg) {
		System.out.println(msg);
		return sc.next();
	}
}
