package az.tarlan.medair.search.DAO;

import az.tarlan.medair.patients.entity.Vite;
import az.tarlan.medair.search.entity.SearchForVite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Repository
public class SearchDAOJPAImpl implements SearchDAO {

    private final EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(SearchDAOJPAImpl.class);

    @Autowired
    public SearchDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
//    public List<Vite> find(SearchForVite searchForVite) {
//        logger.info("Поиск пациента с критериями: {}", searchForVite);
//        String sql = buildSqlQuery(searchForVite);
//        Query theQuery = entityManager.createQuery("FROM Vite WHERE " + sql);
//
//        // Параметризация
//        setQueryParameters(theQuery, searchForVite);
//
//        List<Vite> patients = theQuery.getResultList();
//        return patients.isEmpty() ? List.of() : patients;  // Возвращаем пустой список вместо null
//    }

    public List<Vite> find(SearchForVite searchForVite) {
        logger.info("Поиск пациента с критериями: {}", searchForVite);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vite> cq = cb.createQuery(Vite.class);
        Root<Vite> vite = cq.from(Vite.class);

        // Создаем список условий
        Predicate criteria = cb.conjunction(); // Начинаем с TRUE

        if (searchForVite.getPatientId() != 0) {
            criteria = cb.and(criteria, cb.equal(vite.get("patientId"), searchForVite.getPatientId()));
        }
        if (searchForVite.getPatientName() != null && !searchForVite.getPatientName().isEmpty()) {
            criteria = cb.and(criteria, cb.like(vite.get("patientName"), "%" + searchForVite.getPatientName() + "%"));
        }
        if (searchForVite.getPhoneNumber() != null && !searchForVite.getPhoneNumber().isEmpty()) {
            criteria = cb.and(criteria, cb.like(vite.get("phoneNumber"), "%" + searchForVite.getPhoneNumber() + "%"));
        }
        if (searchForVite.getPatientSurName() != null && !searchForVite.getPatientSurName().isEmpty()) {
            criteria = cb.and(criteria, cb.like(vite.get("patientSurName"), "%" + searchForVite.getPatientSurName() + "%"));
        }

        // Применяем условия к запросу
        cq.where(criteria);

        // Выполняем запрос
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Vite> findAll() {
        logger.info("Поиск всех пациентов");
        Query theQuery = entityManager.createQuery("FROM Vite ORDER BY patientId DESC");
        return theQuery.getResultList();
    }

//    private String buildSqlQuery(SearchForVite searchForVite) {
//        StringBuilder sql = new StringBuilder("1=1");  // Начинаем с условия, которое всегда истинно
//        appendCondition(sql, "patientId", searchForVite.getPatientId(), true);
//        appendCondition(sql, "patientName", searchForVite.getPatientName(), false);
//        appendCondition(sql, "phoneNumber", searchForVite.getPhoneNumber(), false);
//        appendCondition(sql, "patientSurName", searchForVite.getPatientSurName(), false);
//        return sql.toString();
//    }
//
//    private void appendCondition(StringBuilder sql, String colName, Object param, boolean isExactMatch) {
//        if (param != null && !param.toString().isEmpty() && !"0".equals(param.toString())) {
//            if (isExactMatch) {
//                sql.append(" AND ").append(colName).append(" = :").append(colName);  // Для точного совпадения
//            } else {
//                sql.append(" AND ").append(colName).append(" LIKE :").append(colName);  // Для поиска по шаблону
//            }
//        }
//    }

//    private void setQueryParameters(Query query, SearchForVite searchForVite) {
//        if (searchForVite.getPatientId() != 0) {
//            query.setParameter("patientId", searchForVite.getPatientId());
//        }
//        if (searchForVite.getPatientName() != null && !searchForVite.getPatientName().isEmpty()) {
//            query.setParameter("patientName", "%" + searchForVite.getPatientName() + "%");
//        }
//        if (searchForVite.getPhoneNumber() != null && !searchForVite.getPhoneNumber().isEmpty()) {
//            query.setParameter("phoneNumber", "%" + searchForVite.getPhoneNumber() + "%");
//        }
//        if (searchForVite.getPatientSurName() != null && !searchForVite.getPatientSurName().isEmpty()) {
//            query.setParameter("patientSurName", "%" + searchForVite.getPatientSurName() + "%");
//        }
//    }
}
