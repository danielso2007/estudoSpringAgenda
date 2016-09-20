package br.com.estudo.agenda.web.resources;

import br.com.estudo.agenda.interfaces.services.AgendaService;
import br.com.estudo.agenda.model.domain.Agenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("/agenda")
public class AgendaResource {

    @Autowired
    private AgendaService agendaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(Agenda agenda) {
        agendaService.save(agenda);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Agenda find(@PathParam("id") Long id) {
        return agendaService.find(id);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        Agenda agenda = agendaService.find(id);
        agendaService.delete(agenda);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Agenda agenda) {
        agendaService.update(agenda);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Agenda> listAll() {
        return agendaService.listAll();
    }

}
