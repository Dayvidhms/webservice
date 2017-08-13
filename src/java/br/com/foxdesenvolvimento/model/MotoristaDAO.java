package br.com.foxdesenvolvimento.model;

import br.com.foxdesenvolvimento.controller.Motorista;
import br.com.foxdesenvolvimento.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class MotoristaDAO {
    
    private Session sessao;
    
    public MotoristaDAO(){
        sessao = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insereMotorista(Motorista motorista){
        try{
            this.sessao.beginTransaction();
            sessao.save(motorista);
            sessao.getTransaction().commit();
        }catch(Exception ex){
            
        }
        
        sessao.close();
    }
    
    public List<Motorista> selectMotoristas(){
        List<Motorista> motoristas;
        this.sessao.beginTransaction();
        Criteria criteria = this.sessao.createCriteria(Motorista.class);     
        
        motoristas = criteria.list();
        sessao.close();
        return motoristas;
    }
    
    /*public List<Motorista> selectMotoristaByRota(){
        List<Motorista> motoristas;
        this.sessao.beginTransaction();
        Criteria criteria = this.sessao.createCriteria(Motorista.class);
        
        criteria.add(Restrictions.)
        
     
       
    }*/
    
    
}
