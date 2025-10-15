package jp.co.seminar.beans;

import java.io.Serializable;

/**
 * 会議室予約情報
 *
 * <p><strong>バージョン:</strong> 1.0.1</p>
 * <p><strong>作成者:</strong> 佐藤　智喜</p>
 * <p><strong>関連項目:</strong> 直列化された形式</p>
 */
public class ReservationBean implements Serializable {

	//フィールド
	/**直列化用バージョン番号*/
	private static final long serialVersionUID = 1L;
	/**利用日*/
	private String date;
	/**利用終了時刻*/
	private String end;
	/**予約番号*/
	private int id;
	/**会議室ID*/
	private String roomId;
	/**利用開始時刻*/
	private String start;
	/**利用者ID*/
	private String userId;

	//コンストラクタ
	/**直列化復元時に使用します。*/
	public ReservationBean() {
	}

	/**
	 * 会議室予約情報を基に初期化します。
	 *
	 * @param id 予約番号
	 * @param roomId 会議室ID
	 * @param start 利用開始時刻
	 * @param end 利用終了時刻
	 * @param userId 利用者ID
	 */
	public ReservationBean(int id, String roomId, String date, String start, String end, String userId) {
		this.id = id;
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}

	/**
	 * 予約番号以外の会議室予約情報を基に初期化します。予約番号は0となります。
	 *
	 * @param roomId 会議室ID
	 * @param date 利用日
	 * @param start 利用開始時刻
	 * @param end 利用終了時刻
	 * @param userId 利用者ID
	 */
	public ReservationBean(String roomId, String date, String start, String end, String userId) {
		this.roomId = roomId;
		this.date = date;
		this.start = start;
		this.end = end;
		this.userId = userId;
	}

	//メソッド
	/**
	 * 利用者IDを返します。
	 *
	 * @return 利用者ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 予約番号を設定します。
	 *
	 * @param id 予約番号
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 利用日取得
	 * 利用日を返します。
	 * 
	 * @return 利用日
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 利用終了時刻を返します。
	 * 
	 * @return 利用終了時刻
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * 予約番号を返します。
	 * 
	 * @return 予約番号
	 */
	public int getId() {
		return id;
	}

	/**
	 * 会議室IDを返します。
	 * 
	 * @return 会議室ID
	 */
	public String getRoomId() {
		return roomId;
	}

	/**
	 * 利用開始時刻取得
	 * 利用開始時刻を返します。
	 * 
	 * @return 利用開始時刻
	 */
	public String getStart() {
		return start;
	}

	/**
	 * このオブジェクトの文字列表現を返します。
	 * デバッグ用に使用されます。
	 *
	 * @return 会議室予約の文字列表現
	 */
	@Override
	public String toString() {
		return "利用日:" + date + "\n利用終了時刻:" + end + "\n予約番号:" + id + "\n会議室ID:" + roomId + "\n利用開始時刻:" + start
				+ "\n利用者ID:" + userId;

	}
}
