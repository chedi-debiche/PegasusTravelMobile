/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

/**
 *
 * @author rahma
 */

    
import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.events.ActionListener;

import java.util.ArrayList;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Evenement;
import com.mycompany.utils.Statics;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 21695
 */
public class ServiceEvenement {
     public static ServiceEvenement instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    private Resources res;

    public ServiceEvenement() {
        req = new ConnectionRequest();
    }

    public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }
        return instance;
    }

        public boolean addEvent(Evenement a) {

        String url = Statics.BASE_URL+ "/addEvenementMobile";
     
    System.out.println(a);
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("nomevent", a.getNomevent()+"");
       req.addArgument("prixevent", a.getPrixevent()+"");
       req.addArgument("date", a.getDate()+"");
      
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

 public boolean modifEvent( Evenement r) {
       
        System.out.println(r);
        System.out.println("********");
       String url = Statics.BASE_URL + "/updateEvenementMobile";
               req.addArgument("idevent", r.getIdevent()+"");
               req.addArgument("nomevent", r.getNomevent()+"");
                req.addArgument("prixevent", r.getPrixevent()+"");
                req.addArgument("date", r.getDate()+"");
       
       
             
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
    
//    public boolean modifEvent( Evenement r) {
//       
//        System.out.println(r);
//        System.out.println("********");
//       String url = Static.Base_URL + "/updateEvenementMobile?idevent="
//               + r.getIdevent()+
//               "&nomevent=" + r.getNomevent()+
//               "&prixevent=" + r.getPrixevent()+
//               "date=" + r.getDate()
//             ;
//         System.out.println("********");
//      
//   
//       req.setUrl(url);
//       
//
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//                if (resultOK || req.getResponseCode() == 202) {
//                    Dialog.show("sucess", "evenement modifié", null, "OK");
//                   
//
//                }
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }
//    

    public boolean supprimerEvent(int id) {
       
         String url = Statics.BASE_URL + "/deleteEvenementMobile";

        req.setUrl(url);
        req.setPost(false);
        String s=Integer.toString(id); 
        req.addArgument("idevent", s);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                if (resultOK || req.getResponseCode() == 202) {
                    Dialog.show("sucess", "evenement supprimé", null, "OK");
                    
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public ArrayList<Evenement> getAllEvents() {
        ArrayList<Evenement> result = new ArrayList<>();
        String url = Statics.BASE_URL + "/displayEvenementMobile";
        req.setUrl(url);
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp;
            jsonp = new JSONParser();
            
            try {
                Map<String, Object> mapReservation = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapReservation.get("root");
                
                for (Map<String, Object> obj : listOfMaps) {
                    Evenement r = new Evenement();
                    float id = Float.parseFloat(obj.get("idevent").toString());
                    r.setIdevent((int)id);
                    r.setNomevent(((obj.get("nomevent").toString())));
                    r.setPrixevent(Float.parseFloat(obj.get("prixevent").toString()));
                    r.setDate(((obj.get("date").toString())));
                    result.add(r);
                }
            } catch (Exception ex) {
                
                ex.printStackTrace();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);//execution requete else nothing pass
        return result;
    }
        

}

//    public static ServiceEvenement instance = null;
//    private ConnectionRequest req;
//   
//    public boolean resultOK;
//    public ArrayList<Evenement> Reclamation;
//    public ArrayList<Evenement> Event;
// 
//    public static ServiceEvenement getInstance() {
//        if (instance == null) {
//            instance = new ServiceEvenement();
//        }
//        return instance;
//
//    }
//
//    public ServiceEvenement() {
//        req = new ConnectionRequest();
//    }
//
//    public boolean addEvent(Evenement a) {
//
//        String url = Static.Base_URL+ "/addEvenementMobile";
//     
//    System.out.println(a);
//       req.setUrl(url);
//       req.setPost(false);
//       req.addArgument("nomevent", a.getNomevent()+"");
//       req.addArgument("prixevent", a.getPrixevent()+"");
//       req.addArgument("date", a.getDate()+"");
//      
//       req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//       
//        return resultOK;
//       
//    }
//
//public boolean deleteEvent(int id ) {
//        String url = Static.Base_URL +"/deleteEvenementMobile?idevent="+id;
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
//     public boolean updateEvent(Evenement e) {
//        String url = Static.Base_URL +"/updateEvenement?idevent="+e.getIdevent()+"&nomevent="+e.getNomevent()+"&prixevent="+e.getPrixevent()+"&date="+e.getDate();
//        req.setUrl(url);
//        
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                resultOK = req.getResponseCode() == 200 ;  // Code response Http 200 ok
//                req.removeResponseListener(this);
//            }
//        });
//        
//    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
//    return resultOK;
//}

