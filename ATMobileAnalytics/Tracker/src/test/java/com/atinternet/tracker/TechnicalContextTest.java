/*
This SDK is licensed under the MIT license (MIT)
Copyright (c) 2015- Applied Technologies Internet SAS (registration number B 403 261 258 - Trade and Companies Register of Bordeaux – France)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package com.atinternet.tracker;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

@Config(sdk = 21)
@RunWith(RobolectricTestRunner.class)
public class TechnicalContextTest extends AbstractTestClass {

    @Test
    public void getConnectionTest() {
        assertNotNull(TechnicalContext.getConnectionType().execute());
        assertNotSame("", TechnicalContext.getConnectionType().execute());
    }

    @Test
    public void getVTAGTest() {
        assertNotNull(TechnicalContext.VTAG.execute());
        assertNotSame("", TechnicalContext.VTAG.execute());
    }

    @Test
    public void getPTAGTest() {
        assertNotNull(TechnicalContext.PTAG.execute());
        assertEquals("Android", TechnicalContext.PTAG.execute());
    }

    @Test
    public void getLanguageTest() {
        assertNotNull(TechnicalContext.getLanguage().execute());
        assertNotSame("", TechnicalContext.getLanguage().execute());
    }

    @Test
    public void getDeviceTest() {
        assertNotNull(TechnicalContext.getDevice().execute());
        assertNotSame("", TechnicalContext.getDevice().execute());
    }

    @Test
    public void getOSTest() {
        assertNotNull(TechnicalContext.getOS().execute());
        assertNotSame("", TechnicalContext.getOS().execute());
    }

    @Test
    public void getDownloadSourceTest() {
        assertNotNull(TechnicalContext.getDownloadSource(tracker).execute());
        assertEquals("ext", TechnicalContext.getDownloadSource(tracker).execute());
    }

    @Test
    public void getLocalHourTest() {
        assertNotNull(TechnicalContext.getLocalHour().execute());
        assertNotSame("", TechnicalContext.getLocalHour().execute());
    }

    @Test
    public void getApplicationIdentifierTest() {
        assertNotNull(TechnicalContext.getApplicationIdentifier().execute());
        assertNotSame("", TechnicalContext.getApplicationIdentifier().execute());
    }

    @Test
    public void getResolutionTest() {
        assertNotNull(TechnicalContext.getResolution().execute());
        assertNotSame("", TechnicalContext.getResolution().execute());
    }

    @Test
    public void optOutTest() {
        TechnicalContext.optOut(ApplicationProvider.getApplicationContext(), true);
        assertTrue(ApplicationProvider.getApplicationContext().getSharedPreferences(TrackerConfigurationKeys.PREFERENCES, android.content.Context.MODE_PRIVATE).getBoolean(TrackerConfigurationKeys.OPT_OUT_ENABLED, false));
    }

    @Test
    public void getUUIDTest() {
        String uuid = TechnicalContext.getUserId("UUID", false, 1, "fixed").execute();
        assertEquals(uuid, TechnicalContext.getUserId("UUID", false, 1, "fixed").execute());
    }
}
