package br.com.foxdesenvolvimento.ws;

import br.com.foxdesenvolvimento.controller.Motorista;
import br.com.foxdesenvolvimento.controller.Rota;
import br.com.foxdesenvolvimento.controller.Veiculo;
import br.com.foxdesenvolvimento.model.MotoristaDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
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

@Path("/motorista")
public class MotoristaResource {

    @Context
    private UriInfo context;

    public MotoristaResource() {

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
    
    @GET
    @Produces("application/json")
    @Path("/get")
    public String lista(){
        MotoristaDAO dao = new MotoristaDAO();
        Gson gson = new Gson();
        
        return gson.toJson(dao.selectMotoristas());
    }
    
    

    @POST
    @Consumes("application/json")
    @Path("/post")
    public void inserirMotorista(String motorista) {
        Gson gson = new Gson();
        Motorista motoristaResultado;
        
        Veiculo v = new Veiculo();           
        
        try{
            JSONObject jsonObject = new JSONObject(motorista);
            
            v.setPlaca(jsonObject.getString("veiculo_placa"));
        } catch (JSONException ex) {
            System.out.println("Erro ao converter!!!" + ex);
            
        }

        motoristaResultado = (Motorista) gson.fromJson(motorista, Motorista.class);

        motoristaResultado.setVeiculo(v);
        
        MotoristaDAO dao = new MotoristaDAO();
        dao.insereMotorista(motoristaResultado);
    }
    
    
    
    /*@POST
    @Consumes("application/json")
    @Path("/updateRota")
    public void inserirMotoristaRota(){
        Gson gson = new Gson();
        Motorista motoristaResultado;
        
    }*/

}
