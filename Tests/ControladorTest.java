import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControladorTest {

	@Test
	void testBusqueda() {
		Controlador controlador = new Controlador();
	    assertEquals(controlador.busqueda(controlador.getIngles(),"table"), false);
	    controlador.insertar("table", "mesa", true);
	    assertEquals(controlador.busqueda(controlador.getIngles(),"table"), true);
	}

	@Test
	void testInsertarStringStringBoolean() {
		Controlador controlador = new Controlador();
		String palabra = "videogames";
		String traduccion = "videojuegos";
		Boolean ingles = true;
	    assertEquals(controlador.busqueda(controlador.getIngles(), palabra), false);
	    controlador.insertar(palabra, traduccion, ingles);
	    assertEquals(controlador.busqueda(controlador.getIngles(), palabra), true);
	}

}
