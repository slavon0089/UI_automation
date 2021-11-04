package org.example.lesson4;

public class Triangle {
    private  Double S;
    public  double area (int a, int b, int c) throws Exception {
        double p =0;
        if (a*b*c<=0) throw new Exception("Стороны должны быть больше нуля");
        p = (a+b+c)/2;
        S = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        return S;
    }

    public void checkArea() throws Exception {
        if (S<=0) throw new Exception("Невалидные данные, площадь не может быть меньше нуля");

    }
}
