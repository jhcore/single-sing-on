package es.capgemini.gav.kanbanWaffleSample.general.dataaccess.base.dao;

import es.capgemini.gav.kanbanWaffleSample.general.dataaccess.api.BinaryObjectEntity;
import es.capgemini.gav.kanbanWaffleSample.general.dataaccess.api.dao.BinaryObjectDao;

import javax.inject.Named;

/**
 * Implementation of {@link BinaryObjectDao}.
 *
 * @author sspielma
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
