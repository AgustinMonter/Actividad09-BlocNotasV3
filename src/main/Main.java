/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Views.ViewCifrador;
import Models.ModelsCifrador;
import Controllers.ControllerCifrador;

public class Main {

    
    public static void main(String[] args) {
         ViewCifrador viewcifrador = new ViewCifrador();
        ModelsCifrador modelscifrador = new ModelsCifrador();
        ControllerCifrador controllerCifrador = new ControllerCifrador(viewcifrador, modelscifrador);
        
    }
    
}
