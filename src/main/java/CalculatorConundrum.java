class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        // Validar a operação antes de tentar usá-la
        validandoOperacao(operation);

        try {
            int result = switch (operation) {
                case "+" -> operand1 + operand2;
                case "*" -> operand1 * operand2;
                case "/" -> operand1 / operand2;
                default ->
                        throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
            };
            return String.format("%s %s %s = %s", operand1, operation, operand2, result);
        } catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }
    }

    private void validandoOperacao(String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }
    }
}
