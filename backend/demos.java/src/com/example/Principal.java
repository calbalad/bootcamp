/**
 * 
 */
package com.example;

import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author calbalad
 *
 */
public class Principal {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Hola";
		s += " mundo!";
		System.out.println(s);
		Dias dias = Dias.DOMINGO;
		System.out.println(dias);
		Variable(1, 2, 3,5, 6, 4);
		
	};
	



	public static int[] Variable(int a, int b, int... lista) {
		return lista;
	}

}
