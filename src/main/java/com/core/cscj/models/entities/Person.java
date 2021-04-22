package com.core.cscj.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name="person")
@Data
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(unique=true, nullable=false, length=70)
	private String document;

	@Column(nullable=false, length=300)
	private String name;

	@Column(nullable=false, length=300)
	private String lastname;

	@Column(name="birth_date")
	private Timestamp birthDate;

	@Column(length=20)
	private String phone;

	@Column(length=10)
	private String sex;

	@Column(length=1000)
	private String address;

	@OneToMany(mappedBy="person", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Account> accounts;

	@ManyToMany
	@JoinTable(name = "person_cursos",
			joinColumns = @JoinColumn(name = "person_id"),
			inverseJoinColumns = @JoinColumn(name = "curso_id"))
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Curso> cursos;

	@OneToMany(mappedBy="profesor")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Asignatura> asignaturas;

	@ManyToMany(mappedBy = "alumnos", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Evaluacion> evaluaciones;

	@OneToMany(mappedBy="alumno", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Entrega> entregas;

	@OneToMany(mappedBy="alumno", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Set<Respuesta> respuestas;

	public Person() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Set<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(Set<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Set<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(Set<Entrega> entregas) {
		this.entregas = entregas;
	}

	public Set<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Set<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
}