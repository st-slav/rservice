package com.test.rs.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "loc")
public class Loc implements Serializable {
    
    // ======================================
    // =             Attributes             =
    // ======================================

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
    private Long locId;
    @Column(name = "loc_latitude")
    private Float locLatitude;
    @Column(name = "loc_longitude")
    private Float locLongitude;
    @Column(name = "loc_horizontalAccuracy")
    private Float locHorizontalAccuracy;
    @Column(name = "loc_speed")
    private Float locSpeed;
    @Column(name = "loc_course")
    private Float locCourse;
    @Column(name = "loc_altitude")
    private Float locAltitude;
    @Column(name = "loc_verticalAccuracy")
    private Float locVerticalAccuracy;
    @Size(max = 45)
    @Column(name = "loc_actuality")
    private String locActuality;
    @Column(name = "loc_timestamp")
    private BigInteger locTimestamp;
    
    // ======================================
    // =            Constructors            =
    // ======================================
    
    public Loc (Float locLatitude, Float locLongitude, Float locHorizontalAccuracy, Float locSpeed,
            Float locCourse, Float locAltitude, Float locVerticalAccuracy, String locActuality, 
            BigInteger locTimestamp){
        
        this.locLatitude = locLatitude;
        this.locLongitude = locLongitude;
        this.locHorizontalAccuracy = locHorizontalAccuracy;
        this.locSpeed = locSpeed;
        this.locCourse = locCourse;
        this.locAltitude = locAltitude;
        this.locVerticalAccuracy = locVerticalAccuracy;
        this.locActuality = locActuality;
        this.locTimestamp = locTimestamp;
    }
    
    public Loc (){
    }
    
    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getLocId() {
        return locId;
    }

    public void setLocId(Long locId) {
        this.locId = locId;
    }

    public Float getLocLatitude() {
        return locLatitude;
    }

    public void setLocLatitude(Float locLatitude) {
        this.locLatitude = locLatitude;
    }

    public Float getLocLongitude() {
        return locLongitude;
    }

    public void setLocLongitude(Float locLongitude) {
        this.locLongitude = locLongitude;
    }

    public Float getLochorizontalAccuracy() {
        return locHorizontalAccuracy;
    }

    public void setLochorizontalAccuracy(Float lochorizontalAccuracy) {
        this.locHorizontalAccuracy = lochorizontalAccuracy;
    }

    public Float getLocSpeed() {
        return locSpeed;
    }

    public void setLocSpeed(Float locSpeed) {
        this.locSpeed = locSpeed;
    }

    public Float getLocCourse() {
        return locCourse;
    }

    public void setLocCourse(Float locCourse) {
        this.locCourse = locCourse;
    }

    public Float getLocAltitude() {
        return locAltitude;
    }

    public void setLocAltitude(Float locAltitude) {
        this.locAltitude = locAltitude;
    }

    public Float getLocverticalAccuracy() {
        return locVerticalAccuracy;
    }

    public void setLocverticalAccuracy(Float locverticalAccuracy) {
        this.locVerticalAccuracy = locverticalAccuracy;
    }

    public String getLocActuality() {
        return locActuality;
    }

    public void setLocActuality(String locActuality) {
        this.locActuality = locActuality;
    }

    public BigInteger getLocTimestamp() {
        return locTimestamp;
    }

    public void setLocTimestamp(BigInteger locTimestamp) {
        this.locTimestamp = locTimestamp;
    }
    
    // ======================================
    // =           Public Methods           =
    // ======================================    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locId != null ? locId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Loc)) {
            return false;
        }
        Loc other = (Loc) object;
        if ((this.locId == null && other.locId != null) || (this.locId != null && !this.locId.equals(other.locId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.test.rs.entity.Loc[ id=" + locId + " ]";
    }
}
