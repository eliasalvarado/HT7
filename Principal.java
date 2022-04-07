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

        controlador.archivoArray();
        controlador.insertar();
        System.out.println("\nIngles:");
        controlador.recorrer(controlador.getIngles().getRaiz());
        System.out.println("\nFrances:");
        controlador.recorrer(controlador.getFrances().getRaiz());
        
        
        /*while(buclePrincipal)
        {
            
        }*/

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
