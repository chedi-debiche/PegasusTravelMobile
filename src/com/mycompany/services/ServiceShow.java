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
import com.mycompany.entities.Evenement;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rahma
 */
public class ServiceShow {

    public static ServiceShow instance = null;
    private ConnectionRequest req;
    public boolean resultOK;
    public ArrayList<Evenement> Reclamation;
    public ArrayList<Evenement> Event;

    public static ServiceShow getInstance() {
        if (instance == null) {
            instance = new ServiceShow();
        }
        return instance;
    }
    public ServiceShow() {
        req = new ConnectionRequest();
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
