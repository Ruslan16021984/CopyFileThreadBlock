package com.gmail.carbit3333333;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingThread implements Runnable{
	private FileProcess fileProgress;
	private File out;
	private Thread thr;
	
	
	public WritingThread() {
		super();
	}


	public WritingThread(FileProcess fileProgress, File out) {
		super();
		this.fileProgress = fileProgress;
		this.out = out;
		thr = new Thread(this);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thr.start();
	}

	@Override
	public void run() {
		try (FileOutputStream fos = new FileOutputStream(out)){
			while(fileProgress.getBufferSize()!=0) {
				synchronized (fileProgress) {
					fos.write(fileProgress.getBuffer(), 0, fileProgress.getQuantity());
					fileProgress.wait();
			
				}
			}
		} catch (InterruptedException | IOException e) {
			e.getMessage();
		}	
		System.out.println("Copying is done    — 100%\n");
	}

}
