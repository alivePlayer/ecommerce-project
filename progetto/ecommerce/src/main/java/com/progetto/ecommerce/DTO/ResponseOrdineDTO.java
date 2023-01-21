package com.progetto.ecommerce.DTO;

public class ResponseOrdineDTO {

    private float prezzoFinale;
    private int invoiceNumber;
    private String date;
    private Long orderId;

    public float getPrezzoFinale() {
        return prezzoFinale;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getDate() {
        return date;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setPrezzoFinale(float prezzoFinale) {
        this.prezzoFinale = prezzoFinale;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
