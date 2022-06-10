package anft.demo.service;

import anft.demo.DAO.DatabaseManager;
import anft.demo.DataVo.UserInfoVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public void addUser(String userId) {

        String nickname = "none";
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String registerDate = today.format(dateTimeFormatter);

        databaseManager.setNewUser(userId, nickname, registerDate);
    }

    // 유저가 DB에 없는 경우 addUser를 호출해서 새로운 유저 정보 DB에 저장
    public Boolean validateUser(String userId) {
        return findByUserId(userId).getUserId() == null;
    }
}
