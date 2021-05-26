package com.planifixateur.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planifixateur.model.LigneProjet;
import com.planifixateur.model.Projet;
import com.planifixateur.model.dto.LigneProjetDto;
import com.planifixateur.model.dto.ProjetDto;
import com.planifixateur.service.FileStorageService;
import com.planifixateur.service.LigneProjetService;
import com.planifixateur.service.ProjetService;
import com.planifixateur.service.StatisticService;

@CrossOrigin
@RestController
public class StatisticController {

	private final StatisticService statisticService;
	private final LigneProjetService ligneProjetService;
	private final FileStorageService fileService;
	private final ProjetService projetService;

	@Autowired
	public StatisticController(StatisticService statisticService, LigneProjetService ligneProjetService,
			FileStorageService fileService, ProjetService projetService) {
		this.statisticService = statisticService;
		this.ligneProjetService = ligneProjetService;
		this.fileService = fileService;
		this.projetService = projetService;
	}

	@GetMapping("/statistics/toptenprojets")
	public List<ProjetDto> classementProjet() {
		List<Projet> projets = this.projetService.listAllProjet();
		List<ProjetDto> projetsDto = projets.stream().map(ProjetDto::from).collect(Collectors.toList());
		projetsDto.sort(Comparator.comparing(ProjetDto::getTempsTotal).reversed());
		List<ProjetDto> firstNElementsList = projetsDto.stream().limit(10).collect(Collectors.toList());
		return firstNElementsList;
	}

	@GetMapping("/statistics/toptentaches")
	public List<LigneProjetDto> classementTache() {
		List<LigneProjet> lignes = this.ligneProjetService.listAllLigneProjet();
		List<LigneProjetDto> lignesDto = lignes.stream().map(LigneProjetDto::from).collect(Collectors.toList());
		lignesDto.sort(Comparator.comparing(LigneProjetDto::getTempsTotal).reversed());
		List<LigneProjetDto> firstNElementsList = lignesDto.stream().limit(10).collect(Collectors.toList());
		return firstNElementsList;
	}
}
