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

public class Order extends BusinessObject {

    private String orderId;
    private double turnover;
    private int status;
    private OrderDiscount orderDiscount;
    private OrderAmount orderAmount;
    private OrderDelivery orderDelivery;
    private int paymentMethod;
    private boolean newCustomer;
    private OrderCustomVars customVariables;
    private boolean confirmationRequired;

    OrderCustomVars getCustomVariables() {
        return customVariables;
    }

    /**
     * Get discount object
     *
     * @return OrderDiscount
     */
    public OrderDiscount Discount() {
        return orderDiscount == null ? (orderDiscount = new OrderDiscount(this)) : orderDiscount;
    }

    /**
     * Get amount object
     *
     * @return OrderAmount
     */
    public OrderAmount Amount() {
        return orderAmount == null ? (orderAmount = new OrderAmount(this)) : orderAmount;
    }

    /**
     * Get delivery object
     *
     * @return OrderDelivery
     */
    public OrderDelivery Delivery() {
        return orderDelivery == null ? (orderDelivery = new OrderDelivery(this)) : orderDelivery;
    }

    /**
     * Get CustomVars
     *
     * @return OrderCustomVars
     */
    public OrderCustomVars CustomVars() {
        return customVariables = (customVariables == null) ? new OrderCustomVars() : customVariables;
    }

    /**
     * Get order id
     *
     * @return String
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Get turnover
     *
     * @return double
     */
    public double getTurnover() {
        return turnover;
    }

    /**
     * Get status
     *
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * Get boolean newCustomer value
     *
     * @return boolean
     */
    public boolean isNewCustomer() {
        return newCustomer;
    }

    /**
     * Get payment method
     *
     * @return int
     */
    public int getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Get boolean confirmationRequired value
     *
     * @return boolean
     */
    public boolean isConfirmationRequired() {
        return confirmationRequired;
    }

    /**
     * Set a new order id
     *
     * @param orderId String
     * @return Order
     */
    public Order setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    /**
     * Set a new turnover
     *
     * @param turnover double
     * @return Order
     */
    public Order setTurnover(double turnover) {
        this.turnover = turnover;
        return this;
    }

    /**
     * Set a new status
     *
     * @param status int
     * @return Order
     */
    public Order setStatus(int status) {
        this.status = status;
        return this;
    }

    /**
     * Change boolean newCustomer value
     *
     * @param newCustomer boolean
     * @return Order
     */
    public Order setNewCustomer(boolean newCustomer) {
        this.newCustomer = newCustomer;
        return this;
    }

    /**
     * Set a new payment method
     *
     * @param paymentMethod int
     * @return Order
     */
    public Order setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    /**
     * Change boolean confirmationRequired value
     *
     * @param confirmationRequired boolean
     * @return Order
     */
    public Order setConfirmationRequired(boolean confirmationRequired) {
        this.confirmationRequired = confirmationRequired;
        return this;
    }

    Order(Tracker tracker) {
        super(tracker);
        orderId = "";
        turnover = -1.0;
        status = -1;
        paymentMethod = -1;
        newCustomer = false;
        confirmationRequired = false;
    }

    @Override
    void setEvent() {

        ParamOption encode = new ParamOption().setEncode(true);

        // Informations de commande
        tracker.setParam("cmd", orderId);

        if (turnover > -1.0) {
            tracker.setParam("roimt", turnover);
        }
        if (status > -1) {
            tracker.setParam("st", status);
        }

        // Nouveau client
        tracker.setParam("newcus", newCustomer ? "1" : "0");

        // Remises
        if (orderDiscount != null) {
            double discountTaxFree = orderDiscount.getDiscountTaxFree();
            double discountTaxIncluded = orderDiscount.getDiscountTaxIncluded();
            String promotionalCode = orderDiscount.getPromotionalCode();
            if (discountTaxFree > -1) {
                tracker.setParam("dscht", discountTaxFree);
            }
            if (discountTaxIncluded > -1) {
                tracker.setParam("dsc", discountTaxIncluded);
            }
            if (promotionalCode != null) {
                tracker.setParam("pcd", promotionalCode, encode);
            }
        }

        // Montants
        if (orderAmount != null) {
            double amountTaxFree = orderAmount.getAmountTaxFree();
            double amountTaxIncluded = orderAmount.getAmountTaxIncluded();
            double taxAmount = orderAmount.getTaxAmount();
            if (amountTaxFree > -1) {
                tracker.setParam("mtht", amountTaxFree);
            }
            if (amountTaxIncluded > -1) {
                tracker.setParam("mtttc", amountTaxIncluded);
            }
            if (taxAmount > -1) {
                tracker.setParam("tax", taxAmount);
            }
        }

        // Livraison
        if (orderDelivery != null) {
            double shippingFeesTaxFree = orderDelivery.getShippingFeesTaxFree();
            double shippingFeesTaxIncluded = orderDelivery.getShippingFeesTaxIncluded();
            String deliveryMethod = orderDelivery.getDeliveryMethod();
            if (shippingFeesTaxFree > -1) {
                tracker.setParam("fpht", shippingFeesTaxFree);
            }
            if (shippingFeesTaxIncluded > -1) {
                tracker.setParam("fp", shippingFeesTaxIncluded);
            }
            if (deliveryMethod != null) {
                tracker.setParam("dl", deliveryMethod, encode);
            }
        }

        // Custom variables
        if (customVariables != null) {
            for (OrderCustomVar var : customVariables) {
                tracker.setParam("o" + var.getVarId(), var.getValue());
            }
        }

        // Methode de paiement
        if (paymentMethod > -1) {
            tracker.setParam("mp", paymentMethod);
        }

        // Confirmation requise
        if (confirmationRequired) {
            tracker.setParam(Hit.HitParam.Tp.stringValue(), "pre1");
        }
    }
}
