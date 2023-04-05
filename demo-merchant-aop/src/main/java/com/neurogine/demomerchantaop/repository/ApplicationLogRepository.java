package com.neurogine.demomerchantaop.repository;

import com.neurogine.demomerchantaop.model.ApplicationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationLogRepository extends JpaRepository<ApplicationLog,Long> {
}
