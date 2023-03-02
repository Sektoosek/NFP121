import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ListeurFabriquesStatiques implements Listeur {

	@Override
	public List<Method> getMethodes(String nomClasse) throws Exception {
		List<Method> resultat = new ArrayList<>();
		Class<?> classes = Class.forName(nomClasse);
		Method[] methodes = classes.getDeclaredMethods();
		for (Method m : methodes) {
			if (Modifier.isStatic(m.getModifiers()) && m.getReturnType() == classes) {
			resultat.add(m);
			}
		}
		return resultat; 

	}
	
	
	/*
	 * 
	 * public List<Method> getMethodes(String nomClasse) throws Exception {
        Class<?> classe = Class.forName(nomClasse);
        Method[] methodes = classe.getDeclaredMethods();
        List<Method> res = new ArrayList<Method>();
        for (Method m : methodes) {
            if (Modifier.isStatic(m.getModifiers()) && m.getReturnType() == classe) {
                Class<?>[] paramClasse = m.getParameterTypes();
                if (!Arrays.asList(paramClasse).contains(classe) ) {
                    res.add(m);
                }
            }
        }
        return res;
    }
	 */

}
