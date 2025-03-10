package me.finguide.finguide.Voice.repository;

import me.finguide.finguide.Voice.domain.Voice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoiceRepository extends JpaRepository<Voice, Long> {

}
