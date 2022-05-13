/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Reclamation;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 21695
 */
public class ListReca {
  Form previous;

    Resources theme = UIManager.initFirstTheme("/theme");

    public static Reclamation currentAliment = null;
    Button addBtn;

    TextField searchTF;
    ArrayList<Component> componentModels;
    public ArrayList<Reclamation> coach;
   

    public static ListReca instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ListReca() {
        req = new ConnectionRequest();
    }

    public static ListReca getInstance() {
        if (instance == null) {
            instance = new ListReca();
        }
        return instance;
    }

  /*  public ArrayList<Reclamation> parseTasks(String jsonText) {
        try {
            coach = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> ListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) ListJson.get("root");

            for (Map<String, Object> obj : list) {
                Reclamation r = new Reclamation();

               float id = Float.parseFloat(obj.get("numero").toString());
                r.setNumero((int)id);
                r.setNom(((obj.get("nom").toString())));
                r.setPrenom(((obj.get("prenom").toString())));
                r.setEmail(((obj.get("email").toString())));    
                r.setCommentaire(((obj.get("commentaire").toString())));
                r.setTypereclamation(((obj.get("typeReclamation").toString())));
                r.setDatereclamation(((obj.get("dateReclamation").toString())));

                coach.add(r);
            }

        }
        catch (IOException ex) {

        }
        return coach;
    }

    public ArrayList<Reclamation> getAllcoach() {
        req = new ConnectionRequest();
        String url = Static.Base_URL + "/displayReclamationMobile";

        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                coach = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return coach;
    }*/
    
    
    public ArrayList<Reclamation>affichageReclamations() {
        ArrayList<Reclamation> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/displayReclamationMobile";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapReservation = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReservation.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Reclamation r = new Reclamation();
                        
                        
                        
                        
                        
                        
                        float id = Float.parseFloat(obj.get("numero").toString());
                        r.setNumero((int)id);
                        r.setNom(((obj.get("nom").toString())));
                        r.setPrenom(((obj.get("prenom").toString())));
                        r.setEmail(((obj.get("email").toString())));
                        r.setCommentaire(((obj.get("commentaire").toString())));
                        r.setTypereclamation(((obj.get("typereclamation").toString())));
                        r.setDatereclamation(((obj.get("datereclamation").toString())));
                     
                        //Date
//                        String DateConverter =  obj.get("date").toString().substring(obj.get("date").toString().indexOf("timestamp") + 10 , obj.get("date").toString().lastIndexOf("}"));
//                        
//                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
//                        
//                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                        String dateString = formatter.format(currentTime);
//                        re.setDate(dateString);

//insert data into ArrayList result
result.add(r);


                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution requete else nothing pass

        return result;
        
        
    }
     
}

