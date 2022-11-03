package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import JUnit.Junit09_Geometria.dto.Geometria;


class GeometriaTest {

	Geometria geom;
	
	@BeforeEach
	public void before() {
		geom = new Geometria();
	}
	
	@Test
	public void testGeometria() {
		geom = new Geometria(2);
	}
	
	@Test
	public void testAreacuadrado() {
		int resultado = geom.areacuadrado(5);
		int esperado = 25;
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testAreacirculo() {
		//El resultado será 50,27, podría poner "esperado" en un double pero lo hice con un margen de 1 para darle uso al delta.
		double resultado = geom.areaCirculo(4);
		int esperado = 50;
		int delta = 1;
		assertEquals(esperado,resultado,delta);
	}
	
	@Test
	public void testAreaTriangulo() {
		double resultado = geom.areatriangulo(4,10);
		int esperado = 20;
		assertEquals(esperado,resultado);
	}

	@Test
	public void testAreaRectangulo() {
		int resultado = geom.arearectangulo(5,8);
		int esperado = 40;
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testAreaPentagono() {
		double resultado = geom.areapentagono(7,4);
		int esperado = 14;
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testAreaRombo() {
		double resultado = geom.arearombo(6,6);
		int esperado = 18;
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testAreaRomboide() {
		double resultado = geom.arearomboide(2,8);
		int esperado = 16;
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testAreaTrapecio() {
		double resultado = geom.areatrapecio(5,7,2);
		int esperado = 12;
		assertEquals(esperado,resultado);
	}
	
	//Para comprobar todas las figuras lo haremos a través de un array.
	
	private static Stream<Arguments> getFormatFixture(){
		return Stream.of(
				Arguments.of(0,"Default"),
				Arguments.of(1,"cuadrado"),
				Arguments.of(2,"Circulo"),
				Arguments.of(3,"Triangulo"),
				Arguments.of(4,"Rectangulo"),
				Arguments.of(5,"Pentagono"),
				Arguments.of(6,"Rombo"),
				Arguments.of(7,"Romboide"),
				Arguments.of(8,"Trapecio"));
	}
	
	@ParameterizedTest
	@MethodSource("getFormatFixture")
	public void testFiguras(int a,String b) {
		String resultado = geom.figura(a);
		assertEquals(b,resultado);
	}
		
	//En los siguientes test comprobamos que funcionan a la misma vez el setter y el getter.
	
	@Test
	public void testSetGetId() {
		geom.setId(5);
		int resultado = geom.getId();
		int esperado = 5;
		assertEquals(esperado,resultado);
	}
	
	
	@Test
	public void testSetGetNom() {
		geom.setNom("Testeo del setter");
		String resultado = geom.getNom();
		String esperado = "Testeo del setter";
		assertEquals(esperado,resultado);
	}
	
	
	@Test
	public void testSetGetArea() {
		geom.setArea(8);
		double resultado = geom.getArea();
		double  esperado = 8;
		assertEquals(esperado,resultado);
	}
	
	@Test
	public void testToString() {
		geom.setId(1);
		geom.setNom("Cuadrado");
		geom.setArea(7.5);
		String resultado = geom.toString();
		String  esperado =  "Geometria [id=1, nom=Cuadrado, area=7.5]";
		assertEquals(esperado,resultado);
	}
	

}
