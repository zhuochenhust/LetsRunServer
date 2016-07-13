package com.tarena.dao.operate;

import java.sql.*;

import com.tarena.dao.conn.DBConnManager;
import com.tarena.util.Log;
import com.tarena.util.Tools;



/**
 * insert delete update
 * 
 * @author smlzhang
 * 
 */
public class Modify {
	Log logger = Log.getInstance();

	/**
	 * ������?,��ֹSqlע��,��mysql������������?
	 * 
	 * @param sql
	 * @param setParameter
	 * @return
	 */
	public int exec(String sql, SetParameter setParameter) {
		// System.out.println(sqlStr);

		int flag = -2;
		DBConnManager conn = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			conn = DBConnManager.getInstance();
			con = conn.getConnection("mssql");
			stmt = con.prepareStatement(sql);
			setParameter.set(stmt);
			int value = stmt.executeUpdate();
			flag = value;
		} catch (java.lang.Exception ex) {
			 ex.printStackTrace();
			Tools.writeException(ex);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.releaseConnection("mssql", con);
				}

			} catch (Exception e) {			
				Tools.writeException(e);
			}
		}
		return flag;
	}

	/**
	 * sql��û���û���������ݣ�����Ҫ�õ�?
	 * 
	 * @param sql
	 * @return
	 */
	public int exec(String sql) {
		// System.out.println(sqlStr);

		int flag = -2;
		DBConnManager conn = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			conn = DBConnManager.getInstance();
			con = conn.getConnection("mssql");
			stmt = con.prepareStatement(sql);
			int value = stmt.executeUpdate();
			flag = value;
		} catch (java.lang.Exception ex) {
			// ex.printStackTrace();
			Tools.writeException(ex);
			
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.releaseConnection("mssql", con);
				}

			} catch (Exception e) {
				// e.printStackTrace();
				Tools.writeException(e);
			}
		}
		return flag;
	}
}
