package service;

import java.util.*;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.*;

import com.uam.CLINICA.model.*;

public class ImplDAO implements IDAO {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public <T> List<T> getAll(String namedQuery, Class<T> clazz) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            TypedQuery<T> query = em.createNamedQuery(namedQuery, clazz);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public <T> List<T> get(String namedQuery, Class<T> clazz, Object... param) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            TypedQuery<T> query = em.createNamedQuery(namedQuery, clazz);
            int position = 1;
            for (Object obj : param) {
                query.setParameter(position++, obj);
            }
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public <T> T findById(Class<T> clazz, Integer id) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            T entity = em.find(clazz, id);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public <T> void remove(T entity) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public <T> void create(T entity) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public <T> T update(T entity) {
        T entityUpdate = null;
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            em.getTransaction().begin();
            entityUpdate = em.merge(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return entityUpdate;
    }

    // Método para verificar la cédula y la contraseña
    public Recepcionista findRecepcionistaByCedulaAndPassword(String cedula, String rawPassword) {
        List<Recepcionista> results = get("Recepcionista.findByCedula", Recepcionista.class, cedula);

        if (results != null && !results.isEmpty()) {
            Recepcionista recepcionista = results.get(0);  // Obtiene el primer resultado

            // Verifica la contraseña
            if (recepcionista.verifyPassword(rawPassword)) {
                return recepcionista;  // Si la contraseña es correcta, retorna el recepcionista
            }
        }
        return null;  // Si no se encuentra o la contraseña es incorrecta
    }
}

