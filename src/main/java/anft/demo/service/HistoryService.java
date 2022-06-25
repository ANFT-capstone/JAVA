package anft.demo.service;


import anft.demo.DAO.DatabaseManager;
import anft.demo.DataVo.RequestHistoryVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final DatabaseManager databaseManager;

    // 히스토리 전체 목록 조회
    public List<RequestHistoryVo> findAll() {
        return databaseManager.getAllHistory();

    }

    // 새로운 히스토리 정보 DB에 저장
    @Transactional
    public void addHistory(String requestUser, int requestFunction, String parameters, char result) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String requestDate = today.format(dateTimeFormatter);

        databaseManager.setNewHistory(requestUser, requestFunction, requestDate, parameters, result);
    }
}
