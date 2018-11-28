package com.gmail.carbit3333333;

public class ShowProgress implements Runnable{

	private FileProcess filePr;
	private Thread thr;
	
	
	@Override
	public void run() {
		for (int i = 1; (i<(filePr.getFileLenght())/filePr.getBufferSize()); i++) {
			synchronized(filePr) {
				try {
					filePr.wait();
					filePr.showProgress(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	public ShowProgress(FileProcess filePr) {
		super();
		this.filePr = filePr;
		thr = new Thread(this);
		try {
			thr.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thr.start();
	}
	public ShowProgress() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
