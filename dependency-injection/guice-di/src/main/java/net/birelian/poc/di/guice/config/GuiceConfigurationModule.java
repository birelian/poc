package net.birelian.poc.di.guice.config;

import com.google.inject.AbstractModule;
import net.birelian.poc.di.guice.dao.ContactDao;
import net.birelian.poc.di.guice.dao.ContactDaoImpl;
import net.birelian.poc.di.guice.service.ContactService;
import net.birelian.poc.di.guice.service.ContactServiceImpl;

/**
 * Guice configuration module
 *
 * Dependency injection configurations are defined here.
 */
public class GuiceConfigurationModule extends AbstractModule {

    @Override
    protected void configure() {

        // Bindings
        bind(ContactService.class).to(ContactServiceImpl.class);
        bind(ContactDao.class).to(ContactDaoImpl.class);

    }
}
