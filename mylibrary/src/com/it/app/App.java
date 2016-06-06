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
		// 管理员登陆
		Login();
		while (true) {
			System.out.println("====图书管理系统====");
			System.out.println("1.借书");
			System.out.println("2.还书");
			System.out.println("3.添加书籍");
			System.out.println("4.修改书籍");
			System.out.println("5.删除书籍");
			System.out.println("6.查看所有书籍");
			System.out.println("7.查找指定书籍");
			System.out.println("8.新建图书证");
			System.out.println("9.退出系统");
			System.out.println("================");
			System.out.println("请选择：");
			String input = sc.next();
			if (input.equals("1")) {

			} else if (input.equals("2")) {

			} else if (input.equals("3")) {

			} else if (input.equals("4")) {

			} else if (input.equals("5")) {

			} else if (input.equals("6")) {

			} else if (input.equals("7")) {

			} else if (input.equals("8")) {
				// 新建图书证
				newCard();
			} else if (input.equals("9")) {
				System.out.println("【退出成功！】");
				break;
			} else {
				System.out.println("【选择错误，请重新选择！】");
			}
		}
		sc.close();
	}
	private void newCard(){
		Card card = new Card();
		card.setCode(getStr("编号："));
		card.setName(getStr("姓名："));
		card.setTel(getStr("电话："));
		if(cardDAO.add(card)){
			System.out.println("success");
		}else{
			System.out.println("error");
		}
	}
	

	private void Login() {
		String name = getStr("请输入用户名：");
		String pwd = getStr("请输入密码：");
		if (adminDAO.find(name, pwd)) {
			System.out.println("登陆成功！");
		} else {
			System.out.println("用户名或密码错误！");
			Login();
		}
	}

	private String getStr(String msg) {
		System.out.println(msg);
		return sc.next();
	}
}
