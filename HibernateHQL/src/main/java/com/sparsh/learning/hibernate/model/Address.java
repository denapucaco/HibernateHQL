/**
 * 
 */
package com.sparsh.learning.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author prashant.swamy
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

    /** serialVersionUID. */
    private static final long serialVersionUID = 7354915794158694924L;

    @Id
    @Column(name = "emp_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = { @Parameter(name = "property", value = "employee") })
    private long id;

    @Column(name = "address_line")
    private String addressLine;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "city")
    private String city;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee employee;

    /**
     * Default Constructor.
     */
    public Address() {

    }

    /**
     * Constructor.
     * @param addressLine
     * @param pinCode
     * @param city
     */
    public Address(final String addressLine, final String pinCode, final String city) {
        this.addressLine = addressLine;
        this.pinCode = pinCode;
        this.city = city;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return the addressLine
     */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     * @param addressLine the addressLine to set
     */
    public void setAddressLine(final String addressLine) {
        this.addressLine = addressLine;
    }

    /**
     * @return the pinCode
     */
    public String getPinCode() {
        return pinCode;
    }

    /**
     * @param pinCode the pinCode to set
     */
    public void setPinCode(final String pinCode) {
        this.pinCode = pinCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", addressLine=" + addressLine + ", pinCode=" + pinCode + ", city=" + city + "]";
    }

}
