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

import org.json.JSONObject;

class Event {

    /**
     * Tracker instance
     */
    private final Tracker tracker;

    /**
     * Constructor
     *
     * @param tracker Tracker
     */
    Event(Tracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Set a generic event
     *
     * @param category String
     * @param action   String
     * @param label    String
     * @return Tracker
     */
    Tracker set(String category, String action, String label) {
        return set(category, action, label, new JSONObject().toString());
    }

    /**
     * Set a generic event
     *
     * @param category String
     * @param action   String
     * @param label    String
     * @param value    String
     * @return Tracker
     */
    Tracker set(String category, String action, String label, String value) {
        ParamOption appendWithEncoding = new ParamOption().setAppend(true).setEncode(true);
        ParamOption afterIdWithEncoding = new ParamOption().setRelativePosition(ParamOption.RelativePosition.after)
                .setRelativeParameterKey(Hit.HitParam.UserId.stringValue()).setEncode(true);

        return tracker.setParam(Hit.HitParam.HitType.stringValue(), category)
                .setParam(Hit.HitParam.Action.stringValue(), action)
                .setParam(Hit.HitParam.Screen.stringValue(), label, afterIdWithEncoding)
                .setParam(Hit.HitParam.JSON.stringValue(), value, appendWithEncoding);
    }
}
