def setting(func) {
  func()
}

def engine(map) {
  switch(map) {
    case Map : 
      println "이름=" + map["name"] 
      println "국어=" + map["kor"] 
      println "영어=" + map.eng 
      break
    case String :
      values = map.split(":") 
      println "#이름=" + values[0]; 
      println "#국어=" + values[1]; 
      println "#영어=" + values[2]; 
      break
  }
}

def m(func) {
  func()
}

m{
  engine (["name":"홍길동", "kor":100, "eng":90])
  engine ("홍길동:90:80")
  setting ({
    println "okok"
    engine "name":"임꺽정", "kor":100, "eng":100
  })
}