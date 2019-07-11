package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
 
	public static void main(String[] args){
		FileIO.copyResBySnglByte("/home/X/laboratoryTestFile/copyFrom/123", "/home/X/laboratoryTestFile/copyTo/123");
		
	}
	public static void copyResBySnglByte(String fromDir,String toDir){
		try {
			
			InputStream fis = new FileInputStream(fromDir);
			OutputStream fos = new FileOutputStream(toDir);
			int bytesRead; 
			while ((bytesRead = fis.read()) !=-1) {
				System.out.println(bytesRead);
				fos.write(bytesRead);
			}
			fis.close();
			fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void copyResByMultiByte(String fromDir,String toDir){
		try {
			
			InputStream fis = new FileInputStream(fromDir);
			OutputStream fos = new FileOutputStream(toDir);
			byte[] buf = new byte[5];        
			int bytesRead; 
			System.out.println(buf.length);
			while ((bytesRead = fis.read(buf)) !=-1) {
				System.out.println(bytesRead);
				System.out.println(buf.length);
				fos.write(buf, 0, bytesRead);
			}
			fis.close();
			fos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void copyResByBuffer(String fromDir,String toDir){
		try {
			
			InputStream fis = new FileInputStream(fromDir);
			OutputStream fos = new FileOutputStream(toDir);
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte[] buf = new byte[1024];        
			int bytesRead;        
			while ((bytesRead = bis.read(buf)) !=-1) {
				bos.write(buf, 0, bytesRead);
			}
			bis.close();
			bos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
