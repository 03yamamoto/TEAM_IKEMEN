package jp.co.seminar.beans;

import java.io.Serializable;

public class RoomBean implements Serializable{

	//フィールド
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	//コンストラクタ
	public RoomBean() {
	}

	public RoomBean(String id, String name) {
		id = id;
		name = name;
	}

	//メソッド
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	//デバッグ用
	@Override
	public String toString() {
		return "ID:" + id + "名前:" + name;

	}
}
