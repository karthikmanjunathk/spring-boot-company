@Component
public class UniqueFieldValidator implements ConstraintValidator<companyCode, String> {



    @PersistenceUnit
    private EntityManagerFactory emf;
    private Class validationContext;
    private String companyCode;

    @Override
    public void initialize(UniqueField uniqueField) {
        this.validationContext = uniqueField.validationContext();
        this.companyCode = companyCode;
    }

    """
    ● Not-Mandatory
    ● Unique
    ● If value is provided, the format of the String
    should be as below:
    ○ Length should be 5 characters
    ○ 1st & 2nd characters should be alphabets
    (case insensitive)
    ○ 3rd & 4th characters should be numbers
    ○ 5th character should be E or N (case
    insensitive)
    """

    @Override
    public boolean isValid(String companyCode, ConstraintValidatorContext cxt) {
        if companyCode.length() != 5{
            return false;
        }
        if (!Character.isLetter(string.charAt(0)) || !Character.isLetter(string.charAt(1))){
            return false;
        }
        if (!Character.isDigit(string.charAt(2)) || Character.isDigit(string.charAt(3))) {
            return false;
        }
        if (string.charAt(4).toLowerCase() != 'n' || string.charAt(4).toLowerCase() != 'e') {
            return false;
        }

        Optional<Company> entity = companyService.getCompanyByCode(String companyCode);
        if(entity instanceof Company){
            return false;
        }
        return true;
    }

}