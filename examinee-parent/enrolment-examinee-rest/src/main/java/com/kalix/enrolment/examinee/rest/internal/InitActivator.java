package com.kalix.enrolment.examinee.rest.internal;

import com.kalix.framework.core.api.osgi.KalixBundleActivator;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator extends KalixBundleActivator {
    /*private ServiceReference reference;
    private HttpService httpService;


    @Override
    public void start(BundleContext bundleContext) throws Exception {
        super.start(bundleContext);

        reference = bundleContext.getServiceReference(HttpService.class.getName());
        httpService = (HttpService) bundleContext.getService(reference);
        httpService.registerResources(contextPath + "/enrolment/question/excel", "/excel", null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        super.stop(bundleContext);

        if (reference != null)
            bundleContext.ungetService(reference);
        if (httpService != null) {
            httpService.unregister(contextPath + "/enrolment/question/excel");
        }
    }*/
}
