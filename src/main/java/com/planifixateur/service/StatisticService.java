package com.planifixateur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticService {

	private final LigneProjetService ligneProjetService;
	private final FileStorageService fileService;
	private final ProjetService projetService;

	@Autowired
	public StatisticService(LigneProjetService ligneProjetService, FileStorageService fileService,
			ProjetService projetService) {
		this.ligneProjetService = ligneProjetService;
		this.fileService = fileService;
		this.projetService = projetService;
	}

}
