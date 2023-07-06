package ezen.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import ezen.exam.vo.EmpVO;

@Mapper
public interface EmpMapper {
	
	//모든 사원정보 
	@Select("SELECT * FROM EMP")
	public List<EmpVO> getList();
	
	//새로운 사원 등록
	@Insert("INSERT INTO EMP VALUES (#{empno}, #{ename}, #{job}, #{mgr}, #{sal})")
	public int insert(EmpVO vo);
	
	//특정 사원정보
	@Select("SELECT * FROM EMP WHERE EMPNO=#{mgr}")
	public EmpVO read(Integer empno);
	
	//특정 사원삭제
	@Delete("DELETE FROM EMP WHERE EMPNO=#{empno}")
	public int delete(Integer empno);
	
}
