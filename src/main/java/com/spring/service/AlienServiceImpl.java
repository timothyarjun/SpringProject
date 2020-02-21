package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Alien;
import com.spring.repository.AlienRepo;

@Service
public class AlienServiceImpl implements AlienService {

	@Autowired
	private AlienRepo repo;

	@Override
	public Alien addAlien(Alien alien) {
		return repo.save(alien);
	}

	@Override
	public Alien updateAlien(Alien alien) {
		return repo.saveAndFlush(alien);
	}

	@Override
	public Alien getAlien(int id) {
		return repo.getOne(id);
	}

	@Override
	public List<Alien> getAll() {
		return repo.findAll();
	}

	@Override
	public void deleteAlien(int id) {
		repo.deleteById(id);
	}
}
