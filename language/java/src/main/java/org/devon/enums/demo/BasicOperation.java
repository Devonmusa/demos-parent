package org.devon.enums.demo;

/**
 * Created by lenovo on 2017/11/23.
 */
public enum BasicOperation implements Operation {



    PLUS("+")  {
        @Override
        public   double apply(double  x, double y) {
            return x+y;
        }
    },
    MINUS("-") {
        @Override
        public  double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("*") {
        @Override
        public  double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/"){
        @Override
        public  double apply(double x, double y) {
            return x*y;
        }
    };


    private final String symbol;

    BasicOperation(String symbol){
        this.symbol = symbol;
    };


    public String toSting() {
        return symbol;
    }


}
