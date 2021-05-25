package com.planifixateur.model.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import com.planifixateur.model.Projet;

public class ProjetDto {
	private Long id;

	private String nom;

	private Collection<LigneProjetDto> lignesProjetDto = new ArrayList<LigneProjetDto>();

	private Collection<FileDBDto> filesDBDto = new ArrayList<FileDBDto>();

	private Long tempsTotal;

	public ProjetDto() {
		super();
	}

	public ProjetDto(String nom, Collection<LigneProjetDto> lignesProjetDto, Collection<FileDBDto> filesDBDto,
			Long tempsTotal) {
		super();
		this.nom = nom;
		this.lignesProjetDto = lignesProjetDto;
		this.filesDBDto = filesDBDto;
		this.tempsTotal = tempsTotal;
	}

	public ProjetDto(Long id, String nom, Collection<LigneProjetDto> lignesProjetDto, Collection<FileDBDto> filesDBDto,
			Long tempsTotal) {
		super();
		this.id = id;
		this.nom = nom;
		this.lignesProjetDto = lignesProjetDto;
		this.filesDBDto = filesDBDto;
		this.tempsTotal = tempsTotal;
	}

	public static ProjetDto from(Projet projet) {
		ProjetDto projetDto = new ProjetDto();
		projetDto.setId(projet.getId());
		projetDto.setNom(projet.getNom());
		projetDto.setLignesProjetDto(
				projet.getLignesProjet().stream().map(LigneProjetDto::from).collect(Collectors.toList()));
		projetDto.setFilesDBDto(projet.getFilesDB().stream().map(FileDBDto::from).collect(Collectors.toList()));
		return projetDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<LigneProjetDto> getLignesProjetDto() {
		return lignesProjetDto;
	}

	public void setLignesProjetDto(Collection<LigneProjetDto> lignesProjetDto) {
		this.lignesProjetDto = lignesProjetDto;
	}

	public Collection<FileDBDto> getFilesDBDto() {
		return filesDBDto;
	}

	public void setFilesDBDto(Collection<FileDBDto> filesDBDto) {
		this.filesDBDto = filesDBDto;
	}

	public Long getTempsTotal() {
		Long count = 0L;
		Long t_total = 0L;
		for (LigneProjetDto ligne : lignesProjetDto) {

			count = Math.abs((ligne.getDateFin().getTime() - ligne.getDateDebut().getTime()) / 1000);
			t_total += count;
		}

		return tempsTotal = t_total;
	}

	public void setTempsTotal(Long tempsTotal) {
		this.tempsTotal = tempsTotal;
	}

}
