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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Lead generated by hbm2java
 */
@Entity
@Table(name="lead"
    ,schema="leads"
)
public class Lead  implements java.io.Serializable {


     private BigDecimal id;
     private Customer customer;
     private String notes;
     private Set<Car> cars = new HashSet<Car>(0);

    public Lead() {
    }

	
    public Lead(BigDecimal id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }
    public Lead(BigDecimal id, Customer customer, String notes, Set<Car> cars) {
       this.id = id;
       this.customer = customer;
       this.notes = notes;
       this.cars = cars;
    }
   
    @Id
    @Column(name="id", unique=true, nullable=false, precision=131089, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cus_id", nullable=false)
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @Column(name="notes")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="lead_car", schema="leads", uniqueConstraints=@UniqueConstraint(columnNames={"lead_id", "car_id"}), joinColumns = { 
        @JoinColumn(name="lead_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="car_id", nullable=false, updatable=false) })
    public Set<Car> getCars() {
        return this.cars;
    }
    
    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }




}

