/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Bike;
import entities.Member;
import entities.Rental;

/**
 *
 * @author jojus1101
 */
public class RentalDTO {
    private Long id;
    private String date;
    private Bike bike;
    private Member member;

    public RentalDTO() {
    }
    public RentalDTO(Rental rental) {
        this.bike = rental.getBike();
        this.id = rental.getId();
        this.date = rental.getDate();
        this.member = rental.getMember();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    

    
    
}
