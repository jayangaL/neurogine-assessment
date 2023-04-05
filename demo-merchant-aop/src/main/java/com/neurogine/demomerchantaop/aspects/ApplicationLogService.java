package com.neurogine.demomerchantaop.aspects;

import com.neurogine.demomerchantaop.model.ApplicationLog;
import com.neurogine.demomerchantaop.repository.ApplicationLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationLogService {
    private final ApplicationLogRepository applicationLogRepository;

    public void saveApplicationLog(ApplicationLog applicationLog){
        applicationLogRepository.save(applicationLog);
    }
}
