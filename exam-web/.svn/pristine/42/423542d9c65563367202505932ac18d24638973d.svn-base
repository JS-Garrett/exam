package org.hnjk.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 提供一些文件操作方法. <p>
 * 
 * @author： hzg ,广州华南教育科技发展有限公司.
 * @since： 2009-2-25下午05:56:40
 * @version 1.0
 */
public class FileUtil {

	/**文件路径分隔符*/
	public final static String FILE_SEPARATOR = java.io.File.separator;
	/**1kb*/
	public static long ONE_KB = 1024;
	/**1MB*/
	public static long ONE_MB = ONE_KB * 1024;
	/**1GB*/
	public static long ONE_GB = ONE_MB * 1024;
	/**1TB*/
	public static long ONE_TB = ONE_GB * (long) 1024;
	/**1PB*/
	public static long ONE_PB = ONE_TB * (long) 1024;

	/**
	 * 读取文件内容.
	 * @param name 文件路径.
	 * @return  文件文本内容
	 * @throws IOException
	 */
	public static String readFile(String name) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader in = new BufferedReader(new FileReader(name));
		String s;
		while ((s = in.readLine()) != null) {
			sb.append(s);
			sb.append("\n");
		}
		in.close();
		return sb.toString();
	}
	
	/**
	 * 指定文件编码读取文件内容.
	 * @param filePath  文件路径
	 * @param fileCode  文件编码
	 * @return
	 * @throws IOException 
	 */
	public static String readFile(String filePath,String fileCode) throws IOException{
		
		StringBuffer content 	   = new StringBuffer();
		InputStreamReader isr      = null; 
		BufferedReader bfr         = null;
		
		try {
			File statementFile	   = new File(filePath);
			isr 				   = new InputStreamReader(new FileInputStream(statementFile),fileCode); 
			if(statementFile.isFile()&&statementFile.exists()){
				bfr                = new BufferedReader(isr); 
				String line ;
				while ((line = bfr.readLine()) != null)  content.append(line); 
			}   
		} catch (IOException e) {
			throw new IOException("读取文件出错:"+e.fillInStackTrace());
		}finally{
			try {
				if (null!=bfr) bfr.close();
				if (null!=isr) isr.close(); 
			} catch (IOException e) {
				throw new IOException("读取文件后，关闭流出错:"+e.fillInStackTrace());
			} 
		}
		return content.toString();
	}
	/**
	 * 读取文件内容.
	 * @param file 文件对象
	 * @return 文件字节数组.
	 * @throws IOException
	 * @see #readFileStream(InputStream in)
	 */
	public static byte[] readFile(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		return readFileStream(in);
	}

	/**
	 * 读取文件流内容.
	 * @param in 文件输入流.
	 * @return 文件内容.
	 * @throws IOException
	 */
	public static byte[] readFileStream(InputStream in) throws IOException {
		int size = in.available();
		byte[] bytes = new byte[size];
		// 读取文件
		int offset = 0;
		int numRead = 0;
		while (offset < size) {
			numRead = in.read(bytes, offset, size - offset);
			if (numRead >= 0) {
				offset += numRead;
			} else {
				break;
			}
		}
		in.close();
		// 确认所有的文件已读入.
		if (offset < bytes.length) {
			throw new IOException("Could not read requested " + size + " bytes from input stream");
		}
		return bytes;
	}

	/**
	 * 写文件.
	 * 对文件写入新的内容writemod的方式有2种
	   1：如果文件存在，新的内容追加到文件。否则创建一个新文件
	   2: 如果文件存在，覆盖旧文件的内容。否则创建一个新文件  
	 * @param fileName 文件路径
	 * @param strInputContent 文件内容
	 * @param writemod 写入方式：1 - 追加 2 - 覆盖
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFile(String fileName, String strInputContent, int writemod) throws IOException {
		
		BufferedWriter writer    = null;
		
		try {
			
			StringBuffer content = new StringBuffer();
			File fso = new File(fileName);
			if(!fso.exists()){
				fso.createNewFile();
			}
			writer = new BufferedWriter(new FileWriter(fso));

			switch (writemod) {
			case 1: //最加新的内容到文件              
				String oldContent = readFile(fileName); //先读取原文件内容.
				content.append(oldContent + "\n" + strInputContent);
				break;
			case 2: //新内容覆盖旧文件的内容
				content.append(strInputContent);
				break;
			default:
				content.append(strInputContent);
				break;
			}
			writer.write(content.toString());
		} catch (IOException e) {
			throw new IOException("文件写入出错:"+e.fillInStackTrace());
		}finally{
			if (null!=writer) writer.close();
		}

		return true;

	}

	/**
	 * 创建单个文件夹.
	 * @param folderPath 文件夹路径.
	 * @return
	 * @throws IOException
	 */
	public static String createFolder(String folderPath) throws IOException {
		String txt = folderPath;
		java.io.File myFilePath = new java.io.File(txt);
		txt = folderPath;
		if (!myFilePath.exists()) {
			myFilePath.mkdirs();
		}

		return txt;
	}

	/**
	 * 创建多级文件夹.
	 * @param folderPath  准备要在本级目录下创建新目录的目录路径 例如 c:\myf
	 * @param paths 无限级目录参数，各级目录以单数线区分 例如 a|b|c ,执行完成后为c:\myf\a\b\c
	 * @return 创建后的完整路径
	 * @throws IOException
	 */
	public static String createFolders(String folderPath, String paths) throws IOException {
		String txts = folderPath;
		String txt;
		txts = folderPath;
		StringTokenizer st = new StringTokenizer(paths, "|");
		for (int i = 0; st.hasMoreTokens(); i++) {
			txt = st.nextToken().trim();
			txts = createFolder(txts + FILE_SEPARATOR + txt);
		}

		return txts;
	}

	/**
	 * 创建一个新文件.
	 * @param filePathAndName  文件完整绝对路径及文件名
	 * @param fileContent	文件内容
	 * @throws IOException
	 */
	public static void createFile(String filePathAndName, String fileContent) throws IOException {
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

	/**
	 * 创建一个含编码格式的文件.
	 * @param filePathAndName  文件完整绝对路径及文件名
	 * @param fileContent 文件内容
	 * @param encoding 文件编码格式,如GB2312,UTF-8
	 * @throws IOException
	 */
	public static void createFile(String filePathAndName, String fileContent, String encoding) throws IOException {
		String filePath = filePathAndName;
		filePath = filePath.toString();
		File myFilePath = new File(filePath);
		if (!myFilePath.exists()) {
			myFilePath.createNewFile();
		}
		PrintWriter myFile = new PrintWriter(myFilePath, encoding);
		String strContent = fileContent;
		myFile.println(strContent);
		myFile.close();
	}

	/**
	 * 删除一个文件.
	 * @param filePathAndName 文件完整绝对路径及文件名	
	 * @throws IOException
	 */
	public static void delFile(String filePathAndName) throws IOException {
		String filePath = filePathAndName;
		File myDelFile = new File(filePath);
		if (myDelFile.exists()) {
			myDelFile.delete();
		}
	}

	/**
	 * 删除文件夹.
	 * @param folderPath 文件夹路径
	 * @throws IOException
	 */
	public static void delFolder(String folderPath) throws IOException {
		delAllFile(folderPath); // 删除完里面所有内容
		String filePath = folderPath;
		filePath = filePath.toString();
		java.io.File myFilePath = new java.io.File(filePath);
		myFilePath.delete(); // 删除空文件夹		
	}

	/**
	 * 删除文件夹下所有文件.
	 * @param path 文件夹完整路径.
	 * @throws IOException
	 */
	public static void delAllFile(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || !file.isDirectory()) {
			return;
		}

		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + FILE_SEPARATOR + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + FILE_SEPARATOR + tempList[i]);// 再删除空文件夹

			}
		}
	}

	/**
	 * 拷贝文件.
	 * @param oldPathFile 源文件
	 * @param newPathFile 目标文件
	 * @throws IOException
	 */
	public static void copyFile(String oldPathFile, String newPathFile) throws IOException {
		int bytesum = 0;
		int byteread = 0;
		File oldfile = new File(oldPathFile);
		if (oldfile.exists()) { // 文件存在时
			InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
			FileOutputStream fs = new FileOutputStream(newPathFile);
			byte[] buffer = new byte[1024];
			while ((byteread = inStream.read(buffer)) != -1) {
				bytesum += byteread; // 字节数 文件大小			
				fs.write(buffer, 0, byteread);
			}
			fs.close();
			inStream.close();
		}
	}

	/**
	 * 拷贝文件夹
	 * @param oldPath
	 * @param newPath
	 * @throws IOException
	 */
	public static void copyFolder(String oldPath, String newPath) throws IOException {
		new File(newPath).mkdirs(); // 如果文件夹不存在 则建立新文件夹
		File a = new File(oldPath);
		if(!a.exists()) {
			a.mkdirs();
		}
		String[] file = a.list();
		File temp = null;
		for (int i = 0; i < file.length; i++) {
			if (oldPath.endsWith(File.separator)) {
				temp = new File(oldPath + file[i]);
			} else {
				temp = new File(oldPath + File.separator + file[i]);
			}
			if (temp.isFile()) {
				FileInputStream input = new FileInputStream(temp);
				FileOutputStream output = new FileOutputStream(newPath + FILE_SEPARATOR + (temp.getName()).toString());
				byte[] b = new byte[1024 * 5];
				int len;
				while ((len = input.read(b)) != -1) {
					output.write(b, 0, len);
				}
				output.flush();
				output.close();
				input.close();
			}
			if (temp.isDirectory()) {// 如果是子文件夹
				copyFolder(oldPath + FILE_SEPARATOR + file[i], newPath + FILE_SEPARATOR + file[i]);
			}
		}
	}

	/**
	 * 获取类根路径下的资源流.
	 * 实例：如类目录下的某个属性文件
	 * InputStream inputStream = CommonUtil.getInputStreamBySourceName("pro-config.properties")
	 * @param sourceName
	 * @return
	 */
	public static InputStream getInputStreamBySourceName(String sourceName) {
		InputStream configFileInputStream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		configFileInputStream = classLoader.getResourceAsStream(sourceName);
		return configFileInputStream;
	}

	/**
	 * 
	 * 获取与类下面的同路径的资源
	 * 
	 * @param sourceName
	 * @param aClass
	 * @return
	 */
	public static InputStream getInputStreamBySoureNameInSamePackage(String sourceName, Class<?> aClass) {
		InputStream configFileInputStream = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		configFileInputStream = classLoader.getResourceAsStream(getPackagePath(aClass) + File.separator + sourceName);
		return configFileInputStream;
	}

	/**
	 *  获取包名
	 * @param aClass
	 * @return
	 */
	public static String getPackageName(Class<?> aClass) {
		return aClass.getPackage().getName();
	}

	/**
	 *  把包名转换为路径格式
	 * @param aClass
	 * @return
	 */
	public static String getPackagePath(Class<?> aClass) {
		return getPackageName(aClass).replace('.', File.separatorChar);
	}

	/**
	 * 获取转换为文件尺寸单位的文件大小，如23KB，12MB等
	 * @param fileSize 文件尺寸 Long型
	 * @return 
	 */
	public static String getHumanReadableFileSize(Long fileSize) {
		if (fileSize == null)
			return null;
		return getHumanReadableFileSize(fileSize.longValue());
	}

	/**
	 *  获取转换为文件尺寸单位的文件大小，如23KB，12MB等
	 * @param fileSize long型
	 * @return
	 */
	public static String getHumanReadableFileSize(long fileSize) {
		if (fileSize < 0) {
			return String.valueOf(fileSize);
		}
		String result = getHumanReadableFileSize(fileSize, ONE_PB, "PB");
		if (result != null) {
			return result;
		}

		result = getHumanReadableFileSize(fileSize, ONE_TB, "TB");
		if (result != null) {
			return result;
		}
		result = getHumanReadableFileSize(fileSize, ONE_GB, "GB");
		if (result != null) {
			return result;
		}
		result = getHumanReadableFileSize(fileSize, ONE_MB, "MB");
		if (result != null) {
			return result;
		}
		result = getHumanReadableFileSize(fileSize, ONE_KB, "KB");
		if (result != null) {
			return result;
		}
		return String.valueOf(fileSize) + "B";
	}
	
	/**
	 * 保存一个新文件.
	 * @param path  文件完整绝对路径
	 * @param filename 文件名
	 * @param stream	输入流
	 * @throws IOException
	 */
	public static void saveFileFromInputStream(InputStream stream, String path, String filename) throws IOException {
		FileOutputStream fs = new FileOutputStream(path + FILE_SEPARATOR + filename);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}

	/*
	 * 格式化文件大小 
	 * @param fileSize
	 * @param unit
	 * @param unitName
	 * @return
	 */
	private static String getHumanReadableFileSize(long fileSize, long unit, String unitName) {
		if (fileSize == 0)
			return "0";

		if (fileSize / unit >= 1) {
			double value = fileSize / (double) unit;
			DecimalFormat df = new DecimalFormat("######.##" + unitName);
			return df.format(value);
		}
		return null;
	}
	
	public static void main(String[] ars) throws Exception{
		copyFolder("D:\\hnjk\\datas", "D:\\Marco\\temp");
	}
	
	/**
	 * 获取文件夹下面的文件名（不包含文件夹）
	 * @param path
	 * @return
	 */
	public static List<String> getFilesName(String path) {
		List<String> filesName = new ArrayList<String>();
        File f = new File(path);
        if (!f.exists()) {
            return null;
        }
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (!fs.isDirectory()) {
            	filesName.add(fs.getName());
            }
        }
		return filesName;
    }
}
