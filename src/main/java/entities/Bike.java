/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jojus1101
 */
@Entity
@NamedQueries({
    @NamedQuery(name ="Bike.getAll", query = "SELECT b FROM Bike b"),
    @NamedQuery(name ="Bike.deleteAllRows", query = "DELETE FROM Bike")
})
public class Bike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String size;
    private String gender;
    private int gears;
    private int datePrice;
    
     @ManyToOne(cascade = { CascadeType.PERSIST })// Owning side
    private Storage storage;
     
     @OneToMany(mappedBy="bike", cascade = { CascadeType.PERSIST }) // Non owning side
    private List<Rental> rentalList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bike() {
    }

    public Bike(String make, String size, String gender, int gears, int datePrice, Storage storage) {
        this.make = make;
        this.size = size;
        this.gender = gender;
        this.gears = gears;
        this.datePrice = datePrice;
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public int getDatePrice() {
        return datePrice;
    }

    public void setDatePrice(int datePrice) {
        this.datePrice = datePrice;
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
        if (!(object instanceof Bike)) {
            return false;
        }
        Bike other = (Bike) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bike[ id=" + id + " ]";
    }
    
}
