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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    protected static final Logger logger = LogManager.getLogger();
    List<Reservation> reservations = new ArrayList<Reservation>();
    static User loggedUser;

    /**This function uses the POST method to create a reservation object in the database, via the SessionDAO.
     * @param seat
     * @param row
     * @param dateS
     * @param hour
     * @param user
     * @return Returns the status of the response.
     */
    @GET
    @Path("/reserv={seat}&{row}&{date}&{hour}")
    public Response makeReservation(@PathParam("seat") int seat,@PathParam("row") int row,@PathParam("date") String dateS,@PathParam("hour") String hour,User user) {
        reservations = r.getAll();
    	
    	
    	
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
    	
    	
    	Reservation reserv = new Reservation(res.size()+1,seat,row,se,loggedUser.getCode());

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
    
    /**This function erases a reservation from the database, thus canceling it.
     * @param can The reservation intended to be cancelled
     * @return
     */
    @DELETE
    @Path("/Cancelreserve={code}")
    public Response CancelReservation(@PathParam("code") int code) {
    	reservations = r.getAll();
    	System.out.println("___________________________________________________");
    	System.out.println(code);
    	try {
    		logger.info("Canceling reservation...");
    		Reservation re = r.find(Integer.toString(code));
    		System.out.println("___________________________________________________"+re);
    		r.delete(re);
    		return Response.ok().build();

		} catch (Exception e) {
			return Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
    	
    	
    }
    

}
