package az.tarlan.medair.analysis.DAO;

import az.tarlan.medair.analysis.entity.AnalyzesMedia;
import az.tarlan.medair.analysis.entity.AnalyzesReqBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
@Component
public class AnalyzDAOImpl implements AnalyzDAO {
    private final EntityManager entityManager;
    private static final Logger logger = LoggerFactory.getLogger(AnalyzDAOImpl.class);

    public AnalyzDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public int getAnalysId() {
        logger.info("getAnalysId");
        Query theQuery = entityManager.createQuery(" Select max(analyzesId) from AnalyzesMedia ");
        var list = theQuery.getResultList();
        if (list.get(0) == null) return 1;
        int analysId = (int) list.get(0);
        analysId = analysId + 1;
        return analysId;
    }

    @Override
    public void saveAnalyzes(AnalyzesReqBody analyzesReqBody) {
        logger.info("saveAnalyzes");
        if (!analyzesReqBody.getAnalyzesMediaList().isEmpty())
            cleanUpExistingAnalyzesMedia(analyzesReqBody.getPatientId());

        for (AnalyzesMedia media : analyzesReqBody.getAnalyzesMediaList()) {
            AnalyzesMedia dbAnalyzesMedia = createAnalyzesMedia(analyzesReqBody.getPatientId(), media);
            AnalyzesMedia savedMedia = entityManager.merge(dbAnalyzesMedia);
            if (media.getAnalyzesId() == 0) {
                dbAnalyzesMedia.setAnalyzesId(savedMedia.getAnalyzesId());
            }
            logger.info(dbAnalyzesMedia.toString());
        }
    }

    private void cleanUpExistingAnalyzesMedia(int patientId) {
        Query deleteQuery = entityManager.createQuery("delete from AnalyzesMedia where patientId = :patientId");
        deleteQuery.setParameter("patientId", patientId);
        deleteQuery.executeUpdate();
    }

    private AnalyzesMedia createAnalyzesMedia(int patientId, AnalyzesMedia media) {
        AnalyzesMedia dbAnalyzesMedia = new AnalyzesMedia();
        dbAnalyzesMedia.setPatientId(patientId);
        dbAnalyzesMedia.setAnalyzesDesc(media.getAnalyzesDesc());
        dbAnalyzesMedia.setAnalyzesType(media.getAnalyzesType());
        dbAnalyzesMedia.setAnalyzesContentName(media.getAnalyzesContentName());
        dbAnalyzesMedia.setAnalyzesSubType(media.getAnalyzesSubType());
        dbAnalyzesMedia.setDate(media.getDate());
        dbAnalyzesMedia.setAnalyzesContentUrl(media.getAnalyzesContentUrl());
        return dbAnalyzesMedia;
    }


    @Override
    public List<AnalyzesMedia> findPatientAnalyses(int patientId) {
        logger.info("findPatientAnalyses");
        String FIND_ANALYSES_QUERY = "FROM AnalyzesMedia WHERE patientId = :patientId";
        Query theQuery = entityManager.createQuery(FIND_ANALYSES_QUERY);
        theQuery.setParameter("patientId", patientId);

        List<AnalyzesMedia> analyzesMedia = Collections.emptyList();
        try {
            analyzesMedia = theQuery.getResultList();
        } catch (Exception e) {
            logger.error("Error occurred while fetching analyses for patientId: {}", patientId, e);
        }

        return analyzesMedia;
    }
}
