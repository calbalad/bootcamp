package com.example.domains.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.constraints.Length;

import com.example.domains.core.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the language database table.
 * 
 */
@Entity
@Table(name="language")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language  extends EntityBase<Language> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="language_id")
	@JsonProperty("id")
	private int languageId;

	@Column(name="last_update")
	@Generated(value = GenerationTime.ALWAYS)
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Timestamp lastUpdate;
	
	@Length(max = 20)
	private String name;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="language")
	private List<Film> films;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="languageVO")
	private List<Film> filmsVO;

	public Language() {
		super();
	}

	 
	
	public Language(int languageId) {
		super();
		this.languageId = languageId;
	}

	public Language(int languageId, @Length(max = 20) String name) {
		super();
		this.languageId = languageId;
		this.name = name;
	}


	public Language(int languageId, Timestamp lastUpdate, @Length(max = 20) String name) {
		super();
		this.languageId = languageId;
		this.lastUpdate = lastUpdate;
		this.name = name;
	}

	public int getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Film> getFilms() {
		return this.films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Film addFilm(Film film) {
		getFilms().add(film);
		film.setLanguage(this);

		return film;
	}

	public Film removeFilm(Film film) {
		getFilms().remove(film);
		film.setLanguage(null);

		return film;
	}

	public List<Film> getFilmsVO() {
		return this.filmsVO;
	}

	public void setFilmsVO(List<Film> filmsVO) {
		this.filmsVO = filmsVO;
	}

	public Film addFilmsVO(Film filmsVO) {
		getFilmsVO().add(filmsVO);
		filmsVO.setLanguageVO(this);

		return filmsVO;
	}

	public Film removeFilmsVO(Film filmsVO) {
		getFilmsVO().remove(filmsVO);
		filmsVO.setLanguageVO(null);

		return filmsVO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(languageId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Language))
			return false;
		Language other = (Language) obj;
		return languageId == other.languageId;
	}

	
	
	
}