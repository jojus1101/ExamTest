/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DTO.BikeDTO;
import DTO.RentalDTO;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jojus1101
 */
@Entity
@Table(name = "Bike")
@NamedQueries({
    @NamedQuery(name = "Bike.getAll", query = "SELECT b FROM Bike b"),
    @NamedQuery(name = "Bike.deleteAllRows", query = "DELETE FROM Bike")
    
})
public class Bike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String make;
    private String size;
    private String gender;
    private int gears;
    private int datePrice;
    
     @ManyToOne(cascade = { CascadeType.PERSIST })// Owning side
    private Storage storage;
     
     @OneToMany(mappedBy="bike", cascade = { CascadeType.PERSIST }) // Non owning side
    private List<Rental> rentalList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bike() {
    }

    public Bike(String make, String size, String gender, int gears, int datePrice) {
        this.make = make;
        this.size = size;
        this.gender = gender;
        this.gears = gears;
        this.datePrice = datePrice;
    }


    public Bike(BikeDTO bike ) {
        this.id = bike.getId();
        this.datePrice = bike.getDatePrice();
        this.gears = bike.getGears();
        this.make = bike.getMake();
        this.gender = bike.getGender();
        this.size = bike.getSize();
        this.storage = bike.getStorage();
        for (RentalDTO rental : bike.getRentalList()){
            rentalList.add(new Rental(rental));
        }
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
        int hash = 5;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.make);
        hash = 37 * hash + Objects.hashCode(this.size);
        hash = 37 * hash + Objects.hashCode(this.gender);
        hash = 37 * hash + this.gears;
        hash = 37 * hash + this.datePrice;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bike other = (Bike) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.gears != other.gears) {
            return false;
        }
        if (this.datePrice != other.datePrice) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bike{" + "id=" + id + ", make=" + make + ", size=" + size + ", gender=" + gender + ", gears=" + gears + ", datePrice=" + datePrice + '}';
    }
 
}
