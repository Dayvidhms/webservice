package br.com.foxdesenvolvimento.ws;

import br.com.foxdesenvolvimento.controller.Motorista;
import br.com.foxdesenvolvimento.controller.Rota;
import br.com.foxdesenvolvimento.controller.Veiculo;
import br.com.foxdesenvolvimento.model.MotoristaDAO;
import br.com.foxdesenvolvimento.model.RotaDAO;
import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/rota")
public class RotaResource {
    @Context
    private UriInfo context;

    public RotaResource() {

    }


    @GET
    @Produces("application/json")
    public String getJson() {

        throw new UnsupportedOperationException();
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    @POST
    @Consumes("application/json")
    @Path("/post")
    public void inserirRota(String rota) {
        Gson gson = new Gson();
        Rota rotaResultado;
        
        Motorista m = new Motorista();
        
        try {
            JSONObject jsonObject = new JSONObject(rota);
            
            m.setCpf(jsonObject.getString("motorista_cpf"));
        } catch (JSONException ex) {
            Logger.getLogger(RotaResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        rotaResultado = (Rota) gson.fromJson(rota, Rota.class);
        
        rotaResultado.setMotorista(m);
        
        RotaDAO dao = new RotaDAO();
        dao.insereRota(rotaResultado);
    }
}
