/**
 * Clase Archivo. La cual se encagara de manejar el archivo de tipo txt
 * Autor: Elias Alberto Alvarado Raxon - 21808
 * Fecha de creacion: 06/04/2022
 * @version 1
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo
{
    private File archivo;

	/** 
	 * @param ruta
	 * @return String
	 */
	public String crearArchivo(String ruta)
    {
        try {
            this.archivo = new File(ruta);
            return "\nArchivo leido con exito.";
        } catch (Exception e) {
            //TODO: handle exception
            return "\nOcurrio un error al intentar crear el archivo.";
        }
    }

	/** 
	 * @return ArrayList<Integer>
	 */
	public ArrayList<String> leerArchivo()
	{
		try {
			ArrayList<String> lista = new ArrayList<String>();	
			Scanner scanner;
			try {
				scanner = new Scanner(this.archivo);
				while (scanner.hasNextLine())
				{
					lista.add(scanner.nextLine());
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return lista;
		} catch (Exception e) {
			//TODO: handle exception
			return null;
		}
	}

	/** 
	 * @return File
	 */
	public File getFile()
	{
		return this.archivo;
	}
}
