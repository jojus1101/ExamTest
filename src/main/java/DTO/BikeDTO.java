/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Bike;
import entities.Rental;
import entities.Storage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jojus1101
 */
public class BikeDTO {
    private int id;
    private String make;
    private String size;
    private String gender;
    private int gears;
    private int datePrice;
    private Storage storage;
    private List<RentalDTO> rentalList = new ArrayList();

    public BikeDTO() {
    }
    
    public BikeDTO(Bike bike ) {
        this.id = bike.getId();
        this.datePrice = bike.getDatePrice();
        this.gears = bike.getGears();
        this.make = bike.getMake();
        this.gender = bike.getGender();
        this.size = bike.getSize();
        this.storage = bike.getStorage();
        for (Rental r : bike.getRentalList())
        {
            rentalList.add(new RentalDTO(r));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public List<RentalDTO> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<RentalDTO> rentalList) {
        this.rentalList = rentalList;
    }
    
}
