package com.example.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.omg.CORBA.TSIdentificationPackage.NotAvailable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Comparator;

import com.example.pojo.Reservation;
import com.example.pojo.Session;
import com.example.pojo.User;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import dao.ReservationDAO;
import dao.SessionDAO;

@Path("reservations")
public class ReservationResource {
    ReservationDAO r = ReservationDAO.getInstance();
    static List<Reservation> reservations = new ArrayList<Reservation>();
    static User loggedUser;

    @GET
    @Path("/reserv={seat}&{row}&{date}&{hour}")
    public Response makeReservation(@PathParam("seat") int seat,@PathParam("row") int row,@PathParam("date") String dateS,@PathParam("hour") String hour,User user) {
    	
    	
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	
    	List<Session> sesi = SessionDAO.getInstance().getAll();
    	int se = 0;
    	
    	for (Session session : sesi) {
			try {
				if(session.getDate().equals(format.parse(dateS)) && session.getTime().equals(hour)) {
					se = session.getCode();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	
    	
    	List<Reservation> res = r.getAll();
    	
    	
    	Reservation reserv = new Reservation(res.size()+1,seat,row,se,1);

        reservations = r.getAll();
        for(Reservation re : reservations){
            if(reserv.getRow() == re.getRow() && reserv.getSeat() == re.getSeat() && reserv.getCode() == re.getCode()){
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }else{
                r.save(reserv);
                return Response.status(Response.Status.OK).build();
            }
        }
        
        if(true) {
        	r.save(reserv);
        	return Response.status(Response.Status.OK).build();
        }else {
        	return Response.status(Response.Status.GONE).build();
        }
        
    }
    
    @POST
    @Path("/Cancelreserve")
    public Response CancelReservation(Reservation can) {
    	
    	System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    	System.out.println(can);
    	try {
    		ReservationDAO.getInstance().delete(can);
    		return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
    	
    	
    }

}
