@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberValidator.class)
public @interface EvenNumberOrZero{
    int evenNumber() default 5;
    String message() default "Must be even number or zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}