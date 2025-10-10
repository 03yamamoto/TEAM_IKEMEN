package jp.co.seminar.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jp.co.seminar.dao.ReservationDao;
import jp.co.seminar.dao.RoomDao;
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
		//予約情報が入っているかの確認
		if (reservation == null) {
			throw new Exception("キャンセルする予約情報がありません");
		}
		//キャンセル処理 あとは現在日時より予約日時が上回った場合の例外処理
		if (!(ReservationDao.delete(reservation))) {
			throw new Exception("この予約はすでにキャンセルされています。");
		}
		// 現在日時を取得
		LocalDateTime nowTime = LocalDateTime.now();
		// 予約日時を組み立てる
		LocalDateTime reservationDateTime = LocalDateTime.parse(
				reservation.getDate() + "T" + reservation.getStart());//Tで日時と日付をくっつけている
		if (reservationDateTime.isBefore(nowTime)) {
			throw new Exception("過去の予約はキャンセルできません。");
		}

	}

	//予約日で会議室と時間帯を指定した会議室予約情報を生成
	public ReservationBean createReservation(String roomId, String start) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	    LocalTime startTime = LocalTime.parse(start, formatter);
	    LocalTime endTime = startTime.plusMinutes(INTERVAL);

	    String formattedStart = startTime.format(formatter);
	    String formattedEnd = endTime.format(formatter);

	    String date = this.getDate();
	    String userId = this.getUser().getId(); 
	    
	    return new ReservationBean(roomId, date, formattedStart, formattedEnd, userId);
	    
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
	    RoomBean[] rooms = getRooms(); // 会議室一覧
	    String[] period = getPeriod(); // 時間帯一覧
	    ReservationBean[][] result = new ReservationBean[rooms.length][period.length];

	    // 利用日の予約一覧を取得
	    List<ReservationBean> reservationDate = ReservationDao.findByDate(getDate());

	    for (int i = 0; i < rooms.length; i++) {
	        String roomId = rooms[i].getId();
	        for (int j = 0; j < period.length; j++) {
	            String start = period[j];
	            for (ReservationBean resavationList : reservationDate) {
	                if (resavationList.getRoomId().equals(roomId) &&
	                		resavationList.getStart().equals(start)) {
	                    result[i][j] = resavationList;
	                    break;
	                }
	            }
	        }
	    }

	    return result;
	}

	//会議室IDがroomIdの会議室を返す
	public RoomBean getRoom(String roomId) {
	    RoomBean[] rooms = RoomDao.findAll();
	    if (rooms != null) {
	        for (RoomBean room : rooms) {
	            if (room.getId().equals(roomId)) {
	                return room;
	            }
	        }
	    }
	    return null; // 見つからなかった場合
	}
	
	

	
	public RoomBean[] getRooms() {
		return rooms;
	}

	public UserBean getUser() {
		return user;
	}

	//会議室予約システムにログインしているかの結果を返す
	public boolean login(String id, String password) {
		UserBean roomLogin = UserDao.certificate(id, password);
		if (roomLogin != null) {
			return true;
		}
		return false;
	}

	//会議室予約情報で会議室Daoを利用し、予約
	public void reserve(ReservationBean reservation) {
		boolean success = ReservationDao.insert(reservation); // ReservationDaoがクラス名の例

		if (success) {
		    System.out.println("予約が追加されました！");
		} else {
		    System.out.println("予約の追加に失敗しました！");
		}
	}

	//roomIdの会議室が配列に格納されている添字を返す
	private int roomIndex(String roomId) {
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].equals(roomId)) {
				return i;
			}
		}
		// 見つからなかった場合は例外を投げる
		throw new IndexOutOfBoundsException("会議室が存在しません");
	}

	//利用開始時刻に対応する利用時間帯の添え字を計算
	private int startPeriod(String start) {
		for (int i = 0; i < PERIOD.length; i++) {
			if (PERIOD[i].equals(start)) {
				return i;
			}
		}
		// 見つからなかった場合は例外を投げる
		throw new IndexOutOfBoundsException("指定された時刻が時間帯に存在しません: " + start);
	}

	@Override
	public String toString() {
		return "利用日:" + date + "\n会議室:" + rooms + "\n利用者:" + user;
	}
}
