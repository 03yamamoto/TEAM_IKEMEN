package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.seminar.beans.RoomBean;
import jp.co.seminar.util.MeetingroomConnectionProvider;
import jp.co.seminar.util.RoomList;

public class RoomDao {
	//コンストラクタ
	public RoomDao() {}
	//メソッド
	public static RoomList findAll​() {
		RoomList rlist = new RoomList();
		//データベース接続
		String sql = "SELECT * FROM room";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//SQL文を実行して結果を取得
			try(ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
				RoomBean rbean = new RoomBean(	
				rs.getString("id"),
				rs.getString("name"));
				rlist.add(rbean);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return rlist;
}
}
