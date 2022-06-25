const nftName = "ANFT";
const description = "ANFT Aljalddakggalssen";
//const hiddenImgUrl = "ipfs://QmXBP9WSnKGtyfaAAXKAvEpvbV71sBda3iSdf6EHbdsW8d";
const hiddenImgUrl =
  "https://ipfs.io/ipfs/QmXBP9WSnKGtyfaAAXKAvEpvbV71sBda3iSdf6EHbdsW8d";
//발행 숫자
const totalNum = 10;

try {
  for (let i = 1; i <= totalNum; i++) {
    let json = `{"name":"${nftName} #${i}","description":"${description}","image":"${hiddenImgUrl}","attributes":[{"trait_type": "Unknown","value": "Unknown"}]}`;
    let fs = require("fs");
    fs.writeFile(`json/${i}.json`, json, "utf8", (e) => e);
  }
  console.log("complete!");
} catch (error) {
  console.log(error);
}
