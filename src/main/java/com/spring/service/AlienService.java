package com.spring.service;

import java.util.List;

import com.spring.entity.Alien;

public interface AlienService {
	
	public Alien addAlien(Alien alien);

	public Alien updateAlien(Alien alien);

	public Alien getAlien(int id);

	public List<Alien> getAll();

	public void deleteAlien(int id);
	
}
