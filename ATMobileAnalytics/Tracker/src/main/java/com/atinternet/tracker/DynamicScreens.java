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

import java.util.Date;

public class DynamicScreens extends Helper {

    DynamicScreens(Tracker tracker) {
        super(tracker);
    }

    /**
     * Add an dynamic label
     *
     * @param screenId int
     * @param name     String
     * @param update   Date
     * @return DynamicScreen
     * @deprecated Since 2.2.1, use {@link #add(String, String, Date)} instead.
     */
    @Deprecated
    public DynamicScreen add(int screenId, String name, Date update) {
        DynamicScreen dynamicScreen = new DynamicScreen(tracker)
                .setScreenId(screenId)
                .setName(name)
                .setUpdate(update);

        tracker.getBusinessObjects().put(dynamicScreen.getId(), dynamicScreen);

        return dynamicScreen;
    }

    /**
     * Add an dynamic label
     *
     * @param screenId String
     * @param name     String
     * @param update   Date
     * @return DynamicScreen
     */
    public DynamicScreen add(String screenId, String name, Date update) {
        DynamicScreen dynamicScreen = new DynamicScreen(tracker)
                .setScreenId(screenId)
                .setName(name)
                .setUpdate(update);

        tracker.getBusinessObjects().put(dynamicScreen.getId(), dynamicScreen);

        return dynamicScreen;
    }

    /**
     * Add an dynamic label
     *
     * @param screenId int
     * @param name     String
     * @param update   Date
     * @param chapter1 String
     * @return DynamicScreen
     * @deprecated Since 2.2.1, use {@link #add(String, String, Date, String)} instead.
     */
    @Deprecated
    public DynamicScreen add(int screenId, String name, Date update, String chapter1) {
        return add(screenId, name, update).setChapter1(chapter1);
    }

    /**
     * Add an dynamic label
     *
     * @param screenId String
     * @param name     String
     * @param update   Date
     * @param chapter1 String
     * @return DynamicScreen
     */
    public DynamicScreen add(String screenId, String name, Date update, String chapter1) {
        return add(screenId, name, update).setChapter1(chapter1);
    }

    /**
     * Add an dynamic label
     *
     * @param screenId int
     * @param name     String
     * @param update   Date
     * @param chapter1 String
     * @param chapter2 String
     * @return DynamicScreen
     * @deprecated Since 2.2.1, use {@link #add(String, String, Date, String, String)} instead.
     */
    @Deprecated
    public DynamicScreen add(int screenId, String name, Date update, String chapter1, String chapter2) {
        return add(screenId, name, update, chapter1).setChapter2(chapter2);
    }

    /**
     * Add an dynamic label
     *
     * @param screenId String
     * @param name     String
     * @param update   Date
     * @param chapter1 String
     * @param chapter2 String
     * @return DynamicScreen
     */
    public DynamicScreen add(String screenId, String name, Date update, String chapter1, String chapter2) {
        return add(screenId, name, update, chapter1).setChapter2(chapter2);
    }

    /**
     * Add an dynamic label
     *
     * @param screenId int
     * @param name     String
     * @param update   Date
     * @param chapter1 String
     * @param chapter2 String
     * @param chapter3 String
     * @return DynamicScreen
     * @deprecated Since 2.2.1, use {@link #add(String, String, Date, String, String, String)} instead.
     */
    @Deprecated
    public DynamicScreen add(int screenId, String name, Date update, String chapter1, String chapter2, String chapter3) {
        return add(screenId, name, update, chapter1, chapter2).setChapter3(chapter3);
    }

    /**
     * Add an dynamic label
     *
     * @param screenId String
     * @param name     String
     * @param update   Date
     * @param chapter1 String
     * @param chapter2 String
     * @param chapter3 String
     * @return DynamicScreen
     */
    public DynamicScreen add(String screenId, String name, Date update, String chapter1, String chapter2, String chapter3) {
        return add(screenId, name, update, chapter1, chapter2).setChapter3(chapter3);
    }
}
