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

@Repository
public class SearchDAOJPAImpl implements SearchDAO {

    private final EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(SearchDAOJPAImpl.class);

    @Autowired
    public SearchDAOJPAImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Vite> find(SearchForVite searchForVite) {
        logger.info("find");
        String sql = buildSqlQuery(searchForVite);
        System.out.println("Find search");
        System.out.println(sql);
        Query theQuery = entityManager.createQuery("FROM Vite WHERE " + sql);
        List<Vite> patients = theQuery.getResultList();
        return patients.isEmpty() ? null : patients;
    }

    @Override
    public List<Vite> findAll() {
        logger.info("findAll");
        System.out.println("Find All");
        Query theQuery = entityManager.createQuery("FROM Vite ORDER BY patientId DESC");
        List<Vite> patients = theQuery.getResultList();
        System.out.println(patients.toString());
        return theQuery.getResultList();
    }

    private String buildSqlQuery(SearchForVite searchForVite) {
        StringBuilder sql = new StringBuilder();
        appendConditionForId(sql, "patientId", String.valueOf(searchForVite.getPatientId()));
        appendCondition(sql, "patientName", searchForVite.getPatientName());
        appendCondition(sql, "phoneNumber", searchForVite.getPhoneNumber());
        appendCondition(sql, "patientSurName", searchForVite.getPatientSurName());
        return sql.toString();
    }

    private void appendCondition(StringBuilder sql, String colName, String param) {
        if (param != null && !param.isEmpty() && !"0".equals(param)) {
            if (sql.length() == 0) {
                sql.append(colName).append(" LIKE '%").append(param).append("%'");
            } else {
                sql.append(" AND ").append(colName).append(" LIKE '%").append(param).append("%'");
            }
        }
    }
    private void appendConditionForId(StringBuilder sql, String colName, String param) {
        if (param != null && !param.isEmpty() && !"0".equals(param)) {
            if (sql.length() == 0) {
                sql.append(colName).append(" ='").append(param).append("'");
            } else {
                sql.append(" AND ").append(colName).append(" ='").append(param).append("'");
            }
        }
    }
}
