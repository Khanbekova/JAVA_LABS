/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labjava1;

/**
 *
 * @author Елена
 */
public class IntegralThread extends Thread {
    double high;
    double low;
    double step;
    double res = 0.0;

    public IntegralThread(String _low, String _high, String _step) {
        high = Double.parseDouble(_high);
        low = Double.parseDouble(_low);
        step = Double.parseDouble(_step);
    }

    @Override
    public void run() {
        for (int i = 0; i < (high - low) / step; i++) {
            res += step * (0.5 * (Math.sin(low + i * step) + Math.sin(low + (i + 1) * step)));

        }

    }

    public synchronized double getResult() {
        return res/2 ;
    }

}
