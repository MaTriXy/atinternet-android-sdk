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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@Config(sdk =21)
@RunWith(RobolectricTestRunner.class)
public class OrderAmountTest extends AbstractTestClass {

    private OrderAmount orderAmount;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        orderAmount = new OrderAmount(new Order(tracker));
    }

    @Test
    public void initTest() {
        assertEquals(-1, orderAmount.getAmountTaxFree(), 0);
        assertEquals(-1, orderAmount.getAmountTaxIncluded(), 0);
        assertEquals(-1, orderAmount.getTaxAmount(), 0);
    }

    @Test
    public void setTest() {
        orderAmount.set(123, 456, 789);
        assertEquals(123, orderAmount.getAmountTaxFree(), 0);
        assertEquals(456, orderAmount.getAmountTaxIncluded(), 0);
        assertEquals(789, orderAmount.getTaxAmount(), 0);

        orderAmount = orderAmount.setAmountTaxFree(123).setAmountTaxIncluded(456).setTaxAmount(789);
        assertEquals(123, orderAmount.getAmountTaxFree(), 0);
        assertEquals(456, orderAmount.getAmountTaxIncluded(), 0);
        assertEquals(789, orderAmount.getTaxAmount(), 0);
    }
}
