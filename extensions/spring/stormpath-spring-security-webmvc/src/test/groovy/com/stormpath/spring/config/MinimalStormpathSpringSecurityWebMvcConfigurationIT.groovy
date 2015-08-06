/*
 * Copyright 2015 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.spring.config

import com.stormpath.sdk.api.ApiKey
import com.stormpath.sdk.application.Application
import com.stormpath.sdk.cache.CacheManager
import com.stormpath.sdk.client.Client
import com.stormpath.spring.security.provider.StormpathAuthenticationProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.springframework.test.context.web.WebAppConfiguration
import org.testng.annotations.Test

import javax.servlet.Filter

import static org.testng.Assert.assertNotNull

/**
 * @since 1.0.RC4.6
 */
@ContextConfiguration(classes = MinimalStormpathSpringSecurityWebMvcAppConfig.class)
@WebAppConfiguration
class MinimalStormpathSpringSecurityWebMvcConfigurationIT extends AbstractTestNGSpringContextTests {

    @Autowired
    StormpathWebSecurityConfiguration c;

    @Autowired
    ApiKey apiKey;

    @Autowired
    CacheManager stormpathCacheManager;

    @Autowired
    Client client;

    @Autowired
    Application application;

    @Autowired
    Filter stormpathFilter;

    @Autowired
    StormpathAuthenticationProvider stormpathAuthenticationProvider;

    @Test
    void test() {
        //assertNotNull c
        assertNotNull apiKey
        assertNotNull stormpathCacheManager
        assertNotNull client
        assertNotNull application
        assertNotNull stormpathFilter

        assertNotNull stormpathAuthenticationProvider
        assertNotNull stormpathAuthenticationProvider.applicationRestUrl
        assertNotNull stormpathAuthenticationProvider.client
    }
}