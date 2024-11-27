# Farm Simulator Game

11/27 3:01 am
- GameEnvironment -> GameCenter 변경
- GameCenter에 private Weather 추가
- GameCenter에 feedAnimals 삭제
- GameCenter에 playAnimals 삭제
- 기타 GameCenter에서 Animal 관련 삭제
- gui에서 animal 관련 삭제
- item 목록 Compost, Egg, RedBull, Namool 추가
 +)각 item의 용도를 crop / Product / Health 세가지로 나누어서 적용해야하나?, 그리고 product 재료로 들어가는 item들은 보너스 인스턴스를 없애고 바로 product 만들기 위한 인벤토리 등으로 들어가는 형식으로 짜야할듯. 예를들어 item(Name, type (crop or Product or Health), price, bonus)는 crop과 health에 적용되는 항목이고 item(Name, type (crop or Product or Health), price, n)은 product가 인벤토리로 n개 들어가는 항목
  - main과 src의 weather 코드 일단 추가해봄! 돌아가는지 안 돌아가는지는 아직 미지수지만...ㅎㅎ 이번 업데이트까지만 main에 바로 올렸고 낼 업데이트 부터는 hajin branch에 올릴게용~
