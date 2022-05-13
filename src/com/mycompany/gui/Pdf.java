/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServicesReclamation;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;

/**
 *
 * @author 21695
 */
public class Pdf extends BaseForm {

    public Pdf (Resources res) {
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setTitle("Liste des reclamations");
        getContentPane().setScrollVisible(true);
        super.addSideMenu(res);

       
   

        //this.theme=theme;
        SpanLabel sp = new SpanLabel();

        sp.setText(ServicesReclamation.getInstance().affichageReclamations().toString());
        add(sp);
        //// f twig 
        Button pdf = new Button("pdf");
        add(pdf);
        pdf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {


                    String path = "";
                    Document document;
                document = new Document() {};
                    try {

                    //    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path + "reclamation.pdf"));

                        document.open();
                        PdfPTable tb1 = new PdfPTable(10);
                        tb1.addCell("DateRecalamtion");
                        tb1.addCell("EmailReclamation");
                        tb1.addCell("DescriptionReclamation");

                        //tb1.addCell("img");
                        tb1.addCell("EtatReclamation");
                        tb1.addCell("nomuser");

                        ServicesReclamation es = new ServicesReclamation();
                        ArrayList<Reclamation> list = es.affichageReclamations();
                        for (Reclamation m : list) {

                            String nom = String.valueOf(m.getNom());
                            String prenom = String.valueOf(m.getPrenom());
                            String email = String.valueOf(m.getEmail());
                              String comm = String.valueOf(m.getCommentaire());
                              String type = String.valueOf(m.getTypereclamation());
                            String date = String.valueOf(m.getDatereclamation());
                            
                            tb1.addCell(date);
                            tb1.addCell(nom);
                            tb1.addCell(type);
                            //tb1.addCell(image);
                            tb1.addCell(nom);
                            tb1.addCell(prenom);
                              tb1.addCell(email);
                              tb1.addCell(comm);


                        }
                        document.add(new Paragraph("Reclamation"));

                        document.add(tb1);
                        document.close();
         //writer.close();
                        com.codename1.io.File file = new com.codename1.io.File("Reclamation.pdf");
                        new ListeRec(res).show();

 //   desktop.open(file);
                    } 
                    catch (Exception e){
                        e.printStackTrace();
                    
                  
                   
      
              }}
                    //Logger.getLogger(ListFormation.class.getName()).log(Level.SEVERE, null, ex);

                    //Logger.getLogger(ListFormation.class.getName()).log(Level.SEVERE, null, ex);
                    //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

             


        });}
    
}
