package controller;

import java.util.concurrent.Semaphore;

public class Threadcontroller extends Thread{
	private int tid, passo, tot, dist = 50;
	private static int j;
	private String[] ordem = {"primeira","segunda","terceira","quarta"};
	private Semaphore semaforo;
	
	public Threadcontroller(int tid, Semaphore semaforo ) {
		this.tid = tid;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		corredor();
		try {
			semaforo.acquire();
			porta();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	
	private void corredor() {
		while(tot < dist) {
			passo = (int)((Math.random()* 2.1)+ 4);
			tot += passo;
			if(tot > dist) {
				System.out.println("A pessoa do corredor "+tid+" andou "+passo+" metros e já percorreu "+dist+" metros.");
			}else {
				System.out.println("A pessoa do corredor "+tid+" andou "+passo+" metros e já percorreu "+tot+" metros.");
			}
			try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("A pessoa do corredor "+tid+" terminou o caminho.");
	}
	
	private void porta() {
		int tempo;
		System.out.println("A "+ordem[j]+" pessoa a chegar na porta foi a pessoa do corredor "+tid+".");
		j++;
		tempo = (int)((Math.random()*1001)+1000);
		try {
			sleep(tempo);
		}catch(Exception f) {
			f.printStackTrace();
		}
		System.out.println("A pessoa do corredor "+tid+" saiu.");
	}

}
