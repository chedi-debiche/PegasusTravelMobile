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
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Maison;
import com.mycompany.entities.Voyage;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceVoyage {
      public static ServiceVoyage instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceVoyage getInstance() {
        if(instance == null )
            instance = new ServiceVoyage();
        return instance ;
    }
    
    
    
    public ServiceVoyage() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public void ajoutVoyage(Voyage voyage) {
        
        String url =Statics.BASE_URL+"/addVoyageMobile?nom="+voyage.getNom()+"&destination="+voyage.getDestination()+"&description="+voyage.getDescription()+"&prix="+voyage.getPrix()+"&image="+voyage.getImage(); // aa sorry n3adi getId lyheya mech ta3 user ta3 reclamation
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
    //affichage
    
    public ArrayList<Voyage>affichageVoyage() {
        ArrayList<Voyage> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/displayVoyageMobile";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object>mapMaison = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapMaison.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps) {
                        Voyage me = new Voyage();
                        
                        //dima id fi codename one float 5outhouha
                      //  int id = Integer.parseInt(obj.get("id").toString());
                      float id = Float.parseFloat(obj.get("id").toString());
                        
                        String nom = obj.get("nom").toString();
                         String localisation = obj.get("destination").toString();

                        
                        String description = obj.get("description").toString();
                       // int prix = Integer.parseInt(obj.get("prix").toString());
                         float prix = Float.parseFloat(obj.get("prix").toString());
                        String image = obj.get("image").toString();

                        
                        me.setId((int)id);
                        me.setNom(nom);
                        me.setDestination(localisation);
                        me.setDescription(description);
                        me.setPrix((int)prix);
                        me.setImage(image);

                        
                        //Date 
                     
                        //insert data into ArrayList result
                        result.add(me);
                       
                    
                    }
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
        
        
    }
    
    
    
    //Detail Reclamation bensba l detail n5alihoa lel5r ba3d delete+update
    
   /* public Reclamation DetailRecalamation( int id , Reclamation reclamation) {
        
        String url = Statics.BASE_URL+"/detailReclamation?"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());
        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                
                reclamation.setObjet(obj.get("obj").toString());
                reclamation.setDescription(obj.get("description").toString());
                reclamation.setEtat(Integer.parseInt(obj.get("etat").toString()));
                
            }catch(IOException ex) {
                System.out.println("error related to sql 🙁 "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return reclamation;
        
        
    }
    
    
   */ //Delete 
    public boolean deleteVoyage(int id ) {
        String url = Statics.BASE_URL +"/deleteVoyageMobile?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    
    
    
    //Update 
    public boolean modifierVoyage(Voyage voyage) {
         String url = Statics.BASE_URL +"/updateVoyageMobile?id="+voyage.getId()+"&nom="+voyage.getNom()+"&destination="+voyage.getDestination()+"&description="+voyage.getDescription()+"&prix="+voyage.getPrix()+"&image="+voyage.getImage();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
        
    }
    

    
    
}