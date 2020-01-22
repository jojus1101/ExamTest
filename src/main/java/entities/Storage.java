/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import DTO.BikeDTO;
import DTO.StorageDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jojus1101
 */
@Entity
@NamedQueries({
    @NamedQuery(name ="Storage.getAll", query = "SELECT s FROM Storage s"),
    @NamedQuery(name ="Storage.deleteAllRows", query = "DELETE FROM Storage")
})
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private int capacity;
    
    @OneToMany(mappedBy="storage", cascade = { CascadeType.PERSIST }) // Non owning side
    private List<Bike> bikeList = new ArrayList<>();


    public Storage(String address, int capacity) {
        this.address = address;
        this.capacity = capacity;
    }

    public Storage() {
    }
    public Storage(StorageDTO storage) {
        this.id = storage.getId();
        this.address = storage.getAddress();
        this.capacity = storage.getCapacity();
        for (BikeDTO bike : storage.getBikeList()){
            bikeList.add(new Bike(bike));
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
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
        if (!(object instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Storage[ id=" + id + " ]";
    }
    
}
