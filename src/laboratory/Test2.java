package laboratory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class Test2 {
	
	private void zip(String zipFileName, File inputFile) throws Exception {
        System.out.println("压缩中...");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        BufferedOutputStream bo = new BufferedOutputStream(out);
        
        out.putNextEntry(new ZipEntry("555")); // 创建zip压缩进入点base
        System.out.println("5");
        FileInputStream in = new FileInputStream(inputFile);
        BufferedInputStream bi = new BufferedInputStream(in);
        int b;
        while ((b = in.read()) != -1) {
        	out.write(b); // 将字节流写入当前zip目录
        }
//        bi.close();
        in.close(); // 输入流关闭
        
        
        
        bo.close();
        out.close(); // 输出流关闭
        System.out.println("压缩完成");
    }
	
	
	
	public static void main(String[] args) {
		Test2 book = new Test2();
        try {
            book.zip("/home/X/Desktop/123/123/zip.zip",new File("/home/X/Desktop/123/123/123.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
