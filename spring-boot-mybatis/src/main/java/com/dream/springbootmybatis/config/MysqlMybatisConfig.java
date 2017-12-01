package com.dream.springbootmybatis.config;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ClassUtils;

import com.alibaba.druid.pool.DruidDataSource;


/**
 * mysql数据库配置
 * 
 */
@Configuration
@MapperScan(basePackages = "com.dream.springbootmybatis.mapper", sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class MysqlMybatisConfig {

	private static Logger log = LoggerFactory
			.getLogger(MysqlMybatisConfig.class);

	@Autowired
	private JdbcConfig jdbcConfig;

	@Bean(name = "mysqlDataSource")
	@Primary
	public DataSource mysqlDataSource() {
		DruidDataSource ds = new DruidDataSource();
		//基本属性 user、password、driverclass、url
		ds.setDriverClassName(jdbcConfig.getDriver());
		ds.setUsername(jdbcConfig.getUsername());
		ds.setPassword(jdbcConfig.getPassword());
		ds.setUrl(jdbcConfig.getUrl());
		
		ds.setMaxActive(jdbcConfig.getMaxActive());//最大连接数
		ds.setInitialSize(jdbcConfig.getInitialSize());//初始化大小
		ds.setMinIdle(jdbcConfig.getMinIdle());//最小连接数
		ds.setMaxWait(jdbcConfig.getMaxWait());//配置获取连接等待超时的时间
		ds.setTimeBetweenEvictionRunsMillis(jdbcConfig.getTimeBetweenEvictionRunsMillis());//多久才进行一次检测，检测需要关闭的空闲连接
		ds.setRemoveAbandoned(jdbcConfig.getRemoveAbandoned());//超过时间限制是否回收
		ds.setRemoveAbandonedTimeout(jdbcConfig.getRemoveAbandonedTimeout());//超过时间限制多长
		ds.setMinEvictableIdleTimeMillis(jdbcConfig.getMinEvictableIdleTimeMillis());//连接在池中最小生存的时间，单位是毫秒
		ds.setValidationQuery(jdbcConfig.getValidationQuery());//用来检测连接是否有效的sql，sql自定义 用于测试
		ds.setTestOnBorrow(jdbcConfig.getTestOnBorrow());// 申请连接时执行validationQuery检测连接是否有效，配置为true会降低性能
		ds.setTestOnReturn(jdbcConfig.getTestOnReturn());//归还连接时执行validationQuery检测连接是否有效，配置为true会降低性能 

		return ds;
	}

	public Resource[] getResource(String basePackage, String pattern)
			throws IOException {
		String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
				+ ClassUtils
						.convertClassNameToResourcePath(new StandardEnvironment()
								.resolveRequiredPlaceholders(basePackage))
				+ "/" + pattern;
		Resource[] resources = new PathMatchingResourcePatternResolver()
				.getResources(packageSearchPath);
		return resources;
	}

	@Bean(name = "mysqlSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(
			@Qualifier("mysqlDataSource") DataSource datasource)
			throws Exception {
		log.debug("> sqlSessionFactory");
		final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(datasource);
		sqlSessionFactory.setConfigLocation(new ClassPathResource(
				"mybatis-config.xml"));
		sqlSessionFactory.setFailFast(true);
		sqlSessionFactory
				.setMapperLocations(getResource("mapper", "*.xml"));
		return sqlSessionFactory.getObject();
	}

	@PostConstruct
	public void postConstruct() {
		log.info("jdbc.settings={}", jdbcConfig);
	}
}
