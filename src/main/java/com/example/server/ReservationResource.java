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

@Path("reservations")
public class ReservationResource {
    ReservationDAO r = ReservationDAO.getInstance();
    static List<Reservation> reservations = new ArrayList<Reservation>();
    static User loggedUser;

    @GET
    @Path("/reserv={seat}&{row}&{date}&{hour}")
    public Response makeReservation(@PathParam("seat") int seat,@PathParam("row") int row,@PathParam("date") String dateS,@PathParam("hour") String hour,User user) {
    	
    	SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		try {
			date = (Date) formatdate.parse(dateS);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	
    	Session sesi = new Session(1,date,hour,1);
    	Reservation reserv = new Reservation(1,seat,row,sesi,loggedUser);
    	
        reservations = r.getAll();
        reserv.setReservoir(loggedUser);
        for(Reservation re : reservations){
            if(reserv.getRow() == re.getRow() && reserv.getSeat() == re.getSeat() && reserv.getCode() == re.getCode()){
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }else{
                r.save(reserv);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

}
