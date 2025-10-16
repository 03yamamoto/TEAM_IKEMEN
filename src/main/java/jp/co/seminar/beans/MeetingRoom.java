package jp.co.seminar.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import jp.co.seminar.dao.ReservationDao;
import jp.co.seminar.dao.RoomDao;
import jp.co.seminar.dao.UserDao;
import jp.co.seminar.util.RoomList;

/**
 * 会議室管理システムのモデル
 *
 * <p><strong>バージョン:</strong> 1.0.1</p>
 * <p><strong>作成者:</strong> 佐藤　智喜</p>
 * <p><strong>関連項目:</strong> 直列化された形式</p>
 */
public class MeetingRoom implements Serializable {

	//フィールド
	/**直列化用バージョン番号*/
	private static final long serialVersionUID = 1L;
	/**利用時間(分)60分とする*/
	private static final int INTERVAL = 60;
	/**利用時間帯(開始時刻) ("09:00", "10:00", "11:00", "12:00","13:00", "14:00", "15:00", "16:00")*/
	private static final String[] PERIOD = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00" };
	/**利用日*/
	private String date;
	/**会議室*/
	private RoomList rooms;
	/**利用者*/
	private UserBean user;

	//コンストラクタ 
	/**生成 会議室予約システムを初期化します。*/
	public MeetingRoom() {
		this.rooms = RoomDao.findAll​();
		 Calendar cl = Calendar.getInstance();
		 
	     // SimpleDateFormatクラスを使用して、パターンを設定する
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	 this.date = sdf.format(cl.getTime());
	}

	//メソッド
	/**
	 * 会議室予約情報で会議室をキャンセルします。
	 *
	 * @param reservation 会議室予約情報
	 * @throws Exception キャンセルできない場合に例外を投げます。
	 * <ul>
	 *   <li>キャンセル済みの場合: "既にキャンセルされています"</li>
	 *   <li>現在時刻が予約時間を過ぎている場合: "時刻が過ぎているためキャンセルできません"</li>
	 * </ul>
	 */
	public void cancel(ReservationBean reservation) throws Exception {
		//予約情報が入っているかの確認
		if (reservation == null) {
			throw new Exception("キャンセルする予約情報がありません");
		}
		// 現在日時を取得
		LocalDateTime nowTime = LocalDateTime.now();
		// 予約日時を組み立てる
		LocalDateTime reservationDateTime = LocalDateTime.parse(
				reservation.getDate() + "T" + reservation.getStart());//Tで日時と日付をくっつけている
		if (reservationDateTime.isBefore(nowTime)) {
			throw new Exception("過去の予約はキャンセルできません。");
		}
		//現在日時より予約日時が上回った場合の例外処理
				if (!(ReservationDao.delete​(reservation))) {
					throw new Exception("この予約はすでにキャンセルされています。");
				}
	}

	/**
	 * 予約日で会議室と時間帯を指定した会議室予約情報を生成します。
	 * 開始時刻を基に終了時刻を自動で設定します。
	 *
	 * @param roomId 会議室ID
	 * @param start 利用開始時刻（HH:mm形式を想定）
	 * @return 会議室予約情報
	 */
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
	
	/**
	 * 会議室予約システムの利用日を返します。
	 *
	 * @return 利用日
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * 会議室予約システムの利用日を設定します。
	 *
	 * @param date 利用日
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 利用時間帯の開始時刻を表す配列を返します。
	 *
	 * @return 開始時刻の配列
	 */
	public static String[] getPeriod() {
		return PERIOD;
	}

	/**
	 * 会議室予約システムの利用日における予約状況を返します。
	 * 配列は会議室 × 時間帯の構成です。
	 *
	 * @return 会議室・時間帯ごとの予約状況
	 */
	public ReservationBean[][] getReservations() {
		RoomList rooms = getRooms(); // 会議室一覧
		String[] period = getPeriod(); // 時間帯一覧
		ReservationBean[][] result = new ReservationBean[rooms.size()][period.length];

		// 利用日の予約一覧を取得
		List<ReservationBean> reservationDate = ReservationDao.findByDate​(getDate());

		for (int i = 0; i < rooms.size(); i++) {
			String roomId = rooms.get(i).getId();
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

	/**
	 * 指定された会議室IDに対応する会議室を返します。
	 * 見つからない場合はnullを返します。
	 *
	 * @param roomId 会議室ID
	 * @return 対応する会議室（見つからない場合は null）
	 */
	public RoomBean getRoom(String roomId) {
		RoomList rooms = RoomDao.findAll​();
		if (rooms != null) {
			for (RoomBean room : rooms) {
				if (room.getId().equals(roomId)) {
					return room;
				}
			}
		}
		return null; // 見つからなかった場合
	}
	
	/**
	 * 会議室予約システムで利用できるすべての会議室を返します。
	 *
	 * @return 会議室の配列
	 */
	public RoomList getRooms() {
		return rooms;
	}
	
	/**
	 * 会議室予約システムにログインしている利用者を返します。
	 *
	 * @return 利用者情報
	 */
	public UserBean getUser() {
		return user;
	}

	/**
	 * 会議室予約システムにログインします。
	 *
	 * @param id 利用者ID
	 * @param password パスワード
	 * @return ログイン成功時はtrue、失敗時はfalse
	 */
	public boolean login(String id, String password) {
		this.user = UserDao.certificate​(id, password);
		if (user != null) {
			return true;
		}
		return false;
	}

	/**
	 * 会議室予約情報をもとに、会議室DAOを利用して予約を登録します。
	 *
	 * @param reservation 会議室予約情報
	 * @throws Exception 予約できない場合に例外を投げます。
	 * <ul>
	 *   <li>予約済みの場合: "既に予約されています"</li>
	 *   <li>現在時刻が予約時間を過ぎている場合: "時刻が過ぎているため予約できません"</li>
	 * </ul>
	 */
	public void reserve(ReservationBean reservation) throws Exception {
	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime reservationTime = LocalDateTime.parse(
	        reservation.getDate() + "T" + reservation.getStart());

	    if (reservationTime.isBefore(now)) {
	        throw new Exception("時刻が過ぎているため予約できません");
	    }

	    boolean success = ReservationDao.insert(reservation);
	    if (success) {
	        System.out.println("予約が追加されました！");
	    } else {
	        throw new Exception("既に予約されています");
	    }
	}
	
	/**
	 * 指定された会議室IDに対応する会議室の配列添字を返します。
	 *
	 * @param roomId 会議室ID
	 * @return 配列の添字
	 * @throws IndexOutOfBoundsException 会議室が存在しない場合
	 */
	private int roomIndex(String roomId) {
		for (int i = 0; i < rooms.size(); i++) {
			if (rooms.get(i).getId().equals(roomId))  {
				return i;
			}
		}
		// 見つからなかった場合は例外を投げる
		throw new IndexOutOfBoundsException("会議室が存在しません");
	}

	/**
	 * 利用開始時刻に対応する利用時間帯の添え字を計算します。
	 *
	 * @param start 利用開始時刻（HH:mm形式を想定）
	 * @return 時間帯番号
	 * @throws IndexOutOfBoundsException 利用時間帯が範囲外の場合
	 */
	private int startPeriod(String start) {
		for (int i = 0; i < PERIOD.length; i++) {
			if (PERIOD[i].equals(start)) {
				return i;
			}
		}
		// 見つからなかった場合は例外を投げる
		throw new IndexOutOfBoundsException("指定された時刻が時間帯に存在しません: " + start);
	}
	
	/**
	 * このオブジェクトの文字列表現を返します。
	 * デバッグ用に使用されます。
	 *
	 * @return 会議室予約システムの文字列表現
	 */
	@Override
	public String toString() {
		return "利用日:" + date + "\n会議室:" + rooms + "\n利用者:" + user;
	}
}
