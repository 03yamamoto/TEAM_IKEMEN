package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.seminar.beans.ReservationBean;
import jp.co.seminar.util.MeetingroomConnectionProvider;

public class ReservationDao {
	//コンストラクタ
	public ReservationDao() {}
	//メソッド
	public static boolean delete​(ReservationBean reservation) {
		
	}

	public static MeetingroomList findByDate​(String date){
		MeetingroomList mList = new MeetingroomList();
		//データベース接続
		String sql = "SELECT * FROM reservation";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//SQL文を実行して結果を取得
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
				int id = rs.getInt("id");//キャスト必要
				String roomId = rs.getString("roomId");
				String date = rs.getString("date");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String userid = rs.getString("userid");
				ReservationBean rese = new ReservationBean(id,roomId,date,start,end,userid);
				mList.add(rese);
				}
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return mList;
	}

	public static boolean insert(ReservationBean reservation) {
		//データベース接続
		String sql = "INSERT INTO reservation";
		//try-with-resources構文でリソースを自動的にクローズ
		try(Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//SQL文を実行して結果を取得
			int ret=pstmt.executeUpdate();	
			return ret!=0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return false;
	}

}

