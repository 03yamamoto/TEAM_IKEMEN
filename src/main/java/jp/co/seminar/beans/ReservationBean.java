package jp.co.seminar.beans;

import java.io.Serializable;

public class ReservationBean implements Serializable {

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

	//会議室予約情報を基に初期化
	public ReservationBean(int id, String roomId, String date, String start, String end, String userId) {
		this.id = id;
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}
	
	//予約番号以外の会議室予約情報を基に初期化
	public ReservationBean(String roomId, String date, String start, String end, String userId) {
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
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
		return "利用日:" + date + "\n利用終了時刻:" + end + "\n予約番号:" + id + "\n会議室ID:" + roomId + "\n利用開始時刻:" + start
				+ "\n利用者ID:" + userId;

	}
}
