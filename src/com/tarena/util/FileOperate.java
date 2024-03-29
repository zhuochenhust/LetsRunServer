package com.tarena.util;
import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Vector;

public class FileOperate {
   private String message;
	Log logger = Log.getInstance();
   public FileOperate() {
   }
   public static void main(String[] args) {
   	FileOperate op=new FileOperate();
   String content="中国防大学修改";
  // content=Tools.viewToUTF8(content);
   	try
	{
   
   		//String file="c:\\12.txt";
//   		
//   		String ChapterDir = "c://1";
//		String zipPath = "c://1//12.zip";;
//		Vector fileNames = ZipUtils.unZip(zipPath, ChapterDir);
//   		String file="c:\\1";
//   		
//   		FileOperate o=new FileOperate();
//   		//o.delFile(file);
//   		o.delFolder(file);
//   		System.out.println("ok");
   		
   		
		//String file="D:\\JBossWeb\\webapps\\wwwMobiBobCom\\upLoadComicData\\75\\9";
   		//String file="c:\\12.zip";//能删除
   	String file="D:\\JBossWeb\\webapps\\wwwMobiBobCom\\upLoadComicData\\75\\16\\12.zip";//能删除
		FileOperate o=new FileOperate();
		//o.delFile(file);
		o.delFolder(file);
		System.out.println("ok");
   		System.out.println(File.separator);
	} catch(Exception e)
	{
		
	}	
}
   
   /**
    * 读取一个文件夹下的所有文件名
    * @param path 带有完整绝对路径的文件夹名   
    * @return 返回List 文件名的
    */
   public void reName(String Path,String lang) {
   	
    try {       
        File a=new File(Path);
        String[] file=a.list();      
        File temp=null;
        String filename=null;
        for (int i = 0; i < file.length; i++) {          
           if(Path.endsWith(File.separator)){
           		temp=new File(Path+file[i]);
	        }else{
	            temp=new File(Path+File.separator+file[i]);
	        }
           if (temp.isFile()){
	           filename=(temp.getName()).toString();
	           String[] fileNames=filename.split("\\.");
	           String basename=fileNames[0];
	           String extName=fileNames[1];
	          
	           String newname=basename+"_"+lang+"."+extName;
	           System.out.println(newname);
	           temp.renameTo(new File(Path+newname));  
	          
	          
           	}
           }
      
    }catch (Exception e) {
    	logger.sysException.info("",e);
    }

}

   
   /**
    * 向一个文件以以字符集UTF-8写内容，
    * @param filePathAndName 文本文件完整绝对路径及文件名
    * @param fileContent 文本文件内容
    * @return true  成功  false  失败
    */
   public boolean WriteFileByte(String filePathAndName, String fileContent) {
    boolean r=false;
   
   //int l=b.l
    try{
    	
    	FileOutputStream fs = new FileOutputStream(filePathAndName);     
    	     try{		     
		     	byte [] byteBuffer = fileContent.getBytes("UTF-8");				
		     	fs.write(byteBuffer, 0, byteBuffer.length);		     
		     	r=true;	
		     	fs.close();
		     }catch(Exception e){
		     	logger.sysException.info("",e);
		     }	
   		
		   }catch(IOException es){
		   	logger.sysException.info("",es);
		    }
		
    return r;     
   }

   /**
    * 向一个文件以指定字符集编码写内容，
    * @param filePathAndName 文本文件完整绝对路径及文件名
    * @param fileContent 文本文件内容
    * @param encoding  字符集
    * @return
    */
   public boolean WriteFile_bak(String filePathAndName, String fileContent,String encoding) {
    boolean r=false;
   	encoding = encoding.trim();
    StringBuffer str = new StringBuffer("");
    String st = "";
   
   //int l=b.l
    try{
    	
    	FileOutputStream fs = new FileOutputStream(filePathAndName);     
    	OutputStreamWriter osr;
	     if(encoding.equals("")){
	      osr = new OutputStreamWriter(fs);
	     }else{
	      osr = new OutputStreamWriter(fs,encoding);
	     }
	     BufferedWriter wr = new BufferedWriter(osr);
		     try{
		     	
		     
		     	byte [] byteBuffer = fileContent.getBytes("UTF-8");
				//ois.write(byteBuffer, 0, byteBuffer.length);
		     	fs.write(byteBuffer, 0, byteBuffer.length);
		     	//wr.wr
		     	r=true;
		     	wr.flush();
		     	wr.close();
		     }catch(Exception e){
		     	logger.sysException.info("",e);
		     }	
   		
		   }catch(IOException es){
		   	logger.sysException.info("",es);
		    }
		
    return r;     
   }

   /**
    * 读出内容，加上上换行符号
    * @param filePathAndName
    * @param encoding
    * @return
    * @throws IOException
    */
   public String readTxtLine(String filePathAndName,String encoding) throws IOException{
    encoding = encoding.trim();
    StringBuffer str = new StringBuffer("");
    String st = "";
    FileInputStream fs=null;
    try{
      fs= new FileInputStream(filePathAndName);
     InputStreamReader isr;
     if(encoding.equals("")){
      isr = new InputStreamReader(fs);
     }else{
      isr = new InputStreamReader(fs,encoding);
     }
     BufferedReader br = new BufferedReader(isr);
     try{
      String data = "";
      while((data = br.readLine())!=null){
        //str.append(data+"\r\n"); 
      	str.append(data+"\n");       
      }
     }catch(Exception e){
      str.append(e.toString());
     }
     st = str.toString();
    }catch(IOException es){
     st = "";
    }
    fs.close();
    return st;     
   }


   
   /**
    * 读取一个文件夹下的所有文件名
    * @param path 带有完整绝对路径的文件夹名   
    * @return 返回List 文件名的
    */
   public ArrayList getfiles(String Path) {
   	ArrayList list=new ArrayList();
    try {
       
        File a=new File(Path);
        String[] file=a.list();
       // System.out.println(file.length);
        File temp=null;
        String filename=null;
        for (int i = 0; i < file.length; i++) {
          
           if(Path.endsWith(File.separator)){
           		temp=new File(Path+file[i]);
	        }else{
	            temp=new File(Path+File.separator+file[i]);
	        }
           if (temp.isFile()){
	           filename=(temp.getName()).toString();
	           System.out.println(filename);
	           list.add(filename);
	          
           	}
           }
      
    }catch (Exception e) {
    	logger.sysException.info("",e);
    }
    return list;
}
   
   /**
    * 读取文本文件内容
    * @param filePathAndName 带有完整绝对路径的文件名
    * @param encoding 文本文件打开的编码方式
    * @return 返回文本文件的内容
    */
   public String readTxt(String filePathAndName,String encoding) throws IOException{
    encoding = encoding.trim();
    StringBuffer str = new StringBuffer("");
    String st = "";
    try{
     FileInputStream fs = new FileInputStream(filePathAndName);
     InputStreamReader isr;
     if(encoding.equals("")){
      isr = new InputStreamReader(fs);
     }else{
      isr = new InputStreamReader(fs,encoding);
     }
     BufferedReader br = new BufferedReader(isr);
     try{
      String data = "";
      while((data = br.readLine())!=null){
        str.append(data+" "); 
      }
     }catch(Exception e){
      str.append(e.toString());
     }
     st = str.toString();
    }catch(IOException es){
     st = "";
    }
    return st;     
   }

   /**
    * 新建目录
    * @param folderPath 目录
    * @return 返回目录创建后的路径
    */
   public String createFolder(String folderPath) {
       String txt = folderPath;
       try {
           java.io.File myFilePath = new java.io.File(txt);
           txt = folderPath;
           if (!myFilePath.exists()) {
               myFilePath.mkdir();
           }
       }
       catch (Exception e) {
       	logger.sysException.info("",e);
       }
       return txt;
   }
   
   /**
    * 多级目录创建
    * @param folderPath 准备要在本级目录下创建新目录的目录路径 例如 c:myf
    * @param paths 无限级目录参数，各级目录以单数线区分 例如 a|b|c
    * @return 返回创建文件后的路径 例如 c:myfac
    */
   public String createFolders(String folderPath, String paths){
       String txts = folderPath;
       try{
           String txt;
           txts = folderPath;
           StringTokenizer st = new StringTokenizer(paths,"|");
           for(int i=0; st.hasMoreTokens(); i++){
                   txt = st.nextToken().trim();
                   if(txts.lastIndexOf("/")!=-1){ 
                       txts = createFolder(txts+txt);
                   }else{
                       txts = createFolder(txts+txt+"/");    
                   }
           }
      }catch(Exception e){
      	logger.sysException.info("",e);
      }
       return txts;
   }

   
   /**
    * 新建文件
    * @param filePathAndName 文本文件完整绝对路径及文件名
    * @param fileContent 文本文件内容
    * @return
    */
   public void createFile(String filePathAndName, String fileContent) {
    
       try {
           String filePath = filePathAndName;
           filePath = filePath.toString();
           File myFilePath = new File(filePath);
           if (!myFilePath.exists()) {
               myFilePath.createNewFile();
           }
           FileWriter resultFile = new FileWriter(myFilePath);
           PrintWriter myFile = new PrintWriter(resultFile);
           String strContent = fileContent;
           myFile.println(strContent);
           myFile.close();
           resultFile.close();
       }
       catch (Exception e) {
       	logger.sysException.info("",e);
       }
   }


   /**
    * 有编码方式的文件创建
    * @param filePathAndName 文本文件完整绝对路径及文件名
    * @param fileContent 文本文件内容
    * @param encoding 编码方式 例如 GBK 或者 UTF-8
    * @return
    */
  /* public void createFile(String filePathAndName, String fileContent, String encoding) {
    
       try {
           String filePath = filePathAndName;
           filePath = filePath.toString();
           File myFilePath = new File(filePath);
           if (!myFilePath.exists()) {
               myFilePath.createNewFile();
           }
           PrintWriter myFile = new PrintWriter(myFilePath,encoding);
           String strContent = fileContent;
           myFile.println(strContent);
           myFile.close();
       }
       catch (Exception e) {
           message = "创建文件操作出错";
       }
   } 
*/

   /**
    * 删除文件
    * @param filePathAndName 文本文件完整绝对路径及文件名
    * @return Boolean 成功删除返回true遭遇异常返回false
    */
   public boolean delFile(String filePathAndName) {
    boolean bea = false;
       try {
           String filePath = filePathAndName;
           File myDelFile = new File(filePath);
           if(myDelFile.exists()){
            myDelFile.delete();
            bea = true;
           }else{
            bea = false;
            message = (filePathAndName+"<br>删除文件操作出错");
           }
       }
       catch (Exception e) {
       	logger.sysException.info("",e);
       }
       return bea;
   }
   


   /**
    * 删除文件夹 必须是c:\\1 不能是c:\
    * @param folderPath 文件夹完整绝对路径
    * @return
    */
   public void delFolder(String folderPath) {
       try {
           delAllFile(folderPath); //删除完里面所有内容
           String filePath = folderPath;
           filePath = filePath.toString();
           java.io.File myFilePath = new java.io.File(filePath);
           myFilePath.delete(); //删除空文件夹
       }
       catch (Exception e) {
       	logger.sysException.info("",e);
       }
   }
   
   
   /**
    * 删除指定文件夹下所有文件
    * @param path 文件夹完整绝对路径
    * @return
    * @return
    */
   public boolean delAllFile(String path) {
    boolean bea = false;
       File file = new File(path);
       if (!file.exists()) {
           return bea;
       }
       if (!file.isDirectory()) {
           return bea;
       }
       String[] tempList = file.list();
       File temp = null;
       for (int i = 0; i < tempList.length; i++) {
           if (path.endsWith(File.separator)) {
               temp = new File(path + tempList[i]);
           }else{
               temp = new File(path + File.separator + tempList[i]);
           }
           if (temp.isFile()) {
               temp.delete();
           }
           if (temp.isDirectory()) {
               delAllFile(path+"/"+ tempList[i]);//先删除文件夹里面的文件
               delFolder(path+"/"+ tempList[i]);//再删除空文件夹
               bea = true;
           }
       }
       return bea;
   }


   /**
    * 复制单个文件
    * @param oldPathFile 准备复制的文件源
    * @param newPathFile 拷贝到新绝对路径带文件名
    * @return
    */
   public void copyFile(String oldPathFile, String newPathFile) {
       try {
           int bytesum = 0;
           int byteread = 0;
           File oldfile = new File(oldPathFile);
           if (oldfile.exists()) { //文件存在时
               InputStream inStream = new FileInputStream(oldPathFile); //读入原文件
               FileOutputStream fs = new FileOutputStream(newPathFile);
               byte[] buffer = new byte[1444];
               while((byteread = inStream.read(buffer)) != -1){
                   bytesum += byteread; //字节数 文件大小
                   System.out.println(bytesum);
                   fs.write(buffer, 0, byteread);
               }
               inStream.close();
           }
       }catch (Exception e) {
       	logger.sysException.info("",e);
       }
   }
   

   /**
    * 复制整个文件夹的内容
    * @param oldPath 准备拷贝的目录
    * @param newPath 指定绝对路径的新目录
    * @return
    */
   public void copyFolder(String oldPath, String newPath) {
       try {
           new File(newPath).mkdirs(); //如果文件夹不存在 则建立新文件夹
           File a=new File(oldPath);
           String[] file=a.list();
           File temp=null;
           for (int i = 0; i < file.length; i++) {
               if(oldPath.endsWith(File.separator)){
                   temp=new File(oldPath+file[i]);
               }else{
                   temp=new File(oldPath+File.separator+file[i]);
               }
               if(temp.isFile()){
                   FileInputStream input = new FileInputStream(temp);
                   FileOutputStream output = new FileOutputStream(newPath + "/" +
                   (temp.getName()).toString());
                   byte[] b = new byte[1024 * 5];
                   int len;
                   while ((len = input.read(b)) != -1) {
                       output.write(b, 0, len);
                   }
                   output.flush();
                   output.close();
                   input.close();
               }
               if(temp.isDirectory()){//如果是子文件夹
                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]);
               }
           }
       }catch (Exception e) {
       	logger.sysException.info("",e);
       }
   }


   /**
    * 移动文件
    * @param oldPath
    * @param newPath
    * @return
    */
   public void moveFile(String oldPath, String newPath) {
       copyFile(oldPath, newPath);
       delFile(oldPath);
   }
   

   /**
    * 移动目录
    * @param oldPath
    * @param newPath
    * @return
    */
   public void moveFolder(String oldPath, String newPath) {
       copyFolder(oldPath, newPath);
       delFolder(oldPath);
   }
   public String getMessage(){
       return this.message;
   }
}

