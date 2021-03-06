package hr.kiki.leads.entity;
// Generated May 1, 2019 6:00:00 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CarProperty generated by hbm2java
 */
@Entity
@Table(name="car_property"
    ,schema="leads"
)
public class CarProperty  implements java.io.Serializable {


     private CarPropertyId id;
     private Property property;
     private Car car;

    public CarProperty() {
    }

    public CarProperty(CarPropertyId id, Property property, Car car) {
       this.id = id;
       this.property = property;
       this.car = car;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="carId", column=@Column(name="car_id", nullable=false, precision=131089, scale=0) ), 
        @AttributeOverride(name="propId", column=@Column(name="prop_id", nullable=false, precision=131089, scale=0) ), 
        @AttributeOverride(name="value", column=@Column(name="value") ) } )
    public CarPropertyId getId() {
        return this.id;
    }
    
    public void setId(CarPropertyId id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="prop_id", nullable=false, insertable=false, updatable=false)
    public Property getProperty() {
        return this.property;
    }
    
    public void setProperty(Property property) {
        this.property = property;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="car_id", nullable=false, insertable=false, updatable=false)
    public Car getCar() {
        return this.car;
    }
    
    public void setCar(Car car) {
        this.car = car;
    }




}


