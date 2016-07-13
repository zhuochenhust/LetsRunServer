package com.tarena.dao.conn;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.tarena.util.Log;



/*���ӳع�����,���Թ��������ݿ����ӳ�*/
public class DBConnManager {
	Log logger = Log.getInstance();
	//���ӳ����б�
	private Vector poolnames = new Vector();
	//�����������б�
	private Vector drivernames = new Vector();
	//���ݿ��ʶ�б�
	private Vector dbids = new Vector();
	//�û����б�
	private Vector usernames = new Vector();
	//�����б�
	private Vector passwds = new Vector();
	//����������б�
	private Vector maxconns = new Vector();
	//���ӳض���
	private static Hashtable connPools = new Hashtable();
	
	static DBConnManager instance; 
	
	public DBConnManager() {
		try{
			InputStream is = getClass().getResourceAsStream("/db.properties");
			Properties pro = new Properties();
			pro.load(is);
		//���mysql���ݿ��������Ϣ
		poolnames.addElement("mssql");
		drivernames.addElement(pro.getProperty("drivers"));
		dbids.addElement(pro.getProperty("dbids"));
		usernames.addElement(pro.getProperty("user"));
		passwds.addElement(pro.getProperty("password"));
		maxconns.addElement(pro.getProperty("maxconns"));
		}catch(Exception e){
			//System.out.print(e);
			logger.sysException.info("",e);
		}
		
		
		//�������ӳ�
		createPools();
	}
	
	/*�����ӷ��ظ���ָ�������ӳ�*/
	public   void releaseConnection(String name, Connection con) {
		DBConnPool pool = (DBConnPool) connPools.get(name);
		if (pool != null)
			pool.releaseConnection(con);
	}
	
	/*�õ�һ��ָ�����ӳ��е�����*/
	public  Connection getConnection(String name) {
		DBConnPool pool = (DBConnPool) connPools.get(name);
		if (pool != null)
			return pool.getConnection();
		return null;
	}
	
	/*�ر���������*/
	public synchronized void closeConns() {
		Enumeration allPools = connPools.elements();
		while (allPools.hasMoreElements()) {
			DBConnPool pool = (DBConnPool) allPools.nextElement();
			pool.closeConn();
		}
	}
	
	/*�������ӳ�*/
	private void createPools() {
		for(int i = 0; i<poolnames.size();i++){
			String poolname = poolnames.elementAt(i).toString();
			String drivername = drivernames.elementAt(i).toString();
			String dbid = dbids.elementAt(i).toString();
			String username = usernames.elementAt(i).toString();
			String passwd = passwds.elementAt(i).toString();
			int maxconn=0;
			try {
				maxconn = Integer.parseInt(maxconns.elementAt(i).toString());
			}
			catch (NumberFormatException e) {
				//e.printStackTrace();
				logger.sysException.info("",e);
			}
			DBConnPool pool = new DBConnPool(poolname, drivername, dbid, username, passwd, maxconn);
			connPools.put(poolname, pool);
		}
	}
	public static int getLinkNum(String name) {
		DBConnPool pool = (DBConnPool) connPools.get(name);
		return pool.getInUse();
	}
	
	static synchronized public DBConnManager getInstance() {
		if (instance == null) {                                         //�жϱ���ľ�̬ʵ�������Ƿ���ֵ
		  instance = new DBConnManager();                         //û�У�����һ�������ʵ��
		}
		return instance;                                                //���ر����ʵ������
	  }

}

