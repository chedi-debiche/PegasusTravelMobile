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
import com.mycompany.entities.Voyage;
import com.mycompany.services.ServiceVoyage;

/**
 *
 * @author ASUS
 */
public class ModifierVoyageForm  extends BaseForm {
      Form current;
    public ModifierVoyageForm(Resources res , Voyage v) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
   
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
       
       
        super.addSideMenu(res);
       
        TextField nom = new TextField(v.getNom() , "nom" , 20 , TextField.ANY);
        TextField destination = new TextField(v.getDestination() , "destination" , 20 , TextField.ANY);
        TextField description = new TextField(v.getDescription() , "Description" , 20 , TextField.ANY);
        TextField prix = new TextField(String.valueOf(v.getPrix()) , "prix" , 20 , TextField.ANY);
        TextField image = new TextField(String.valueOf(v.getImage()) , "image" , 20 , TextField.ANY);
 
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
       
      //  ComboBox etatCombo = new ComboBox();
       
      //  etatCombo.addItem("Non Traiter");
       
       // etatCombo.addItem("Traiter");
       
       // if(r.getEtat() == 0 ) {
          //  etatCombo.setSelectedIndex(0);
       // }
       // else
          ////  etatCombo.setSelectedIndex(1);
       
       
       
       
       
        nom.setUIID("NewsTopLine");
        destination.setUIID("NewsTopLine");
        description.setUIID("NewsTopLine");
     
       
        nom.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
       
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   {
           
           v.setNom(nom.getText());
           v.setDestination(destination.getText());
           v.setDescription(description.getText());
           
         ////  if(etatCombo.getSelectedIndex() == 0 ) {
             //  v.setEtat(0);
          // }
           //else
             //  v.setEtat(1);
     
       
       //appel fonction modfier reclamation men service
       
       if(ServiceVoyage.getInstance().modifierVoyage(v)) { // if true
           new ListVoyageForm(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListVoyageForm(res).show();
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
                 new FloatingHint(destination),
                createLineSeparator(),
                new FloatingHint(description),
                createLineSeparator(),
                //etatCombo,
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
               
               
        );
       
        add(content);
        show();
       
       
    }
   
}
