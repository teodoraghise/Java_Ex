public enum Operations implements Calculator<Double> {
    ADDITION {
        @Override
        public Double calculate(Double num1, Double num2) throws InvalidNumber {
            if (num1 >= 1000000000 || num2 >= 1000000000) {
                throw new InvalidNumber((char) 27 + "\033[1;36mYou cannot have more then 10 digits");
            }
            return num1 + num2;
        }
    },

    SUBTRACTION {
        @Override
        public Double calculate(Double num1, Double num2) throws InvalidNumber {
            if (num1 >= 1000000000 || num2 >= 1000000000) {
                throw new InvalidNumber((char) 27 + "\033[1;36mYou cannot have more then 10 digits");
            }
            return num1 - num2;
        }
    },

    MULTIPLY {
        @Override
        public Double calculate(Double num1, Double num2) throws InvalidNumber {
            if (num1 >= 1000000000 || num2 >= 1000000000) {
                throw new InvalidNumber((char) 27 + "\033[1;36mYou cannot have more then 10 digits");
            }
            return num1 * num2;
        }
    },

    DIVIDE {
        @Override
        public Double calculate(Double num1, Double num2) throws DivideByZero, InvalidNumber {
            if (num1 >= 1000000000 || num2 >= 1000000000) {
                throw new InvalidNumber((char) 27 + "\033[1;36mYou cannot have more then 10 digits");
            }
            return num1 / num2;
        }
    };
}