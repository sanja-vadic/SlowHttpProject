package net.etfbl.sanja.main;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		while(true) {
			for(int i=0; i<500; ++i) {
				new Thread(new HttpSlowClient()).start();
			}
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
}
