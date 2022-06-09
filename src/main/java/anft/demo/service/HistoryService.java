package anft.demo.service;


import anft.demo.DAO.DatabaseManager;
import anft.demo.DataVo.RequestHistoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final DatabaseManager databaseManager;

    // 히스토리 전체 목록 조회
    public List<RequestHistoryVo> findAll() {
        return databaseManager.getAllHistory();

    }
}
