package com.argildx.aem.resourceResolver;

import java.util.Collections;
import java.util.Map;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

public class ResourceResolverUtil {

  /** The resource resolver factory. */
  @Reference
  private transient ResourceResolverFactory resourceResolverFactory;

  /**
   * Gets the resource resolver.
   *
   * @return the resource resolver
   */
  public ResourceResolver getResourceResolver() {
    ResourceResolver resourceResolver = null;
    try {
      final Map<String, Object> authInfo = Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, (Object) "ResourceResolverUtil");
      resourceResolver = resourceResolverFactory.getServiceResourceResolver(authInfo);
    } catch (LoginException le) {
    }
    return resourceResolver;
  }

}
