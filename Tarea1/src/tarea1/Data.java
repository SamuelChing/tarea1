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
    public void store(ArrayList<String> comandos){
        if(comandos.get(1).toLowerCase().equals("ax")){
            this.ax=ac;
        }
        else if(comandos.get(1).toLowerCase().equals("bx")){
            this.bx=ac;
        }
        else if(comandos.get(1).toLowerCase().equals("cx")){
            this.cx=ac;
        }
        else{
             this.dx=ac;
        }
    }
    public void operacion(ArrayList<String> comandos){
        String operando;
        if(comandos.get(1).toLowerCase().equals("ax")){
            operando=this.ax;
        }
        else if(comandos.get(1).toLowerCase().equals("bx")){
            operando=this.bx;
        }
        else if(comandos.get(1).toLowerCase().equals("cx")){
            operando=this.cx;
        }
        else{
             operando=this.dx;
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
