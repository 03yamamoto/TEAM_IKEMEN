package jp.co.seminar.beans;

import java.io.Serializable;

/**
 *	会議室の情報
 *
 * <p><strong>バージョン:</strong> 1.0.1</p>
 * <p><strong>作成者:</strong> 佐藤　智喜</p>
 * <p><strong>関連項目:</strong> 直列化された形式</p>
 */
public class RoomBean implements Serializable {

	//フィールド
	/**直列化用バージョン番号*/
	private static final long serialVersionUID = 1L;
	/**会議室ID*/
	private String id;
	/**会議室名*/
	private String name;

	//コンストラクタ
	/**直列化復元時に使用します。*/
	public RoomBean() {
	}
	
	/**
	 * 会議室情報で初期化します。
	 *
	 * @param id 会議室ID
	 * @param name 会議室名
	 */
	public RoomBean(String id, String name) {
		id = id;
		name = name;
	}

	//メソッド
	/**
	 * 会議室IDを返します。
	 *
	 * @return 会議室ID
	 */
	public String getId() {
		return id;
	}
	
	//メソッド
		/**
		 * 会議室名を返します。
		 *
		 * @return 会議室名
		 */
	public String getName() {
		return name;
	}

	/**
	 * このオブジェクトの文字列表現を返します。
	 * デバッグ用に使用されます。
	 *
	 * @return 会議室の文字列表現
	 */
	@Override
	public String toString() {
		return "ID:" + id + "\n名前:" + name;

	}
}
