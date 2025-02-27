@Component
public class Patcher {
    public static void internPatcher(Intern existingIntern, Intern incompleteIntern) throws IllegalAccessException {

        Class<?> internClass= Intern.class;
        Field[] internFields=internClass.getDeclaredFields();
        System.out.println(internFields.length);
        for(Field field : internFields){
            System.out.println(field.getName());
            field.setAccessible(true);

            Object value=field.get(incompleteIntern);
            if(value!=null){
                field.set(existingIntern,value);
            }
            //MAKE THE FIELD PRIVATE AGAIN
            field.setAccessible(false);
        }

    }

}