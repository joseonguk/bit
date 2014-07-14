package servlets.step05;

import java.util.Map;

public class ScoreAdd implements PageController{
  ScoreDao scoreDao;  

  // 의존객체 주입
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
    
  }

  @Override
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    
    Score score = new Score();
    score.setName(params.get("name")[0]);
    score.setKor(Integer.parseInt(params.get("kor")[0]));
    score.setEng(Integer.parseInt(params.get("eng")[0]));
    score.setMath(Integer.parseInt(params.get("math")[0]));
    scoreDao.insert(score);
    
    //model.put("scores", scoreDao.list());
    
    //return "/score/step05/ScoreList.jsp";
    return "redirect:list.do";
  }
}
