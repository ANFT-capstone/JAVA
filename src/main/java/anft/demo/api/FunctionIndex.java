package anft.demo.api;

import lombok.Getter;

@Getter
public enum FunctionIndex {
    NFT_LIST(0),
    FIND_NFT_BY_NFT_ID(1),
    FIND_NFT_BY_NFT_URI(2),
    FIND_NFT_BY_USER_ID(3),
    ADD_NFT(4),

    CATETORY_LIST(10),
    ADD_CATEGORY(11),

    USER_LIST(20),
    FIND_USE_BY_USER_ID(21);

    private final int value;
    FunctionIndex(int value) {
        this.value = value;
    }
}
