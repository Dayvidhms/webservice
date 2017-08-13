package br.com.foxdesenvolvimento.model;

import br.com.foxdesenvolvimento.controller.Veiculo;
import br.com.foxdesenvolvimento.util.HibernateUtil;
import org.hibernate.Session;

public class VeiculoDAO {
    
    private Session sessao;
    
    public VeiculoDAO(){
        sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insereVeiculo(Veiculo veiculo){
        try{
            this.sessao.beginTransaction();
            sessao.save(veiculo);
            sessao.getTransaction().commit();
        }catch(Exception e){
            
        }
    }
}
