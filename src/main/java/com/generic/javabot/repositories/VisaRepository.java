package com.generic.javabot.repositories;

import com.generic.javabot.entities.Visa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface VisaRepository extends JpaRepository<Visa, Integer> {
}