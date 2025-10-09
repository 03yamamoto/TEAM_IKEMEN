package jp.co.seminar.beans;

import java.io.Serializable;

import jp.co.seminar.dao.UserDao;

public class MeetingRoom implements Serializable {

	//フィールド
	private static final long serialVersionUID = 1L;
	//利用時間の設定
	private static int INTERVAL = 60;
	//利用時間帯の設定
	private static String[] PERIOD = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" };
	private String date;
	private RoomBean[] rooms;
	private UserBean user;

	//コンストラクタ 
	public MeetingRoom() {
	}

	//メソッド
	//会議室予約情報で会議室の予約をキャンセルする
	public void cancel(ReservationBean reservation) {
		//キャンセル処理
	}

	//予約日で会議室と時間帯を指定した会議室予約情報を生成
	public ReservationBean createReservation(String roomId, String start) {
		return null; //処理
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	//利用時間帯の配列を返す
	public static String[] getPeriod() {
		return PERIOD;
	}

	//会議室予約システムの利用日における予約状況を返す
	public ReservationBean[][] getReservations() {
		return; //予約状況の処理が決まり次第追記
	}

	public RoomBean[] getRooms() {
		return rooms;
	}

	public UserBean getUser() {
		return user;
	}
	
	//会議室予約システムにログインしているかの結果を返す
	public boolean login(String id,String password) {
		UserBean roomLogin = UserDao.certificate(id,password);
		if(roomLogin !=null){
		return true;
		} return false;
	}
	
	//会議室予約情報で会議室Daoを利用し、予約
	public void reserve(ReservationBean reservation) {
		//予約処理
	}
	
	//roomIdの会議室が配列に格納されている添字を返す
	private int roomIndex(String roomId){
		return;//処理
	}	
	//利用開始時刻に対応する利用時間帯の添え字を計算
	private int startPeriod(String start) {
		return 0;
	}

	//テスト用処理
	@Override
	public String toString() {
		return "利用日:" + date + "\n会議室:" + rooms + "\n利用者:" + user;
	}
}
