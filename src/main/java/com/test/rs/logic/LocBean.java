package com.test.rs.logic;

import com.test.rs.entity.Loc;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "location")
public class LocBean implements LocLocal{
    
    @PersistenceContext(unitName = "LocatonPU")
    private EntityManager em;
    
    public void addLocListFromRestPakage(ArrayList<Loc> locList){
        for(Loc loc : locList){
            em.persist(loc);
        }
    }
}
