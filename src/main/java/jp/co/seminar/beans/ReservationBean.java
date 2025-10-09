package jp.co.seminar.beans;

import java.io.Serializable;

public class ReservationBean implements Serializable{

	//フィールド
	private static final long serialVersionUID = 1L;
	private String date;
	private String end;
	private int id;
	private String roomId;
	private String start;
	private String userId;

	//コンストラクタ
	public ReservationBean() {
	}

	public ReservationBean(String roomId, String date, String start, String end, String userId) {
		roomId = roomId;
		date = date;
		start = start;
		end = end;
		userId = userId;
	}

	//メソッド
	public String getUserId() {
		return userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public String getEnd() {
		return end;
	}

	public int getId() {
		return id;
	}

	public String getRoomId() {
		return roomId;
	}

	public String getStart() {
		return start;
	}

	//デバッグ用
	@Override
	public String toString() {
		return "利用日:" + date + "利用終了時刻:" + end + "予約番号:" + id + "会議室ID:" + roomId+"利用開始時刻:"+start+"利用者ID:"+userId;
	
}
}
