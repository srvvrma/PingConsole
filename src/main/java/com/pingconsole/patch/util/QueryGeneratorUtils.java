package com.pingconsole.patch.util;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingconsole.patch.dto.PingFile;


@Service
@Transactional
@SuppressWarnings("rawtypes")
public class QueryGeneratorUtils {

	@Autowired
	private SessionFactory sessionFactory;

	public Criterion searchAllClassPatchPath(String classPath) {

		return Restrictions.ilike("location", "%"
				+ trimClassPath(classPath) + "%");

	}


	public Criterion searchAllOdtPatchPath(String path) {
		return Restrictions.ilike("location", "%"
				+ trimOdtPath(path) + "%");
	}
	
	public Criterion searchAllJsPatchPath(String path) {
		return Restrictions.ilike("location", "%"
				+ trimJsPath(path) + "%");
	}
	
	public Criterion searchAllXmlPatchPath(String path) {
		return Restrictions.ilike("location", "%"
				+ trimXmlPath(path) + "%");
	}
	
	public Criterion searchAllXlsPatchPath(String path) {
		return Restrictions.ilike("location", "%"
				+ trimXlsPath(path) + "%");
	}
	
	public Criterion searchAllProperPatchPath(String path) {
		return Restrictions.ilike("location", "%"
				+ trimProperPath(path) + "%");
	}
	
	private String trimClassPath(String classPath) {
		return classPath.substring(
				classPath.indexOf("/src/main/java/") + "/src/main/java/".length(),
				classPath.lastIndexOf(".")).replaceAll("\\s", "");
	}
	
	private String trimOdtPath(String path) {
		return path.substring(
				path.indexOf("/src/main/resources/") + "/src/main/resources/".length(),
				path.lastIndexOf(".")).replaceAll("\\s", "");
	}
	
	private String trimJsPath(String path) {
		return path.substring(
				path.indexOf("/static-resources/") + "/static-resources/".length(),
				path.lastIndexOf(".")).replaceAll("\\s", "");
	}
	
	private String trimXmlPath(String path) {
		return path.substring(
				path.indexOf("/resources/") + "/resources/".length(),
				path.lastIndexOf(".")).replaceAll("\\s", "");
	}
	
	private String trimXlsPath(String path) {
		return path.substring(
				path.indexOf("/resources/") + "/resources/".length(),
				path.lastIndexOf(".")).replaceAll("\\s", "");
	}
	
	private String trimProperPath(String path) {
		return path.substring(
				path.indexOf("/src/main/resources/") + "/src/main/resources/".length(),
				path.lastIndexOf(".")).replaceAll("\\s", "");
	}


	public List executeSearch(List<Criterion> criterionList) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(
				PingFile.class);
		//criteria.add(Restrictions.disjunction().add(Restrictions.like("myField", "str1")).add(Restrictions.like("myField", "str2")));
		Disjunction disjunction =  Restrictions.disjunction();
		for (Criterion criterion : criterionList) {
			 disjunction.add(criterion);
		}
		cr.add(disjunction);
		return cr.list();
	}


}
