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

	//ログイン時id,pass照合メソッド
	public static UserBean certificate​(String id, String password) {
		UserBean ubean =null;
		//データベース接続
		String sql = "SELECT * FROM user WHERE id = ? AND password = ? flag = 1";
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

	//新規登録時name,pass重複確認メソッド
	public static boolean searchDuplication(String password, String name) {
		//データベース接続
		String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//プレースホルダーに値を設定
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			//SQL文を実行して結果を取得
			try(ResultSet rs = pstmt.executeQuery()){
				boolean result = rs.next();
				return result;
			}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("ドライバが見つかりません");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQLに関するエラーです。");
			}
			return false;
		
}

	//利用者IDを自動で決めるメソッド(西暦2桁+連番5桁)
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
					String maxId = rs.getString("MAX(id)");
					int nextNumber = 1;
					if (maxId != null) {
						nextNumber = Integer.parseInt(maxId.substring(2)) + 1;
					}
					return year + String.format("%05d", nextNumber); // 例: "00001"
				}
			}
			return year + "00001"; // 初IDならこれ！
		}
	}

	//新規登録メソッド※追加要件
	public static boolean newUser(UserBean newuser) {
		//データベース接続
		String sql = "INSERT INTO user (id,password,name,address,flag) VALUES (?, ?, ?, ?,1)";
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
	public static boolean updateUser(UserBean before, UserBean after) {
		//データベース接続
		String sql = "UPDATE user SET password = ?, name = ?, address = ? WHERE id AND password = ? AND name = ? AND address = ?";
		//try-with-resources構文でリソースを自動的にクローズ
		try(
			Connection conn = MeetingroomConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			//プレースホルダーに値を設定
			pstmt.setString(1, after.getPassword());
			pstmt.setString(2, after.getName());
			pstmt.setString(3, after.getAddress());
			pstmt.setString(4, before.getPassword());
			pstmt.setString(5, before.getName());
			pstmt.setString(6, before.getAddress());
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
		public static boolean deleteUser(UserBean delete) {
			//データベース接続
			String sql = "UPDATE user SET flag = 0 WHERE id = ?, password = ?, name = ?, address = ? flag = 1";
			//try-with-resources構文でリソースを自動的にクローズ
			try(
				Connection conn = MeetingroomConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				//プレースホルダーに値を設定
				pstmt.setString(1, delete.getId());
				pstmt.setString(2, delete.getPassword());
				pstmt.setString(3, delete.getName());
				pstmt.setString(4, delete.getAddress());
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