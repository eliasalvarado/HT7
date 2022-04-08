/**
 * Clase principal. La cual sera la encargada de interactuar con el usuario
 * Autor: Elias Alberto Alvarado Raxon - 21808
 * Fecha de creacion: 06/04/2022
 * @version 1
 */

import java.util.Scanner;

public class Principal
{   
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Controlador controlador = new Controlador();

        boolean buclePrincipal = true;
        boolean bucle = true;
        Boolean ingles = true;
        String palabra = "";
        String traduccion = "";
        String ruta = "";
        int respuesta = 0;


        while(bucle)
        {
            try {
                System.out.println("\nPor favor, ingrese la ruta de su archivo de tipo texto.\nRespuesta: ");
                ruta = scanner.nextLine();
                ruta = ruta + "\\diccionario.txt";
                System.out.println(controlador.leerArchivo(ruta));
                
                if(controlador.comprobarArchivo())
                {
                    bucle = false; 
                    System.out.println(controlador.leerArchivo(ruta));
                }
                else
                {
                    bucle = false;
                    System.out.println("\nHa ocurrido un error al intentar leer el archivo.");
                    if(pregunta("¿Desea intentarlo de nuevo?\n1. Si.\n2. No.\nRespuesta: ", 2) == 1)
                    {
                        bucle = true; 
                    }
                    else buclePrincipal = false;
                }
            } catch (Exception e) {
                //TODO: handle exception
                bucle = false;
                    System.out.println("\nHa ocurrido un error al intentar leer el archivo.");
                    if(pregunta("¿Desea intentarlo de nuevo?\n1. Si.\n2. No.\nRespuesta: ", 2) == 1)
                    {
                        bucle = true; 
                    }
                    else buclePrincipal = false;
            }
        }

        //Pruebas///////////////////////////////////////////////
        controlador.archivoArray();
        controlador.insertar();
        System.out.println("\nIngles:");
        controlador.recorrer(controlador.getIngles().getRaiz());
        System.out.println("\nFrances:");
        controlador.recorrer(controlador.getFrances().getRaiz());
        ////////////////////////////////////////////////////////
        
        while(buclePrincipal)
        {
            respuesta = pregunta("Menu:\n1. Traducir palabra.\n2. Traducir texto.\n3. Agregar traduccion.\n4. Editar diccionario.\n5. Eliminar traduccion.\n6. Salir.\nRespueta: ", 6);
            switch (respuesta) {
                case 1: //palabra
                if(pregunta("¿Que desea traducir?\n1. Ingles-Espaniol.\n2. Frances-Espaniol.\nNOTA: Si la palabra ingresada no existe en el diccionario, esta apararecera con el siguiente formato: *PalabraIngresada*.\nRespuesta: ", 2) == 1) ingles = true;
                else ingles = false;
                System.out.println("\nIngrese la palabra que desee traducir: ");
                palabra = scanner.nextLine();
                System.out.println("La traduccion de: '" + palabra + "' es: " + controlador.traducir(palabra, ingles));
                    break;
                
                case 2: //texto
                System.out.println("\nIngrese ruta del archivo con el texto a traducir: ");
                ruta = scanner.nextLine();
                ruta = ruta + "\\texto.txt";
                System.out.println(controlador.traducirTexto(ruta));
                    break;

                case 3: //agregar traduccion
                if(pregunta("¿A que diccionario lo desea agregar?\n1. Ingles-Espaniol.\n2. Frances-Espaniol.\nRespuesta: ", 2) == 1) ingles = true;
                else ingles = false;
                if(ingles) System.out.println("\nIngrese la palabra en Ingles que desee agregar: ");
                else System.out.println("\nIngrese la palabra en Frances que desee agregar: ");
                palabra = scanner.nextLine();
                System.out.println("\nIngrese su traduccion al Espaniol: ");
                traduccion = scanner.nextLine();
                System.out.println(controlador.insertar(palabra, traduccion, ingles));
                    break;
                
                case 4: //Editar diccionario
                    
                    break;

                case 5: //Eliminar palabra de un diccionario
                if(pregunta("¿A que diccionario lo desea agregar?\n1. Ingles-Espaniol.\n2. Frances-Espaniol.\nRespuesta: ", 2) == 1) ingles = true;
                else ingles = false;
                if(ingles) System.out.println("\nIngrese la palabra en Ingles que desee eliminar: ");
                else System.out.println("\nIngrese la palabra en Frances que desee eliminar: ");
                palabra = scanner.nextLine();
                System.out.println(controlador.eliminarPalabra(palabra, ingles));
                    break;

                case 6: //Salir
                buclePrincipal = false;    
                    break;

                default: //Salir
                buclePrincipal = false;
                    break;
            }
        }

    }  
    
    /** 
     * @param pregunta
     * @param opciones
     * @return int
     */
    public static int pregunta(String pregunta, int opciones)
    {
        boolean bucle = true;
        int respuesta = 0;
        Scanner scanner = new Scanner(System.in);
        try 
        {
            while(bucle)
            {
                System.out.println(pregunta);
                respuesta = scanner.nextInt();
                scanner.nextLine();
                if(respuesta > 0 && respuesta <= opciones) bucle = false;
                else System.out.println("\nRepuesta no valida.\n");
            }    
        } catch (Exception e) {
            System.out.println("\nRepuesta no valida. Ingrese solamente numeros.\n");
            respuesta = pregunta(pregunta, opciones);
        }
        return respuesta;
    }
}
