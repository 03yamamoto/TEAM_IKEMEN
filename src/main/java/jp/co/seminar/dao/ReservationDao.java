package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.co.seminar.beans.ReservationBean;
import jp.co.seminar.util.MeetingroomConnectionProvider;
import jp.co.seminar.util.ReservationList;

public class ReservationDao {
	//コンストラクタ
	public ReservationDao() {}
	//メソッド
	public static boolean delete​(ReservationBean reservation) {
		//データベース接続
		String sql = "UPDATE reservation SET flag=0 WHERE id=?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//パラメータクエリの設定
			pstmt.setString(1, reservation.getId()+"");
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

	public static ReservationList findByDate​(String date){
		ReservationList mList = new ReservationList();
		//データベース接続
		String sql = "SELECT * FROM reservation WHERE date=?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//パラメータクエリの設定
			pstmt.setString(1, date);
			//SQL文を実行して結果を取得
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
				int id = rs.getInt("id");
				String roomId = rs.getString("roomId");
				String datee = rs.getString("date");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String userid = rs.getString("userid");
				ReservationBean rese = new ReservationBean(id,roomId,datee,start,end,userid);
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
		String sql = "INSERT INTO reservation (roomId,date,start,end,userId,flag) VALUES (?,?,?,?,?,1)";
		//try-with-resources構文でリソースを自動的にクローズ
		try(Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//パラメータクエリの設定
			pstmt.setString(1, reservation.getRoomId());
			pstmt.setString(2, reservation.getDate());
			pstmt.setString(3, reservation.getStart());
			pstmt.setString(4, reservation.getEnd());
			pstmt.setString(5, reservation.getUserId());
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

