//https://pastebin.com/5MMg36M8
//https://pastebin.com/FW5Z3hwm
//https://pastebin.com/y9GWyCis

package org.springframework.samples.petclinic.bill;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.visit.Visit;

@Entity
@Table(name="Facturas")
@NamedQueries({
@NamedQuery(name="billByIdNumber", query="select b from Bill b where b.identificador=:idNumber")
})
public class Bill extends BaseEntity {
	
	@Column(name = "identificador")
	@Digits(integer = 10, fraction = 0)
	private long identificador;
	
	@Column(name = "fecha_compra")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date fecha_pago;
	
	@Column(name = "cuantia")
	@Digits(integer=5, fraction=2)
    @DecimalMin("0.0")
	private double cuantia;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner_bill;
	
	@OneToOne
	@JoinColumn(name="visit_id")
	private Visit visit;
		

	public Bill() {
		super();
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public double getCuantia() {
		return cuantia;
	}

	public void setCuantia(double cuantia) {
		this.cuantia = cuantia;
	}

	public Owner getOwner() {
		return owner_bill;
	}

	public void setOwner(Owner owner) {
		this.owner_bill = owner;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

}