package com.tarena.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log {

	 private static Log singleton = null;

	 public Logger sysException;

	 public int i=0;

	 private Log()
	     throws Exception
	 {

	 	sysException=null;
	 	//ʹ�����·��
	     String path=(Log.class.getClassLoader().getResource("")).toString();
	     //System.out.println(path);
	    //ȥ��file:/
	     path=path.substring(6);
	   //  System.out.println(path);     
	     
	     path=path+"log4j.properties"; 
	    // PropertyConfigurator.configure(Config.allClassFolder+"/log4j.properties");
	     sysException = Logger.getLogger("sysException");
	   }

	 public static Log getInstance()
	 {
	 	try{
	    init();
	 	}
	 	catch(Exception e)
		{}
	 	return singleton;
	 }

	 static void init()
	     throws Exception
	 {
	     singleton = new Log();
	 }
	 
	 public static void main(String[] args) {
		System.out.print("t5");
		Log logger = Log.getInstance();
		logger.sysException.info("wap6");


	}

}
