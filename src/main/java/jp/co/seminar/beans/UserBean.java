package jp.co.seminar.beans;

import java.io.Serializable;

public class UserBean implements Serializable {

	//フィールド
	private static final long serialVersionUID = 1L;
	private String address;
	private String id;
	private String name;
	private String password;

	//コンストラクタ
	public UserBean() {
	}

	public UserBean(String id, String password, String name, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	//メソッド
	public String getAddress() {
		return address;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	//新規ユーザー登録
	public boolean newUser() {
		
		return newUser;
	}
	
	//デバッグ用ToString
	@Override
	public String toString() {
		return "アドレス:" + address + "\nID:" + id + "\n名前:" + name + "\nパスワード:" + password;
	}

}
