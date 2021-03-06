/*
 * Copyright 2009 Alin Dreghiciu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.web.service.jetty.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * TODO Add JavaDoc.
 *
 * @author Alin Dreghiciu (adreghiciu@gmail.com)
 * @since 0.7.0, July 31, 2009
 */
public class CompositeActivator
    implements BundleActivator
{

    private BundleActivator m_paxWebActivator;
    private BundleActivator m_jettyActivator;

    public CompositeActivator()
    {
        m_paxWebActivator = new org.ops4j.pax.web.service.internal.Activator();
        m_jettyActivator = new org.ops4j.pax.web.service.jetty.internal.Activator();
    }

    public void start( BundleContext bundleContext )
        throws Exception
    {
        m_jettyActivator.start( bundleContext );
        m_paxWebActivator.start( bundleContext );
    }

    public void stop( BundleContext bundleContext )
        throws Exception
    {
        m_paxWebActivator.stop( bundleContext );
        m_jettyActivator.stop( bundleContext );
    }

}
