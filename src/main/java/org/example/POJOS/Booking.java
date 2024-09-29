package org.example.POJOS;

public class booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositepaid;
    private bookingdates bookingdates;


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositepaid() {
        return depositepaid;
    }

    public void setDepositepaid(Boolean depositepaid) {
        this.depositepaid = depositepaid;
    }

    public org.example.POJOS.bookingdates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(org.example.POJOS.bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    private String additionalneeds;

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }
}
