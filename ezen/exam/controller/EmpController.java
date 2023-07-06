package ezen.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import ezen.exam.service.EmpService;
import ezen.exam.vo.EmpVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/emp/*")
@AllArgsConstructor
@Log4j
public class EmpController {
	
	private EmpService service;
	
	@GetMapping("/list")
	public void list(EmpVO vo, Model model){
		log.info("listlistlistlistlistlist");
		model.addAttribute("eList", service.getList());
	}
	
	@GetMapping("/write")
	public void write() {
		
	}
	
	@PostMapping("/write")
	public String write(EmpVO emp) {
		service.insert(emp);
		return "redirect:/emp/list";
	}
	
	@GetMapping("/read")
	public void read(@RequestParam("empno")Integer empno, Model model) {
		model.addAttribute("emp", service.read(empno));
	}
	
	@GetMapping(value="/remove")
	@ResponseBody
	public RedirectView remove(@RequestParam("empno")int empno){
		log.info("remove : "+empno);
		if(service.delete(empno)) {
			log.info("success");
		}else {
			log.info("fail");
		}
		return new RedirectView("/emp/list");
	}
	
}
