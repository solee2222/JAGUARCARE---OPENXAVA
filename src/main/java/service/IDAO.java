package service;

import java.util.*;

public interface IDAO {
	

	   <T> List<T> getAll(String namedQuery, Class<T> clazz);

	   <T> List<T> get(String namedQuery, Class<T> clazz,Object...param);


	   <T> T findById(Class<T> clazz,Integer id);

	   <T> void remove(T entity);

	   <T> void create(T entity);

	   <T> T update(T entity);


}
