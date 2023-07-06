package org.ezen.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages= {"org.ezen.mapper","org.ezen.testMapper","ezen.exam.mapper"}) //mybatis 연결하기 위한.
@ComponentScan(basePackages= {"org.ezen.sample","org.ezen.service","org.ezen.utils","org.ezen.testService","ezen.exam.service"})

@EnableScheduling //Quartz 라이브러리를 사용하기 위한 어노테이션 추가

public class RootConfig {
	@Bean //메소드의 실행 결과도 반환된 객체는 스프링 객체로 등록
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
		hikariConfig.setUsername("hr");
		hikariConfig.setPassword("hr");
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFfactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
}
