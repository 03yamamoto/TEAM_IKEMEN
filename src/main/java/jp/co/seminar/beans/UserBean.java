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
	UserBean() {
	}

	UserBean(String id, String password, String name, String address) {
		id = id;
		password = password;
		name = name;
		address = address;
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

	//デバッグ用ToString
	@Override
	public String toString() {
		return "アドレス:" + address + "ID:" + id + "名前:" + name + "パスワード:" + password;
	}

}
