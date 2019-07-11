package IO;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest implements AutoCloseable {
	public static void main(String[] args) {
		// 使用DataInputStream,DataOutputStream写入文件且从文件里读取数据。

		try(
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(
					"datasteam.txt"));
				DataInputStream dis = new DataInputStream(new FileInputStream(
						"datasteam.txt"));
				
			){
			// Data Stream写到输入流中
			dos.writeBytes("世界"); //按2字节写入，都是写入的低位
			dos.writeChars("世界"); // 依照Unicode写入
			// 依照UTF-8写入(UTF8变长，开头2字节是由writeUTF函数写入的长度信息。方便readUTF函数读取)
			dos.writeUTF("世界"); 
			dos.flush();
			dos.close();
			// Data Stream 读取
			// 读取字节
			byte[] b = new byte[2];
			dis.read(b);
			System.out.println(new String(b, 0, 2));
			// 读取字符
			char[] c = new char[2];
			for (int i = 0; i < 2; i++) {
				c[i] = dis.readChar();
			}
			System.out.println(new String(c, 0, 2));

			// 读取UTF
			System.out.println(dis.readUTF());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}

