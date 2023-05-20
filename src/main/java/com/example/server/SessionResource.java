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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Comparator;

import com.example.pojo.Session;

import dao.SessionDAO;

@Path("sessions")
public class SessionResource {
    SessionDAO s = SessionDAO.getInstance();
    static List<Session> sessions = new ArrayList<Session>();


	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/creation")
    public Response makeSession(Session session) {
        sessions = s.getAll();

        for(Session se : sessions){
            if((session.getCode() == se.getCode()) && (session.getDate() == se.getDate())){
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }else{
                s.save(session);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
	
}
