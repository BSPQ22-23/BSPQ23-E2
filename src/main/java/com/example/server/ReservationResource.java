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

import dao.ReservationDAO;

@Path("reservations")
public class ReservationResource {
    ReservationDAO r = ReservationDAO.getInstance();
    static List<Reservation> reservations = new ArrayList<Reservation>();


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/reserv")
    public Response makeReservation(Reservation reserv) {
        reservations = r.getAll();

        for(Reservation re : reservations){
            if(reserv.getRow() == re.getRow() && reserv.getSeat() == re.getSeat()){
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }else{
                r.save(reserv);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }

}
