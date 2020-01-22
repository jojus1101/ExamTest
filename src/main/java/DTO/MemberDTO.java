/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Member;
import entities.Rental;
import java.util.List;

/**
 *
 * @author jojus1101
 */
public class MemberDTO {
    private Long id;
    private String name;
    private String signedUpDate;
    private String account;
    private List<RentalDTO> rentalList;

    public MemberDTO() {
    }
    
    public MemberDTO(Member member){
        this.id = member.getId();
        this.name = member.getName();
        this.account = member.getAccount();
        this.signedUpDate = member.getSignedUpDate();
        for (Rental re : member.getRentalList()){
            rentalList.add(new RentalDTO(re));
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

    public List<RentalDTO> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<RentalDTO> rentalList) {
        this.rentalList = rentalList;
    }
    
}
