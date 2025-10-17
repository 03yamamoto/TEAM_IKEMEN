package jp.co.seminar.beans;

import java.io.Serializable;
import java.sql.SQLException;

import jp.co.seminar.dao.UserDao;

/**
 * 利用者の情報を管理するクラスです。
 *
 * <p><strong>バージョン:</strong> 1.0.1</p>
 * <p><strong>作成者:</strong> 佐藤　智喜</p>
 * <p><strong>関連項目:</strong> 直列化された形式</p>
 */
public class UserBean implements Serializable {

	//フィールド
	/**直列化用バージョン番号*/
	private static final long serialVersionUID = 1L;
	/**利用者住所*/
	private String address;
	/**利用者ID*/
	private String id;
	/**氏名*/
	private String name;
	/**パスワード*/
	private String password;

	//コンストラクタ
	/**直列化復元時に使用します*/
	public UserBean() {
	}

	/**
	 * 利用者情報を基に初期化します。
	 *
	 * @param id 利用者ID
	 * @param password パスワード
	 * @param name 氏名
	 * @param address 住所
	 */
	public UserBean(String id, String password, String name, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	/**
	 * 新規ユーザーの情報を初期化します。
	 *
	 * @param id 利用者ID
	 * @param password パスワード
	 * @param name 氏名
	 * @param address 住所
	 * @throws SQLException SQLエラーが出た場合に例外を表示します
	 */
	public UserBean(String password, String name, String address) throws SQLException, ClassNotFoundException {
	    this.password = password;
	    this.name = name;
	    this.address = address;
	    this.id = UserDao.maxId(); // 例外が発生する可能性あり！
	}

	//メソッド
	/**
	 * 住所を返します。
	 *
	 * @return 住所
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 利用者IDを返します。
	 *
	 * @return 利用者ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 氏名を返します。
	 *
	 * @return 氏名
	 */
	public String getName() {
		return name;
	}

	/**
	 * パスワードを返します。
	 *
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ユーザー情報をもとに新規ユーザーを登録します。
	 * <p>
	 * このメソッドは、IDとパスワードが一致する既存ユーザーが
	 * データベースに存在するかを確認し、存在しない場合のみ新規登録を行います。
	 * </p>
	 *
	 * @return 登録に成功した場合はtrue、重複またはエラーが発生した場合はfalse
	 */
	public boolean beenNewUser() {
		UserBean beenFieldNewUser = new UserBean(this.id, this.password, this.name, this.address);

		try {
			// 重複チェック（IDとパスワードが一致するユーザーがいるか）
			boolean exists = UserDao.seachDuplication(beenFieldNewUser.getId(), beenFieldNewUser.getPassword());
			if (exists) {
				System.out.println("同じIDとパスワードのユーザーがすでに存在します！");
				return false;
			}

			// 新規登録
			boolean result = UserDao.newUser(beenFieldNewUser);
			return true;

		} catch (SQLException e) {
			System.out.println("ユーザー登録中にエラーが発生しました");
			e.printStackTrace();
			return false;
		}
	}

	//デバッグ用ToString
	/**
	 * このオブジェクトの文字列表現を返します。
	 * デバック用
	 *
	 * @return 利用者の文字列表現
	 */
	@Override
	public String toString() {
		return "アドレス:" + address + "\nID:" + id + "\n名前:" + name + "\nパスワード:" + password;
	}

}
