package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long clientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactInfo;

    // Foreign key reference to Advisor
    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Portfolio portfolio;

    protected Client() {}

    public Client(String name, String contactInfo, Advisor advisor) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.advisor = advisor;
    }

    // Getters and Setters
    public long getClientId() { return clientId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getContactInfo() { return contactInfo; }

    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public Advisor getAdvisor() { return advisor; }

    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }

    public Portfolio getPortfolio() { return portfolio; }

    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
}
