package com.test.rs.logic;

import com.test.rs.entity.Loc;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "location")
public class LocBean implements LocLocal{
    
    @PersistenceContext(unitName = "LocatonPU")
    private EntityManager em;
    
    @Override
    public void addLocListFromRestPakage(ArrayList<Loc> locList){
        Iterator<Loc> it = locList.iterator();
        while (it.hasNext()) {
            Loc loc = it.next();
            em.persist(loc);
        }
    }
}
