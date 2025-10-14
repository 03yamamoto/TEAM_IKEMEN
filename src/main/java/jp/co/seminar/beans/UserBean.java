package jp.co.seminar.beans;

import java.io.Serializable;

public class UserBean implements Serializable {

	/**
	 * <br>
	 * 利用者の情報<br>
	 * 
	 * @author 佐藤　智喜
	 * @version 1.0.1
	 */
	
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
	
	public UserBean(String id, String password, String name, String address) {
		/**
		 * 利用者情報を基に初期化します。
		 *
		 * @param id 利用者ID
		 * @param password パスワード
		 * @param name 氏名
		 * @param address 住所
		 */
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
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

	//新規ユーザー登録
	/**
	 * 新規ユーザーを返します。
	 *
	 * @return 新規ユーザー
	 */
	public boolean newUser() {
		
		return newUser;
	}
	
	//デバッグ用ToString
	@Override
	public String toString() {
		return "アドレス:" + address + "\nID:" + id + "\n名前:" + name + "\nパスワード:" + password;
	}

}
