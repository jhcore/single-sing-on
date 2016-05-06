package es.capgemini.gav.kanbanWaffleSample.general.configuration;

import java.util.ArrayList;
import java.util.List;

import waffle.servlet.spi.NegotiateSecurityFilterProvider;
import waffle.servlet.spi.SecurityFilterProvider;
import waffle.servlet.spi.SecurityFilterProviderCollection;
import waffle.spring.NegotiateSecurityFilter;
import waffle.spring.NegotiateSecurityFilterEntryPoint;
import waffle.spring.WindowsAuthenticationProvider;
import waffle.windows.auth.impl.WindowsAuthProviderImpl;

/**
 * This class initialize all Waffle Single Sign On configuration.
 *
 * @author jhcore
 */
public class WinauthSSOImpl {

  private WindowsAuthenticationProvider waffleWindowsAuthProvider;

  private NegotiateSecurityFilterProvider negotiateSecurityFilterProvider;

  private SecurityFilterProviderCollection waffleSecurityFilterProviderCollection;

  private NegotiateSecurityFilterEntryPoint negotiateSecurityFilterEntryPoint;

  private NegotiateSecurityFilter waffleNegotiateSecurityFilter;

  /**
   * The constructor.
   */
  public WinauthSSOImpl() {

    this.waffleWindowsAuthProvider = waffleWindowsAuthProvider();

    this.negotiateSecurityFilterProvider = negotiateSecurityFilterProvider(this.waffleWindowsAuthProvider);

    this.waffleSecurityFilterProviderCollection =
        waffleSecurityFilterProviderCollection(this.negotiateSecurityFilterProvider);

    this.negotiateSecurityFilterEntryPoint =
        negotiateSecurityFilterEntryPoint(this.waffleSecurityFilterProviderCollection);

    this.waffleNegotiateSecurityFilter = waffleNegotiateSecurityFilter(this.waffleSecurityFilterProviderCollection);
  }

  /**
   * @return the WindowsAuthProvider
   */
  private WindowsAuthenticationProvider waffleWindowsAuthProvider() {

    WindowsAuthenticationProvider windowsAuthenticationProvider = new WindowsAuthenticationProvider();
    windowsAuthenticationProvider.setAuthProvider(new WindowsAuthProviderImpl());
    return windowsAuthenticationProvider;
  }

  /**
   * @return negotiateSecurityFilterProvider
   */
  @SuppressWarnings("javadoc")
  private NegotiateSecurityFilterProvider negotiateSecurityFilterProvider(
      final WindowsAuthenticationProvider windowsAuthenticationProvider) {

    return new NegotiateSecurityFilterProvider(windowsAuthenticationProvider.getAuthProvider());
  }

  /**
   * @return SecurityFilterProviderCollection
   */
  private SecurityFilterProviderCollection waffleSecurityFilterProviderCollection(
      final NegotiateSecurityFilterProvider negotiateSecurityFilterProvider) {

    final List<SecurityFilterProvider> securityFilterProviders = new ArrayList<>();

    securityFilterProviders.add(negotiateSecurityFilterProvider);

    return new SecurityFilterProviderCollection(securityFilterProviders.toArray(new SecurityFilterProvider[] {}));
  }

  /**
   * @return NegotiateSecurityFilterEntryPoint
   */
  private NegotiateSecurityFilterEntryPoint negotiateSecurityFilterEntryPoint(
      final SecurityFilterProviderCollection securityFilterProviderCollection) {

    final NegotiateSecurityFilterEntryPoint negotiateSecurityFilterEntryPoint = new NegotiateSecurityFilterEntryPoint();

    negotiateSecurityFilterEntryPoint.setProvider(securityFilterProviderCollection);

    return negotiateSecurityFilterEntryPoint;
  }

  /**
   * @return NegotiateSecurityFilter
   */
  private NegotiateSecurityFilter waffleNegotiateSecurityFilter(
      final SecurityFilterProviderCollection securityFilterProviderCollection) {

    final NegotiateSecurityFilter negotiateSecurityFilter = new NegotiateSecurityFilter();

    negotiateSecurityFilter.setProvider(securityFilterProviderCollection);

    return negotiateSecurityFilter;
  }

  /*
   * GETTERS and SETTERS
   */

  /**
   * @return waffleWindowsAuthProvider
   */
  public WindowsAuthenticationProvider getWaffleWindowsAuthProvider() {

    return this.waffleWindowsAuthProvider;
  }

  /**
   * @param waffleWindowsAuthProvider new value of waffleWindowsAuthProvider.
   */
  public void setWaffleWindowsAuthProvider(WindowsAuthenticationProvider waffleWindowsAuthProvider) {

    this.waffleWindowsAuthProvider = waffleWindowsAuthProvider;
  }

  /**
   * @return negotiateSecurityFilterProvider
   */
  public NegotiateSecurityFilterProvider getNegotiateSecurityFilterProvider() {

    return this.negotiateSecurityFilterProvider;
  }

  /**
   * @param negotiateSecurityFilterProvider new value of negotiateSecurityFilterProvider.
   */
  public void setNegotiateSecurityFilterProvider(NegotiateSecurityFilterProvider negotiateSecurityFilterProvider) {

    this.negotiateSecurityFilterProvider = negotiateSecurityFilterProvider;
  }

  /**
   * @return waffleSecurityFilterProviderCollection
   */
  public SecurityFilterProviderCollection getWaffleSecurityFilterProviderCollection() {

    return this.waffleSecurityFilterProviderCollection;
  }

  /**
   * @param waffleSecurityFilterProviderCollection new value of waffleSecurityFilterProviderCollection.
   */
  public void setWaffleSecurityFilterProviderCollection(
      SecurityFilterProviderCollection waffleSecurityFilterProviderCollection) {

    this.waffleSecurityFilterProviderCollection = waffleSecurityFilterProviderCollection;
  }

  /**
   * @return negotiateSecurityFilterEntryPoint
   */
  public NegotiateSecurityFilterEntryPoint getNegotiateSecurityFilterEntryPoint() {

    return this.negotiateSecurityFilterEntryPoint;
  }

  /**
   * @param negotiateSecurityFilterEntryPoint new value of negotiateSecurityFilterEntryPoint.
   */
  public void setNegotiateSecurityFilterEntryPoint(
      NegotiateSecurityFilterEntryPoint negotiateSecurityFilterEntryPoint) {

    this.negotiateSecurityFilterEntryPoint = negotiateSecurityFilterEntryPoint;
  }

  /**
   * @return waffleNegotiateSecurityFilter
   */
  public NegotiateSecurityFilter getWaffleNegotiateSecurityFilter() {

    return this.waffleNegotiateSecurityFilter;
  }

  /**
   * @param waffleNegotiateSecurityFilter new value of waffleNegotiateSecurityFilter.
   */
  public void setWaffleNegotiateSecurityFilter(NegotiateSecurityFilter waffleNegotiateSecurityFilter) {

    this.waffleNegotiateSecurityFilter = waffleNegotiateSecurityFilter;
  }

}
