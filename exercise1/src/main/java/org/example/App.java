package org.example;

import java.util.Arrays;

public class App 
{
    /*
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
     * Для вывода итогового массива я создал массив, куда скопировал значения в заданном 
     * диапазоне (от offset до readLength + 1), затем в цикле изменил каждое значение с 
     * учётом скидки, получив массив новых цен. Также я сделал проверки на корректность
     * принимаемых данных. В задаче не было сказано, что сделать если цена равна или меньше 
     * нуля, поэтому я решил пропускать такие числа и оставлять ноль. В задаче я использовал
     * методы класса Arrays, чтобы скопировать массив в заданом диапазоне.
     */
    public static int[] decryptData( int[] price, int discount, int offset, int readLength) {
        if((discount >= 1 && discount <= 99) && offset >= 0 && readLength > 0) {
            int[] discountPrices = Arrays.copyOfRange(price, offset, readLength + 1);
            for(int i = 0; i < discountPrices.length; i++) {
                if(price[i] <= 0) continue;
                else discountPrices[i] -= (discountPrices[i] * discount) / 100;
            }
            return discountPrices;
        } else {
            throw new RuntimeException("Заданы неверные параметры");
        }
    }
    public static void main( String[] args )
    {
        int prices[] = {5,100,20,66,16};
        int result[] = decryptData(prices, 50, -1, 3 );
        System.out.println(Arrays.toString(result));
    }

    
}
