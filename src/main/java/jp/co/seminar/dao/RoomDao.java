package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.seminar.util.MeetingList;
import jp.co.seminar.util.MeetingroomConnectionProvider;

public class RoomDao {
	//コンストラクタ
	public RoomDao() {}
	//メソッド
	public static RoomBean[] findAll​() {
		//データベース接続
		String sql = "SELECT * FROM room WHERE id = ?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//プレースホルダーに値を設定
			pstmt.setString(1, );
			//SQL文を実行して結果を取得
			try(ResultSet rs = pstmt.executeQuery()){
				String id = rs.getString("id");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return;
}
}
