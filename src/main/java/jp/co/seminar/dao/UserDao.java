package jp.co.seminar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import jp.co.seminar.beans.UserBean;
import jp.co.seminar.util.MeetingroomConnectionProvider;

public class UserDao {
	//コンストラクタ
	public UserDao() {}
	//user検索メソッド
	public static UserBean certificate​(String id, String password) {
		UserBean ubean =null;
		//データベース接続
		String sql = "SELECT * FROM user WHERE id = ? AND password = ?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			System.out.println(id);
			System.out.println(password);
			//プレースホルダーに値を設定
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			//SQL文を実行して結果を取得
			try(ResultSet rs = pstmt.executeQuery()){
				rs.next();
				String idd = rs.getString("id");
				String pass = rs.getString("password");
				String name = rs.getString("name");
				String address = rs.getString("address");
				ubean = new UserBean(idd,pass,name,address);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return ubean;
}
	
	public static String maxId() throws ClassNotFoundException, SQLException{
		//データベース接続
		String sql = "SELECT MAX(id) FROM user WHERE id LIKE ?";
		//try-with-resources構文でリソースを自動的にクローズ
		try (
			Connection conn = MeetingroomConnectionProvider.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			String year = String.valueOf(LocalDate.now().getYear()).substring(2);
		//プレースホルダーに値を設定
			pstmt.setString(1, year + "%");
		//SQL文を実行して結果を取得
			try (ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					String maxId = rs.getString(1);
					int nextNumber = 1;
					if (maxId != null) {
						nextNumber = Integer.parseInt(maxId.substring(2)) + 1;
					}
					return year + String.format("%04d", nextNumber); // 例: "250001"
				}
			}
			return year + "0001"; // 初IDならこれ！
		}
	}
	
	//新規登録メソッド※追加要件
	public static boolean newuser(UserBean newuser) {
		//データベース接続
		String sql = "INSERT INTO user (id,password,name,address) VALUES ('?', '?', '?', '?')";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//プレースホルダーに値を設定
			pstmt.setString(1, newuser.getId());
			pstmt.setString(2, newuser.getPassword());
			pstmt.setString(3, newuser.getName());
			pstmt.setString(4, newuser.getAddress());
			//SQL文を実行して結果を取得
			int ret = pstmt.executeUpdate();
			return ret != 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return false;
}
	//登録情報修正メソッド※追加要件
	public static boolean updateuser(UserBean before, UserBean after) {
		//データベース接続
		String sql = "UPDATE user SET id = ?, password = ?, name = ?, address = ? WHERE id = ? AND password = ? AND name = ? AND address = ?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//プレースホルダーに値を設定
			pstmt.setString(1, after.getId());
			pstmt.setString(2, after.getPassword());
			pstmt.setString(3, after.getName());
			pstmt.setString(4, after.getAddress());
			pstmt.setString(5, before.getId());
			pstmt.setString(6, before.getPassword());
			pstmt.setString(7, before.getName());
			pstmt.setString(8, before.getAddress());
			//SQL文を実行して結果を取得
			int ret = pstmt.executeUpdate();
			return ret != 0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLに関するエラーです。");
		}
		return false;
}
	//登録情報削除メソッド※追加要件
		public static boolean deleteuser(UserBean delete) {
			//データベース接続
			String sql = "UPDATE user SET flag = 1 WHERE id = ?, password = ?, name = ?, address = ? flag = ?";
			//try-with-resources構文でリソースを自動的にクローズ
			try(
				Connection conn = MeetingroomConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				//プレースホルダーに値を設定
				pstmt.setString(1, delete.getId()+"");
				pstmt.setString(2, delete.getPassword()+"");
				pstmt.setString(3, delete.getName()+"");
				pstmt.setString(4, delete.getAddress()+"");
				pstmt.setString(5, delete.getId()+"");
				//SQL文を実行して結果を取得
				int ret = pstmt.executeUpdate();
				return ret != 0;
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