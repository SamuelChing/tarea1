/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import static java.lang.Math.abs;
import java.util.ArrayList;

/**
 *
 * @author Samuel & Nahum
 */
public class Data {
    String ax,bx,cx,dx,ac;
    public Data(){
        ax="0";
        bx="0";
        cx="0";
        dx="0";
        ac="0";
    }
    public void reinicio(){
        this.ax="0";
        this.bx="0";
        this.cx="0";
        this.dx="0";
        this.ac="0";
    }
    //GETTERS
    public String getAx() {
        return ax;
    }

    public String getBx() {
        return bx;
    }

  

    public String getCx() {
        return cx;
    }

   

    public String getDx() {
        return dx;
    }

  
    public String getAc() {
        return ac;
    }

   
    /**
     * Realiza cambios por la instrucción "MOV"
     * @param comandos, lista con comandos por revisar, el largo siempre será 3 
     */
    public void mov(ArrayList<String> comandos){
        switch (comandos.get(1).toLowerCase()) {
            case "ax":
                this.ax=comandos.get(2);
                break;
            case "bx":
                this.bx=comandos.get(2);
                break;
            case "cx":
                this.cx=comandos.get(2);
                break;
            default:
                this.dx=comandos.get(2);
                break;
        }
        
    }
    /**
     * Realiza cambios por la instrucción "LOAD"
     * @param comandos  lista con comandos por revisar, el largo siempre será 2 
     */
    public void load(ArrayList<String> comandos){
        switch (comandos.get(1).toLowerCase()) {
            case "ax":
                this.ac=ax;
                break;
            case "bx":
                this.ac=bx;
                break;
            case "cx":
                this.ac=cx;
                break;
            default:
                this.ac=dx;
                break;
        }
    }
    /**
     * Realiza cambios por la instrucción "STORE"
     * @param comandos lista con comandos por revisar, el largo siempre será 2 
     */
    public void store(ArrayList<String> comandos){
        switch (comandos.get(1).toLowerCase()) {
            case "ax":
                this.ax=ac;
                break;
            case "bx":
                this.bx=ac;
                break;
            case "cx":
                this.cx=ac;
                break;
            default:
                this.dx=ac;
                break;
        }
    }
    /**
     * Esta función realiza cambios por las instrucciones de sumar y restar
     * @param comandos, esta lista tiene un largo de 2
     */
    public void operacion(ArrayList<String> comandos){
        String operando;
        switch (comandos.get(1).toLowerCase()) {
            case "ax":
                operando=this.ax;
                break;
            case "bx":
                operando=this.bx;
                break;
            case "cx":
                operando=this.cx;
                break;
            default:
                operando=this.dx;
                break;
        }
        if(comandos.get(0).toLowerCase().equals("add")){
            this.ac=Integer.toString(Integer.parseInt(ac)+Integer.parseInt(operando));
        }
        else{
            this.ac=Integer.toString(Integer.parseInt(ac)-Integer.parseInt(operando));
        }
    }
    /***
     *Esta funciona realiza un numero decimal en string en un string con su representación binaria
     * @param numberString
     * @return string
     */
    public String decimalToBinary(String numberString){
        int numero= Integer.parseInt(numberString);
        String resultado;
        boolean isNegative=false;
        if(numero<0) isNegative=true;
        resultado=aux_decimalToBinary(isNegative, Integer.toBinaryString(abs(numero)));
        return resultado;
    }
    /**
     * @param isNegative indica si el # es negativo o no
     * @param resultado donde será almacenado el resultado
     * @return string
     */
    public String aux_decimalToBinary(boolean isNegative, String resultado){
        
        int end = 7-resultado.length();
        for(int i =0; i<end;i++){
            resultado="0"+resultado;
        }
        if(isNegative) resultado="1"+resultado;
        else  resultado="0"+resultado;
        return resultado;
    }
    
}
