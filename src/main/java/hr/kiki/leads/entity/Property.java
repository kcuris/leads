package hr.kiki.leads.entity;
// Generated May 1, 2019 6:00:00 PM by Hibernate Tools 3.2.2.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Property generated by hbm2java
 */
@Entity
@Table(name="property"
    ,schema="leads"
)
public class Property  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private Set<CarProperty> carProperties = new HashSet<CarProperty>(0);

    public Property() {
    }

	
    public Property(BigDecimal id) {
        this.id = id;
    }
    public Property(BigDecimal id, String name, Set<CarProperty> carProperties) {
       this.id = id;
       this.name = name;
       this.carProperties = carProperties;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false, precision=131089, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="property")
    public Set<CarProperty> getCarProperties() {
        return this.carProperties;
    }
    
    public void setCarProperties(Set<CarProperty> carProperties) {
        this.carProperties = carProperties;
    }




}


