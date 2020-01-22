/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Bike;
import entities.Storage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojus1101
 */
public class StorageDTO {
    private Long id;
    private String address;
    private int capacity;
    private List<BikeDTO> bikeList = new ArrayList<>();

    public StorageDTO() {
    }
    
    public StorageDTO(Storage storage) {
        this.id = storage.getId();
        this.address = storage.getAddress();
        this.capacity = storage.getCapacity();
        for (Bike b : storage.getBikeList())
        {
            this.bikeList.add(new BikeDTO(b));
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

    public List<BikeDTO> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<BikeDTO> bikeList) {
        this.bikeList = bikeList;
    }
    
    
    
}
