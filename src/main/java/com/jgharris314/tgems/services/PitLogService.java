package com.jgharris314.tgems.services;

import com.jgharris314.tgems.models.PitLog;
import com.jgharris314.tgems.repositories.PitLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PitLogService {
    @Autowired
    PitLogRepository pitLogRepository;

    public List<PitLog> getAllPitLogs() {
        return pitLogRepository.findAll();
    }

    public PitLog getPitLogById(Integer pit_log_id) {
        return pitLogRepository.findById(pit_log_id).orElse(null);
    }

    public PitLog createPitLog(PitLog pitLog) {
        return pitLogRepository.save(pitLog);
    }
}
