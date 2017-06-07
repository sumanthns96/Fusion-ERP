/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import static java.lang.System.exit;

/**
 *
 * @author Sumanth Saligram
 */
public class ERP {
    
    int retry=0;

   
           public void start(){
               ERPProgress p = new ERPProgress();
       ERPLoginAuth erplogin = new ERPLoginAuth();
      ERPLoginerror error = new ERPLoginerror();
        ERPDBConnect con = new ERPDBConnect(error);
        if(error.access==0){erplogin.setVisible(false);}
        else erplogin.setVisible(true);
           }
    public static void main(String[] args) {
       
              ERP e = new ERP();
              e.start();

    }
    
}
