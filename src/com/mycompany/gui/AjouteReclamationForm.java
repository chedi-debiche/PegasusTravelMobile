/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Maison;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceMaison;
import com.mycompany.services.ServicesReclamation;

/**
 *
 * @author 21695
 */
public class AjouteReclamationForm extends BaseForm {
     Form current;
    public AjouteReclamationForm(Resources res ) {
        super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
     Container ct = new Container(BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Reclamation");
        getContentPane().setScrollVisible(false);
       
       
        tb.addSearchCommand(e ->  {
           
        });
       
        Tabs swipe = new Tabs();
       
        Label s1 = new Label();
        Label s2 = new Label();
       
        addTab(swipe,s1, res.getImage("dar-nour-3.jpg"),"","",res);
       
        //
       
         swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("List", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("Pdf", barGroup);
        liste.setUIID("SelectBar");
       
        RadioButton stat = RadioButton.createToggle("state", barGroup);
        stat.setUIID("SelectBar");
       
       
       
        RadioButton partage = RadioButton.createToggle("Ajouter", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
          ListeRec a = new ListeRec(res);
           a.show();
            refreshTheme();
        });
//        Button pdf = new Button("pdf");
//       
//         pdf.addActionListener((e) -> {
//               InfiniteProgress ip = new InfiniteProgress();
//        final Dialog ipDlg = ip.showInifiniteBlocking();
//        
//            if (Dialog.show("Confirmation", "Voulez vous imprimer ces reunions en pdf ?", "Oui", "Annuler")) {
//                                                
//                                                              
//                                                                      
//                                                                      
//                                                                        Dialog.show("Success","imprimer",new Command("OK"));
//                                                                        new Pdf(res).show();
//                                                                      
//                                                                  
//
//                                            }
//           
//            refreshTheme();                    
//        });
//         ct.add(liste);
         
            liste.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
          Pdf a2 = new Pdf(res);
           a2.show();
         
            refreshTheme();
        });
             
         stat.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
          StatistiquePieForme a2 = new StatistiquePieForme(res);
           a2.show();
         
            refreshTheme();
        });
       
       
         
         
       
         partage.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
        AjouteReclamationForm a1 = new AjouteReclamationForm(res);
           a1.show();
          // StatistiquePieForm
         
            refreshTheme();
        });
       
     
        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(4, mesListes,liste,stat, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
       bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

       
       
       
     
TextField nom = new TextField("", " Nom");
        nom.setUIID("TextFieldBlack");
        addStringValue("nom",nom);
        
        TextField prenom = new TextField("", "prenom");
         prenom.setUIID("TextFieldBlack");
        addStringValue("prenom",prenom);
        
        TextField email = new TextField("", "Email");
         email.setUIID("TextFieldBlack");
        addStringValue("prenom",email);
        
          TextArea  commentaire = new TextArea ("");
         commentaire.setUIID("TextFieldBlack");
        addStringValue("commentaire",commentaire);
        
      Picker datereclamation = new Picker();
        datereclamation.setType(Display.PICKER_TYPE_DATE);
         datereclamation.setUIID("TextFieldBlack");
        addStringValue("datereclamation",datereclamation);
     
       ComboBox solo = new ComboBox("Evenement", "Voyage", "Hotel");
        solo.setUIID("TextFieldBlack");
        addStringValue("typereclamation", solo);
        
        Button btnAjouter = new Button("Ajouter");
        addStringValue("", btnAjouter);
       
       
        //onclick button event

        btnAjouter.addActionListener((e) -> {
           
           
            try {
               
                if ((nom.getText().length() == 0) || (prenom.getText().length() == 0) ||  (email.getText().length() == 0)||  (commentaire.getText().length() == 0)||(datereclamation.getText().length() == 0))
                {
                   
                    Dialog.show("Alert", "Please fill all the fields", "OK", "");}
                else {
                    InfiniteProgress ip = new InfiniteProgress();; //Loading  after insert data
               
                    Reclamation r = new Reclamation(nom.getText(), prenom.getText(), email.getText(),commentaire.getText(),datereclamation.getText(),solo.getSelectedItem().toString());
                      if (ServicesReclamation.getInstance().addProduit(r)) {
                        Dialog.show("Success", "Connection accepted", "OK", "");
                        System.out.println("********");
                    } else {
                        Dialog.show("ERROR", "Server error", "OK", "");  
                    }
               
                    final Dialog iDialog = ip.showInfiniteBlocking();
                   
                  //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                   
                    //njibo iduser men session (current user)
                    Reclamation m = new Reclamation((nom.getText()).toString(),
                               
                                  (prenom.getText()).toString(),
                            (email.getText()).toString(),
                            (commentaire.getText()).toString(),
                                  String.valueOf(datereclamation.getText()).toString(),
                    solo.getSelectedItem().toString());


                                //   0,SessionManager.getIdMaison());
                   
                   System.out.println("data  evenement == "+m);
                   
                   
                    //appelle methode ajouterReclamation mt3 service Reclamation bch nzido données ta3na fi base
                    ServicesReclamation.getInstance().addProduit(m);
                   
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                   
                    //ba3d ajout net3adaw lel ListREclamationForm
                  new ListeRec(res).show();
                   
                   
                    refreshTheme();//Actualisation
                           
                }
               
            }catch(Exception ex ) {
                ex.printStackTrace();
            }
           
           
           
           
           
        });
       
       
    }

    private void addStringValue(String s, Component v) {
       
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
    }

    private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
       
        if(image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
       
       
       
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2 ) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
        }
       
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
        Label overLay = new Label("","ImageOverlay");
       
       
        Container page1 =
                LayeredLayout.encloseIn(
                imageScale,
                        overLay,
                        BorderLayout.south(
                        BoxLayout.encloseY(
                        new SpanLabel(text, "LargeWhiteText"),
                                        spacer
                        )
                    )
                );
       
        swipe.addTab("",res.getImage("Logo.png"), page1);
       
       
       
       
    }
   
   
   
    public void bindButtonSelection(Button btn , Label l ) {
       
        btn.addActionListener(e-> {
        if(btn.isSelected()) {
            updateArrowPosition(btn,l);
        }
    });
    }

    private void updateArrowPosition(Button btn, Label l) {
       
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
        l.getParent().repaint();
    }
}

//    Form current;
//
//    public AjouteReclamationForm(Resources res) {
//        super("Newsfeed", BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
//
//        Toolbar tb = new Toolbar(true);
//        current = this;
//        setToolbar(tb);
//        getTitleArea().setUIID("Container");
//        setTitle("Ajout Reclamation");
//        getContentPane().setScrollVisible(false);
//
//        tb.addSearchCommand(e -> {
//
//        });
//
//        Tabs swipe = new Tabs();
//
//        Label s1 = new Label();
//        Label s2 = new Label();
//
//        addTab(swipe, s1, res.getImage("dar-nour-3.jpg"), "", "", res);
//
//        //
//        swipe.setUIID("Container");
//        swipe.getContentPane().setUIID("Container");
//        swipe.hideTabs();
//
//        ButtonGroup bg = new ButtonGroup();
//        int size = Display.getInstance().convertToPixels(1);
//        Image unselectedWalkthru = Image.createImage(size, size, 0);
//        Graphics g = unselectedWalkthru.getGraphics();
//        g.setColor(0xffffff);
//        g.setAlpha(100);
//        g.setAntiAliased(true);
//        g.fillArc(0, 0, size, size, 0, 360);
//        Image selectedWalkthru = Image.createImage(size, size, 0);
//        g = selectedWalkthru.getGraphics();
//        g.setColor(0xffffff);
//        g.setAntiAliased(true);
//        g.fillArc(0, 0, size, size, 0, 360);
//        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
//        FlowLayout flow = new FlowLayout(CENTER);
//        flow.setValign(BOTTOM);
//        Container radioContainer = new Container(flow);
//        for (int iter = 0; iter < rbs.length; iter++) {
//            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
//            rbs[iter].setPressedIcon(selectedWalkthru);
//            rbs[iter].setUIID("Label");
//            radioContainer.add(rbs[iter]);
//        }
//
//        rbs[0].setSelected(true);
//        swipe.addSelectionListener((i, ii) -> {
//            if (!rbs[ii].isSelected()) {
//                rbs[ii].setSelected(true);
//            }
//        });
//
//        Component.setSameSize(radioContainer, s1, s2);
//        add(LayeredLayout.encloseIn(swipe, radioContainer));
//
//        ButtonGroup barGroup = new ButtonGroup();
//        RadioButton mesListes = RadioButton.createToggle("maison", barGroup);
//        mesListes.setUIID("SelectBar");
//        RadioButton liste = RadioButton.createToggle("Maps", barGroup);
//        liste.setUIID("SelectBar");
//
//        RadioButton stat = RadioButton.createToggle("statistique", barGroup);
//        stat.setUIID("SelectBar");
//
//        RadioButton partage = RadioButton.createToggle("Ajouter", barGroup);
//        partage.setUIID("SelectBar");
//        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
//
//        mesListes.addActionListener((e) -> {
//            InfiniteProgress ip = new InfiniteProgress();
//            final Dialog ipDlg = ip.showInifiniteBlocking();
//
//         //   ListeRec a = new ListeRec(res);
//         //   a.show();
//            refreshTheme();
//        });
//
//        liste.addActionListener((e) -> {
//            InfiniteProgress ip = new InfiniteProgress();
//            final Dialog ipDlg = ip.showInifiniteBlocking();
//
//            //     MapsAPIForm a1 = new MapsAPIForm();
//            new MapsAPIForm();
//            //    a1.show();
//            refreshTheme();
//        });
//
//        stat.addActionListener((e) -> {
//            InfiniteProgress ip = new InfiniteProgress();
//            final Dialog ipDlg = ip.showInifiniteBlocking();
//
//            StatistiquePieForm a2 = new StatistiquePieForm(res);
//            a2.show();
//
//            refreshTheme();
//        });
//
//        partage.addActionListener((e) -> {
//            InfiniteProgress ip = new InfiniteProgress();
//            final Dialog ipDlg = ip.showInifiniteBlocking();
//
//            AjouteReclamationForm a1 = new AjouteReclamationForm(res);
//            a1.show();
//            // StatistiquePieForm
//
//            refreshTheme();
//        });
//
//        add(LayeredLayout.encloseIn(
//                GridLayout.encloseIn(4, mesListes, liste, stat, partage),
//                FlowLayout.encloseBottom(arrow)
//        ));
//
//        partage.setSelected(true);
//        arrow.setVisible(false);
//        addShowListener(e -> {
//            arrow.setVisible(true);
//            updateArrowPosition(partage, arrow);
//        });
//        bindButtonSelection(mesListes, arrow);
//        bindButtonSelection(liste, arrow);
//        bindButtonSelection(partage, arrow);
//        // special case for rotation
//        addOrientationListener(e -> {
//            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
//        });
//
//        //
//        TextField nom = new TextField("", "Votre Nom");
//        nom.setUIID("TextFieldBlack");
//        addStringValue("nom", nom);
//
//        TextField prenom = new TextField("", "Votre Prenom");
//        prenom.setUIID("TextFieldBlack");
//        addStringValue("prenom", prenom);
//        
//        TextField email = new TextField("", " Votre Email");
//        email.setUIID("TextFieldBlack");
//        addStringValue("email", email);
//        
//        TextField commentaire = new TextField("", "Votre Prenom");
//        commentaire.setUIID("TextFieldBlack");
//        addStringValue("commentaire", commentaire);
//        
//        
//        ComboBox solo = new ComboBox("Evenement", "Voyage", "Hotel");
//        solo.setUIID("TextFieldBlack");
//        addStringValue("typereclamation", solo);
//         Picker datepicker = new Picker();
//        datepicker.setType(Display.PICKER_TYPE_DATE);
//         datepicker.setUIID("TextFieldBlack");
//        addStringValue("dateReclamation",datepicker);
//        //  TextField id = new TextField("", " id");
//       // TextField id = new TextField("", " Votre id");
//        Button btnValider = new Button("Ajouter Reclamations");
//        addStringValue("", btnValider);
//        //onclick button event 
//
//        btnValider.addActionListener((e) -> {
//
//            try {
//
//                if ((nom.getText().length() == 0) || (prenom.getText().length() == 0) || (email.getText().length() == 0) || (commentaire.getText().length() == 0) || (datepicker.getText().length() == 0)) {
//                    Dialog.show("Alert", "Please fill all the fields", "OK", "");
//                } else {
//                    InfiniteProgress ip = new InfiniteProgress(); //Loading  after insert data
//
//                    final Dialog iDialog = ip.showInfiniteBlocking();
//
//                    //  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                    //njibo iduser men session (current user)
//                    Reclamation r = new Reclamation(nom.getText(), prenom.getText(), email.getText(), commentaire.getText(), datepicker.getText(), solo.getSelectedItem().toString());
//
//                    if (ServicesReclamation.getInstance().addProduit(r)) {
//                        Dialog.show("Success", "Connection accepted", "OK", "");
//                        System.out.println(r);
//                    } else {
//                        Dialog.show("ERROR", "Server error", "OK", "");
//
//                    }
//
//                    //   0,SessionManager.getIdMaison());
//                    //appelle methode ajouterReclamation mt3 service Reclamation bch nzido données ta3na fi base 
//                    //  ServicesReclamation.getInstance().addProduit(m);
//                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
//
//                    //ba3d ajout net3adaw lel ListREclamationForm
//                    //   new ListMaisonForm(res).show();
//                    refreshTheme();//Actualisation
//
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//        });
//
//    }
//
//    private void addStringValue(String s, Component v) {
//
//        add(BorderLayout.west(new Label(s, "PaddedLabel"))
//                .add(BorderLayout.CENTER, v));
//        add(createLineSeparator(0xeeeeee));
//    }
//
//    private void addTab(Tabs swipe, Label spacer, Image image, String string, String text, Resources res) {
//        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
//
//        if (image.getHeight() < size) {
//            image = image.scaledHeight(size);
//        }
//
//        if (image.getHeight() > Display.getInstance().getDisplayHeight() / 2) {
//            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 2);
//        }
//
//        ScaleImageLabel imageScale = new ScaleImageLabel(image);
//        imageScale.setUIID("Container");
//        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
//
//        Label overLay = new Label("", "ImageOverlay");
//
//        Container page1
//                = LayeredLayout.encloseIn(
//                        imageScale,
//                        overLay,
//                        BorderLayout.south(
//                                BoxLayout.encloseY(
//                                        new SpanLabel(text, "LargeWhiteText"),
//                                        spacer
//                                )
//                        )
//                );
//
//        swipe.addTab("", res.getImage("Logo.png"), page1);
//
//    }
//
//    public void bindButtonSelection(Button btn, Label l) {
//
//        btn.addActionListener(e -> {
//            if (btn.isSelected()) {
//                updateArrowPosition(btn, l);
//            }
//        });
//    }
//
//    private void updateArrowPosition(Button btn, Label l) {
//
//        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);
//        l.getParent().repaint();
//    }


