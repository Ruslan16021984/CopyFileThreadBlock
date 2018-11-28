package com.gmail.carbit3333333;

public class FileProcess {
	
	private byte[] buffer;
	private long fileLenght;
	private int quantity;
	

	public long getFileLenght() {
		return fileLenght;
	}

	public void setFileLenght(long fileLenght) {
		this.fileLenght = fileLenght;
	}
	public FileProcess() {
		super();
		
	}
	public synchronized void setBuffer(byte[]buffer, int quntity) {
		this.buffer = buffer;
		this.quantity = quntity;
		
		if(buffer.length !=0) {
			System.out.println("ThreadRead fis.read  " + this);
		}
		notify();
	}
	public synchronized byte[] getBuffer() {
		System.out.println("ThreadWrite fos.write  " + this);
		notifyAll();
		return this.buffer;
	}
	public void showProgress(long iteration) {
		String temp = "%";
		System.out.format("Thread-3 progress  — %2.0f%s\n\n", (((double) iteration * buffer.length) / fileLenght) * 100, temp);
	}

	public int getQuantity() {
		return quantity;
	}
	public synchronized float getBufferSize() {
		return buffer.length;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0;; i++) {
			sb.append(buffer[i]);
			if(i == buffer.length-1) {
				return sb.append(" [Byte: "+ quantity +"]").toString();
			}
			sb.append(", ");
		}
		
	}
	
}
