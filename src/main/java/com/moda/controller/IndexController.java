package com.moda.controller;

import com.moda.model.Kullanici;
import com.moda.repository.KullaniciRepository;
import com.rabbitmq.client.AMQP;
import dagger.Reusable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    KullaniciRepository repository;

    @RequestMapping("/")
    public ModelAndView index(Model model) {
        model.addAttribute("kullanici",new Kullanici());
        return new ModelAndView("index");
    }

   /* @RequestMapping(value = "/login")
    public String logins(Kullanici kullanici) throws SQLException {
        String email, sifre;
        email = kullanici.getEmail();
        sifre = kullanici.getSifre();
        Connection con;
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false", "root", "bedir123456");
        if (kullanici != null) {
            String query = "SELECT * FROM Kullanici WHERE email = '" + email + "' AND sifre = '" + sifre + "'";
            Statement sta = (Statement) con.createStatement();
            ResultSet res = sta.executeQuery(
                    "SELECT * FROM Kullanici WHERE email = '" + email + "' AND sifre = '" + sifre + "'");
            String email2="";
            String pass="";
            String User="";
            while (res.next()) {
                 email2=res.getString(7);
                 pass=res.getString(10);
                 User=res.getString(9);
            }
            if(email2!=""&&pass!=""&&User.equals("MUSTERI")) {
                con.close();
                return "login";

            }
            else if(email2!=""&&pass!=null&&User.equals("MODACI")) {

                return "admin";
            }
            else {
                con.close();
                return "index";
            }
            }
        else{
            con.close();
            return "index";
        }
        }
*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("user") Kullanici kullanici) {
       ModelAndView model=new ModelAndView();
        Kullanici kullanici2= repository.findByEmail(kullanici.getEmail());
       String kullanicitur=kullanici2.getKullaniciTipi().toString();
       if(kullanici2!=null) {
           if(kullanicitur.equals("MUSTERI")) {
            model.setViewName("CanliGorusme");
            model.addObject("kullanici",kullanici2);
            return model;
           }
            else {
                model.setViewName("MODACI");
                model.setViewName("CanliGorusmeModa");
                model.addObject(kullanici2);
               return model;

           }

        }
       else {

           return null;
       }


    }




}

