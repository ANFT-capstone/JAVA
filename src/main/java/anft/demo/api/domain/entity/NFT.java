package anft.demo.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nft_table")
public class NFT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String hashcode;

    private String ownerId;

    @Column(nullable = false)
    private Double price;

    @Builder
    private NFT(String hashcode, Double price) {

        this.hashcode = hashcode;
        this.ownerId = "none";
        this.price = price;
    }

    @Builder
    public NFT(String hashcode, String ownerId, Double price) {

        this.hashcode = hashcode;
        this.ownerId = ownerId;
        this.price = price;
    }
}
