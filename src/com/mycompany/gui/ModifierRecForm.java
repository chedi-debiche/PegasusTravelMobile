/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reclamation;
import com.mycompany.entities.Voyage;
import com.mycompany.services.ServiceVoyage;
import com.mycompany.services.ServicesReclamation;

/**
 *
 * @author 21695
 */
public class ModifierRecForm extends BaseForm {
    Form current;
    public ModifierRecForm(Resources res , Reclamation v) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
   
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Modifier Reclamation");
        getContentPane().setScrollVisible(false);
       
       
        super.addSideMenu(res);
       
        TextField nom = new TextField(v.getNom() , "nom" , 20 , TextField.ANY);
        TextField prenom = new TextField(v.getPrenom() , "prenom" , 20 , TextField.ANY);
        TextField email = new TextField(v.getEmail(), "email" , 20 , TextField.ANY);
        TextField Commentaire = new TextField(v.getCommentaire() , "commentaire" , 20 , TextField.ANY);
        TextField datereclamation = new TextField(v.getDatereclamation() , "datereclamation" , 20 , TextField.ANY);
   TextField typereclamation = new TextField(v.getTypereclamation() , "typereclamation" , 20 , TextField.ANY);
   
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
        prenom.setUIID("NewsTopLine");
        email.setUIID("NewsTopLine");
      Commentaire.setUIID("NewsTopLine");
       datereclamation.setUIID("NewsTopLine");
       typereclamation.setUIID("NewsTopLine");
       
        nom.setSingleLineTextArea(true);
         prenom.setSingleLineTextArea(true);
        email.setSingleLineTextArea(true);
         Commentaire.setSingleLineTextArea(true);
          datereclamation.setSingleLineTextArea(true);
           typereclamation.setSingleLineTextArea(true);
       
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   {
           
           v.setNom(nom.getText());
           v.setPrenom(prenom.getText());
           v.setEmail(email.getText());
            v.setCommentaire(Commentaire.getText());
             v.setDatereclamation(datereclamation.getText());
               v.setTypereclamation(typereclamation.getText());
           
         ////  if(etatCombo.getSelectedIndex() == 0 ) {
             //  v.setEtat(0);
          // }
           //else
             //  v.setEtat(1);
     
       
       //appel fonction modfier reclamation men service
       
       if(ServicesReclamation.getInstance().modifEvent(v)) { // if true
           new  ListeRec(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new  ListeRec(res).show();
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
                 new FloatingHint(prenom),
                createLineSeparator(),
                new FloatingHint(email),
                createLineSeparator(),
                new FloatingHint(Commentaire),
                createLineSeparator(),
                 new FloatingHint(datereclamation),
                  createLineSeparator(),
                 new FloatingHint(typereclamation),
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
