/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Evenement;
import com.mycompany.services.ServiceEvenement;

/**
 *
 * @author rahma
 */
public class ModifierEventForm extends BaseForm {
    Form current;
    public ModifierEventForm(Resources res , Evenement m) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("modifier Maison");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
        TextField nom = new TextField(m.getNomevent() , "nom" , 20 , TextField.ANY);
       
        TextField prix = new TextField(String.valueOf(m.getPrixevent()) , "prix" , 20 , TextField.ANY);
        TextField date = new TextField(m.getDate() , "date" , 20 , TextField.ANY);

 
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        
       // ComboBox etatCombo = new ComboBox();
        
      //  etatCombo.addItem("Non Traiter");
        
       // etatCombo.addItem("Traiter");
        
    //    if(r.getEtat() == 0 ) {
      //      etatCombo.setSelectedIndex(0);
      //  }
      //  else 
        //    etatCombo.setSelectedIndex(1);
        
        
        
        
       
        nom.setUIID("NewsTopLine");
        prix.setUIID("NewsTopLine");
        date.setUIID("NewsTopLine");
     //   prix.setUIID("NewsTopLine");
        

        
        nom.setSingleLineTextArea(true);
        prix.setSingleLineTextArea(true);
        date.setSingleLineTextArea(true);
      //  prix.setSingleLineTextArea(true);
        

        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           m.setNomevent(nom.getText());
          
          m.setPrixevent(Float.parseFloat(prix.getText()));
           m.setDate(date.getText());
           




           

           
           
          
         //  if(etatCombo.getSelectedIndex() == 0 ) {
        //       r.setEtat(0);
        //   }
         //  else 
           //    r.setEtat(1);
      
       
       //appel fonction modfier reclamation men service
       
       if(ServiceEvenement.getInstance().modifEvent(m)) { // if true
           new ListMaisonForm(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new dispalyEventForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
     
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(prix),
                createLineSeparator(),
                new FloatingHint(date),
                createLineSeparator(),
                
            
                
                  

             //   etatCombo,
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    
    
}
}
