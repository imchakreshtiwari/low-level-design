package com.pattern.lowleveldesign;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLDetailsRepo extends JpaRepository<URLDetails, Long> {
}
