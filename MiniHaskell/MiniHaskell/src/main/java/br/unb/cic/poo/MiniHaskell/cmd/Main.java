package br.unb.cic.poo.MiniHaskell.cmd;

import java.util.Scanner;

/**
 * Programa experimental para "brincar" com a 
 * linguagem MiniHaskell. 
 * 
 * @author rbonifacio
 */
public class Main {
	public static final String MSG = "Hello. This is the "
			+ "first experimental interpreter for MiniHaskell. "
			+ "Enjoy it!";
	
	public static final String PMT = ">";
	
	/**
	 * Metodo principal do programa. 
	 * @param args
	 */
	public static void main(String args[]) {
	
		System.out.println(MSG);
	
		System.out.println();
		System.out.println();
		
		Main m = new Main();
		m.loop();
	}
	
	private void loop() {
		
		Scanner sc = new Scanner(System.in);
	
		String cmd = sc.nextLine();
		
		while(!cmd.equals("exit();")) {
			
		}
	}
	
}
