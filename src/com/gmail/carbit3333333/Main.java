package com.gmail.carbit3333333;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		int bufferSize = 4;
		FileProcess fileProgress = new FileProcess();
		ReadingThread readingThread = new ReadingThread(fileProgress,new File("E:\\Работа\\Увви\\b.txt"), bufferSize);
		ShowProgress progress = new ShowProgress(fileProgress);
		WritingThread writingThread = new WritingThread(fileProgress, new File("E:\\Работа\\Увви\\a.txt"));
		
		
	}

}
