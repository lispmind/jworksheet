package jworksheet;

import com.progfun.funcs.HighOrderFuncs;
import com.progfun.funcs.Sum;
import scala.Function1;
import scala.collection.immutable.List;
import scala.collection.immutable.Nil$;
import scala.runtime.AbstractFunction1;


public class App {
    static Function1<Integer, Integer> id = new AbstractFunction1<Integer, Integer>() {
        public Integer apply(Integer x) {
            return x;
        }
    };

    static Function1<Integer, Integer> cube = new AbstractFunction1<Integer, Integer>() {
        public Integer apply(Integer x) {
            return x * x * x;
        }
    };

    static Function1<Integer, Integer> fact = new AbstractFunction1<Integer, Integer>() {
        public Integer apply(Integer x) {
            int sum = 1;
            for (int i = 1; i <= x; i++) {
                sum *= i;
            }
            return sum;
        }
    };

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(new HighOrderFuncs().sumInt(1, 8));

        System.out.println(Sum.sumInt(1, 8));
        System.out.println(Sum.sumCube(1, 8));
        System.out.println(Sum.sumFact(1, 8));

        System.out.println(Sum.sum(id, 1, 8));
        System.out.println(Sum.sum(cube, 1, 8));
        System.out.println(Sum.sum(fact, 1, 8));

        System.out.println(Sum.sumTail(new AbstractFunction1<Object, Object>() {
            @Override
            public Object apply(Object v1) {
                return v1;
            }
        }, 1, 8));
        System.out.println(Sum.sumTail(new AbstractFunction1<Object, Object>() {
            @Override
            public Object apply(Object v1) {
                Integer x = (Integer) v1;
                return x * x * x;
            }
        }, 1, 8));
        System.out.println(Sum.sumTail(new AbstractFunction1<Object, Object>() {
            @Override
            public Object apply(Object v1) {
                Integer x = (Integer) v1;
                int sum = 1;
                for (int i = 1; i <= x; i++) {
                    sum *= i;
                }
                return sum;
            }
        }, 1, 8));

        List nil = Nil$.MODULE$; // the empty list
        List one = nil.$colon$colon(1); // 1::nil
        List two = one.$colon$colon(2); // 2::1::nil
        System.out.println(one);
        System.out.println(two);
        System.out.println(Nil$.MODULE$.$colon$colon("fdsfsd"));

        System.out.println(Sum.funcList(new AbstractFunction1<String, List<String>>() {
            @Override
            public List<String> apply(String v1) {
                return Nil$.MODULE$.$colon$colon(v1);
            }
        }, "a", "123456"));
    }
}
