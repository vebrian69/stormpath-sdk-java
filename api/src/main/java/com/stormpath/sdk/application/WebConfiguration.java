/*
 * Copyright 2016 Stormpath, Inc.
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
package com.stormpath.sdk.application;

import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.resource.Auditable;
import com.stormpath.sdk.resource.Resource;
import com.stormpath.sdk.resource.Saveable;

/**
 * @since 1.1.0
 */
public interface WebConfiguration extends Resource, Saveable, Auditable {

    String getDomainName();

    String getBasePath();

    WebConfigurationStatus getStatus();

    ApiKey getSigningApiKey();

    Application getApplication();

    OAuth2Property getOAuth2();

    EnabledProperty getRegister();

    EnabledProperty getVerifyEmail();

    EnabledProperty getLogin();

    EnabledProperty getLogout();

    EnabledProperty getForgotPassword();

    EnabledProperty getChangePassword();

    EnabledProperty getIdSite();

    EnabledProperty getCallback();

    MeProperty getMe();
}
