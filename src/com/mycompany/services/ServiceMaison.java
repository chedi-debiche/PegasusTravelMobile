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
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Lenovo
 */
public class ServiceMaison {
    
    //singleton 
    public static ServiceMaison instance = null ;
    
    public static boolean resultOk = true;

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceMaison getInstance() {
        if(instance == null )
            instance = new ServiceMaison();
        return instance ;
    }
    
    
    
    public ServiceMaison() {
        req = new ConnectionRequest();
        
    }
    
    
    //ajout 
    public void ajoutMaison(Maison maison) {
        
        String url =Statics.BASE_URL+"/addMaisonMobile?nom="+maison.getNom()+"&localisation="+maison.getLocalisation()+"&description="+maison.getDescription()+"&prix="+maison.getPrix()+"&imageMaison="+maison.getImageMaison(); // aa sorry n3adi getId lyheya mech ta3 user ta3 reclamation
        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
    //affichage
    

      
      
      
      
      public ArrayList<Maison> affichageMaison()
    {

        ArrayList<Maison> result = new ArrayList<>();
        String url = Statics.BASE_URL+"/displayMaisonMobile";
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                JSONParser jsonp;
                jsonp = new JSONParser();
                
                try 
                {
                    Map<String,Object>mapMaison = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String,Object>> ListOfMaps = (List<Map<String,Object>>) mapMaison.get("root");
                    System.out.println(mapMaison);
                    for(Map<String, Object> obj : ListOfMaps)
                    {
                        System.out.println(obj);
                        Maison c = new Maison();
                        float id = Float.parseFloat(obj.get("idMaison").toString());
                        String NameMaison = obj.get("nom").toString();
                        String Localisation = obj.get("localisation").toString();
                         String Description = obj.get("description").toString();
                        float Prix = Float.parseFloat(obj.get("prix").toString());
                        String ImageMaison = obj.get("imageMaison").toString();

                        c.setIdMaison((int)id);
                        c.setNom(NameMaison);
                        c.setLocalisation(Localisation);
                        c.setDescription(Description);
                        c.setPrix((float)Prix);
                        c.setImageMaison(ImageMaison);
                        
                        result.add(c);
                        System.out.println(c.getIdMaison()+" "+c.getNom()+" "+c.getLocalisation()+" "+c.getDescription()+" "+c.getPrix()+" "+c.getImageMaison());
                    }
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

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
                System.out.println("error related to sql :( "+ex.getMessage());
            }
            
            
            System.out.println("data === "+str);
            
            
            
        }));
        
              NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

              return reclamation;
        
        
    }*/
    
    
    //Delete 
    public boolean deleteMaison(int id ) {
        String url = Statics.BASE_URL +"/deleteMaisonMobile?id="+id;
        
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
   public boolean modifierMaison(Maison maison) {
        String url = Statics.BASE_URL +"/updateMaisonMobile?id="+maison.getIdMaison()+"&nom="+maison.getNom()+"&localisation="+maison.getLocalisation()+"&description="+maison.getDescription()+"&prix="+maison.getPrix()+"&imageMaison="+maison.getImageMaison();
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