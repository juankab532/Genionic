package co.edu.javeriana.ionic.servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import co.edu.javeriana.ionic.entidades.Entidad;

@Stateless
@Path("entidad")
@ApplicationPath("")
public class EntidadServices extends Application {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @GET
    @Path("/obtenerEntidad/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entidad obtenerEntidad(@PathParam("id") Long id) {
        return entityManager.find(Entidad.class, id);
    }
    
    @GET
    @Path("/obtenerTodasEntidades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entidad> obtenerTodasEntidades() {
        Query query = entityManager.createQuery("SELECT e FROM Entidad e");
        return query.getResultList();
    }
    
    @POST
    @Path("/agregarEntidad")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entidad agregarEntidad(Entidad entidad) {
        Entidad entidadCrear = new Entidad();
        entidadCrear.setCampo1(entidad.getCampo1());
        entidadCrear.setCampo2(entidad.getCampo2());
        entidadCrear.setCampo3(entidad.getCampo3());
        entityManager.persist(entidadCrear);
        return entidadCrear;
    }
    
    @POST
    @Path("/actualizarEntidad")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Entidad actualizarEntidad(Entidad entidad) {
        Entidad entidadActualizar = obtenerEntidad(entidad.getId());
        entidadActualizar.setCampo1(entidad.getCampo1());
        entidadActualizar.setCampo2(entidad.getCampo2());
        entidadActualizar.setCampo3(entidad.getCampo3());
        entidadActualizar = entityManager.merge(entidadActualizar);
        return entidadActualizar;
    }
    
    @POST
    @Path("/eliminarEntidad")
    @Consumes(MediaType.APPLICATION_JSON)
    public void eliminarEntidad(Long id) {
        entityManager.remove(obtenerEntidad(id));
    }
    
}
