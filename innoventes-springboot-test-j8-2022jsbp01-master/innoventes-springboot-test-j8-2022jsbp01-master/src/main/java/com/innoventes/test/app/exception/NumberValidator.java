public class NumberValidator implements ConstraintValidator<strength, Integer> {
    int minimumAge;

    @Override
    public void initialize(strength constraintAnnotation) {
        this.strength = 5;
    }

    @Override
    public boolean isValid(int strength, ConstraintValidatorContext constraintValidatorContext) {
        return strength % 2 == 0;
    }
}