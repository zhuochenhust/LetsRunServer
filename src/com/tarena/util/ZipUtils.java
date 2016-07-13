package com.tarena.util;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.util.Enumeration;
import java.util.Vector;

import org.apache.tools.zip.ZipEntry;

import org.apache.tools.zip.ZipFile;

import org.apache.tools.zip.ZipOutputStream;


/**
 * 
 * ���ܣ� 1 ��ʵ�ְ�ָ���ļ����µ������ļ�ѹ��Ϊָ���ļ�����ָ�� zip �ļ� 2 ��ʵ�ְ�ָ���ļ����µ� zip �ļ���ѹ��ָ��Ŀ¼��
 * 
 * 
 * 
 * @author ffshi
 * 
 * 
 */

public class ZipUtils {

	public static void main(String[] args) {

		// �� E ��������ʽ�ļ����µ������ļ�ѹ���� E �� stu Ŀ¼�£�ѹ������ļ�������Ϊ ������ʽ .zip

		// zip ("E:// ������ʽ ", "E://stu // ������ʽ .zip ");

		// �� E �� stu Ŀ¼�µ�������ʽ .zip ѹ���ļ��ڵ������ļ���ѹ�� E �� stu Ŀ¼����

		Vector fileNames = (new ZipUtils()).unZip("c://1.zip", "c://stu");
		for (int i = 0; i < fileNames.size(); i++) {
			System.out.println(fileNames.get(i));
		}

	}

	/**
	 * 
	 * ���ܣ��� sourceDir Ŀ¼�µ������ļ����� zip ��ʽ��ѹ��������Ϊָ�� zip �ļ� create date:2009- 6- 9
	 * 
	 * author:Administrator
	 * 
	 * 
	 * 
	 * @param sourceDir
	 * 
	 *            E:// �ҵı���
	 * 
	 * @param zipFile
	 * 
	 *            ��ʽ�� E://stu //zipFile.zip ע�⣺���� zipFile ���Ǵ�����ַ���ֵ��
	 * 
	 *            �� "E://stu //" ���� "E://stu "
	 * 
	 *            ��� E ���Ѿ����� stu ����ļ��еĻ�����ô�ͻ���� java.io.FileNotFoundException:
	 *            E:/stu
	 * 
	 *            ( �ܾ����ʡ� ) ����쳣������Ҫע����ȷ���ε��ñ�����Ŷ
	 * 
	 * 
	 */

	public static void zip(String sourceDir, String zipFile) {

		OutputStream os;

		try {

			os = new FileOutputStream(zipFile);

			BufferedOutputStream bos = new BufferedOutputStream(os);

			ZipOutputStream zos = new ZipOutputStream(bos);

			File file = new File(sourceDir);

			String basePath = null;

			if (file.isDirectory()) {

				basePath = file.getPath();

			} else {

				basePath = file.getParent();

			}

			zipFile(file, basePath, zos);

			zos.closeEntry();

			zos.close();

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * 
	 * 
	 * create date:2009- 6- 9 author:Administrator
	 * 
	 * 
	 * 
	 * @param source
	 * 
	 * @param basePath
	 * 
	 * @param zos
	 * 
	 * @throws IOException
	 */

	private static void zipFile(File source, String basePath,

	ZipOutputStream zos) {

		File[] files = new File[0];

		if (source.isDirectory()) {

			files = source.listFiles();

		} else {

			files = new File[1];

			files[0] = source;

		}

		String pathName;

		byte[] buf = new byte[1024];

		int length = 0;

		try {

			for (File file : files) {

				if (file.isDirectory()) {

					pathName = file.getPath().substring(basePath.length() + 1)

					+ "/";

					zos.putNextEntry(new ZipEntry(pathName));

					zipFile(file, basePath, zos);

				} else {

					pathName = file.getPath().substring(basePath.length() + 1);

					InputStream is = new FileInputStream(file);

					BufferedInputStream bis = new BufferedInputStream(is);

					zos.putNextEntry(new ZipEntry(pathName));

					while ((length = bis.read(buf)) > 0) {

						zos.write(buf, 0, length);

					}

					is.close();

				}

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	/**
	 * 
	 * ��ѹ zip �ļ���ע�ⲻ�ܽ�ѹ rar �ļ�Ŷ��ֻ�ܽ�ѹ zip �ļ� ��ѹ rar �ļ� ����� java.io.IOException:
	 * Negative
	 * 
	 * seek offset �쳣 create date:2009- 6- 9 author:Administrator
	 * 
	 * 
	 * 
	 * @param zipfile
	 * 
	 *            zip �ļ���ע��Ҫ�����ڵ� zip �ļ�Ŷ�������ǰ� rar ��ֱ�Ӹ�Ϊ zip ���������
	 *            java.io.IOException:
	 * 
	 *            Negative seek offset �쳣
	 * 
	 * @param destDir
	 * 
	 * @throws IOException
	 */

	public  Vector unZip(String zipfile, String destDir) {

		Vector fileNames = new Vector();
		destDir = destDir.endsWith("//") ? destDir : destDir + "//";

		byte b[] = new byte[1024];

		int length;

		ZipFile zipFile;
		String fileName;
		try {
			File file = new File(zipfile);
			zipFile = new ZipFile(file);

			Enumeration enumeration = zipFile.getEntries();

			ZipEntry zipEntry = null;

			while (enumeration.hasMoreElements()) {

				zipEntry = (ZipEntry) enumeration.nextElement();

				File loadFile = new File(destDir + zipEntry.getName());

				fileName = loadFile.getName();
	

				if (zipEntry.isDirectory()) {

					// ��ζ����Բ�Ҫ����Ϊÿ�ζ�ò�ƴ���ײ㿪ʼ������

					loadFile.mkdirs();

				} else {

					if (!loadFile.getParentFile().exists())

						loadFile.getParentFile().mkdirs();

					OutputStream outputStream = new FileOutputStream(loadFile);

					InputStream inputStream = zipFile.getInputStream(zipEntry);

					while ((length = inputStream.read(b)) > 0) {

						outputStream.write(b, 0, length);
					}

					outputStream.close();
					outputStream = null;
					inputStream.close();
					inputStream = null;

				}
				loadFile = null;
			}

			System.out.println(" �ļ���ѹ�ɹ�2 ");
			
			// jiujun 08-07
			

			
			file = null;
			zipFile.close();
			zipFile=null;
			enumeration=null;
			zipEntry=null;
			System.gc();

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}finally
		{
			
		}
		
		
		return fileNames;

	}

}
