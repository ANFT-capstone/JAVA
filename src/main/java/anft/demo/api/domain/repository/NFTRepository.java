package anft.demo.api.domain.repository;

import anft.demo.api.domain.entity.NFT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NFTRepository extends JpaRepository<NFT, Long> {

    @Query("select n from NFT n where n.hashcode = :hashcode")
    NFT findByHashcode(@Param("hashcode") String hashcode);

    @Query("select n from NFT n where n.ownerId = :ownerId")
    List<NFT> findAllByOwnerId(@Param("ownerId") String ownerId);

    @Query("select n from NFT n")
    List<NFT> findAll();

}
