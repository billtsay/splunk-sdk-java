/*
 * Copyright 2011 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.splunk;

import org.junit.Test;

public class UploadTest extends SDKTestCase {
    @Test
    public void testOneshot() {
        String filename;
        String osName = service.getInfo().getOsName();
        if (osName.equals("Windows")) {
            filename = "C:\\Windows\\WindowsUpdate.log"; // normally here
        } else if (osName.equals("Linux")) {
            filename = "/var/log/messages";
        } else if (osName.equals("Darwin")) {
            filename = "/var/log/system.log";
        } else {
            throw new Error("OS: " + osName + " not supported");
        }

        service.getUploads().create(filename);
        
        for (Upload oneshot : service.getUploads().values()) {
            oneshot.getBytesIndexed();
            oneshot.getOffset();
            oneshot.getSize();
            oneshot.getSize();
            oneshot.getSourcesIndexed();
            oneshot.getSpoolTime();
        }
    }
}