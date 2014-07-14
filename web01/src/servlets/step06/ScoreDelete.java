package servlets.step06;

import java.util.Map;

public class ScoreDelete  implements PageController {
  ScoreDao scoreDao;  
  
  public void setScoreDao(ScoreDao scoreDao) {
    this.scoreDao = scoreDao;
    
  }

  @Override
  public String execute(Map<String, String[]> params, Map<String, Object> model)
      throws Exception {
    
    scoreDao.delete(Integer.parseInt(params.get("no")[0]));
     
    //model.put("scores", scoreDao.list());
      
    //return "/score/step05/ScoreList.jsp";
    
    return "redirect:list.do";
  }
}














