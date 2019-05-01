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
 * Customer generated by hbm2java
 */
@Entity
@Table(name="customer"
    ,schema="leads"
)
public class Customer  implements java.io.Serializable {


     private BigDecimal id;
     private String extId;
     private String name;
     private String email;
     private String phone;
     private Set<Lead> leads = new HashSet<Lead>(0);

    public Customer() {
    }

	
    public Customer(BigDecimal id) {
        this.id = id;
    }
    public Customer(BigDecimal id, String extId, String name, String email, String phone, Set<Lead> leads) {
       this.id = id;
       this.extId = extId;
       this.name = name;
       this.email = email;
       this.phone = phone;
       this.leads = leads;
    }
   
     @Id 
    
    @Column(name="id", unique=true, nullable=false, precision=131089, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    
    @Column(name="ext_id")
    public String getExtId() {
        return this.extId;
    }
    
    public void setExtId(String extId) {
        this.extId = extId;
    }
    
    @Column(name="name")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="phone")
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="customer")
    public Set<Lead> getLeads() {
        return this.leads;
    }
    
    public void setLeads(Set<Lead> leads) {
        this.leads = leads;
    }




}

