package me.finguide.finguide.Guardian.repository;

import me.finguide.finguide.Guardian.domain.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}
