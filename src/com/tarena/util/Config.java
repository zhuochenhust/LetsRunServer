package com.tarena.util;

public class Config {
	
	public static String siteRoot="";
	//����ʱ��
	public static final String webSite="http://192.168.1.10";
	
	//���Կ�����ģ������android�ͻ���ʱʹ�ã�������ģ������android�ͻ��˱�����ipֱ�ӷ���
	//public static final String webSite="http://192.168.1.101";
	public static final String comicImageDir="upLoadComicData";
	static 
	{
		    siteRoot=(Log.class.getClassLoader().getResource("")).toString();
		    // System.out.println(siteRoot);
		    //ȥ��file:/
		     siteRoot=siteRoot.substring(6);
		     //ȥ��WEB-INF/classes/
		     
		     int length=siteRoot.length();
		     siteRoot=siteRoot.substring(0, length-"/WEB-INF/classes/".length());
// ��/�滻�� \\
		  // System.out.println(siteRoot);  
		     
		     siteRoot=  Tools.replaceString(siteRoot, "/", "\\");
	}
	

	 public static void main(String[] args)
	 {
		 System.out.println(siteRoot);
	 }
	
	 

}
