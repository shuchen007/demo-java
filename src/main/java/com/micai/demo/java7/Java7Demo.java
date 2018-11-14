package com.micai.demo.java7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Java7Demo implements AutoCloseable {
	
	public void test() throws ArithmeticException {
		System.out.println("java7-> 自定义关闭资源类,使用资源...");
		int result = 1/0;
	}

	@Override
	public void close() throws IOException {
		System.out.println("自动关闭资源中...");
		throw new IOException("自动关闭资源失败");
	}
	
	/**
	 * 测试自动关闭
	 * @throws Exception
	 */
	public void testAutoCloseable() throws Exception {
		try(Java7Demo demo = new Java7Demo()) {
			demo.test();
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * 测试非自动关闭
	 * @throws Exception
	 */
	public void testNoAutoCloseable() throws Exception {
		Java7Demo demo = new Java7Demo();
		try {
			demo.test();
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		finally {
			try {
				demo.close();
			} 
			catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public static void testChannel() {
		
		try {
			RandomAccessFile file = new RandomAccessFile("nio-test.txt", "rw");
			FileChannel channel = file.getChannel();
			ByteBuffer bBuffer  = ByteBuffer.allocate(32); // 分配一个新的字节缓冲区
			int byteRead = channel.read(bBuffer); // 读到缓冲区
			
			while (byteRead != -1) {
				System.out.println("length: "+byteRead);
				
				bBuffer.flip(); //flip()的具体操作就是把Buffer的limit固定到当前的position，然后把position归零。
				
				byte[] bytes = new byte[byteRead];
				int index = 0;
				while (bBuffer.hasRemaining()) {
					bytes[index] = bBuffer.get();
					index++;
				}
				System.out.println(new String(bytes,"UTF-8"));
				
				bBuffer.clear();
//				bBuffer.compact();
				byteRead = channel.read(bBuffer);
			}
			
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Java7Demo demo = new Java7Demo();
		try {
			demo.testAutoCloseable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
