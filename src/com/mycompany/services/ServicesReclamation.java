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
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
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
public class ServicesReclamation  {
    public static ServicesReclamation instance = null;
    private ConnectionRequest req;
    Resources res;
    public boolean resultOK;
     private ConnectionRequest cr;
     public ArrayList<Reclamation> Reclamation;
    public ArrayList<Reclamation> games;
    Form previous;

    public static ServicesReclamation getInstance() {
        if (instance == null) {
            instance = new ServicesReclamation();
        }
        return instance;

    }

    public ServicesReclamation() {
        req = new ConnectionRequest();
    }

  

   public boolean addProduit(Reclamation a) {
       
     
         System.out.println(a);
       
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
      String url = Statics.BASE_URL+ "/addReclamationMobile";
     
    System.out.println(a);
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("nom", a.getNom()+"");
       req.addArgument("prenom", a.getPrenom()+"");
       req.addArgument("email", a.getEmail()+"");
       req.addArgument("commentaire", a.getCommentaire()+"");
       req.addArgument("typeReclamation", a.getTypereclamation()+"");
       req.addArgument("dateReclamation", a.getDatereclamation()+"");
       req.addArgument("id", a.getId()+"");
       
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
       
        return resultOK;
       
    }
   
     /*  public ArrayList<Reclamation> parseProduit(String jsonText){
        try {
           
            Reclamation =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson =
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamation r = new Reclamation();
                float id = Float.parseFloat(obj.get("numero").toString());
                r.setNumero((int)id);
                r.setNom(((obj.get("nom").toString())));
                r.setPrenom(((obj.get("prenom").toString())));
                r.setEmail(((obj.get("email").toString())));    
                r.setCommentaire(((obj.get("commentaire").toString())));
                r.setTypereclamation(((obj.get("typeReclamation").toString())));
                r.setDatereclamation(((obj.get("dateReclamation").toString())));
//                if (obj.get("titre")==null)
//                    r.setTitre("iheb");
//                else
//                    r.setTitre(obj.get("titre").toString());
                Reclamation.add(r);
            }
           
           
        } catch (IOException ex) {
           
        }
        return Reclamation;
    }
 public ArrayList<Reclamation> getAllProduits(){
        req = new ConnectionRequest();
        String url = Statics.BASE_URL+"/tasks/";
        String url = Static.Base_URL+"/displayReclamationMobile";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Reclamation = parseProduit(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Reclamation;
    }*/
  /*  public ArrayList<Reclamation> parseGames(String jsonText){
        try {
            games=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson =
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamation r = new Reclamation();
               float id = Float.parseFloat(obj.get("numero").toString());
                r.setNumero((int)id);
                r.setNom(((obj.get("nom").toString())));
                r.setPrenom(((obj.get("prenom").toString())));
                r.setEmail(((obj.get("email").toString())));    
                r.setCommentaire(((obj.get("commentaire").toString())));
                r.setTypereclamation(((obj.get("typeReclamation").toString())));
                r.setDatereclamation(((obj.get("dateReclamation").toString())));
               //  if (obj.get("description")==null)
           //   t.setDescription(obj.get("des"));
              //  else
                   
                games.add(r);
            }
           
           
        } catch (IOException ex) {
           
        }
        return games;
    }
      public ArrayList<Reclamation> getAllGames() {
        req= new ConnectionRequest();
        String url = Static.Base_URL + "/displayReclamationMobile";
        System.out.println("===>" + url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                games = parseGames(new String(req.getResponseData()));
                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return games;
    }*/
  
//    public boolean deleteReservation(int numero ) {
//        String url = Static.Base_URL +"/updateReclamation?id="+numero;
//        
//        req.setUrl(url);
//        
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                    
//                    req.removeResponseCodeListener(this);
//            }
//        });
//        
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return  resultOK;
//    }
//   public boolean supprimerEvent(int numero) {
//        System.out.println("********");
//        String url = Static.Base_URL + "/deleteReclamationMobile";
//
//         req.setUrl(url);
//        
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                    
//                    req.removeResponseCodeListener(this);
//            }
//        });
//        
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return  resultOK;
//    }
   public boolean supprimerEvent(int numero) {
        System.out.println("********");
        String url = Statics.BASE_URL+ "/deleteReclamationMobile";

        req.setUrl(url);
   req.setPost(false);
   String s=Integer.toString(numero);
        req.addArgument("numero", s);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                if (resultOK || req.getResponseCode() == 202) {
                    Dialog.show("sucess", "Reclamation supprimé", "Anuller", "OK");
                    //new ListeRec(previous).show();
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
//    public boolean modifEvent( String nom,String prenom, String email, String commentaire,String datereclamation, String typereclamation) {
//        System.out.println("********");
//        String url = Static.Base_URL + "/updateReclamation";
//
//        req.setUrl(url);
//        req.setPost(false);
//        req.addArgument("nom", nom);
//        req.addArgument("prenom", prenom);
//        req.addArgument("email", email);
//        req.addArgument("commentaire", commentaire);
//          req.addArgument("typeReclamation", typereclamation);
//        req.addArgument("dateReclamation", datereclamation);
//      
//
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//                if (resultOK || req.getResponseCode() == 202) {
//                    Dialog.show("sucess", "Reclamation modifié", null, "OK");
//                   
//
//                }
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }
    public boolean modifEvent(Reclamation a) {

//       String url = Static.Base_URL + "/updateReclamation";              
//       req.addArgument("numeo", a.getNumero()+"");
//        req.addArgument("nom", a.getNom()+"");
//       req.addArgument("prenom", a.getPrenom()+"");
//       req.addArgument("email", a.getEmail()+"");
//       req.addArgument("commentaire", a.getCommentaire()+"");
//       req.addArgument("typereclamation", a.getTypereclamation()+"");
//       req.addArgument("datereclamation", a.getDatereclamation()+"");
//        req.setUrl(url);      
//       req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }
System.out.println(a);
        System.out.println("********");
       String url = Statics.BASE_URL + "/updateReclamation";
               req.addArgument("numero", a.getNumero()+"");
               req.addArgument("nom", a.getNom()+"");
                req.addArgument("prenom", a.getPrenom()+"");
                req.addArgument("email", a.getEmail()+"");
                 req.addArgument("commentaire", a.getCommentaire()+"");
             req.addArgument("typereclamation", a.getTypereclamation()+"");
        req.addArgument("datereclamation", a.getDatereclamation()+"");
             
         System.out.println("********");
     
   
       req.setUrl(url);
       

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                if (resultOK || req.getResponseCode() == 202) {
                    Dialog.show("sucess", "evenement modifié", null, "OK");
                   

                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
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
