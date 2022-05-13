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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.Document;
import com.mycompany.entities.Evenement;
import com.mycompany.services.ServiceEvenement;
import java.util.ArrayList;



/**
 *
 * @author rahma
 */
public class PDFevent extends BaseForm{
   



/**
 *
 * @author 21695
 */

public PDFevent (Resources res) {
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setTitle("Liste des Evenements");
        getContentPane().setScrollVisible(true);
        super.addSideMenu(res);

       
   

        //this.theme=theme;
        SpanLabel sp = new SpanLabel();

        sp.setText(ServiceEvenement.getInstance().getAllEvents().toString());
        add(sp);
        //// f twig
        Button pdf = new Button("pdf");
        add(pdf);
        pdf.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {


                    String path = "";
                    Document document = new Document();
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

                        ServiceEvenement es = new ServiceEvenement();
                        ArrayList<Evenement> list = es.getAllEvents();
                        for (Evenement m : list) {

                            String date = String.valueOf(m.getNomevent());
                            String nom = String.valueOf(m.getPrixevent());
                            String type = String.valueOf(m.getDate());

                            

                            tb1.addCell(date);
                            tb1.addCell(nom);
                            tb1.addCell(type);
                            //tb1.addCell(image);
                           

                        }
                        document.add(new Paragraph("Reunion"));

                        document.add(tb1);
                        document.close();
         //writer.close();
                        com.codename1.io.File file = new com.codename1.io.File("reunion.pdf");
                        new dispalyEventForm(res).show();

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


