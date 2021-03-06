package java56.service;

import java56.dao.MemberDao;
import java56.dao.StudentDao;
import java56.vo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/* StudentService 인터페이스의 구현체
 */

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  MemberDao   memberDao;
  
  @Autowired
  StudentDao  studentDao;
  
  @Transactional(
      propagation=Propagation.REQUIRED, 
      rollbackFor={Throwable.class})
  public void signup(Student student) throws Exception {
    memberDao.insert(student);
    studentDao.insert(student);
  }
}












