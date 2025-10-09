package jp.co.seminar.dao;

import java.sql.Connection;

import jp.co.seminar.beans.UserBean;

public class UserDao {
	//コンストラクタ
	public UserDao() {}
	//メソッド
	public static UserBean certificate​(String id, String password) {
		//データベース接続
		String sql = "SELECT id,password FROM user WHERE id = ?, passwprd = ?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = DictionaryConnectionProvider.getConnection();
				){}
	
	}

}
