package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.seminar.util.MeetingroomConnectionProvider;

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
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//プレースホルダーに値を設定
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			//SQL文を実行して結果を取得
			try(ResultSet rs = pstmt.executeQuery()){
				String idd = rs.getString("id");
				String pass = rs.getString("password");
				UserBean uBean = new UserBean(idd,password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return uBean;
}
}