package anft.demo.service;

import DAO.DatabaseManager;
import DataVo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final DatabaseManager databaseManager;

    // 유저 전체 목록 조회
    public List<UserInfoVo> findAll() {
        return databaseManager.getAllUser();
    }

    // 유저 id로 조회
    public UserInfoVo findByUserId(String userId) {

        return databaseManager.getUserByUserID(userId);
    }

    // 새로운 유저 정보 DB에 저장
    @Transactional
    public void addUser(String userId, String nickname, String registerDate) {
        databaseManager.setNewUser(userId, nickname, registerDate);
    }
}
