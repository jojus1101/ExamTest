/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DTO.MemberDTO;
import DTO.RentalDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jojus1101
 */
@Entity
@NamedQueries({
    @NamedQuery(name ="Member.getAll", query = "SELECT m FROM Member m"),
    @NamedQuery(name ="Member.deleteAllRows", query = "DELETE FROM Member")
})
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String signedUpDate;
    private String account;
    
    @OneToMany(mappedBy="member", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Rental>rentalList = new ArrayList();
    
    public void addRental(Rental rental){
        rentalList.add(rental);
    }
    
    public List<Rental> getRentalList() {
        return rentalList;
    }

    public Member(String name, String signedUpDate, String account) {
        this.name = name;
        this.signedUpDate = signedUpDate;
        this.account = account;
    }

    
    public Member() {
    }
    public Member(MemberDTO member) {
        this.id = member.getId();
        this.name = member.getName();
        this.signedUpDate = member.getSignedUpDate();
        this.account = member.getAccount();
        for (RentalDTO r : member.getRentalList()){
            rentalList.add(new Rental(r));
        }
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignedUpDate() {
        return signedUpDate;
    }

    public void setSignedUpDate(String signedUpDate) {
        this.signedUpDate = signedUpDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member)) {
            return false;
        }
        Member other = (Member) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Member[ id=" + id + " ]";
    }
    
}
