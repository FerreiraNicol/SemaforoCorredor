package view;

import java.util.concurrent.Semaphore;
import controller.Threadcontroller;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int i = 0; i < 4; i++) {
			Thread td = new Threadcontroller(i+1, semaforo);
			td.start();
		}
	}

}
