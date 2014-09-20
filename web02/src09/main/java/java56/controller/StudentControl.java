package java56.controller;

import java.io.File;

import java56.service.StudentService;
import java56.vo.Student;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

/* 트랜잭션 처리를 StudentService 객체에 위임.
 * => 비즈니스 로직을 분리하여 관리
 * => 재사용이 높아지고 유지보수가 쉬워진다.
 */

@Controller
@RequestMapping("/member")
@SessionAttributes({"student"}) // 모델 보관소에 저장되는 객체들 중에서 세션에 들어갈 객체를 지정한다.
public class StudentControl {
  
  @Autowired
  ServletContext servletContext;

  @Autowired
  StudentService studentService;
  
  @RequestMapping("/signup")
  public String signup(){
    return "/member/MemberSignup";
  }
  
  @RequestMapping(value="/signup2", method=RequestMethod.POST)
  public String signup2(
      Student student, 
      MultipartFile photo,
      Model model) throws Exception{
    
    String uploadDir = servletContext.getRealPath("/fileupload");
    File uploadFile = new File(uploadDir + "/" + photo.getOriginalFilename());
    photo.transferTo(uploadFile);
    
    student.setPhotoPath(photo.getOriginalFilename());
    
    model.addAttribute("student", student);
    
    return "/member/MemberSignup2";
  }
  
  @RequestMapping(value="/signup3", method=RequestMethod.POST)
  public String signup3(Student student) { 
    
    return "/member/MemberSignup3";
  }
  
  @RequestMapping(value="/signupComplete", method=RequestMethod.POST)
  public String signupComplete(
      Student student, SessionStatus sessionStatus) throws Exception{
      
    studentService.signup(student);
    
    // setComplete()을 호출하면 
    // 클래스 상단에 지정한(@SessionAttributes(.......)) 세션 보관 객체를 제거한다.
    // 즉, 세션 보관소에서 "student" 이름으로 저장된 객체를 제거한다. 
    sessionStatus.setComplete();
    
    return "/member/MemberSignupComplete";
  }
}
