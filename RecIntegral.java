/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labjava1;

import java.io.Serializable;

/**
 *
 * @author Елена
 */
public class RecIntegral implements Serializable {

        private String low;
        private String high;
        private String step;

        public RecIntegral(String low, String high, String step) throws MyExceptionClass {
            if (Double.valueOf(low) < 0.000001
                    || Double.valueOf(low) > 1000000
                    || Double.valueOf(high) < 0.000001
                    || Double.valueOf(high) > 1000000
                    || Double.valueOf(step) < 0.000001
                    || Double.valueOf(step) > 1000000) {
                throw new MyExceptionClass("Data is not correct");
            }
            this.low = low;
            this.high = high;
            this.step = step;
        }

        public String getStep() {
            return this.step;
        }

        public String getLow() {
            return this.low;
        }

        public String getHigh() {
            return this.high;
        }
    }
