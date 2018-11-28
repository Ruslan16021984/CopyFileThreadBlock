package com.gmail.carbit3333333;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingThread implements Runnable {

	private FileProcess fileProgress;
	private File in;
	private byte[] array;
	private Thread thr;

	public ReadingThread(FileProcess fileProgress, File in, int bufferSize) {
		super();
		this.fileProgress = fileProgress;
		this.in = in;
		array = new byte[bufferSize];
		thr = new Thread(this);
		thr.start();
	}

	@Override
	public void run() {
		fileProgress.setFileLenght(in.length());
		try (FileInputStream fis = new FileInputStream(in)) {
			for (int quntity = 0; (quntity = fis.read(array)) > 0;) {
				synchronized (fileProgress) {
					fileProgress.setBuffer(array, quntity);
					fileProgress.wait();
				}
			}
		} catch (InterruptedException | IOException e) {
			System.out.println(e.getMessage());
		}
		fileProgress.setBuffer(new byte[0], 0);

	}

}
