package com.planifixateur.controller;

public class TacheController {
//	private final TacheService tacheService;
//
//	@Autowired
//	public TacheController(TacheService tacheService) {
//		this.tacheService = tacheService;
//	}
//
//	@GetMapping("/tache")
//	public ResponseEntity<List<TacheDto>> getTaches() {
//		List<Tache> taches = tacheService.listAllTache();
//		List<TacheDto> tachesDto = taches.stream().map(TacheDto::from).collect(Collectors.toList());
//		return new ResponseEntity<>(tachesDto, HttpStatus.OK);
//	}
//
//	@GetMapping("/tache/{id}")
//	public ResponseEntity<TacheDto> getTache(@PathVariable final Long id) {
//		Tache tache = tacheService.getTache(id);
//		return new ResponseEntity<>(TacheDto.from(tache), HttpStatus.OK);
//	}
//
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("/tache")
//	public ResponseEntity<TacheDto> addTache(@RequestBody final TacheDto newTacheDto) {
//		Tache tache = tacheService.saveTache(Tache.from(newTacheDto));
//		return new ResponseEntity<>(TacheDto.from(tache), HttpStatus.OK);
//	}
}
