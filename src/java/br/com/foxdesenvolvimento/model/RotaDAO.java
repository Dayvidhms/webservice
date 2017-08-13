
package br.com.foxdesenvolvimento.model;

import br.com.foxdesenvolvimento.controller.Motorista;
import br.com.foxdesenvolvimento.controller.Rota;
import br.com.foxdesenvolvimento.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;


public class RotaDAO {
    private Session sessao;
    
    public RotaDAO(){
        sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insereRota(Rota rota){
        try{
            this.sessao.beginTransaction();
            sessao.save(rota);
            sessao.getTransaction().commit();
        }catch(Exception ex){
            
        }
        
        sessao.close();
    }

    
}
