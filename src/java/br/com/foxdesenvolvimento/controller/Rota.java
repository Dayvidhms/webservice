package br.com.foxdesenvolvimento.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Rota {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String escolas;
    private String bairros;
    
    @OneToOne(targetEntity = Motorista.class)
    private Motorista motorista;

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public String getEscolas() {
        return escolas;
    }

    public void setEscolas(String escolas) {
        this.escolas = escolas;
    }

    public String getBairros() {
        return bairros;
    }

    public void setBairros(String bairros) {
        this.bairros = bairros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}