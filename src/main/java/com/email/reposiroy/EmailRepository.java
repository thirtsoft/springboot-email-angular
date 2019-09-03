package com.email.reposiroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.email.model.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
