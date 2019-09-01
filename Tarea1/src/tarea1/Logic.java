/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Samuel & Nahum
 * Esta clase realiza el funcionalidades necesarias iniciales
 */
public class Logic {
    List<String> listaDeComandos; //Lista de comandos, todo en strings
    List<ArrayList<String>> resultado;
    List<ArrayList<String>> resultadoExplicito; //Guardo en una lista, sublistas de comandos
    ArrayList<Integer> pila;//Pila exitenste donde se "guarda" las instrucciones
    //String de cada registro posible por entrar al sistema
    String[] registros = {"AX","BX","CX","DX","load","store","mov","sub","add"};
    //Equivalente de cada registro en binario..
    String[] registrosBinario={"0001","0010","0011","0100"
                                ,"0001","0010","0011","0100","0101"};
    Data tool; //Mi obj con funcionalidades
    public Logic(){
       
        resultadoExplicito= new ArrayList<>() ;
        resultado= new ArrayList<>() ;
        tool= new Data();
        pila= new ArrayList();
       
    }
    public List<Integer> getPila(){
        return this.pila;
    }
    public void generarPila(){
        int size= resultado.size();
        Random r= new Random();
        int posicion= r.nextInt(90)+1;
       
        while(!(posicion+size<=99)){
            posicion=r.nextInt(90)+1;
        }
        int fin= size+posicion;
        int contador=0;
        for(int i =posicion;i<fin;i++){
            pila.add(i);
            contador++;
           
        }
    }
    public void setLista(List<String> lista){
        listaDeComandos=lista;
    }
    public List<ArrayList<String>> getLista(){
        return this.resultado;
    }
    public void separarLista(){
        listaDeComandos.forEach((listaDeComando) -> {
            traductor(listaDeComando);
        });
    }
    /**
    * resultado: lista de comandos en binarios
    * @param comandos, un string con comandos
    */
    //[mov, ax, -5]
    public void traductor(String comandos){
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> listaExplicita = new ArrayList<>();
        String[] sublista =comandos.split("\\s|,");
        //Recorremos la lista con comandos
        for (String sublista1 : sublista) {
            //Buscamos su reemplazo en registrosbinarios o lo convertimos en numero
            for (int j = 0; j<registros.length; j++) {
                try {
                    Integer.parseInt(sublista1);
                    lista.add(tool.decimalToBinary(sublista1));
                    listaExplicita.add(sublista1);
                    break;
                } catch (NumberFormatException ex) {
                    if (registros[j].toUpperCase().equals(sublista1)) {
                        
                        lista.add(registrosBinario[j]);
                        listaExplicita.add(sublista1);
                    }
                }
               
            }
        }
        
        resultadoExplicito.add(listaExplicita);
        resultado.add(lista);
        
        
    }
    
}
