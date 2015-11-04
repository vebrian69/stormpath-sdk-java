package com.stormpath.sdk.organization;
/*
* Copyright 2015 Stormpath, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

/**
 * @since 1.0.RC5
 */
public enum OrganizationStatus {

    /**
     * Enabled organizations within a Tenant can be used as "Directory stores"
     */
    ENABLED,

    /**
     * Disabled organizations within a Tenant cannot be used as "Directory stores"
     */
    DISABLED,
}