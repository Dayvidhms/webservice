package br.com.foxdesenvolvimento.ws;

import br.com.foxdesenvolvimento.controller.Motorista;
import br.com.foxdesenvolvimento.controller.Veiculo;
import br.com.foxdesenvolvimento.model.VeiculoDAO;
import com.google.gson.Gson;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/veiculo")
public class VeiculoResource {
    
    @Context
    private UriInfo context;
    
    public VeiculoResource(){
        
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
    public void inserirVeiculo(String veiculo){
        Gson gson = new Gson();
        Veiculo veiculoResultado;
        
        veiculoResultado = (Veiculo) gson.fromJson(veiculo, Veiculo.class);

        VeiculoDAO dao = new VeiculoDAO();
        dao.insereVeiculo(veiculoResultado);
    }    
}
