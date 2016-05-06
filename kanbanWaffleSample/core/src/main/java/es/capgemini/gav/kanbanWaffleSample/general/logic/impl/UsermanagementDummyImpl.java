package es.capgemini.gav.kanbanWaffleSample.general.logic.impl;

import es.capgemini.gav.kanbanWaffleSample.general.common.api.UserProfile;
import es.capgemini.gav.kanbanWaffleSample.general.common.api.Usermanagement;
import es.capgemini.gav.kanbanWaffleSample.general.common.api.datatype.Role;
import es.capgemini.gav.kanbanWaffleSample.general.common.api.to.UserDetailsClientTo;
import es.capgemini.gav.kanbanWaffleSample.general.common.base.AbstractBeanMapperSupport;

import javax.inject.Named;

import org.springframework.stereotype.Component;

/**
 * Implementation of {@link Usermanagement}.
 */
@Named
@Component
public class UsermanagementDummyImpl extends AbstractBeanMapperSupport implements Usermanagement {

  @Override
  public UserProfile findUserProfileByLogin(String login) {
    // this is only a dummy - please replace with a real implementation
    UserDetailsClientTo profile = new UserDetailsClientTo();
    profile.setName(login);
    profile.setFirstName("Peter");
    profile.setLastName(login);
    profile.setRole(Role.CHIEF);
    return profile;
  }

}
