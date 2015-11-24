package br.unb.cic.imdb.integracao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import junit.framework.TestCase;

public class FooTest extends TestCase {

	private List<Integer> lista;
	
	public void setUp() {
		lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
	}
	public void testMapFuncaoQuadrado() {
		List<Integer> res = lista.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(res);
	}
}
