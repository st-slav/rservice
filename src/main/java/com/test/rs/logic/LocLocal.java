package com.test.rs.logic;

import com.test.rs.entity.Loc;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface LocLocal {
    
    void addLocListFromRestPakage(ArrayList<Loc> locList);    
}
