package anft.demo.api.service;

import DAO.DatabaseManager;
import DataVo.FunctionInfoVo;
import DataVo.NftInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FunctionInfoService {

    private final DatabaseManager databaseManager;

    // 지원하는 기능 전체 목록 조회
    public List<FunctionInfoVo> findAll() {
        return databaseManager.getAllFunction();
    }

}
