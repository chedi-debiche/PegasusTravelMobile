/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Maison;
import com.mycompany.services.ServiceMaison;

/**
 *
 * @author CC
 */
public class ModifierMaisonForm extends BaseForm {
    
    
     Form current;
    public ModifierMaisonForm(Resources res , Maison m) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("modifier Maison");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
        TextField nom = new TextField(m.getNom() , "nom" , 20 , TextField.ANY);
        TextField localisation = new TextField(m.getLocalisation() , "localisation" , 20 , TextField.ANY);
        TextField description = new TextField(m.getDescription() , "description" , 20 , TextField.ANY);
        TextField prix = new TextField(String.valueOf(m.getPrix()) , "prix" , 20 , TextField.ANY);
        TextField imageMaison = new TextField(m.getImageMaison() , "imageMaison" , 20 , TextField.ANY);

 
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
        localisation.setUIID("NewsTopLine");
        description.setUIID("NewsTopLine");
     //   prix.setUIID("NewsTopLine");
        imageMaison.setUIID("NewsTopLine");

        
        nom.setSingleLineTextArea(true);
        localisation.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
      //  prix.setSingleLineTextArea(true);
        imageMaison.setSingleLineTextArea(true);

        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           m.setNom(nom.getText());
           m.setLocalisation(localisation.getText());
          // m.setPrix(prix.getText());
           m.setDescription(description.getText());
           m.setImageMaison(imageMaison.getText());




           

           
           
          
         //  if(etatCombo.getSelectedIndex() == 0 ) {
        //       r.setEtat(0);
        //   }
         //  else 
           //    r.setEtat(1);
      
       
       //appel fonction modfier reclamation men service
       
       if(ServiceMaison.getInstance().modifierMaison(m)) { // if true
           new ListMaisonForm(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListMaisonForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(nom),
                createLineSeparator(),
                new FloatingHint(localisation),
                createLineSeparator(),
                new FloatingHint(description),
                createLineSeparator(),
                
                new FloatingHint(imageMaison),
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
