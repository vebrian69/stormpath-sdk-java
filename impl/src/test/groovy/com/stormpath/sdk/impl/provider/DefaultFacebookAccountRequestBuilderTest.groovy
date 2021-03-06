/*
 * Copyright 2014 Stormpath, Inc.
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
package com.stormpath.sdk.impl.provider

import com.stormpath.sdk.provider.FacebookAccountRequestBuilder
import com.stormpath.sdk.provider.ProviderAccountRequest
import com.stormpath.sdk.provider.ProviderAccountRequestBuilder
import com.stormpath.sdk.provider.Providers
import org.testng.annotations.Test

import static org.testng.Assert.assertEquals
import static org.testng.Assert.assertTrue
import static org.testng.Assert.fail

/**
 * @since 1.0.beta
 */
class DefaultFacebookAccountRequestBuilderTest {

    @Test
    void testWithAccessToken() {
        def providerRequest = Providers.FACEBOOK;
        def requestBuilder = providerRequest.account();
        assertTrue(requestBuilder instanceof FacebookAccountRequestBuilder)
        assertTrue(ProviderAccountRequestBuilder.isInstance(requestBuilder))
        def request = requestBuilder.setAccessToken("CAAHUbqIB55EH1MmLxJJLGRPXVknFt0aA36spMcFQXIzTdsHUZD").build();
        assertTrue(request instanceof ProviderAccountRequest)
        assertEquals(request.getProviderData().getProviderId(), "facebook")
        def providerData = request.getProviderData()
        assertTrue(providerData instanceof DefaultFacebookProviderData)
        providerData = (DefaultFacebookProviderData) providerData
        assertEquals(providerData.getAccessToken(), "CAAHUbqIB55EH1MmLxJJLGRPXVknFt0aA36spMcFQXIzTdsHUZD")
    }

    @Test
    void testWithAuthorizationCode() {
        def providerRequest = Providers.FACEBOOK;
        def requestBuilder = providerRequest.account();
        assertTrue(requestBuilder instanceof FacebookAccountRequestBuilder)
        assertTrue(ProviderAccountRequestBuilder.isInstance(requestBuilder))
        def request = requestBuilder.setCode("CAAHUbqIB55EH1MmLxJJLGRPXVknFt0aA36spMcFQXIzTdsHUZD")
                .setRedirectUri("http://foo.com/authorize").build();
        assertTrue(request instanceof ProviderAccountRequest)
        assertEquals(request.getProviderData().getProviderId(), "facebook")
        def providerData = request.getProviderData()
        assertTrue(providerData instanceof DefaultFacebookProviderData)
        providerData = (DefaultFacebookProviderData) providerData
        assertEquals(providerData.getProperty('code'), "CAAHUbqIB55EH1MmLxJJLGRPXVknFt0aA36spMcFQXIzTdsHUZD")
        assertEquals(request.redirectUri, "http://foo.com/authorize")
    }

    @Test
    void testMissingAccessTokenAndCode() {
        def requestBuilder = Providers.FACEBOOK.account();

        try {
            requestBuilder.build();
            fail("Should have failed")
        } catch (IllegalStateException e) {
            assertEquals(e.getMessage(), "Either accessToken or code must be provided before building.")
        }
    }

    @Test
    void testAddingAccessTokenAndCode() {
        def requestBuilder = Providers.FACEBOOK.account();

        try {
            requestBuilder.setAccessToken("abc").setCode("sdc").build();
            fail("Should have failed")
        } catch (IllegalStateException e) {
            assertEquals(e.getMessage(), "Either accessToken or code must be provided before building.")
        }
    }

}
