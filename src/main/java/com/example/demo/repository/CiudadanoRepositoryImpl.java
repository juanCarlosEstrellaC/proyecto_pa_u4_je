package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.funcional.Ciudadano;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{

	@Override
	public void insertar(Ciudadano ciudadano) {
		
	}

}
