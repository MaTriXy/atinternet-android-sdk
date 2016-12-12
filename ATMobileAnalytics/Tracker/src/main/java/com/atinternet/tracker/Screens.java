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

public class Screens extends Helper {

    Screens(Tracker tracker) {
        super(tracker);
    }

    /**
     * Add a screen
     *
     * @return Screen
     */
    public Screen add() {
        Screen screen = new Screen(tracker);
        tracker.getBusinessObjects().put(screen.getId(), screen);

        return screen;
    }

    /**
     * Add a screen
     *
     * @param context android.content.Context
     * @return Screen
     */
    public Screen add(android.content.Context context) {
        Screen screen = new Screen(tracker)
                .setName(context.getClass().getCanonicalName());
        tracker.getBusinessObjects().put(screen.getId(), screen);

        return screen;
    }

    /**
     * Add a screen
     *
     * @param name String
     * @return Screen
     */
    public Screen add(String name) {
        Screen screen = new Screen(tracker)
                .setName(name);
        tracker.getBusinessObjects().put(screen.getId(), screen);

        return screen;
    }

    /**
     * Add a screen
     *
     * @param name     Strin
     * @param chapter1 String
     * @return Screen
     */
    public Screen add(String name, String chapter1) {
        return add(name).setChapter1(chapter1);
    }

    /**
     * Add a screen
     *
     * @param name     String
     * @param chapter1 String
     * @param chapter2 String
     * @return Screen
     */
    public Screen add(String name, String chapter1, String chapter2) {
        return add(name, chapter1).setChapter2(chapter2);
    }

    /**
     * Add a screen
     *
     * @param name     String
     * @param chapter1 String
     * @param chapter2 String
     * @param chapter3 String
     * @return Screen
     */
    public Screen add(String name, String chapter1, String chapter2, String chapter3) {
        return add(name, chapter1, chapter2).setChapter3(chapter3);
    }
}
